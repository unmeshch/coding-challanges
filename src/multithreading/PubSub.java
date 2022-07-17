package multithreading;

/**
 * TODO
 * Problem statement : Run two threads such that one will print 1..2..3 and other will print A..B..C
 * The condition here is the printing of these two threads should be interleaved i.e.
 * thread one prints 1 then thread two prints A, again thread one prints 2 then thread two prints B
 * Expected output would look like : 1 A 2 B 3 C 4 D
 * @author Unmesh Chougule
 */
public class PubSub {

    public static void main(String[] args) {

        PubSub pubSub = new PubSub();
        new Thread(pubSub.getNumberPrinter()).start();
        new Thread(pubSub.getAlphabetPrinter()).start();
    }

    /**
     * Gives logic to Print number which waits for next alphabet to print before printing next number again
     * @return lambda expression of the expected logic
     */
    public Runnable getNumberPrinter() {
        return () -> {

        };
    }

    /**
     * Gives logic to Print alphabet which waits for next number to print before printing next alphabet again
     * @return lambda expression of the expected logic
     */
    public Runnable getAlphabetPrinter() {
        return () -> {

        };
    }
}
