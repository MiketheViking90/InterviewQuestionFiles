class Link{
	int data;
	Link next;

	public Link(int d){
		data = d;
	}

	public print(){
		System.out.println(data);
	}
}

class LinkedList(){
	Link first;

	public LinkedList(){
		first = null;
	}

	public isEmpty(){
		return first==null;
	}
	public Add(int data){
		link = New Link(data)
		first.next=link;
	}

	public print(){
		Link current = first;
		while (current != null) {
			current.print();
			current = current.next;
		}
	}

}

class Test(){
	public static void main(){
		LinkedList linkTest = new LinkedList()

		linkTest.Add(12);
		linkTest.Add(13);
		linkTest.print()
	}
}

