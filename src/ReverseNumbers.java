import java.util.*;
import java.lang.*;

public class ReverseNumbers
{
    public static void expandedForm(int num) {
        ArrayList<Integer> listNumb = new ArrayList<Integer>();
        while (num > 0) {
            listNumb.add(num%10);
            num = num / 10;
        }
//        listNumb = Collections.reverse(Arrays.asList(listNumb));
//        for (int i =0; i<listNumb.size(); i++) {
//            if (listNumb[i] != 0) {
//                listNumb[i] = listNumb[i]*Math.pow(10,listNumb.size()-i-1);
//            }
//        }
//        return String.join(" + ", listNumb);
        System.out.println(listNumb);
    }

    public static void main(String[] args) {
        ReverseNumbers run = new ReverseNumbers();
        run.expandedForm(70840);

    }
}