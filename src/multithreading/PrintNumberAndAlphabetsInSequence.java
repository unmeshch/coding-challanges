package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Problem statement : Run two threads such that one will print 1..2..3 and other will print A..B..C
 * The condition here is the printing of these two threads should be interleaved i.e.
 * thread one prints 1 then thread two prints A, again thread one prints 2 then thread two prints B
 * Expected output would look like : 1 A 2 B 3 C 4 D
 * @author Unmesh Chougule
 */
public class PrintNumberAndAlphabetsInSequence {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        PrintNumberAndAlphabetsInSequence pubSub = new PrintNumberAndAlphabetsInSequence();
        new Thread(pubSub.getNumberPrinter(queue)).start();
        new Thread(pubSub.getAlphabetPrinter(queue)).start();
    }

    /**
     * Gives logic to produce numbers, which are published in the queue
     * @return lambda expression of the expected logic
     */
    public Runnable getNumberPrinter(final BlockingQueue<Integer> queue) {
        return () -> {
            int limit = 10;
            for (int i=1; i<=limit; i++) {
                /*if (i==5) {
                    try {
                        System.out.println("Test waiting 3 seconds to produce next number to see if alphabet printer also waits for this.");
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted while sleeping : "+e);
                    }
                }*/
                queue.add(i);
            }
        };
    }

    /**
     * Gives logic to Print alphabet which waits for next number to be available in the queue before printing next alphabet again
     * @return lambda expression of the expected logic
     */
    public Runnable getAlphabetPrinter(final BlockingQueue<Integer> queue) {
        return () -> {
            char limit = 'J';
            for (char i='A'; i<=limit; i++) {
                try {
                    int nextNum = queue.take();
                    System.out.println(nextNum + " " +i);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted while waiting for next number : "+e);
                }
            }
        };
    }
}
