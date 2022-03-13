package Amazon.ArraysAndStrings;

public class regexPractice {
    public String reg(String some) {
        some.toLowerCase().split("[;',.?!]");
        some.replaceAll("[^a-zA-Z0-9]", " ");
        some.matches("\\s"); // any whitespace characters
        some.split("\\d"); // splits digits
        // \ is an escape sequence
        return some;
    }
}
