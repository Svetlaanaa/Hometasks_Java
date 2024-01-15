public class AlreadyExistsException extends Exception{
    private String value;
    private int position;

    public AlreadyExistsException(String value, int position){
        this.value = value;
        this.position = position;
    }

    public int getPosition(){
        return position;
    }

    public String getValue(){
        return value;
    }
}
