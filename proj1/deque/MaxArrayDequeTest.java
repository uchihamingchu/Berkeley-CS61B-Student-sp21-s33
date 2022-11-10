package deque;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Comparator;

class compareInt implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return a - b;
    }
}

public class MaxArrayDequeTest {
    public static void main (String[] args) {
        //Comparator<Integer> c = Comparator<Integer>();
//       // ArrayDeque<Integer> a = ArrayDeque<>();
//        MaxArrayDeque<Integer> a = MaxArrayDeque<>();


        compareInt c = new compareInt();
        System.out.println("result" + c.compare(1, 2));

        MaxArrayDeque<Integer> a = new MaxArrayDeque<>(c);
        a.printDeque();
        for (int i = 0; i < 10; i++) {
            a.addLast(i);
        }
        a.printDeque();
        System.out.println("max" + a.max());
    }
}
