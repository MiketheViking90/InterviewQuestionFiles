class Queue{
	Node first;
	Node last;

	void insert(int d) {
		Node inLine = new Node(d);

		if (first != null){
			last.next = inLine;
			last = inLine;
		} else {
			first = inLine;
			last = inLine;
		}
	} 

	Node remove() {
		if (first != null) {
			Node rv = first;
			first = first.next;
			return rv;
		} else {
			return null;
		}
	}
}