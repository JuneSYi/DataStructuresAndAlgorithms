package Math.Bitwise;
//INCOMPLETE
public class addAsBinary {
    public String addBinary(String a, String b) {
        if (a.equals("0") && b.equals("0")) {
            return "0";
        }
        int aInt = 0;
        int bInt = 0;
        double exp = 0;
        // getting binary version of binary a, convert each 1 to int, add int, then convert back to binary
        for (int i =a.length()-1; i>=0; i--) {
            int dd = Integer.parseInt(String.valueOf(a.charAt(i))); //starting with most right number, finds int value
            if (dd == 0) { //if value is 0, we can go next
                exp++;
                continue;
            }
            aInt += (int)Math.pow(2,exp); // since dd = 1, we can find int by 2^value of exp
            exp++;
        }
        double expTwo = 0;
        for (int i =b.length()-1; i>=0; i--) {
            int cc = Integer.parseInt(String.valueOf(b.charAt(i)));
            if (cc == 0) {
                expTwo++;
                continue;
            }
            bInt += (int)Math.pow(2,expTwo);
            expTwo++;
        }
        int cInt = aInt + bInt; // using example 1, this is 4
        StringBuilder ans = new StringBuilder();
        for (int i = (int)(Math.log((double)cInt)/Math.log(2)); i >=0; i--) { // i starts at sqrt of cInt (2)
            if (cInt - (int)Math.pow(2,i) >= 0) { // if 2^i is less than cInt, we add a 1
                ans.append("1");
                cInt -= (int)Math.pow(2,i);
                continue;
            }
            ans.append("0");

        }
        return ans.toString();
            /*
            sqrt of 40 as int is 6, so i = 6-1 = 5

            40 -32 (2^5) = 32, appends 1

            8 - (2^4) =16, appends 0

            8 - (2^3) = 8, appends 1

            0 - (2^2) = 4, appends 0

            0 -  (2^1) = 2, appends 0

            0 - (2^0) = 1, appends 0
            */



    }
}
