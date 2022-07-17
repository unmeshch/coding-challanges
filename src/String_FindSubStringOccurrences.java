
/**
 * Problem statement : Given a string S and another string sub, find number of occurrences of sub in S
 * Example : S = "abcdxabcabcwegab", sub = "abc"
 * output = 3 (as abc is present 3 times in the given string)
 *
 * @author Unmesh Chougule
 */
public class String_FindSubStringOccurrences {

    public static void main(String[] args) {
        final String input = "abcdxabcabcwegab";
        final String sub = "abc";
        int count = solution(input, sub);
        System.out.printf("Substring '%s' occurs '%d' times in input '%s' string", sub, count, input);
    }

    /**
     * Returns number of occurrences of given substring in the input string
     * @param input given string
     * @param sub sub string to be checked for
     * @return number of occurrences
     */
    public static int solution(final String input, final String sub) {
        if (input == null || input.trim().length() == 0) {
            return 0;
        }

        int occurrenceCount = 0;

        int traverseCounter = 0;
        while (traverseCounter < input.length()) {
            int subi = 0;
            while (traverseCounter < input.length() && input.charAt(traverseCounter) == sub.charAt(subi)) {
                if (subi == sub.length()-1) {
                    occurrenceCount++;
                    break;
                }
                traverseCounter++;
                subi++;
            }
            traverseCounter++;
        }

        return occurrenceCount;
    }
}
