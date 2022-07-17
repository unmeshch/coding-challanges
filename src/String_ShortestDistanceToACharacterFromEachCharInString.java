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
 * As of now solution has O(2n) time complexity
 *
 * @author Unmesh Chougule
 */
public class String_ShortestDistanceToACharacterFromEachCharInString {

    public static void main(String[] args) {
        final String input = "LoveToCode";
        int[] arr = new int[input.length()];
        char specificChar = 'e';

        solution(arr, input, specificChar);

        System.out.println("Input string : "+input);
        System.out.printf("Output wrt '%s' : ",specificChar);
        ElementsPrinter.print(arr);
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
}