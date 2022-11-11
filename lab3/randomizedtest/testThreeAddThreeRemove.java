import org.junit.Test;
import randomizedtest.AListNoResizing;
import randomizedtest.BuggyAList;
import static org.junit.Assert.*;
//package randomizedtest;

public class testThreeAddThreeRemove {
    @Test
    public void mySimpleTest() {
        AListNoResizing<Integer> lst1 = new AListNoResizing<>();
        BuggyAList<Integer> lst2 = new BuggyAList<>();
        for (int i = 0; i < 4; i++) {
            lst1.addLast(i);
            lst2.addLast(i);
        }
        assertEquals(lst1.size(), lst2.size());
        int i = lst1.removeLast();
        int j = lst2.removeLast();
        assertEquals(i, j);
        assertEquals(lst1.removeLast(), lst2.removeLast());
        assertEquals(lst1.removeLast(), lst2.removeLast());
    }

    @Test
    public void AListRandomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                //System.out.println("AListNoResizing addLast(" + randVal + ")");
                L2.addLast(randVal);
                //System.out.println("BuggyAList addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                //System.out.println("AListNoResizing size: " + size);
                int size2 = L2.size();
                //System.out.println("BuggyAList size: " + size2);
                assertEquals(size, size2);
            } else if (L.size() > 0 && L2.size() > 0 && operationNumber == 2) {
                int LLast = L.getLast();
                //System.out.println("AListNoResizing getLast(" + LLast + ")");
                int LLast2 = L2.getLast();
                //System.out.println("BuggyAList getLast(" + LLast2 + ")");
                assertEquals(LLast, LLast2);
                int last = L.removeLast();
                //System.out.println("AListNoResizing removeLast(" + last + ")");
                int last2 = L2.removeLast();
                //System.out.println("BuggyAList removeLast(" + last2 + ")");
                assertEquals(last, last2);
            }
        }
    }
}
