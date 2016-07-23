class weave{
	public static void interleave(int[] A){
		int N = A.length/2;
		int t;

		for (int i = N - 1; i > 0; i--) {
			for (int j = i; j < N + (N - i); j += 2) {
				t = A[j];
				A[j] = A[j+1];
				A[j+1] = t;
			}
			for (int m : A) {
			}
		}
	}

	public static void main(String[] args){
		int[] A = {1,3,5,7,2,4,6,8};

		interleave(A);

		for (int i : A)
			System.out.print(i);
	}
}