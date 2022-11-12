package deque;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Comparator;



public class MaxArrayDequeTest {

    public static class compareInt implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return a - b;
        }
    }
    public static void main (String[] args) {
        //Comparator<Integer> c = Comparator<Integer>();
//       // ArrayDeque<Integer> a = ArrayDeque<>();
//        MaxArrayDeque<Integer> a = MaxArrayDeque<>();


        Comparator<Integer> c = new compareInt();
        System.out.println("result" + c.compare(1, 2));

        MaxArrayDeque<Integer> a = new MaxArrayDeque<Integer>(c);
        a.printDeque();
        for (int i = 0; i < 100; i++) {
            a.addLast(i);
        }
        a.printDeque();
        System.out.println("max: " + a.max());
    }
}
