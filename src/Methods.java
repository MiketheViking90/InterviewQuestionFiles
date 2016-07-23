
class Methods{
	public static void checkSum(int a){
		int sum=0;

		String s = String.valueOf(a);
		char[] charAry = s.toCharArray();

		for(int i = 0; i < 10; i++){
			sum += Character.getNumericValue(charAry[i]);
		}

		sum %= 10;

		System.out.println(sum);
	}

	public static double min(double[] a){
		double min = a[0];

		for(int i = 1; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}

	public static double max(double[] a){
		double max = a[0];

		for(int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}

	public static void normalize(double[] a){
		double min = min(a);
		double max = max(a);
		double differ = max - min;

		for (int i = 0; i < a.length; i++){
			a[i] -= min;
			a[i] /= differ;
		}

		for (int i = 0; i < a.length; i++){
			System.out.println(a[i] + ", ");
		}
	}

	public static long factorial(int n){
		if (n == 1) return 1;
		return n * (factorial(n-1));
	}

	public static void binary(int n){
		while (n > 1) {
			System.out.println(n % 2);
			n /= 2;
		}
		System.out.println(n);
	}

	public static String binFactorial(int n){
		if (n == 0) return "0";
		if (n == 1) return "1";
		return binFactorial(n/2)+Integer.toString(n%2);
	}

	public static int binSearch(int[] A, int n, int min, int max){
		int mid;	

		if (min > max) return 'c';
		else{
			mid = (max + min) / 2;

			if (n < A[mid]) 
				return binSearch(A,n,min,mid-1);
			else if (n > A[mid])
				return binSearch(A,n,mid+1,max);
			else 
				return mid;
		}
	}

	public static void main(String[] args){
		int[] A = {1,4,6,7,8,9,12,31,45,78,98};

		System.out.println(binSearch(A,31,0,10));
	}
}