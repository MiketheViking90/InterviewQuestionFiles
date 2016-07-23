class Node{
	int data;
	Node next;

	public Node(int d) {
		this.data = d;
	}

	public Node(){}
}

class LinkedList{
	Node head;

	public LinkedList(Node node) {
		this.head = node;
	}

	public LinkedList() {}
}

class NodeTest{
	public static void append(Node head, int k) {
		if (head == null) head.data = k;
		else {
			while (head.next != null) {
				head = head.next;
			}
			head.next = new Node(k);
		}
	}

	public static void test(Node n) {
		n.data = 3;
	}

	public static void deleteNode(Node mid) {
		if (mid == null) return;

		Node next = mid.next;
		mid.next = next.next;
		mid.data = next.data;
	}

	public static void moveNode(LinkedList l1, LinkedList l2) {
		Node newHead = l2.head;
		l2.head = l2.head.next;

		newHead.next = l1.head;
		l1.head = newHead;
	}

	public static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void concat(Node n1, Node n2) {
		while (n1.next != null) {
			n1 = n1.next;
		}
		n1.next = n2;
	}

	public static void main(String[] args) {
		Node head = new Node(7);
		append(head, 8);
		append(head, 1);
		append(head, 3);
		append(head, 2);
		append(head, 5);
		append(head, -3);

		printList(head);
	}
}

class Stack{
	Node top;

	public void push(int k) {
		if (top == null) {
			top = new Node(k);
		} else {
			Node newTop = new Node(k);
			newTop.next = top;
			top = newTop;
		}
	}
}