public class MinHeap {
	private int[] heap;
	private int curSize;
	private int size;

	public Heap(int n) {
		heap = new int[n];
		size = n;
		curSize = 0;
	}

	public void insert(int d) {
		if (curSize < size) {
			heap[curSize] = d;
			heapifyUp(curSize);
			curSize++;
		} else {
			return;
		}
	}

	private void heapifyUp(int index) {
		if (index <= 1) return;

		int parentIndex = (index / 2);
		if 
	}
}