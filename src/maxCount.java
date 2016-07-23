class maxCount{
	public static int maxCount(int[] a){
		int max = a[0];
		int count = 0;

		for (int i : a) {
			if (i == max) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				max = i;
				count = 1;
			}
		}
		return max;
	}  

	public static void main(String[] args) {
		int[] A = {1,0,2,1,3};

		System.out.println(maxCount(A));
	}
}

