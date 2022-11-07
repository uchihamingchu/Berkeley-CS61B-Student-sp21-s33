public class ArrayIntList {
    private int[] elementData;
    private int size;

    public ArrayIntList(int size){
        int[] elementData = new int[size];
        size = size;
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




}
