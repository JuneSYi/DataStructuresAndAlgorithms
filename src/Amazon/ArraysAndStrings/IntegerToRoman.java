package Amazon.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class IntegerToRoman {
    public String intToRoman(int num) {
        int index = 0;
        StringBuilder ans = new StringBuilder();
        List<String> build = new ArrayList<>();
        while (num != 0) {
            int temp = num%10;
            if (temp == 0) {
                index++;
                num = num/10;
                continue;
            }
            if (index == 0) {
                if (temp ==4 ) {
                    build.add("V");
                    build.add("I");
                }
                if (temp == 9) {
                    build.add("X");
                    build.add("I");
                }

            }

            if (index == 1) {

            }

            if (index == 2) {

            }

            if (index == 3) {

            }

            index++;
            num = num/10;
        }
        return ans.toString();

    }
}
