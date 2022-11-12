package deque;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class DequeTest {
    @Test
    public void ArrayDequeRandomizedTest() {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 6);
            int randVal = StdRandom.uniform(0, 100);
            if (operationNumber == 0) {
                dq.addFirst(randVal);
                System.out.println("ArrayDeque add first: " + randVal);
            } else if (operationNumber == 1) {
                dq.addLast(randVal);
                System.out.println("ArrayDeque add last: " + randVal);
            } else if (operationNumber == 2) {
                int size = dq.size();
                System.out.println("ArrayDeque size: " + size);
            } else if (dq.size()> 0 && operationNumber == 3) {

            } else if (dq.size()> 0 && operationNumber == 4) {
                int removed = dq.removeFirst();
                //assertEquals(firstItem, removed);
                System.out.println("ArrayDeque remove first: " + removed);
            } else if (dq.size()> 0 && operationNumber == 5) {
                int removed = dq.removeLast();
                System.out.println("ArrayDeque remove last: " + removed);
            }
        }
    }

    @Test
    public void LinkedListDequeRandomizedTest() {}
}

