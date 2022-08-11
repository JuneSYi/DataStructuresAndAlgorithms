package Amazon.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        // letter logs before digit logs
        // letter logs sorted lexicographically, if contents are same, then by identifiers
        // digit logs main their relative ordering, no change
        /*
        for letter logs, the identifier doesn't dictate the order at first, we need to compare content
        we can sort through twice

        first time: we check is substring is let
        then add to array list
        after sort is done, we can compare each one and switch orders if true

        then it's sorted

        then we can go back to logs and sort through and find all that start with dig, and add to end of arraylist
        can we return with toArray?
         */
        List<String> list = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            String[] arr = logs[i].split("\\s");

            if (Pattern.matches("[0-9]",arr[1])) {
                continue;
            }
            list.add(logs[i]);
        }
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                String[] arr = list.get(i).split("\\s");
                String[] brr = list.get(j).split("\\s");
                if (arr[1].compareTo(brr[1]) > 0) {
                    list.add(i, list.get(j));
                    list.remove(j+1);
                    list.add(j, list.get(i+1));
                    list.remove(i+1);
                }
            }
        }

        for (int i = 0; i < logs.length; i++) {
            String[] arr = logs[i].split("\\s");
            if (Pattern.matches("[0-9]",arr[1])) {
                list.add(logs[i]);
            }
        }

        String[] ans = new String[list.size()];
        return list.toArray(ans);
    }

    public static void main(String[] args) {
        ReorderLogFiles test = new ReorderLogFiles();
        String[] dog = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        System.out.println(Arrays.toString(test.reorderLogFiles(dog)));
        System.out.println(Arrays.toString(test.reorderLogFiles(logs)));
    }
}
