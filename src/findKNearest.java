class findKNearest {
	public static int[] kNearest(int[] sorted, int n, int k) {
		int[] rv =  new int[k];
		int N = sorted.length;

		if (sorted[N-1] <= n) {
			for (int j = 0; j < k; j++) {
				rv[j] = sorted[N - j - 1];
			}
			return rv;
		}

		if (sorted[0] > n) {
			for (int j = 0; j < k; j++){
				rv[j] = sorted[j];
			}
			return rv;
		}
		int i;
		for (i = 0; i < N - 1; i++) {
			if ((sorted[i] <= n) && (sorted[i+1] >= n)) {
				break;
			}
		}

		int l = i, r = i + 1;

		int j = 0;
		while (j < k) {
			if ((l > 0) && (r < N)) {
				if (Math.abs(n - sorted[l]) > Math.abs(n - sorted[r])) {
					rv[j++] = sorted[r++];
				} else {
					rv[j++] = sorted[l--];
				}
			} else if (r >= N) {
				rv[j++] = sorted[l--];
			} else  {
				rv[j++] = sorted[r++];
			}
		}
		return rv;
	}

	public static void main(String[] args){
		int[] sorted = {1,2,3,4,7,8,100,101,123,428};
		int n = 500;
		int k = 3;

		int[] rv = kNearest(sorted, n, k);
		for (int i : rv) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

class maxSubSequence{
	public static int maxSequence(int[] sequence){
		int localMax = 0;
		int globalMax = 0;
		boolean allNegative = true;
		int maxNegative = sequence[0];

		for(int i : sequence) {
			if (i > 0) allNegative = false;
			if ((i < 0) && (i > maxNegative)) maxNegative = i;

			localMax = Math.max(0, localMax + i);
			globalMax = Math.max(localMax, globalMax);
		}
		if (!allNegative) return globalMax;
		else return maxNegative;
	}

	public static void main(String[] args){
		int[] seq = {-2, -11, -4, -13, -5, -2};

		System.out.println(maxSequence(seq));
	}
}