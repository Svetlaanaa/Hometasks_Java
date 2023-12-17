public class TypeOfString {
    public static String checkType(String input) {
        if (input.trim().matches("^[A-Za-z][A-Za-z0-9._$]{7,}$")) {
            return "username";
        } else if (input.trim().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            return "email";
        } else if (input.trim().matches("^\\+\\d{1,2}-?\\(?(\\d{3})\\)?-?\\d{3}-?\\d{2}-?\\d{2}$")) {
            return "телефон";
        } else if (input.trim().matches("^\\d{10}$|^\\d{12}$")) {
            return "ИНН";
        } else {
            return "none";
        }
    }
}
