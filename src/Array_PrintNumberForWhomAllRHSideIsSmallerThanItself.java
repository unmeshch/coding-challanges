
/**
 * Problem statement : From a given array print all numbers such that, it has all small/equal numbers on its right-hand side in the array
 * Example : arr = {50, 3, 15, 5, 9, 30, 16, 1, 0}
 * Output = 50, 30, 16, 1, 0
 *
 * Solution has O(n) time complexity
 *
 * @author Unmesh Chougule
 */
public class Array_PrintNumberForWhomAllRHSideIsSmallerThanItself {

    public static void main(String[] args) {
        int[] arr = {50, 3, 15, 5, 9, 30, 16, 1, 0};
        solution(arr);
    }

    /**
     * Prints all numbers in given array such that it is large/equal to as compared all elements in its left-hand side in the array
     * @param arr given array
     */
    public static void solution(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int maxNumberTillNow = 0;
        //traverse from last and maintain the largest number found to compare each number with it
        for (int i=arr.length-1; i>=0; i--) {
            int currNum = arr[i];
            if (currNum >= maxNumberTillNow) {
                maxNumberTillNow = currNum; //update max number found till now
                System.out.print(currNum + " ");
            }
        }

    }
}