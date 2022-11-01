
public class LinkedIntList {
    public static class ListNode{
        public int data;
        public ListNode next;

        public ListNode (){
            this (0, null);
        }

        public ListNode (int data){
            this (data, null);
        }

        public ListNode (int data, ListNode next){
            this.data = data;
            this.next = next;
        }
    }

    private ListNode first;

    public LinkedIntList (){
        this.first = null;
    }
    public LinkedIntList(ListNode first){
        this.first = first;
    }

    public LinkedIntList (int data){
        first = new ListNode(data);
    }

    public static void main (String[] args) {
        LinkedIntList list = new LinkedIntList();
        list.add (0);
        list.add (1);
        list.add (5);
        list.add (7);
        System.out.println(list);
        //System.out.println("index: " + list.indexOf(2));
        System.out.println(list.toString());
        System.out.println("list size is:" + list.size());
        //list.remove(0);
        //System.out.println(list);
        //LinkedIntList list2 = list.squareList();
        //System.out.println ("The Squared list is:" + list2);
        //System.out.println (list.hasTwoConsecutive());
        //System.out.println (list2.hasTwoConsecutive());
        //System.out.println ("Sorted? :" + list.isSorted());
        //list.reverse3();
        //System.out.println ("reverse:" + list);
        //list.removeAll(0);
        //System.out.println ("Removed:" + list);
        //LinkedIntList list3 = list.removeEvens();
        //System.out.println("Remove Evens:" + list);
        //System.out.println(list3);
        //list.doubleList();
        //System.out.println ("new double list: "+ list);
        LinkedIntList list4 = list.reverseNonDestructive();
        System.out.println ("reverse list results: new list is: " + list4);
    }

    public void add (int value){
        if (first == null){
            first = new ListNode(value);
        } else {
            ListNode p = first;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new ListNode(value);
        }
    }

    public int size (){
        int size = 0;
        ListNode p = first;
        while (p != null){
            p = p.next;
            size ++;
        }
        return size;
    }

    public int get (int index){
        ListNode p = first;
        for (int i = 0; i < index; i++){
            p = p.next;
        }
        return p.data;
    }

    public void PrintString (){
        System.out.print ("[ ");
        ListNode p = first;
        if (first != null) {
            System.out.print(first.data);
            while (p != null) {
                System.out.print("," + p.data);
                p = p.next;
            }
        }
        System.out.println(" ]");
    }

    public String toString (){
        if (first == null){
            return "[]";
        } else {
            String result = "[" + first.data;
            ListNode p = first.next;
            while (p != null){
                result += "," + p.data;
                p = p.next;
            }
            result += "]";
            return result;
        }
    }

    public int indexOf (int value) {
        int index = 0;
        ListNode p = first;
        while (p != null){
            if (p.data == value){
                return index;
            }
            index ++;
            p = p.next;
        }
        return -1;
    }

    public void add (int index, int data){
        if (first == null || index == 0){
            first = new ListNode(data, first);
        } else {
            ListNode p = first;
            for (int i = 0; i < index -1; i++){
                p = p.next;
            }
            p.next = new ListNode (data, p.next);
        }
    }

    public void remove (int index){
        if (first == null){
            System.out.println ("Empty List!");
            return;
        }
        if (index == 0){
            first = first.next;
        } else {
            ListNode p = first;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            p.next = p.next.next;
        }
    }

    public LinkedIntList copyList (){
        if (first == null) {
            System.out.println ("Cannot Copy Empty List!");
            return null;
        }
        ListNode p = first;
        ListNode NewFirst = new ListNode(first.data);
        ListNode current = NewFirst;
        p = p.next;
        while (p != null){
            current.next = new ListNode(p.data);
            p = p.next;
            current = current.next;
        }
        LinkedIntList NewList = new LinkedIntList(NewFirst);
        return NewList;
    }

    public LinkedIntList squareList (){
        if (first == null) {
            System.out.println ("Cannot Square Empty List!");
            return null;
        }
        ListNode p = first;
        ListNode NewFirst = new ListNode(first.data*first.data);
        ListNode current = NewFirst;
        p = p.next;
        while (p != null){
            current.next = new ListNode(p.data*p.data);
            p = p.next;
            current = current.next;
        }
        LinkedIntList NewList = new LinkedIntList(NewFirst);
        return NewList;
    }

    public boolean hasTwoConsecutive () {
        if (first == null || first.next == null) {
            return false;
        }
        ListNode p = first;
        while (p.next != null){
            if (p.data == p.next.data - 1){
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public boolean isSorted (){
        if (first == null){
            return true;
        }
        ListNode p = first;
        while (p.next != null){
            if (p.data > p.next.data){
                return false;
            }
            p = p.next;
        }
        return true;
    }

    public void slutter (){
        ListNode p = first;
        while (p != null){
            p.next = new ListNode(p.data, p.next);
            p = p.next.next;
        }
    }

    public void reverse3 (){
        ListNode current = first;
        while (current != null && current.next != null && current.next.next != null){
            int temp = current.data;
            current.data = current.next.next.data;
            current.next.next.data = temp;
            current = current.next.next.next;
        }
    }


    public void removeAll (int value){
        if (first != null && first.data == value) {
            first = first.next;
        }
        if (first != null) {
            ListNode p = first;
            while (p.next != null) {
                if (p.next.data == value) {
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
        }
    }

    public LinkedIntList removeEvens (){
        LinkedIntList newList = new LinkedIntList();
        if (first != null){
            newList.first = first.next;
            ListNode list1 = first;
            ListNode list2 = first.next;

            while (list1.next != null && list2.next != null){
                list1.next = list1.next.next;
                list2.next = list2.next.next;
                list1 = list1.next;
                list2 = list2.next;

            }
                list1.next = null;
        }
        return newList;
    }

    public void doubleList (){
    if (first != null) {
        ListNode list2 = new ListNode(first.data);
        ListNode p = list2;
        ListNode current = first;
        while (current.next != null) {
            current = current.next;
            p.next = new ListNode(current.data);
            p = p.next;
        }
        current.next = list2;
    }
    }

    public LinkedIntList reverseNonDestructive (){
        LinkedIntList result = new LinkedIntList();
        if (first != null) {
            ListNode head = new ListNode(first.data);
            ListNode p = first;
            p = p.next;
            while (p != null) {
                head = new ListNode(p.data, head);
                p = p.next;
            }
            result.first = head;
        }
        return result;
    }


    public void reverseDestructive (){
        if (first != null){
            ListNode p = first;
        }
    }

}
