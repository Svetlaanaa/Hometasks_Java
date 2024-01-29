import java.util.HashSet;
import java.util.Set;

public class Example {
    private Set<String> textValues = new HashSet<>();

    public String getMessage(String value){
        try {
            if (!textValues.add(value)) {
                throw new AlreadyExistsException(value, textValues.size() + 1);
            } else {
                textValues.add(value);
            }
        } catch (AlreadyExistsException e) {
            System.out.println("Дублирующееся значение " + e.getValue() + " было введено в позиции " + e.getPosition());
            return "Значение: " + e.getValue() + ", позиция: " + e.getPosition();
        }
        return "";
    }
}
