import java.util.*;

class fibonacci{
	public static int fib(int n) {
		int[] mem = new int[n];

		return fib(mem, n);
	}

	public static int fib(int[] mem, int n) {
		mem[0] = 1;
		mem[1] = 1;

		for (int i = 2; i < n; i++) {
			mem[i] = mem[i-1] + mem[i-2];
		}

		return mem[n-1];
	}

	public static void main(String[] args) {
		int n = 12;

		System.out.println(fib(4));
	}
}

class upSteps{
	public static int upSteps(int n) {
		int[] mem = new int[n + 1];

		return upSteps(mem, n);
	}

	public static int upSteps(int[] mem, int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else if (n == 3) {
			return 4;
		}

		else mem[n] = (upSteps(mem, n - 1) + upSteps(mem, n - 2) + upSteps(mem, n - 3));

		return mem[n];
	}

	public static void main(String[] args) {
		System.out.println(upSteps(5));
	}
}

class nPaths{
	public static int nPaths(int x, int y) {
		int[][] grid = new int[x + 1][y + 1];
		for (int i = 0; i <= x; i++) {
			grid[i][0] = 1;
		}

		for (int j = 0; j <= y; j++) {
			grid[0][j] = 1;
		}

		return nPaths(grid, x, y);
	}

	public static int nPaths(int[][] grid, int x, int y) {
		if (x == 0) return 1;
		if (y == 0) return 1;

		if (x >= 1 && y >= 1) {
			grid[x][y] = nPaths(grid, x-1, y) + nPaths(grid, x, y-1);
		} else if (x >= 1) {
			grid[x][y] = nPaths(grid, x-1,y);
		} else if(y >= 1) {
			grid[x][y] = nPaths(grid, x, y-1);
		}
		return grid[x][y];
	}

	public static void main(String[] args){
		System.out.println(nPaths(7,0));
	}
}

class printSubsets{
	public static void printSubs(String s) {
		printSubs(s, "");
	}

	public static void printSubs(String s, String s1) {
		int N = s.length();

		if (N == 0) {
			return;
		}

	 	if (N == 1) {
	 		System.out.println(s1+ s);
	 		System.out.println(s1 + "*");
	 		return;
	 	}

	 	printSubs(s.substring(1, N), s1 + s.substring(0,1));
	 	printSubs(s.substring(1, N), s1 + "*");
	}

	public static void main(String[] args) {
		String s = "abc";

		printSubs(s);
	}
}

class printPermutations{
	public static String insertCharAt(char c, String s, int i) {
		String rv = s.substring(0,i) + c + s.substring(i, s.length());
		return rv;
	}

	public static ArrayList<String> getPermutations(String s) {
		int N = s.length();
		ArrayList<String> permutations = new ArrayList<String>();

		if (N == 0) {
			permutations.add("");
			return permutations;
		}

		char first = s.charAt(0);
		String remainder = s.substring(1);

		ArrayList<String> remainPerms = getPermutations(remainder);

		for (String t : remainPerms) {
			for (int i = 0; i < s.length(); i++) {
				String s1 = insertCharAt(first, t, i);
				permutations.add(s1);
			}
		}

		return permutations;
	}

	public static void main(String[] args) {
		String s = "abcde";
		ArrayList<String> p = getPermutations(s);


		for (String t : p) {
			System.out.println(t);
		}
	}
}

class nCoins{
	public static int nCombinations(int n) {
		int[] mem = new int[n + 1];
		mem[0] = 0;
		for (int i = 1; i <= 4; i++) {
			mem[i] = 1;
		}
		for (int i = 5; i <= 9; i++) {
			mem[i] = 2;
		}
		return 1;
	}
}

class fib{
	public static int fib(int n) {
		int[] Mem = new int[n + 1];
		Mem[0] = 1;
		Mem[1] = 1;

		return fib(n, Mem);
	}

	public static int fib(int n, int[] Mem) {
		if (n <= 1) return 1;

		for (int i = 2; i <= n; i++) {
			Mem[i] = Mem[i - 1] + Mem[i - 2];
		}

		return Mem[n];
	}

	public static void fizzBuzz() {
		int a, b;

		for (int i = 0; i <= 50; i = i + 3) {
			a = i % 3;
			b = i % 5;

			if (a == 0 && b == 0) {
				System.out.println(i + ":" + "fizzbuzz");
			} else if (a == 0) {
				System.out.println(i + ":" + "fizz");
			} else if (b == 0) {
				System.out.println(i + ":" + "buzz");
			}
		}
	}

	public static boolean isArmstrong(int n) {
		String nString = String.valueOf(n);

		int sum = 0;
		for (int i = 0; i < nString.length(); i++) {
			sum += Integer.parseInt(nString.substring(i,i+1));
		}

		return sum == n;
	}

	public static void main(String[] args){
		int n = 12;

		System.out.println(isArmstrong(9));
	}
}

class primeFact{
	public static ArrayList<Integer> getPrimeFactorization(int n) {
		ArrayList<Integer> rv = new ArrayList<Integer>();

		while (n % 2 == 0) {
		
			n /= 2;
			rv.add(2);
		}

		for (int p = 3; p <= n/p; p += 2) {
			while (n % p == 0) {
				n /= p;
				rv.add(p);
			}
		}

		if (n > 1) rv.add(n);
		return rv;
	}

	public static void main(String[] args) {
		ArrayList<Integer> factors = getPrimeFactorization(49);

		for (Integer i : factors) {
			System.out.println(i);
		}
	}
}