class Node {
	int data;
	Node next;

	public Node(int k) {
		data = k;
	}

	public void append(int k) {
		Node node = this;
		while (node.next != null) {
			node = node.next;
		}	
		node.next = new Node(k);
	}

	public void insert(int k) {
		Node tmp = new Node(this.data);
		tmp.next = this.next;

		this.data = k;
		this.next = tmp;
	}

	public void print() {
		Node node = this;
		System.out.println();
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
	}
}

class addLists{
	public static Node addLists(Node h1, Node h2) {
		return addLists(h1, h2, 0);
	}

	public static Node addLists(Node h1, Node h2, int carry) {
		if ((h1 == null && h2 == null) && carry == 0) {
			return null;
		}

		Node result = new Node(0);
		int sum = carry;

		if (h1 != null) {
			sum += h1.data;
		}
		if (h2 != null) {
			sum += h2.data;
		}

		result.data = sum % 10;
		Node next = addLists(h1 == null ? null : h1.next,
						       h2 == null ? null : h2.next,
						         sum >= 10 ? 1 : 0);
		result.next = next;
		return result;
	}

	public static void removeKth(Node head, int k) {
		int i = 0;

		while (i < (k - 1)) {
			if (head == null) break;
			head = head.next;
			i++;
		}

		head.next = head.next.next;
	}

	public static int length(Node head) {
		int len = 0;

		while (head != null) {
			head = head.next;
			len++;
		}
		return len;
	}

	public static void altAppend(Node head) {
		int len = length(head);

		for (int i = 0; i < len; i++) {
			
		}
	}

	public static void main(String[] args){
		Node head = new Node(1);
		head.append(11);
		head.append(2);
		head.append(12);
		head.append(3);
		head.append(13);
		System.out.println(length(head));
		//removeKth(head, 2);

		//altAppend(head);
		head.print();
	}
}
