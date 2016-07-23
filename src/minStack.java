class Node{
	int data;
	Node next;

	public Node(int d){
		data = d;
	}
}

class Stack{
	Node last;

	void push(int d){
		Node newTail = new Node(d);

		if (last == null) {
			last = new Node(d);
		} else {
			newTail.next = last;
			last = newTail;
		}
	}

	int pop() {
		int rv = last.data;

		last = last.next;
		return rv;
	}
}	

class minStack{
	Node last;
	Stack minStack;

	public minStack(){
		minStack = new Stack();
	}

	void push(int d){
		Node newTail = new Node(d);

		if (last == null) {
			last = newTail;
		} else {
			newTail.next = last;
			last = newTail;
		}

		if (minStack.last == null) {
			minStack.last = new Node(d);
		} else if (minStack.last.data > d) {
			minStack.push(d);
		}
	}

	int pop() {
		if (last == null) {
			return 0;
		}

		int rv = last.data;
		last = last.next;

		if (rv == minStack.last.data) {
			minStack.pop();
		}

		return rv;
	}

	int min(){
		return minStack.last.data;
	}
}

class stackTest{
	public static void main(String[] args){
		minStack stack = new minStack();

		stack.push(2);
		stack.push(4);
		stack.push(1);
		
		for (Node n = stack.last; n != null; n = n.next) {
			System.out.println((n.data));
		}
		stack.pop();
		System.out.println(stack.min());
	}
}