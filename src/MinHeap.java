public class MinHeap {
	private int[] heap;
	private int curSize;
	private int size;

	public MinHeap(int n) {
		heap = new int[n];
		size = n;
		curSize = 0;
	}

	public int size() {
		return curSize;
	}

	public int peek() {
		return heap[0];
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
		if (index < 1) return;

		int parentIndex = (index / 2);
		if (heap[parentIndex] > heap[index]) {
			int t = heap[index];
			heap[index] = heap[parentIndex];
			heap[parentIndex] = t;
			heapifyUp(parentIndex);
		}
	}

	public int remove() {
		if (curSize == 0) return Integer.MIN_VALUE;

		int min = heap[0];
		heap[0] = heap[curSize];
		heapifyDown(0);
		curSize--;

		return min;
	}

	public void swapTop(int d) {
		heap[0] = d;
	}
	
	public void heapifyDown(int index) {
		if ((2 * index + 2) > (curSize - 1)) return;

		int left = (2 * index + 1);
		int right = (2 * index + 2);
		int swapIndex = (heap[left] < heap[right] ? left : right);

		if (heap[swapIndex] < heap[index]) {
			int t = heap[index];
			heap[index] = heap[swapIndex];
			heap[swapIndex] = t;
			heapifyDown(swapIndex);
		}
	}

	public int[] getVals() {
		return heap;
	}

	public void printVals() {
		for (int i = 0; i < curSize - 1; i++) {
			System.out.print(heap[i] + ", ");
		}
		System.out.println(heap[curSize - 1]);
	}
}