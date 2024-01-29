import java.util.Arrays;

public enum Directions {
    UP("Вверх", 38, new int[]{0, -1}),
    DOWN("Вниз", 40, new int[]{0, 1}),
    LEFT("Влево", 37, new int[]{-1, 0}),
    RIGHT("Вправо", 39, new int[]{1, 0});

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }

    private String title;
    private int code;
    private int[] vector;
    Directions(String title, int code, int[] vector) {
        this.title = title;
        this.code = code;
        this.vector = Arrays.copyOf(vector, vector.length);
    }


}
