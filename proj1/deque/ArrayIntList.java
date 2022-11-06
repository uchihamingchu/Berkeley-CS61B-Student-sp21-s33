package deque;

public class ArrayIntList {
    private int[] elementData;
    private int size;

    public ArrayIntList(int value){
        elementData = new int[value];
        size = 0;
    }

    public ArrayIntList(){
        elementData = new int[100];
        size = 0;
    }

    public String toString() {
        String result = "[";
        if (size != 0){
            result += elementData[0];
            for (int i = 1; i <size; i++) {
                result += ", "+ elementData[i];
            }
        }
        result += "]";
        return result;
    }

    public void add(int value){
        elementData[size] = value;
        size++;
    }

    public int get(int index){
        return elementData[index];
    }

    public int indexOf(int value){
        for (int i = 0; i < size; i++){
            if (elementData[i] == value){
                return i;
            }
        }
        return -1;
    }

    public void remove(int index){
        checkIndex(index);
        for (int i = index; i < size -1 ; i++){
            elementData[i] = elementData[i+1];
        }
        size --;
    }

    public void add(int index, int value){
        checkIndex(index);
        for (int i = size; i > index; i--){
            elementData[i] = elementData[i-1];
        }
        elementData[index] = value;
        size ++;
    }

    private void checkIndex(int index){
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException("Index" + index + "is out of bound!");
    }

    public void addAll (ArrayIntList other){
        for (int i = 0; i < other.size; i++){
            add(other.elementData[i]);
        }
    }

    public boolean isPairwiseSorted(){
        boolean result = true;
        for (int i = 0; i < size -1; i += 2) {
            if (elementData[i] > elementData[i + 1]) {
                result = false;
            }
        }
            return result;
    }

    public void mirror(){
        for (int i = size -1; i >= 0; i--){
            add(elementData[i]);
        }
    }

    public ArrayIntList fromCounts(){
        ArrayIntList result = new ArrayIntList();
        for (int i = 0; i < size -1; i += 2){
            for (int j = 0; j < elementData[i]; j++){
                result.add(elementData[i+1]);
            }
        }
        return result;
    }

    public static void main(String[] args){
        ArrayIntList list1 = new ArrayIntList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        System.out.println(list1.toString());
        list1.remove(1);
        System.out.println("after removal " + list1.toString());
        list1.add(3, 0);
        //System.out.println(list1.get(1));
        System.out.println(list1);
        //System.out.println(list1.isPairwiseSorted());
        list1.mirror();
        System.out.println(list1);
        ArrayIntList list2 =list1.fromCounts();
        System.out.println("from counts result:" + list2);
        System.out.println(list2.size);
    }
}
