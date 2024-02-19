package J2.Hometask_3.Task1;

import java.util.ArrayList;
import java.util.Map;

public class Filter {
    public static ArrayList<ArrayList<Object>> filterOnTraded(ArrayList<String> columns,
                                                              ArrayList<ArrayList<Object>> data) {
        int indexTraded = columns.indexOf("is_traded");

        ArrayList<ArrayList<Object>> newList = new ArrayList<>();

        for (ArrayList<Object> d : data) {
            if ((int) d.get(indexTraded) == 1) {
                newList.add(d);
            }
        }
        return newList;
    }

    public static ArrayList<MoexData> selectOnFields(ArrayList<String> columns,
                                                     ArrayList<ArrayList<Object>> data,
                                                     Map<String, Integer> titleAndIndexes) {
        for(Map.Entry<String, Integer> entry : titleAndIndexes.entrySet()){
            int index = columns.indexOf(entry.getKey());

            if (index != -1) {
                entry.setValue(index);
            }
        }

        ArrayList<MoexData> filteredList = new ArrayList<>();

        for (ArrayList<Object> listData: data){
            MoexData moexData = new MoexData();
            moexData.setSecid((String) listData.get(titleAndIndexes.get("secid")));
            moexData.setShortname((String) listData.get(titleAndIndexes.get("shortname")));
            moexData.setRegnumber((String) listData.get(titleAndIndexes.get("regnumber")));
            moexData.setName((String) listData.get(titleAndIndexes.get("name")));
            moexData.setEmitent_title((String) listData.get(titleAndIndexes.get("emitent_title")));
            moexData.setEmitent_inn((String) listData.get(titleAndIndexes.get("emitent_inn")));
            moexData.setEmitent_okpo((String) listData.get(titleAndIndexes.get("emitent_okpo")));

            filteredList.add(moexData);
        }

        return filteredList;
    }
}