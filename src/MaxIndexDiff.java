class MaxIndexDiff{
	public static int maxDiff(int[] A){
		int i = 0;
		int N = A.length - 1;
		int max = -1;

		for (i = N; i > 0; i++) {
			for (j = 0; j < i; j++) {
				if (A[i] > A[j]) {
					if (j - i > max) max = (j - i);				}
				if (i < max) break;
			}
		}
		return max;
	}

	public static void main(String[] args){
		int[] A = {34,8,10,3,2,80,30,33,1};

		System.out.println(maxDiff(A));
	}
}