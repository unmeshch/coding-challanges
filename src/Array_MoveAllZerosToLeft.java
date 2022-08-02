import util.ElementsPrinter;

/**
 * Move all zero in the given array to left, without changing the order of all other elements
 *
 * e.g. inout = {1,50,35,0,7,45,0}  output = {0,0,1,50,35,7,45}
 *
 * @author Unmesh Chougule
 */
public class Array_MoveAllZerosToLeft {

    public static void main(String[] args) {
        int[] arr = {1,50,35,0,7,45,0};
        solution(arr);
        System.out.println("Array after moving zeros : ");
        ElementsPrinter.print(arr);
    }

    /**
     * TODO : check if time complexity can be improved. Space complexity is already O(1)
     * Moves all zeros in given array to left without changing the order of other elements
     * @param arr given array
     */
    public static void solution(final int[] arr) {
        if (arr.length<1) return;

        int left = 0;
        int right = -1;

        while (right < arr.length-1) {
            right++;
            if (arr[right] == 0) {
                //once we find zero in array, swap all the elements before that to make space for this zero in left most side
                for (int i=right; i>left; i--) {
                    swap(arr, i, i-1);
                }
                left++;
            }
        }
    }

    /**
     * Swaps two elements in given array at given indexes
     * @param arr given array
     * @param from index one
     * @param to index two
     */
    private static void swap(final int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
