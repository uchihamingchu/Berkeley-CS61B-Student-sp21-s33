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

    public ArrayDeque(int firstIndex){
        items = (T[]) new Object[START_SIZE];
        size = 0;
        this.firstIndex = firstIndex;
        this.lastIndex = firstIndex + 1;
    }

    // create a deep copy of other
    public ArrayDeque(ArrayDeque other){
        items = (T[]) new Object[other.items.length];
        firstIndex = other.firstIndex;
        lastIndex = other.lastIndex;
        size = 0;
        for (int i = 1; i < other.size + 1; i ++){
            addLast((T) other.items[(firstIndex + i) % other.items.length]);
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
            resize();
        }
        items[firstIndex] = item;
        firstIndex = (firstIndex -1 + items.length) % items.length;
        size++;
    }
    public void addLast(T item){
        if (size == items.length) {
            resize();
        }
        items[lastIndex] = item;
        lastIndex = (lastIndex +1) % items.length;
        size++;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){ return size;}
//    private void printDeque(){
//        String result = "[" + items[(firstIndex+1) % items.length];
//        for (int i = 2; i < size+1; i++){
//            result += " " + items[(firstIndex+i) % items.length];
//        }
//        result += "]";
//        System.out.println(result);
//    }

    public void printDeque(){
        String result = "[" + items[0];
        for (int i = 1; i < items.length; i++){
            result += " " + items[i];
        }
        result += "]";
        System.out.println(result);
    }
    public T removeFirst(){
        T item = items[firstIndex];
        items[firstIndex] = null;
        size--;
        firstIndex = (firstIndex + 1)% items.length;
        return item;
    }
    public T removeLast(){
        T item = items[lastIndex];
        items[lastIndex] = null;
        size --;
        lastIndex = (firstIndex - 1 + items.length) % items.length;
        return item;
    }
    public T get(int index){
        T item = items[index];
        return item;
    }
    public void resize(){
        T[] newList = (T[]) new Object[items.length *2];
        System.arraycopy(items, 0, newList, items.length, firstIndex +1);
        System.arraycopy(items,(firstIndex+1)% items.length,newList, (firstIndex+1)%items.length, items.length-firstIndex-1);
        lastIndex = items.length + lastIndex;
        items = newList;
    }

    public static void main(String[] args){
        ArrayDeque<Integer> list1 = new ArrayDeque<>(3);
        list1.addFirst(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(8);
//        //list1.removeLast();
        list1.addLast(9);
        list1.addLast(10);
        list1.addLast(11);
        list1.addLast(12);
        list1.addLast(13);
        list1.addLast(14);
        list1.addLast(15);
        list1.addLast(16);
        list1.addLast(17);
//       list1.addLast("your");
//        list1.addLast("name?");
        list1.printDeque();
        System.out.println("list size is " + list1.size);
        System.out.println(list1.get(3));
    }

}

