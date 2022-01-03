package Math.Bitwise;

/**
 *  GOOGLE Question:
 * Flipping an image (leetcode)
 * Given an n x n binary matrix image, flip the image horizontally, then invert it, then return the resulting image.
 * To flip an image horizontally means that each row of the image is reversed.
 * [1,1,0] --> [0,1,1]
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0
 * [0,1,1] --> [1,0,0]
 */
public class flipAnImage {
    public int[][] image(int[][] image) {
        for (int[] row : image) {
            // for every row in image, reverse this array
            for (int i = 0; i < (image[0].length +1) / 2; i++) {
                // swap, only need to do half the length since we're swapping
                int temp = row[i] ^ 1; // this xor will be applied to the value
                row[i] = row[image[0].length -i -1]^1; // can use row[i] because row will rotate through all arrays.
                //[i] calculation will go through every iteration per row
                //starting from 0, we take the opposite end and replace the beginning, this will flip all the values
                row[image[0].length-i-1] = temp;
                // [row[i], 1, row[image[0].length-i-1]]
                // [row[image[0].length-i-1]^1, 1, row[0]^1]

                // [row[image[0].length-i-1]^1, 1, row[0]^1]
                // [row[image[0].length-i-1]^1, row[image[1].length-i-1]-->>row[1]^1, row[0]^1]
                // [row[image[0].length-i-1]^1, row[1]^1, row[0]^1]

                //
            }
        }
        return image;
    }
}

