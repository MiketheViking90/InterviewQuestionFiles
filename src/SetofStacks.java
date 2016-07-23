import java.util.*;

class SetofStacks{
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	int capacity;

	Stack lastStack(){
		if (stacks.size() == 0) {	
			return null;
		} else {
			return stacks.get(stacks.size() - 1);
		}
	}

	void push(int d){
		Node pushed = new Node(d);
		Stack curStack = lastStack();

		if (curStack == null) {
			Stack newStack = new Stack();
			newStack.push(d);
			stacks.add(newStack);
		} else if (curStack.count < capacity) {
			curStack.push(d);
		} else {
			Stack nextStack = new Stack();
			nextStack.push(d);
			stacks.add(nextStack);
		}

	}

	Node pop() {
		Stack curStack = lastStack();

		if (curStack == null) {
			return null;
		} else {	
			Node rv = curStack.pop();
			if (curStack.count == 0) {
				stacks.remove(stacks.size() - 1);
			}
			return rv;
		}
	}

	void printSet() {
		for (Stack s : stacks){
			for (Node n = s.top; n != null; n = n.next){
				System.out.print(n.data + "<--");
			}
			System.out.println();
		}
	}

	Node popAt(int n) {
		Stack curStack = stacks.get(n - 1);

		if (curStack == null) return null;
		else {
			Node rv = curStack.pop();
			return rv;
		}
	}
}

class SetTest{
	public static void main(String[] args){
		SetofStacks set = new SetofStacks();
		set.capacity = 4;

		set.push(2);
		set.push(3);
		set.push(7);
		set.push(12);
		set.push(3);
		set.push(314);

		set.popAt(1);

		set.printSet();
	}
}