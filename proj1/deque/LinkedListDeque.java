
package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListDeque<T> {
    private class TNode {
        private T item;
        private TNode prev;
        private TNode next;

        public TNode() {
            this(null, null, null);
        }

        public TNode(T item) {
            this(item, null, null);
        }

        public TNode(T item, TNode prev, TNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public T getItem() {
            return item;
        }

        public TNode getPrev() {
            return prev;
        }

        public TNode getNext() {
            return next;
        }

        public void setPrev(TNode p) {
            prev = p;
        }

        public void setNext(TNode n) {
            next = n;
        }

        public void setItem(T item) {
            this.item = item;
        }

//        public T getRecursive(int index) {
//            if (index == 0){
//                return getItem();
//            }
//            return getNext().getRecursive(index-1);
//        }
    }

    private TNode header;
    private TNode trailer;
    private int size;


    public LinkedListDeque() {
        header = new TNode();
        trailer = new TNode(null, header, null);
        header.setNext(trailer);
    }

    // create a deep copy of other
    public LinkedListDeque(LinkedListDeque other){
        header = new TNode();
        trailer = new TNode(null, header, null);
        header.setNext(trailer);
        if (!other.isEmpty()){
            TNode p = (TNode) other.header;
            while (p.getNext()!= trailer) {
                T item = (T) p.getNext().getItem();
                addLast(item);
                p = p.next;
            }
        }
        size = other.size();
    }

    public void addFirst(T item) {
        addBetween(item, header, header.getNext());
    }

    public void addLast(T item) {
        addBetween(item, trailer.getPrev(), trailer);
    }

    public void addBetween (T item, TNode prev, TNode next){
        TNode node = new TNode(item, prev, next);
        prev.setNext(node);
        next.setPrev(node);
        size ++;
    }
    public void addBetween(T item, T prev, T next) {
        TNode prevNode = this.getTNode(prev);
        TNode nextNode = this.getTNode(next);
        if (prevNode == null || nextNode == null || prevNode.getNext() != nextNode){
            System.out.println("Invalid Insertion!");
        } else if (prevNode.getNext() == nextNode) {
            TNode node = new TNode(item, prevNode, nextNode);
            prevNode.setNext(node);
            nextNode.setPrev(node);
            size++;
        }
    }

    private TNode getTNode (T item){
        TNode p = header.getNext();
        while (p != trailer){
            if (p.getItem().equals(item)){
                return p;
            }
            p = p.getNext();
        }
        System.out.println("No Identical Item Found!");
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        TNode p = header;
        String s = "Deque:";
        while (p.getNext() != trailer) {
            p = p.getNext();
            s += p.getItem() + " ";
        }
        System.out.println(s);
    }

    public T removeFirst() {
        if (size != 0) {
            TNode node = header.getNext();
            T item = (T) node.getItem();
            header.setNext(node.getNext());
            node.getNext().setPrev(header);
            size --;
            return item;
        } else {
            System.out.println("Cannot Remove the first item because the List is empty!");
            return null;
        }
    }

    public T removeLast() {
        if (size != 0) {
            TNode node = trailer.getPrev();
            trailer.setPrev(node.getPrev());
            node.getPrev().setNext(trailer);
            size --;
            return (T) node.getItem();
        } else {
            return null;
        }
    }

    public T get(int index) {
        if (index >= 0 && index <= size) {
            TNode p = header.getNext();
            for (int i = 0; i < index; i++) {
                p = p.getNext();
            }
            return (T) p.getItem();
        } else {
            System.out.println("Illegal Index!");
            return null;
        }
    }

    public T getRecursiveHelper(TNode node, int index) {
        if (index == 0){
            return node.getItem();
        }
        return getRecursiveHelper(node.getNext(), index-1);
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(header.getNext(), index);
    }
//    public T getRecursive(int index) {
//        if (index == 0) {
//            return header.getNext().getItem();
//        }
//        LinkedListDeque<T> newD = new LinkedListDeque<T>();
//        newD.header = header.getNext();
//        return newD.getRecursive(index-1);
//    }

}

class Main {
    public static void main (String[] args){
        LinkedListDeque<Integer> list = new LinkedListDeque<Integer>();
        list.addFirst(1);
        list.addFirst(7);
        list.addLast(3);
        list.printDeque();
//        //list.addBetween(5, 1, 3);
//        list.printDeque();
//        System.out.println ("List is Empty? " + list.isEmpty());
//        System.out.println ("List Size is:" + list.size());
//        System.out.println ("get " + list.get(2));
        //System.out.println("Get Recursive is: " + list.getRecursive(2));
        //System.out.println();
//        int i = list.removeFirst();
//        System.out.println("item " + i + " removed at First Position");
//        list.printDeque();
//        System.out.println ("List Size is:" + list.size());
//        int j = list.removeLast();
//        System.out.println("item " + j + " removed at Last Position");
//        list.printDeque();
//        System.out.println(list.get(0));

//        LinkedListDeque<String> s = new LinkedListDeque<>();
//        s.addFirst("hello");
//        s.addLast("world");
//        s.addBetween("yes ", "hello", "world");
//        s.printDeque();
//        System.out.println("size is " + s.size());
//        s.removeFirst();
//        s.printDeque();
        int i = list.getRecursive(0);
        System.out.println(i);
    }


}






