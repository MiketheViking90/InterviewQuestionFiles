class Angles{
	public static void uniform(){
		double a,b,c,d,e;

		a = Math.random();
		b = Math.random();
		c = Math.random();
		d = Math.random();
		e = Math.random();

		System.out.println(Math.min(a,b));
	}

	public static boolean equals(int a, int b, int c){
		if ((a == b) && (b == c)) {
			return true;
		}
		return false;
	}

	public static boolean isPrime(long p){
		long sqRt = (long) Math.sqrt(p);

		if (p == 1) return false;

		for (long i=sqRt; i>=2; i--){
			if ((p % i) == 0) {
				return false;
			}
		}
		return true;
	}

	public static int nthPrime(int n){
		int number=1;
		int count = 0;

		while(count<n){
			if (isPrime(number++)){
				count = count+1;
			}
		}
		return number-1;
	}

	public static int PrimeCounter(int n){
		int counter=0;

		for (int i = n; i>=2; i--){
			if (isPrime(i)) {
				System.out.println(i);
				counter++;
			}
		}
		return counter;
	}

	public static boolean divisible(int n){
		for(int i=2;i<=20;i++){
			System.out.println(n%i);
			if ((n%i)!=0){
				return false;
			}
		}
		return true;
	}



	public static int smallestDiv(){
		for(int i=2520;;i=i+2520){
			System.out.println(i);
			if (divisible(i)){
				return i;
			}
		}
	}

	public static int sumSquare(int n){
		int sum=0;

		for (int i=1;i<=n;i++) {
			sum = sum + (int) (Math.pow(i,2));
		}
		return sum;
	}

	public static int squareSum(int n){
		int sum=0;

		for (int i=1;i<=n;i++){
			sum = sum+i;
		}
		return (int) Math.pow(sum,2);
	}

	public static long primeSum(){
		long sum=0;

		for (long i=1000000;i<2000000;i++) {
			if (isPrime(i)) {
				sum = sum+i;
				System.out.println(sum+" "+i);
			}
		}
		return sum;
	}

	public static int numDivisors(int n){
		int nDiv = 0;

		for (int i=2;i<=(n/2);i++){
			if ((n%i) == 0) {
				nDiv++;
			}
		}

		return nDiv+2;
	}

	public static int findFirst(){
		int sum=0;

		for (int i=1;i<200000;i++){
			sum+=i;
			System.out.println("sum: "+sum);
			if (numDivisors(sum) > 500) {
				return sum;
			}
		}
		return -1;
	}

	public static void main(String[] args){
		//System.out.println(isPrime(5));
		//37550402023
		long st=System.nanoTime();
		System.out.println(findFirst());
		long end= System.nanoTime();
		System.out.println((double) (end-st)/1000000000 + " seconds");
	}
}
