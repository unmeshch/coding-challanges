
/**
 * TODO in progress
 * Problem statement : Find duplicate number and missing number in a given array,
 * constraints = arr[i] > 0 AND arr[i] <= arr.length
 *
 * @author Unmesh Chougule
 */
public class Array_FindMissingAndDuplicateNumber {

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 5, 6};
        solution(arr);
    }

    public static void solution(final int[] arr) {
        int n = arr.length;

        int missing = 0;
        int duplicate = 0;
        for (int i=0; i<n; i++) {
            int num = Math.abs(arr[i]);
            if (arr[num-1] < 0) {
                duplicate = num;
            } else {
                arr[num-1] = arr[num-1] * -1;
            }
        }

        System.out.println("Duplicate : "+duplicate);
    }
}
