class interLeave{
	public static void interLeave(int[] A){
		int N = A.length/2;
		int t;

		for (int i = 1; i < N; i++) {
			System.out.println(i + ": ");
			for (int j = 0; j < i; j++) {
				int a = N - i + (2 * j); 
				int b = N - i + (2 * j) +  1;
				System.out.println("\t" + a + ", " + b);
				t = A[a];
				A[a] = A[b];
				A[b] = t;
			}
		}
	}

	public static void main(String[] args){
		int[] A = {1,3,5,7,2,4,6,8};

		interLeave(A);

		for(int i : A) {
			System.out.println(i);
		}
	}
}