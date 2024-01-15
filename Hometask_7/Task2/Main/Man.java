import java.util.Comparator;
import java.util.List;

public class Man {
    private String name;
    private List<String> things;
    public Man(String name, List<String> things){
        this.name = name;
        things.sort(Comparator.reverseOrder());
        this.things = List.copyOf(things);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getThings() {
        return things;
    }
    public void setThings(List<String> things) {
        this.things = things;
    }

}
