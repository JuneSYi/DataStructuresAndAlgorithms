package Amazon.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class test {
    public String CommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[!?.;/,.]", " ");
        paragraph = paragraph.toLowerCase();

        String[] arr = paragraph.split("\\s+");


        Map<String, Integer> newTech = new HashMap<String, Integer>();
        for (int i=0; i<arr.length; i++) {

            if (newTech.containsKey(arr[i])) {
                newTech.put(arr[i],newTech.get(arr[i])+1);
                continue;
            }
            newTech.put(arr[i],1);

        }
        for (int j =0 ; j<banned.length; j++) {
            if (newTech.containsKey(banned[j])) newTech.remove(banned[j]);
        }
        int highest = 0;
        String val = "";

        for (String words : newTech.keySet()) {
            if (newTech.get(words) > highest) {
                highest = newTech.get(words);
                val = words;
            }
        }
        return val;

    }

    public static void main(String[] args) {
        String stre = "Bob hit a ball, the hit BALL flew far after it was hit ball ball ball.";
        String[] ban = {"hit"};
        test exe = new test();
        System.out.println(exe.CommonWord(stre, ban));
    }
}
