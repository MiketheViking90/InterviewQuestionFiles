class arraySort{
	public static void sortArray(int[] A){
		int j = (A.length - 1);
		int i = 0;
		int t;

		while (i < j) {
			if (A[i] == 0 && A[j] == 1) {
				t = A[i];
				A[i] = A[j];
				A[j] = t;
			} else if (A[i] == 1) {
				i++;
			} else if (A[j] == 0) {
				j--;
			}
		}
	}

	public static void main(String[] args){
		int[] A = {0,1,0,1,0,0,1,0,1,1,1,1,1,1};
		sortArray(A);

		for (int i:A)
			System.out.print(i);
	}
}