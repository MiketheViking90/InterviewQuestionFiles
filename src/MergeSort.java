class MergeSort{
	public static void MergeSort(int[] A) {
		int N = A.length;
		int[] tmp = new int[N];

		MergeSort(A, tmp, 0, N-1);
	}

	public static void MergeSort(int[] A, int[] tmp, int lo, int hi) {
		if (lo >= hi) return;

		int mid = (lo + hi) / 2;
		MergeSort(A, tmp, lo, mid);
		MergeSort(A, tmp, mid + 1, hi);
		Merge(A, tmp, lo, mid, hi);
	}

	public static void Merge(int[] A, int[] tmp, int lo, int mid, int hi) {
		//copy A to tmp
		for (int i = lo; i <= hi; i++) {
			tmp[i] = A[i];
		}

		int left = lo;
		int right = mid + 1;
		int cur = lo;

		//sort the numbers of A
		while (left <= mid && right <= hi) {
			if (tmp[left] <= tmp[right]) {
				A[cur++] = tmp[left++];
			} else {
				A[cur++] = tmp[right++];
			}	
		}

		while (left <= mid) {
			A[cur++] = tmp[left++];
		}
	}

	public static void main(String[] args){
		int[] A = {2,3,6,234,5,8,9};

		MergeSort(A);
		for (int i : A) {
			System.out.println(i);
		}
	}
}

class includeSort{
	public static void sort(int[] A, int[] B) {
		int aLen = A.length;
		int bLen = B.length;

		int[] tmpA = new int[aLen - bLen];

		for (int i = 0; i < aLen - bLen; i++) {
			tmpA[i] = A[i];
		}

		int i = 0, j = 0, k = 0;

		while (i < tmpA.length && j < bLen) {
			if (tmpA[i] <= B[j]) {
				A[k++] = tmpA[i++];
			} else {
				A[k++] = B[j++];
			}
		}

		if (i < tmpA.length) {
			while (i < tmpA.length) {
				A[k++] = tmpA[i++];
			}
		} else if (j < bLen) {
			while (j < bLen) {
				A[k++] = B[j++];
			}
		}
	}

	public static void sort1(int[] A, int[] B, int ALast) {
		int bLen = B.length;
		int mergeIndex = bLen + ALast;
		int aIndex = ALast;
		int bIndex = bLen - 1;

		while (aIndex >= 0 && bIndex >= 0) {
			System.out.println("a: " + aIndex + ", " + A[aIndex] + "b: " + bIndex + ", " + B[bIndex]);
			if (A[aIndex] >= B[bIndex]) {
				A[mergeIndex--] = A[aIndex--]; 
			} else {
				A[mergeIndex--] = B[bIndex--];
			}
		}

		if (bIndex >= 0) {
			while (bIndex >= 0) {
				A[mergeIndex--] = B[bIndex--];
			}
		}
	}

	public static void main(String[] args) {
		int[] A = new int[25];
		int[] B = {1,5,8,9,11,13};
		A[0] = 1;
		A[1] = 2;
		A[2] = 4;
		A[3] = 16;

		sort1(A, B, 3);
		String s = "0123456";
		System.out.println(s.substring(0,2));
	}
}


