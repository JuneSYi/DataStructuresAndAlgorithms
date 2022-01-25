public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 55, 66, 78};
        int target = 4;
        System.out.println(search(arr, target, 0, arr.length-1));
        System.out.println(nonRecurs(arr, 4));
    }

    // with recursion
    static int search(int[] array, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end-start)/2;

        if(array[mid] == target) {
            return mid;
        }
        if (target < array[mid]) {
            return search(array, target, start, mid-1); // you have to return it
        }
        return search(array, target, mid+1, end);
    }

    //non recurs
    static public int nonRecurs(int[] inputOne, int targetNumber) {
        int start = 0;
        int end = inputOne.length-1;
        int mid = (end+start) /2;

        while (inputOne[mid] != targetNumber) {
            if (targetNumber < inputOne[mid]) {
                end = mid;
            } else {
                start = mid;
            }
            mid = (end+start)/2;

        }
        return mid; //index where targetnumber resides
    }
}
