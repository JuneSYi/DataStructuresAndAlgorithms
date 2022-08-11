package RandomJavaSandBox;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Hashtabledemo {

    public static void main(String[] args) {
        Hashtable<String, Double> firstHash = new Hashtable<>();
        firstHash.put("Apple", 2.99);
        firstHash.put("Orange", 1.99);
        firstHash.put("Peach", 4.99);
        firstHash.put("Banana", 0.99);
        firstHash.put("Kiwi", 1.99);

        System.out.println("Initial table is: " + firstHash);
        System.out.println("Apple prices are: " + firstHash.get("Apple"));


    }
}
