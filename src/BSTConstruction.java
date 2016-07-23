class BSTConstruction{

	public static long[] generatePermutation(int N, long seed, long limit){
		long[] p = new long[N];
		int j;

		for (int i = 1; i < N; i++) {	
			p[i] = i;
			seed = (seed * 295397169) % 1073741789;

			if (((seed * 1000000) / 1073741789) < limit) {		
				seed = (seed * 295397169) % 1073741789;
				j = (int) ((seed * (i + 1)) / 1073741789);
				swap(i,j,p);
			}		
		}
		return p;
	}

	public static void swap(int i, int j, long[] A) {
		long t = A[i];
		A[i] = A[j];
		A[j] = t;
	}

	public static void main(String[] args){
		long[] A = generatePermutation(10, 87654321, 1000000);
		
		for (int i = 0; i < A.length; i++){
			System.out.println(A[i]);
		}
	}
}