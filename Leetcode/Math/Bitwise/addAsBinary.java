package Math.Bitwise;
//INCOMPLETE
public class addAsBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(); //Google immutability or string vs stringbuilder if you don't know why we use this instead of regular string
        int i = a.length() - 1, j = b.length() -1, carry = 0; //two pointers starting from the back, just think of adding two regular ints from you add from back
        while (i >= 0 || j >= 0) {
            int sum = carry; //if there is a carry from the last addition, add it to carry
            if (j >= 0) sum += b.charAt(j--) - '0'; //we subtract '0' to get the int value of the char from the ascii
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2); //if sum==2 or sum==0 append 0 cause 1+1=0 in this case as this is base 2 (just like 1+9 is 0 if adding ints in columns)
            carry = sum / 2; //if sum==2 we have a carry, else no carry 1/2 rounds down to 0 in integer arithematic
        }
        if (carry != 0) sb.append(carry); //leftover carry, add it
        return sb.reverse().toString();
    }

}

/**
 * my attempt below (failed)
 */
//    public String addBinary(String a, String b) {
//        if (a.equals("0") && b.equals("0")) {
//            return "0";
//        }
//        int aInt = 0;
//        int bInt = 0;
//        double exp = 0;
//        // getting binary version of binary a, convert each 1 to int, add int, then convert back to binary
//        for (int i =a.length()-1; i>=0; i--) {
//            int dd = Integer.parseInt(String.valueOf(a.charAt(i))); //starting with most right number, finds int value
//            if (dd == 0) { //if value is 0, we can go next
//                exp++;
//                continue;
//            }
//            aInt += (int)Math.pow(2,exp); // since dd = 1, we can find int by 2^value of exp
//            exp++;
//        }
//        double expTwo = 0;
//        for (int i =b.length()-1; i>=0; i--) {
//            int cc = Integer.parseInt(String.valueOf(b.charAt(i)));
//            if (cc == 0) {
//                expTwo++;
//                continue;
//            }
//            bInt += (int)Math.pow(2,expTwo);
//            expTwo++;
//        }
//        int cInt = aInt + bInt; // using example 1, this is 4
//        /**
//         * we know that  log(a base b) = n == a = b^n
//         * we have the int version of the number that is summed (cint)
//         * we want to convert it to binary, how?
//         * if we use log (cInt base 2) = n, that's same as cInt = 2^n
//         */
//        StringBuilder ans = new StringBuilder();
//        for (int i = (int)(Math.log((double)cInt)/Math.log(2)); i >=0; i--) { // i starts at sqrt of cInt (2)
//            if (cInt - (int)Math.pow(2,i) >= 0) { // if 2^i is less than cInt, we add a 1
//                ans.append("1");
//                cInt -= (int)Math.pow(2,i);
//                continue;
//            }
//            ans.append("0");
//
//        }
//        return ans.toString();
//            /*
//            sqrt of 40 as int is 6, so i = 6-1 = 5
//
//            40 -32 (2^5) = 32, appends 1
//
//            8 - (2^4) =16, appends 0
//
//            8 - (2^3) = 8, appends 1
//
//            0 - (2^2) = 4, appends 0
//
//            0 -  (2^1) = 2, appends 0
//
//            0 - (2^0) = 1, appends 0
//            */
//
//
//
//    }

