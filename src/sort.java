class sort{
	public static void mergeSort(int[] A) {
		int[] tmp = new int[A.length];
		mergeSort(A, tmp, 0, A.length - 1);
	}

	private static void mergeSort(int[] A, int[] tmp, int lo, int hi) {
		if (lo >= hi) return;

		int mid = (lo + hi) / 2;
		mergeSort(A, tmp, lo, mid);
		mergeSort(A, tmp, mid + 1, hi);
		merge(A, tmp, lo, mid, hi);
	}

	private static void merge(int[] A, int[] tmp, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			tmp[i] = A[i];
		}

		int i = lo;
		int j = mid + 1;
		int k = lo;

		while (i <= mid && j <= hi) {
			if (tmp[i] <= tmp[j]) A[k++] = tmp[i++];
			else A[k++] = tmp[j++];
		}

		while (i <= mid) {
			A[k++] = tmp[i++];
		}
	}

	public static void main(String[] args) {
		int[] A = {4,5,67,5,23,2,4,5,7};

		mergeSort(A);
		for (int i : A) {
			System.out.print(i + " ");
		}
	}
}

class quickSort{
	public static void quickSort(int[] A) {
		quickSort(A, 0, A.length - 1);
	}

	private static void quickSort(int[] A, int left, int right) {
		int index = partition(A, left, right);
		if (left < index - 1) quickSort(A, left, index - 1);
		if (right > index) quickSort(A, index, right);
	}

	private static int partition(int[] A, int left, int right) {
		int pivot = A[(left + right) / 2];

		while (left <= right) {
			while (A[left] < pivot) left++;
			while (A[right] > pivot) right--;
			if (left <= right) {
				int t = A[left];
				A[left] = A[right];
				A[right] = t;

				left++;
				right--;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		int[] A = {2,4,6,923,7,8,73,3,2,2,32,34,39,4};
		quickSort(A);

		for (int i : A) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}