class maxRepeat{
	public static int maxRepeat(int[] A, int N, int k) {
		for (int i = 0; i < A.length; i++) {
			A[A[i] % k] += k;
		}

		int max = A[0];
		int maxIndex = 0;

		for (int i = 0; i < N; i++) {
			if (A[i] > max) {
				max = A[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public static void main(String[] args) {
		int arr[] = {2, 5, 5, 5, 3, 4, 4, 4, 4};

		System.out.println(maxRepeat(arr, arr.length, 8));
	}
}