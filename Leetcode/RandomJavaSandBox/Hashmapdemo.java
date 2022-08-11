package RandomJavaSandBox;

import java.util.*;

public class Hashmapdemo {
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;
        return sum;
    }

    public static void main(String[] args) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        first.add(2);
        System.out.println(first);
        List<Integer> second = new ArrayList<>();
        second.add(2);
        second.add(1);
        System.out.println(second);
        map.put(first, 1);
        map.put(second,2);
        map.put(first, 3);
        for (Integer val : map.values()) {
            System.out.println(val);
        }
        int[] test = new int[1];
        int[] res = new int[2];
        int[] imp = new int[0];
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(imp));
    }
}
