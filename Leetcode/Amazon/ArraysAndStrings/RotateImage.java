package Amazon.ArraysAndStrings;

public class RotateImage {
    public void rotate(int[][] matrix) {
        /*
        1,2,3 ;; 4,5,6, ;; 7,8,9
        7,4,1 ;; 8,5,2, ;; 9,6,3

        00,01,02 ;; 10,11,12 ; 20,21,22
        20,10,00 ;; 21,11,01 ; 22,21,20
        
        1,2,3,4, ;; 5.6.7.8 ;; 9.10.11.12 ;; 13.14.15.16
        13.9.5.1 ;; 14.10.6.2 ;; 15.11.7.8 ;; 16.12.8.4
        
        for each array, we allocate matrix[i][j] where [j] remains the same for the new array, but [i] value descends
        starting from length-1
        we can keep same array by using a temp to hold the numbers and then flip.
         */
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][j] = temp;
            }
        }
    }

    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     */
    public void rotateOptimal(int[][] matrix) {
        int s = 0, e = matrix.length - 1;
        while(s < e){
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++; e--;
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
