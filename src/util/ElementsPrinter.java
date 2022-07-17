package util;

import java.util.List;

/**
 * Class holds logic to print elements from the given array
 * @author Unmesh Chougule
 */
public class ElementsPrinter {

    private static final String SPACE = " ";

    /**
     * Prints elements of given array in space separated format
     * @param arr given int array
     */
    public static void print(final int[] arr) {
        for (int element : arr) {
            System.out.print(element + SPACE);
        }
        System.out.println();
    }

    /**
     * Prints elements of given list in space separated format
     * @param list given list
     */
    public static void print(final List list) {
        for (Object element : list) {
            System.out.print(element + SPACE);
        }
        System.out.println();
    }
}
