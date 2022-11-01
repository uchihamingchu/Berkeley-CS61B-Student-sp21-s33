package IntList;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Return the size of the list using... recursion! */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** Returns the ith item of this IntList. */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    /** Method to return a string representation of an IntList */
    public String toString() {
        if (rest == null) {
            // Converts an Integer to a String!
            return String.valueOf(first);
        } else {
            return first + " -> " + rest.toString();
        }
    }

    /**
     * Method to create an IntList from an argument list.
     * You don't have to understand this code. We have it here
     * because it's convenient with testing. It's used like this:
     *
     * IntList myList = IntList.of(1, 2, 3, 4, 5);
     * will create an IntList 1 -> 2 -> 3 -> 4 -> 5 -> null.
     *
     * You can pass in any number of arguments to IntList.of and it will work:
     * IntList mySmallerList = IntList.of(1, 4, 9);
     */
    public static IntList of(int ...argList) {
        if (argList.length == 0)
            return null;
        int[] restList = new int[argList.length - 1];
        System.arraycopy(argList, 1, restList, 0, argList.length - 1);
        return new IntList(argList[0], IntList.of(restList));
    }
}

    //my contribution//
    //Modify the Intlist class so that every time you add a value you “square” the IntList. //
    public IntList squareList (IntList l, int i){
        if (l == null){
            IntList head = new IntList(i, null);
            return head;
        }

        int size = l.size();
        IntList head = l;
        IntList tempNode = head.rest;
        IntList prevNode = head;
        while (tempNode != null) {
            IntList newNode = new IntList(null, null);
            newNode.rest = tempNode;
            prevNode.rest = newNode;
            newNode.first = prevNode.first* prevNode.first;
            prevNode = tempNode;
            tempNode = tempNode.next;
        }
        prevNode.next = new IntList(i, null);
        return l;
        }

    }

/**
 * Returns a list equal to L with all elements squared. Destructive.
 */
public static void dSquareList(IntList L) {

        while (L != null) {
        L.first = L.first * L.first;
        L = L.rest;
        }
}

/**
 * Returns a list equal to L with all elements squared. Non-destructive.
 */
public static IntList squareListIterative(IntList L){
        if(L==null){
        return null;
        }
        IntList res=new IntList(L.first*L.first,null);
        IntList ptr=res;
        L=L.rest;
        while(L!=null){
        ptr.rest=new IntList(L.first*L.first,null);
        L=L.rest;
        ptr=ptr.rest;
        }
        return res;
        }

/**
 * Returns a list equal to L with all elements squared. Non-destructive.
 */
public static IntList squareListRecursive(IntList L) {
        if (L == null) {
        return null;
        }
        return new IntList(L.first * L.first, squareListRecursive(L.rest));
        }

/** DO NOT MODIFY ANYTHING ABOVE THIS LINE! */

/**
 * Returns a list consisting of the elements of A followed by the
 * *  elements of B.  May modify items of A. Don't use 'new'.
 */

public static IntList dcatenate(IntList A, IntList B) {
        if (A == null) {
            return B;
        }
        IntList p = A;
        while (p.rest != null){
            p = p.rest;
        }
        p.rest = B;
        return A;
    }

/**
 * Returns a list consisting of the elements of A followed by the
 * * elements of B.  May NOT modify items of A.  Use 'new'.
 */
public static IntList catenate(IntList A, IntList B) {
        if (A == null) {
            return B;
        }
        IntList res = new IntList(A.first, null);
        IntList p = res;
        A = A.rest;
        while (A != null) {
            IntList node = new IntList(A.first, null);
            p.rest = node;
            p = p.rest;
            A = A.rest;
        }
        p.rest = B;
        return res;
        }