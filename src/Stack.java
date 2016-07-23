class Stack{
	Node top;
	int count = 0;

	void push(int d){
		Node add = new Node(d);

		if (top == null) {
			top = add;
			count = 1;
		} else {
			add.next = top;
			top = add;
			count++;
		}
	}

	Node pop() {
		if (top != null) {
			Node popped = top;
			top = top.next;
			count--;
			return popped;
		} else {
			return null;
		}
	}
}