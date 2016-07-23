class sumList {
	public static LinkedList sumLists(LinkedList l1, LinkedList l2) {
		Node newHead =  sumLists(l1.getHead(), l2.getHead(), 0);
		LinkedList rv = new LinkedList(newHead);

		return rv;
	}

	private static Node sumLists(Node n1, Node n2, int carry) {
		if (n1 == null && n2 == null && carry == 0) return null;

		int val = carry;

		if (n1 != null) val += n1.data;
		if (n2 != null) val += n2.data;

		Node sum = new Node(val % 10);

		Node nextDigit = sumLists(n1 == null ? null : n1.next, 
									n2 == null ? null : n1.next, 
										val / 10);
		sum = append(sum, nextDigit);

		return sum;
	}

	private static Node append(Node n1, Node n2) {
		n1.next = n2;
		return n1;
	}

	public static LinkedList sumListsInOrder(LinkedList l1, LinkedList l2) {
		Node sum =  sumListsInOrder(l1.getHead(), l2.getHead(), 0);
		LinkedList listSum = new LinkedList(sum);
		return listSum;
	}

	private static Node sumListsInOrder(Node n1, Node n2, int carry) {
		return null;
	}

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList(5);
		l1.append(4);
		l1.append(9);

		LinkedList l2 = new LinkedList(8);
		l2.append(9);
		l2.append(3);

		l1.printList();
		l2.printList();

		LinkedList sum = sumLists(l1, l2);
		sum.printList();
	}
}

class reverseK{
	public static Node reverseK(Node node, int k) {
		if (node == null) return null;

		Node prev = null;
		Node cur = node;
		Node next = cur.next;

		int i = 0;
		while (cur != null && i < k) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			i++;
		}

		if (next != null) {
			node.next = reverseK(next, k);
		}

		return prev;
	}

	public static void main(String[] args) {
		LinkedList l1 = LinkedList.buildList();
		l1.append(6);
		l1.append(7);
		l1.append(8);
		l1.append(9);

		l1.printList();
		Node reversed = reverseK(l1.getHead(), 2);
		while (reversed != null) {
			System.out.print(reversed.data + " ");
			reversed = reversed.next;
		}
	}
}

class spliceLists{
	public static Node spliceLists(Node h1, Node h2) {
		if (h1 == null) return h2;
		if (h2 == null) return h1;

		Node ptr1 = h1;
		Node ptr2 = h2;

		Node p1Next = ptr1.next;
		Node p2Next = ptr2.next;

		while (ptr1.next != null && ptr2 != null) {
			ptr1.next = ptr2;
			ptr2.next = p1Next;
			ptr1 = p1Next;
			ptr2 = p2Next;

			p1Next = ptr1.next;
			if (ptr2 == null) break;
			p2Next = ptr2.next;
		}

		if (ptr2 != null) {
			ptr1.next = ptr2;
		}
		return h1;
	}

	public static Node mergeLists(Node n1, Node n2) {
		if (n1 == null) return n2;
		if (n2 == null) return n1;

		if (n1.data < n2.data) {
			n1.next = mergeLists(n1.next, n2);
			return n1;
		} else {
			n2.next = mergeLists(n1, n2.next);
			return n2;
		}
	}

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList(2);
		l1.append(8);
		l1.append(13);

		LinkedList l2 = new LinkedList(1);
		l2.append(10);
		l2.append(12);

		LinkedList val = new LinkedList(mergeLists(l1.getHead(), l2.getHead()));
		val.printList();
	}
}

class removeDuplicates{
	public static Node removeDuplicates(Node head) {
		if (head == null || head.next == null) return head;

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			while (fast.next != null && fast.next.data == fast.data) {
				fast = fast.next;
			}

			if (fast.next == null) {
				slow.next = null;
				return head;
			} else {
				slow.next = fast.next;
				slow = slow.next;
				fast = fast.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList(1);
		l1.append(1);
		l1.append(2);
		l1.append(2);
		l1.append(2);
		l1.append(3);

		removeDuplicates(l1.getHead());
		l1.printList();
	}
}















