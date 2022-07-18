import util.ElementsPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement : Given a string S and a character C, return an array of int solution where solution[i]
 * is the distance from index i to the closest occurrence of character C in S.
 * Example : Input S = "abcdxydz", C = 'd'
 * solution = {3, 2, 1, 0, 1, 1, 0, 1}
 *
 * @author Unmesh Chougule
 */
public class String_ShortestDistanceToACharacterFromEachCharInString {

    public static void main(String[] args) {
        final String input = "LoveToCode";
        int[] arr = new int[input.length()];
        int[] arr2 = new int[input.length()];
        char specificChar = 'e';

        System.out.println("Input string : "+input);

        solution(arr, input, specificChar);
        System.out.printf("Output wrt '%s' using solution1 : ",specificChar);
        ElementsPrinter.print(arr);

        solution2(arr2, input, specificChar);
        System.out.printf("Output wrt '%s' using solution2 : ",specificChar);
        ElementsPrinter.print(arr2);
    }

    /**
     * Solution for the challenge, returns array with -1 in all places if no character occurrence in the string
     * @param arr output answer array
     * @param input string given
     * @param chr specific character
     */
    public static void solution(final int[] arr, final String input, final char chr) {
        if (input == null || input.trim().length() == 0) {
            return;
        }

        List<Integer> occurrenceList = new ArrayList<>(); // to store indexes of specific character occurrences in the string
        //find the specific character indexes in string
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == chr) {
                occurrenceList.add(i);
            }
        }

        //no occurrence of given character in string, fill output with -1 for all places
        if (occurrenceList.size() == 0) {
            Arrays.fill(arr, -1);
            return;
        }

        int occurrenceListCounter = 0;
        int prevNearestOccurrence = occurrenceList.get(occurrenceListCounter);
        int nextNearestOccurrence = occurrenceList.get(occurrenceListCounter);

        //now calculate distance for each char in the string
        for (int i=0; i<input.length(); i++) {

            //check if prev occurrence is nearer or next
            int distFromPrevNearestDistance = Math.abs(prevNearestOccurrence - i);
            int distFromNextNearestDistance = Math.abs(nextNearestOccurrence - i);

            if (distFromPrevNearestDistance < distFromNextNearestDistance) {
                arr[i] = distFromPrevNearestDistance;
            } else {
                arr[i] = distFromNextNearestDistance;
                if (++occurrenceListCounter < occurrenceList.size()) { //if no next occurrence then do not check for next
                    prevNearestOccurrence = nextNearestOccurrence;
                    nextNearestOccurrence = occurrenceList.get(occurrenceListCounter);
                }
            }
        }
    }

    /**
     * Solution for the challenge, returns array with -1 in all places if no character occurrence in the string
     * @param arr output answer array
     * @param input string given
     * @param chr specific character
     */
    public static void solution2(final int[] arr, final String input, final char chr) {
        if (input == null || input.trim().length() == 0) {
            return;
        }

        int[] tempArr = new int[arr.length];

        int leftNearestOccurrenceFound = -1;
        //traverse from left to right and get distance of character from left nearest occurrence only
        for (int i=0; i<arr.length; i++) {
            if (input.charAt(i) == chr) {
                leftNearestOccurrenceFound = i;
            }
            if (leftNearestOccurrenceFound > -1) {
                tempArr[i] = i - leftNearestOccurrenceFound;
            } else {
                tempArr[i] = Integer.MAX_VALUE;
            }
        }

        int rightNearestOccurrenceFound = -1;
        //traverse from right to left to get distance of character from right nearest occurrence
        for (int i=arr.length-1; i>=0; i--) {
            if (input.charAt(i) == chr) {
                rightNearestOccurrenceFound = i;
            }

            if (rightNearestOccurrenceFound > -1) {
                int diffFromRightNearestOccurrenceFound = rightNearestOccurrenceFound - i;
                arr[i] = Math.min(tempArr[i], diffFromRightNearestOccurrenceFound);
            } else if (leftNearestOccurrenceFound > -1) {
                arr[i] = tempArr[i];
            } else {
                arr[i] = -1;
            }
        }
    }
}