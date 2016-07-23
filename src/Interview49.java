class prioSort{
	public static void prioSort(String full, String prio) {
		char[] charAry = full.toCharArray();
		mergeSort(charAry);
		full = new String(charAry);

		for (int i = 0; i < prio.length(); i++) {
			int index = findChar(prio.substring(i, i + 1), full);
		}
	}

	public static void mergeSort(char[] A) {
		char[] tmp = new char[A.length];
		mergeSort(A, tmp, 0, A.length - 1);
	}

	private static void mergeSort(char[] A, char[] tmp, int lo, int hi) {
		if (lo >= hi) return;

		int mid = (hi + lo) / 2;
		mergeSort(A, tmp, lo, mid);
		mergeSort(A, tmp, mid + 1, hi);
		merge(A, tmp, lo, mid, hi);
	}

	private static void merge(char[] A, char[] tmp, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			tmp[i] = A[i];
		}

		int lIndex = lo;
		int rIndex = mid + 1;
		int k = lo;

		while (lIndex <= mid && rIndex <= hi) {
			if (tmp[lIndex] <= tmp[rIndex]) A[k++] = tmp[lIndex++];
			else A[k++] = tmp[rIndex++];
		}

		while (lIndex <= mid) {
			A[k++] = tmp[lIndex++];
		}
	}


	public static void main(String[] args) {
		String s = "owefpoiadfjlekjwl";
		String prio = "afw";

		prioSort(s, prio);

		char[] chars = s.toCharArray();

		mergeSort(chars);
		for (char c : chars) {
			System.out.print(c + " ");
		}
		System.out.println();
	}
}