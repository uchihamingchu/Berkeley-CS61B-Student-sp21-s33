package deque;

public class ArrayDeque<T> implements Deque<T> {
    public T[] items;
    private int size;
    public int nextFirst;
    public int nextLast;

    private static final int START_SIZE = 8;
    public ArrayDeque() {
        items = (T[]) new Object[START_SIZE];
        size = 0;
        nextFirst = 0;
        nextLast = 0;
    }

    private ArrayDeque(int nextFirst){
        items = (T[]) new Object[START_SIZE];
        size = 0;
        this.nextFirst = nextFirst;
        this.nextLast = nextFirst;
    }

    // create a deep copy of other
    public ArrayDeque(ArrayDeque other){
        items = (T[]) new Object[other.items.length];
        nextFirst = other.nextFirst;
        nextLast = other.nextFirst + 1;
        size = 0;
        for (int i = 1; i < other.size + 1; i ++){
            addLast((T) other.items[(other.nextFirst + i) % other.items.length]);
        }
    }

//    private void add(T item, int index){
//        if (index < 0 || index > size){
//            throw new ArrayIndexOutOfBoundsException("Index Out of Bound!");
//        }
//        if (size == items.length){
//            resize();
//        }
//        for (int i = size; i >= index; i--){
//            items[i] = items [i-1];
//        }
//        items[index] = item;
//        size ++;
//    }
    @Override
    public void addFirst(T item){
        if (size == 0) {
            items[nextFirst] = item;
            nextFirst = (nextFirst -1 + items.length) % items.length;
            nextLast = (nextLast +1) % items.length;
            size++;
            return;
        }
        if (size == items.length) {
            resizeUp();
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst -1 + items.length) % items.length;
        size++;
    }
    @Override
    public void addLast(T item){
        if (size == 0) {
            items[nextLast] = item;
            nextFirst = (nextFirst -1 + items.length) % items.length;
            nextLast = (nextLast +1) % items.length;
            size++;
            return;
        }
        if (size == items.length) {
            resizeUp();
        }
        items[nextLast] = item;
        nextLast = (nextLast +1) % items.length;
        size++;
    }
    @Override
    public int size(){ return size;}
//    private void printDeque(){
//        String result = "[" + items[(nextFirst+1) % items.length];
//        for (int i = 2; i < size+1; i++){
//            result += " " + items[(nextFirst+i) % items.length];
//        }
//        result += "]";
//        System.out.println(result);
//    }
    @Override
    public void printDeque(){
//        String result1 = "[0";
        String result2 = "[" + items[0];
        for (int i = 1; i < items.length; i++){
//            result1 += " " + i;
            result2 += " " + items[i];
        }
 //       result1 += "]";
        result2 += "]";
 //       System.out.println(result1);
        System.out.println(result2);
    }
    @Override
    public T removeFirst(){
//        if (size < items.length*0.25){
//            resizeDown();
//        }
        if (size == 0) {
            return null;
        } else if (size == 1) {
            T item = items[(nextFirst + 1) % items.length];
            items[(nextFirst + 1) % items.length] = null;
            size--;
            nextFirst = (nextFirst + 1) % items.length;
            nextLast = nextFirst;
            return item;
        } else {
            T item = items[(nextFirst + 1) % items.length];
            items[(nextFirst + 1) % items.length] = null;
            size--;
            nextFirst = (nextFirst + 1) % items.length;
            return item;
        }
    }
    @Override
    public T removeLast(){
//        if (size < items.length*0.25){
//            resizeDown();
//        }
        if (size == 0) {
            return null;
        } else if (size == 1) {
            T item = items[(nextLast - 1 + items.length) % items.length];
            items[(nextLast - 1 + items.length) % items.length] = null;
            size--;
            nextLast = (nextLast - 1 + items.length) % items.length;
            nextFirst = nextLast;
            return item;
        } else {
            T item = items[(nextLast - 1 + items.length) % items.length];
            items[(nextLast - 1 + items.length) % items.length] = null;
            size--;
            nextLast = (nextLast - 1 + items.length) % items.length;
            return item;
        }
    }
    @Override
    public T get(int index){
        if (index < 0 || index >= items.length){
            throw new ArrayIndexOutOfBoundsException("Index Out of Bound!");
        }
        T item = items[index];
        return item;
    }
    private void resizeUp(){
        T[] newList = (T[]) new Object[items.length *2];
//        System.arraycopy(items, 0, newList, items.length, nextFirst +1);
//        System.arraycopy(items,(nextFirst+1)% items.length,newList, (nextFirst+1)%items.length, items.length-nextFirst-1);
        System.arraycopy(items, 0, newList, items.length, nextFirst);
        System.arraycopy(items,nextFirst,newList, nextFirst, items.length-nextFirst);
        nextLast = items.length + nextLast;
        items = newList;
    }

//    public void resizeDown(){
//        T[] newList = (T[]) new Object[items.length/4];
//        System.arraycopy(items, nextFirst+1, newList, 0, size);
//
//    }

    public static void main(String[] args){
//        ArrayDeque<Integer> list1 = new ArrayDeque<>(3);
//        System.out.println("list size is " + list1.size);
//        for (int i = 0; i < 100; i++){
//            list1.addLast(i);
//        }
////       list1.addLast("your");
////        list1.addLast("name?");
//        list1.printDeque();
//        System.out.println("list size is " + list1.size);
////        System.out.println(list1.get(3));
//        ArrayDeque newdeque = new ArrayDeque(list1);
//        newdeque.printDeque();
////        System.out.println("After Removal:");
////        System.out.println("First index is " + list1.nextFirst);
////        System.out.println("Last index is " + list1.nextLast);
//        list1.removeLast();
//        list1.removeFirst();
//        list1.printDeque();
//        newdeque.printDeque();
//
//
    }

//    public void selectionSort(){
//        for (int i = 0; i < size; i++){
//            T smallestItem = items[i];
//            for (int j = i; j < size; j++){
//                if (smallestItem.compareTo(items[j]) < 0){
//                    smallestItem = items[j];
//                }
//            }
//            T temp = items[i];
//            items[i] = smallestItem;
//            smallestItem = temp;
//        }
//    }
}

