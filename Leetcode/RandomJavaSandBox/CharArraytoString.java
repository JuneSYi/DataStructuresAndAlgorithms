package RandomJavaSandBox;

public class CharArraytoString {
    public static void main(String[] args) {
        char[] charr = {'a', 'b','c','d'};
        String res = new String(charr);
        System.out.println(res);
        System.out.println(String.valueOf(charr));
        System.out.println(String.copyValueOf(charr));
    }
}
