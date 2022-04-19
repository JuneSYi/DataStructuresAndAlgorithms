package Google.OA;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        /*
        loop through each emails[i]
        for each emails[i]

        maybe i'll have a new string[] that i
        */
        HashSet<String> set = new HashSet<>();
        for (int i =0; i < emails.length; i++) {
            String word = "";
            for (int j=0; i<emails[i].length(); j++) {
                if (emails[i].charAt(j) == '.') continue;
                if (emails[i].charAt(j) == '+' || emails[i].charAt(j) == '@') break;
                word = word + String.valueOf(emails[i].charAt(j));
            }
            for (int j=emails[i].length()-1; j>=0; j--) {
                if (emails[i].charAt(j) == '@') break;
                word = word + String.valueOf(emails[i].charAt(j));
            }
            set.add(word);
        }
        return set.size();
    }

    /**
     * using split and replace
     */
    public int numUniqueEmailsClean(String[] emails) {
        // hash set to store all the unique emails
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            // split into two parts local and domain
            String[] parts = email.split("@");

            // split local by '+'
            String[] local = parts[0].split("\\+");

            // remove all '.', and concatenate '@' and append domain
            uniqueEmails.add(local[0].replace(".", "") + "@" + parts[1]);
        }

        return uniqueEmails.size();
    }
}
