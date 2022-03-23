package CompanyX;

import java.util.*;

public class Zero {
    /*
    you're given a list of a list of a list as a parameter. with the list it looks like this
    [
[["4/1",100], ["4/5",200]], // Company A
[["4/5", 50], ["4/8, 100]], // Company B
[["4/1", 200], ["4/8", 100]] // Company C
]

the string represents the date, the number represents like how much you have invested in units.
so like on company A for 4/1, you have 100 units invested
the outcome should be a list of a list showing something like this
[["4/1", 300], ["4/5", 450], ["4/8", 400]]

where the 300 4/1 represents the total units you have invested in each company

additional note is if the company doesn't indicate any units for that date, we assume that it's the same unit
as the last date it was shown. if there were not units shown at all prior then we put 0. so company B on "4/1"
should be 0. Company C on "4/5" would be 200 since "4/1" was last shown to be 200.
     */
    public List<List<Object>> soHard(List<List<List<Object>>> input) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < input.size(); i++) { // loops through initial by companies
            List<List<Object>> n = input.get(i);
            for (int j = 0; j < n.size(); j++) { // loops through dates of each company
                List<Object> m = input.get(i).get(j);
                //map.put(m.get(0), m.get(1));


            }
        }
        List<List<Object>> temp =  new ArrayList<>();
        return temp;
    }

    public static void main(String[] args) {
        Zero test = new Zero();

        ListInt one = new ListInt();
        one.ListInt("4/1", 100);
        ListInt two = new ListInt();
        two.ListInt("4/5", 200);
        ListInt three = new ListInt();
        three.ListInt("4/5", 50);
        ListInt four = new ListInt();
        four.ListInt("4/8", 100);
        ListInt five = new ListInt();
        five.ListInt("4/1",200);
        ListInt six = new ListInt();
        six.ListInt("4/8", 100);

        List<ListInt> first = new ArrayList<>();
        first.add(one);
        first.add(two);

        List<ListInt> second = new ArrayList<>();
        second.add(three);
        second.add(four);

        List<ListInt> third = new ArrayList<>();
        third.add(five);
        third.add(six);

        List<List<ListInt>> finalInput = new ArrayList<>();
        finalInput.add(first);
        finalInput.add(second);
        finalInput.add(third);

        for (int i = 0; i < finalInput.size(); i++) {
            System.out.println(finalInput.get(i).toString());
        }

    }
}

class ListInt {
    String first;
    int second;

    public void ListInt(String first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return (this.first + " " + this.second);
    }
}