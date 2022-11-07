package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int firstIndex;
    private int lastIndex;

    private static final int START_SIZE = 8;
    public ArrayDeque() {
        items = (T[]) new Object[START_SIZE];
        size = 0;
        firstIndex = 0;
        lastIndex = 1;
    }

    private ArrayDeque(int firstIndex){
        items = (T[]) new Object[START_SIZE];
        size = 0;
        this.firstIndex = firstIndex;
        this.lastIndex = firstIndex + 1;
    }

    // create a deep copy of other
    public ArrayDeque(ArrayDeque other){
        items = (T[]) new Object[other.items.length];
        firstIndex = other.firstIndex;
        lastIndex = other.firstIndex + 1;
        size = 0;
        for (int i = 1; i < other.size + 1; i ++){
            addLast((T) other.items[(other.firstIndex + i) % other.items.length]);
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
    public void addFirst(T item){
        if (size == items.length) {
            resizeUp();
        }
        items[firstIndex] = item;
        firstIndex = (firstIndex -1 + items.length) % items.length;
        size++;
    }
    public void addLast(T item){
        if (size == items.length) {
            resizeUp();
        }
        items[lastIndex] = item;
        lastIndex = (lastIndex +1) % items.length;
        size++;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){return size;}
//    private void printDeque(){
//        String result = "[" + items[(firstIndex+1) % items.length];
//        for (int i = 2; i < size+1; i++){
//            result += " " + items[(firstIndex+i) % items.length];
//        }
//        result += "]";
//        System.out.println(result);
//    }

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
    public T removeFirst(){
//        if (size < items.length*0.25){
//            resizeDown();
//        }
        if (size == 0) {
            return null;
        } else {
            T item = items[(firstIndex + 1) % items.length];
            items[(firstIndex + 1) % items.length] = null;
            size--;
            firstIndex = (firstIndex + 1) % items.length;
            return item;
        }
    }
    public T removeLast(){
//        if (size < items.length*0.25){
//            resizeDown();
//        }
        if (size == 0) {
            return null;
        } else {
            T item = items[(lastIndex - 1 + items.length) % items.length];
            items[(lastIndex - 1 + items.length) % items.length] = null;
            size--;
            lastIndex = (firstIndex - 1 + items.length) % items.length;
            return item;
        }
    }
    public T get(int index){
        if (size == 0){
            return null;
        }
        T item = items[index];
        return item;
    }
    private void resizeUp(){
        T[] newList = (T[]) new Object[items.length *2];
        System.arraycopy(items, 0, newList, items.length, firstIndex +1);
        System.arraycopy(items,(firstIndex+1)% items.length,newList, (firstIndex+1)%items.length, items.length-firstIndex-1);
        lastIndex = items.length + lastIndex;
        items = newList;
    }

//    public void resizeDown(){
//        T[] newList = (T[]) new Object[items.length/4];
//        System.arraycopy(items, firstIndex+1, newList, 0, size);
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
////        System.out.println("First index is " + list1.firstIndex);
////        System.out.println("Last index is " + list1.lastIndex);
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

