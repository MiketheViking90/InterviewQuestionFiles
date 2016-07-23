class Node{
	int data;
	Node next;

	public Node(int k) {
		data = k;
	}
}

class LinkedList{
	Node head;
	int size;

	public void insert(int k) {
		Node newNode = new Node(k);
		Node node = head;

		if (node == null) {
			head = newNode;
		} else {
			while (node.next != null) {
				node = node.next;
			}
			node.next = newNode;
		}
		size++;
	}

	public void printList() {
		Node node = this.head;
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
	}

	public void removeKth(int k) {
		int i = 0;
		Node node = head;

		while (i < k - 1) {
			if (node == null) return;
			node = node.next;
			i++;
		}
		if (node.next == null) return;
		node.next = node.next.next;
	}

	public void insertAt(int val, int k) {
		Node node = head;

		if (k == 0) {
			Node inserted = new Node(val);
			inserted.next = head;
			head = inserted;
		} else {
			for (int i = 0; i < k - 1; i++) {
				if (node == null) return;
				node = node.next;
			}
			Node inserted = new Node(val);
			Node next = node.next;
			node.next = inserted;
			inserted.next = next;
		}
	}

	public void reverse() {
		if (size <= 1) return;

		Node tmp, cur, next;
		cur = head;
		next = head.next;
		head.next = null;

		while (next != null) {
			tmp = next.next;
			next.next = cur;
			cur = next;
			next = tmp;
		}

		head = cur;
	}

	public void printFrom(Node n) {
		System.out.println();
		while (n != null) {
			System.out.print(n.data);
			n = n.next;
		}
	}

	//Parlante LinkedList questions
	//Q1
	public int count(int k) {
		Node n = head;
		int cnt = 0;

		while (n != null) {
			if (n.data == k) cnt++;
		}
		return cnt;
	}

	//Q2
	public int getIndex(int n) {
		Node node = head;
		int i = 0;

		while (i < n) {
			if (node == null) return -1;

			node = node.next;
			i++;
		}
		return node.data;
	}

	//Q4
	public int pop() {
		if (head == null) return -1;

		int val = head.data;
		head = head.next;
		return val;
	}

	//Q6
	public void SortedInsert(int k) {
		Node node = head;
		while (node.data < k && node.next != null) {
			node = node.next;
		}
		Node curNext = node.next;
		Node inserted = new Node(k);
		inserted.next = curNext;
		node.next = inserted;
	}

	//Q7
	public void InsertSort() {
		return;
	}

	//Q8
	public void concatenate(LinkedList l2) {
		Node node = head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = l2.head;
	}

	//Q9
	public LinkedList[] frontBackSplit() {
		LinkedList[] rv = new LinkedList[2];
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();

		Node node = head;
		for (int i = 0; i < size/2 - 1; i++) {
			node = node.next;
		}
		l1.head = this.head;
		l2.head = node.next;
		node.next = null;
		rv[0] = l1;
		rv[1] = l2;
		return rv;
	}

	//Q10
	public void removeDuplicates() {
		Node node = head;

		while (node.next != null) {
			while (node.data == node.next.data) {
				node.next = node.next.next;
			}
			node = node.next;
		}
	}

	//Q11
	public void moveNode(LinkedList l2) {
		if (l2 == null) {
			return;
		}

		Node l2Node = l2.head;
		l2.head = l2.head.next;

		l2Node.next = this.head;
		head = l2Node;
	}

	//Q12 
	public LinkedList[] AlternatingSplit() {
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();

		Node node = head;
		while (node != null) {
			l1.moveNode(this);
			l2.moveNode(this);
		}

		LinkedList[] rv = new LinkedList[2];
		rv[0] = l1;
		rv[1] = l2;
		return rv;
	}
}

class PartialSum{
	Node sum = null;
	int carry = 0;
}

class ListTest{
	public static void altAppend(LinkedList l1) {
		int len = l1.size;
		if (len <= 1) return;

		Node node = l1.head;

		for (int i = 1; i < len/2 + 1; i++) {
			int k = node.next.data;
			System.out.println(k);
			l1.insertAt(k, 0);
			l1.removeKth(i);
			node = node.next;
		}
	}

	public static LinkedList padZeros(LinkedList l1, int k) {
		for (int i = 0; i < k; i++) {
			l1.insertAt(0,0);
		}
		return l1;
	}

	public static PartialSum addListsHelper(Node n1, Node n2) {
		if (n1 == null && n2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}

		PartialSum sum = addListsHelper(n1.next, n2.next);
		int val = sum.carry + n1.data + n2.data;

		Node result = insertBefore(sum.sum, val % 10);
		sum.sum = result;
		sum.carry = (val / 10);

		return sum;
	}

	public static Node insertBefore(Node node, int val) {
		Node newNode = new Node(val);
		newNode.next = node;
		return newNode;
	}

	public static LinkedList addLists(LinkedList l1, LinkedList l2) {
		if (l1 == null || l2 == null) return null;

		int len1 = l1.size;
		int len2 = l2.size;

		if (len1 > len2) {
			l2 = padZeros(l2, len1 - len2);
		} else {
			l1 = padZeros(l1, len2 - len1);
		}

		PartialSum sum = addListsHelper(l1.head, l2.head);

		LinkedList list = new LinkedList();
		list.head = sum.sum;

		if (sum.carry == 0) {
			return list;
		} else {
			list.insertAt(1, 0);
			return list;
		}
	}

	public static void runnerTest(LinkedList l1) {
		Node n1 = l1.head;
		Node n2 = l1.head;

		while(n2 != null || n2.next != null) {
			System.out.println(n1.data);
			System.out.println(n2.data);
			System.out.println();
			n2 = n2.next;
			if (n2.next == null) return;
			n2 = n2.next;
			n2.data = 1231312;
			n1 = n1.next;
		}
	}

	public static void MoveNode(LinkedList l1, LinkedList l2) {
		Node newNode = l2.head;

	}

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();

		l1.insert(1);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(5);
		l1.insert(6);
	}
}