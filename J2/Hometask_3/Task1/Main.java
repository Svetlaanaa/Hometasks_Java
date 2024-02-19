package J2.Hometask_3.Task1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    // https://iss.moex.com/iss/securities.json?q=Yandex
    static final String path = "https://iss.moex.com/iss/securities.json?q=";
    static final Map<String, Integer> titleAndIndexes = new HashMap<>();

    static {
        titleAndIndexes.put("secid", -1);
        titleAndIndexes.put("shortname", -1);
        titleAndIndexes.put("regnumber", -1);
        titleAndIndexes.put("name", -1);
        titleAndIndexes.put("emitent_title", -1);
        titleAndIndexes.put("emitent_inn", -1);
        titleAndIndexes.put("emitent_okpo", -1);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Некорректный ввод аргументов");
            return;
        } else{
            String searchQuery = args[0];

            try {
                URI uri = new URI(path + searchQuery);
                String query = getByHttp(uri);

                Moex moex = getSecuritiesFromJson(query);

                ArrayList<MoexData> dataToCsv = filterData(moex);

                saveToCsv(dataToCsv, searchQuery);

            } catch (URISyntaxException | IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void saveToCsv(ArrayList<MoexData> filteredOnFields, String searchQuery) {
        String userHome = System.getProperty("user.home");

        String directoryPath = userHome + "\\MOEX securities\\";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String pathToFile = directoryPath + searchQuery + ".csv";
        try (Writer writer = new FileWriter(pathToFile)) {
            if (WriterToCsv.save(filteredOnFields, writer)) {
                System.out.println();
            } else {
                System.err.println("Неверный формат данных для записи");
            }

        } catch (IOException e) {
            System.err.printf("Ошибка записи в файл %s: %s\n", searchQuery, e.getMessage());
        }
    }


    private static ArrayList<MoexData> filterData(Moex moex) {
        Securities securities = moex.getSecurities();

        ArrayList<ArrayList<Object>> filteredOnTraded = Filter.filterOnTraded(securities.getColumns(),
                securities.getData());

        ArrayList<MoexData> selectedOnFields = Filter.selectOnFields(securities.getColumns(),
                filteredOnTraded, titleAndIndexes);

        return selectedOnFields;
    }

    private static String getByHttp(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder(uri)
                .build();
        HttpClient client = HttpClient
                .newBuilder()
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode());
        String body = response.body();
        System.out.println(body);
        return body;
    }

    private static Moex getSecuritiesFromJson(String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        return mapper.readValue(body, Moex.class);
    }
}