class LinkedListSum{
	public static LinkedList add(LinkedList l1, LinkedList l2) {
		LinkedList rv = new LinkedList();

		appendNodes(rv,l1.head,l2.head,0);
		return rv;
	}

	public static void appendNodes(LinkedList rv, Node l1, Node l2, int carry){
		if (l1 == null && l2 == null && carry == 0) {
			return;
		}

		int sum = carry;

		if (l1 != null) {
			sum += l1.data;
		} 
		if (l2 != null) {
			sum += l2.data;
		}
		
		rv.append(sum % 10);
		rv.printList();

		carry = (sum >= 10 ? 1 : 0);

		System.out.println(l2.data);

		while (l1 != null || l2 != null || carry != 0) {
			appendNodes(rv, l1 == null ? null : l1.next, 
							l2 == null ? null : l2.next, 
						carry);
		}
	}

	public static Node findHead(LinkedList l1) {
		Node current, runner;

		for (current = l1.head; current.next != null; current = current.next){
			for (runner = current.next; runner != null; runner = runner.next) {
				if (runner == current) {
					return runner;
				}
			}
		}
		return null;
	}

	public static void reverseLinkedList(LinkedList l1){
		Node prev, cur, nextNode;

		prev = null;
		for (cur = l1.head; cur.next != null;) {
			nextNode = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nextNode;
			System.out.println(cur.data);
		}

		l1.head = cur;
		cur.next = prev;
		System.out.println();
		l1.printList();
	}

	public static boolean isPalin(LinkedList l1){
		Stack stack = new Stack();

		Node cur = l1.head;
		Node runner = l1.head;

		while (runner != null && runner.next != null) {
			System.out.println(cur.data);
			stack.push(cur.data);
			cur = cur.next;
			runner = runner.next.next;
		}

		if (runner.next == null) {
			cur = cur.next;
		}

		for (; cur != null; cur = cur.next){
			int val = stack.pop();
			System.out.println(val + ", " + cur.data);
			if (val != cur.data) 
				return false;
		}
		return true;
	}

	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();

		l1.append(7);
		l1.append(5);
		l1.append(5);
		l1.append(7);

		System.out.println(isPalin(l1));
	}
}