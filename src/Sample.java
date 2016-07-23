public class Sample{

	private static String getSuite(int n){
		if (n < 13) {
			return "Hearts";
		} else if (n < 26) {
			return "Diamonds";
		} else if (n < 39) {
			return "Spades";
		} else {
			return "Clover";
		}
	}

	private static String getVal(int m){
		String val;
		if (m == 13) val = "King";
		else if (m == 12) val = "Queen";
		else if (m == 11) val = "Jack";
		else if (m == 1) val = "Ace";
		else val = Integer.toString(m);

		return val;
	}

	public static void permute(int M, int N){
		int r,t,i,j;
		String suite;
		String val;

		int[] nums = new int[N];

		for (i = 0; i < N; i++){
			nums[i] = i;
		}

		for (j = 0; j < M; j++){
			r = j + ((int) (Math.random() * (N-j)));
			t = nums[j];
			nums[j] = nums[r];
			nums[r] = t;
		}
	
		for (i = 0; i < M; i++){
			suite = getSuite(nums[i]);
			val = getVal((nums[i] % 13) + 1);
			System.out.println(val + " of " + suite);
		}
	}

	public static void coupCollect(int N){
		boolean[] found = new boolean[N];
		int val;
		int valCnt = 0;
		int coupCnt = 0;

		while (valCnt < N) {
			val = (int) (Math.random() * N);
			coupCnt++;
			if (!found[val]) {
				found[val] = true;
				valCnt++;
			}
		}
		System.out.println(coupCnt);
	}

	public static void sieveOfEros(int N){
		int k = 0;

		boolean[] Primes = new boolean[N+1];

		for (int i = 2; i <= N; i++){
			Primes[i] = true;
		}

		for (int i = 2; i <= N/i; i++){
			if (Primes[i]) {
				for (int j = 2; j <= N/i; j++) {
					Primes[i * j] = false;
				}
			}
		}
		for (int i = 0; i <= N; i++){
			if (Primes[i]) {
				System.out.println(i);
				k++;
			}
		}
		System.out.println("count: " + k);
	}

	public static void main(String[] args){
		int N = (Integer.MAX_VALUE)/2;
		long st=System.nanoTime();
		sieveOfEros(25);
		long end= System.nanoTime();
		System.out.println((double) (end-st)/1000000000 + " seconds");
	}
}