package timingtest;

/** An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within. */
public class SLList<Item> {
	private class IntNode {
		public Item item;
		public IntNode next;

		public IntNode(Item i, IntNode n) {
			item = i;
			next = n;
		}
	}

	/* The first item (if it exists) is at sentinel.next. */
	private IntNode sentinel;
	private int size;

	/**
	 * Creates an empty timingtest.SLList.
	 */
	public SLList() {
		sentinel = new IntNode(null, null);
		size = 0;
	}

	public SLList(Item x) {
		sentinel = new IntNode(null, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	// my contribution:  implement a second constructor
	// that takes in an array of integers, and creates an SLList with those integers.//
//	public SLList (int[] ints) {
//		sentinel = new IntNode(null, null);
//		IntNode p = sentinel;
//		for (int i = 0; i < ints.length; i++) {
//			p.next = new IntNode(ints[i], null);
//			p = p.next;
//			size++;
//		}
//	}

	/**
	 * Adds x to the front of the list.
	 */
	public void addFirst(Item x) {
		sentinel.next = new IntNode(x, sentinel.next);
		size = size + 1;
	}

	/**
	 * Returns the first item in the list.
	 */
	public Item getFirst() {
		return sentinel.next.item;
	}

	/**
	 * Adds x to the end of the list.
	 */
	public void addLast(Item x) {
		size = size + 1;

		IntNode p = sentinel;

		/* Advance p to the end of the list. */
		while (p.next != null) {
			p = p.next;
		}

		p.next = new IntNode(x, null);
	}

	/**
	 * returns last item in the list
	 */
	public Item getLast() {
		IntNode p = sentinel;

		/* Advance p to the end of the list. */
		while (p.next != null) {
			p = p.next;
		}

		return p.item;
	}


	/**
	 * Returns the size of the list.
	 */
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		/* Creates a list of one integer, namely 10 */
		SLList L = new SLList();
		L.addLast(20);
		System.out.println(L.size());
	}


	// my contribution//
	public void deleteFirst() {
		sentinel.next = sentinel.next.next;
		size = size - 1;
	}


	// my contribution: Implement SLList.insert which takes in an integer x and an integer position. It
//inserts x at the given position. If position is after the end of the list, insert the
//new node at the end.//
//	public void insert(int item, int position) {
//		if (position >= size - 1) {
//			addLast(item);
//			size++;
//		} else {
//			int index = 0;
//			IntNode p = sentinel;
//			while (p.next != null && index != position) {
//				p = p.next;
//				index++;
//			}
//			p.next = new IntNode(item, p.next);
//			size++;
//		}
//	}

	//Add another method to the SLList class that reverses the elements. Do this using
//the existing IntNode objects (you should not use new).
//	public void reverse() {
//		IntNode p = sentinel;
//		int times = 0;
//		while (times < size) {
//			p.next = this.getLast();
//			p = p.next;
//			times++;
//		}
//	}
//
//	private String longestString(SLList<String> list) {
//		int maxIndex = 0;
//		for (int i = 0; i <list.size(); i++){
//			if (list.get(i).length()>list.get(maxIndex).length()){
//				maxIndex = i;
//			}
//		}
//		return list.get(i);
//	}
}