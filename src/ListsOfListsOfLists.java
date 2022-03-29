import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListsOfListsOfLists {
    public static void main(String[] args) {
        List<Integer> force = new ArrayList<>();
        System.out.println(force);
        force.add(1);
        force.add(2);
        System.out.println("force: " + force);

        List<Integer> man = List.of(3,4);
        System.out.println("man: " + man);

        List<Integer> can = Arrays.asList(5, 6);
        System.out.println("can: " + can);

        ArrayList<Integer> sand = new ArrayList<>(Arrays.asList(7,8));
        System.out.println("sand: " + sand);

        List<List<Integer>> doub = new ArrayList<>();
        doub.add(force);
        doub.add(man);
        System.out.println("printing doub: " + doub);
        System.out.println("index zero of doub: " + doub.get(1));
        System.out.println("index one of doub: " + doub.get(1));

        List<List<Integer>> d2 = new ArrayList<>();
        d2.add(can);
        d2.add(sand);
        System.out.println("printing d2: " + d2);
        System.out.println("printing index zero: " + d2.get(0));
        System.out.println("index 1: " + d2.get(1));

        List<List<List<Integer>>> possible = new ArrayList<>();
        possible.add(doub);
        possible.add(d2);
        System.out.println("printing List<List<List<Integer>>>: " + possible);
        System.out.println("printing index 0 of possibel: " + possible.get(0));
        System.out.println("printing index 1 of possible: " + possible.get(1));

        for (int i = 0; i < possible.size(); i++) {
            System.out.println("possible.get(i): " + possible.get(i));
            System.out.println("possible.get(i).get(0): " + possible.get(i).get(0));
            System.out.println("possible.get(i).get(0).get(0): " + possible.get(i).get(0).get(0));
        }

        List<int[]> listOfArrays = new ArrayList<>();
        int[] car = {11, 22};
        int[] mar = {33, 44};
        listOfArrays.add(car);
        System.out.println("added 1 array: " + listOfArrays);
        listOfArrays.add(mar);
        System.out.println("added 2nd array: " + Arrays.toString(listOfArrays.toArray()));
        System.out.println("added 2nd array: " + Arrays.toString(listOfArrays.get(0)));
        System.out.println("printing first value of 1st array: " + listOfArrays.get(0)[0]);


    }
}
