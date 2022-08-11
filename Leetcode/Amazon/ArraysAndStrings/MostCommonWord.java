package Amazon.ArraysAndStrings;

import java.util.*;

public class MostCommonWord {
    /** https://leetcode.com/problems/most-common-word/
    Given a string paragraph and a string array of the banned words banned, return the most frequent
    word that is not banned. It is guaranteed there is at least one word that is not banned, and that the
    answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.

     solution at bottom
     **/
    public String mostCommonWord(String paragraph, String[] banned) {
/*
can't split
substring ascending but there's commas periods.
we know char starts at 28 so we can do 28-128
can't split, what do you split it with? and how to subtract commas and periods .
we can check if there's commas and periods.

first make it all lower? we can split based on space,
and then subtract commas and periods,
    only have to check the beginning and end, soemetimes there can be 2 like ." or ,"

then if word .equals banned word, we remove based on index of the list
then map out everything and add to value for each key-value pair
 */
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

    public String mostCommonWordSolved(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for(String word : banned) if(map.containsKey(word)) map.remove(word);
        String res = null;
        for(String word : map.keySet())
            if(res == null || map.get(word) > map.get(res))
                res = word;
        return res;
    }

    public String mostCommonWordSolution(String paragraph, String[] banned) {

        // 1). replace the punctuations with spaces,
        // and put all letters in lower case
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // 2). split the string into words
        String[] words = normalizedStr.split("\\s+");

        Set<String> bannedWords = new HashSet();
        for (String word : banned)
            bannedWords.add(word);

        Map<String, Integer> wordCount = new HashMap();
        // 3). count the appearance of each word, excluding the banned words
        for (String word : words) {
            if (!bannedWords.contains(word))
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 4). return the word with the highest frequency
        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
