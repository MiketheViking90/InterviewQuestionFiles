class LinkedList{
	class Node{
		int data;
		Node next;

		public Node(int d){
			data = d;
		}
	}

	Node head;

	void append(int d){
		if (head == null) {
			head = new Node(d);
		} else {
			Node n;
			for (n = head; n != null; n = n.next){}
			n.next = new Node(d);
		}
	}
}