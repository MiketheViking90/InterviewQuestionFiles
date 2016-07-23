class maxSubsum{
	public static int maxSubSum(int[] A) {
		int N = A.length;
		int[] Mem = new int[N + 1];

		Mem[0] = 0;
		Mem[1] = A[0];

		return maxSubSum(A, Mem);
	}

	public static int maxSubSum(int[] A, int[] Mem) {
		int N = A.length;

		for (int i = 2; i < N+1; i++) {
			Mem[i] = Math.max(Mem[i-2] + A[i-1], Mem[i-1]);
		}
		return Mem[N];
	}

	public static void main(String[] args){
		int[] A = {2,3,5,1,2,4};

		System.out.println(maxSubSum(A));
	}
}