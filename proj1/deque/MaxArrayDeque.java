package deque;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    Comparator<T> cmp;

    public MaxArrayDeque() {
        super();
    }

    public MaxArrayDeque(Comparator<T> c) {
        super();
        cmp = c;
    }


    public T max() {
        int temp = 0;
        for (int i = 0; i < size(); i++) {
            if (cmp.compare(get(temp), get(i)) < 0) {
                temp = i;
            }
        }
        return get(temp);
    }

    public T max(Comparator<T> c) {
        int temp = 0;
        for (int i = 0; i < size(); i++) {
            if (c.compare(get(temp), get(i)) < 0) {
                temp = i;
            }
        }
        return get(temp);
    }
}
