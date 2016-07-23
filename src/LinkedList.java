public class LinkedList {
	private Node head = null;

	public LinkedList(Node n) {
		this.head = n;
	}

	public LinkedList(int k) {
		this.head = new Node(k);
	}


	public Node getHead() {
		return head;
	}

	public void append(int k) {	
		if (this.head == null) {
			head = new Node(k);
		} else {
			Node n = this.head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = new Node(k);
		}
	}

	public static LinkedList buildList() {
		LinkedList rv = new LinkedList(1);
		rv.append(2);
		rv.append(3);
		rv.append(4);
		rv.append(5);
		return rv;
	}

	public void printList() {
		Node ptr = head;

		while (ptr != null) {
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
}

class Node {
	int data;
	Node next;

	public Node(int k) {
		this.data = k;
	}

	public void append(int k) {
		Node end = new Node(k);
		Node n = this;

		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public void insert(int k) {

	}
}