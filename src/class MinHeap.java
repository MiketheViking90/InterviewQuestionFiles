public class MinHeap {
	private int[] heap;
	private int curSize;
	private int size;

	public MinHeap(int n) {
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
		if (heap[parentIndex] > heap[index]) {
			int t = heap[index];
			heap[index] = heap[parentIndex];
			heap[parentIndex] = t;
			heapifyUp(parentIndex);
		}
	}
	
	public int[] getVals() {
		return heap;
	}

	public void printVals() {
		System.out.println();
		for (int i = 0; i < curSize - 1; i++) {
			System.out.print(heap[i] + ", ");
		}
		System.out.println(heap[curSize]);
	}
}