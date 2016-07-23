import java.util.*;

class secondHi{
	public static char secondHi(String s) {
		char[] sChars = s.toCharArray();
		int[] charCount = new int[128];

		for (char c : sChars) {
			charCount[c]++;
		}

		char hi1 = s.charAt(0), hi2 = s.charAt(1);
		int cnt1 = 0, cnt2 = 0;

		for (int i = 0; i < 128; i++) {
			if (charCount[i] > cnt1) {
				cnt2 = cnt1;
				cnt1 = charCount[i];

				hi2 = hi1;
				hi1 = (char) i;
			} else if (charCount[i] > cnt2) {
				cnt2 = charCount[i];
				hi2 = (char) i;
			}
		}

		return hi2;
	}

	public static void main(String[] args){
		String s = "aaaaabbcccddd";

		System.out.println((secondHi(s)));
	}
}

class printSubsets{
	public static int[] binRep(int n, int len) {
		int[] binary = new int[len];

		int i = 0;
		while (n > 0) {
			binary[i++] = n%2;
			n /= 2;
		}

		return binary;
	}

	public static void printSubSet(char[] tuple, int[] members) {
		System.out.print("(");
		for (int i = 0; i < members.length; i++) {
			if (members[i] == 1) {
				System.out.print(tuple[i] + " ");
			} else {
				System.out.print("* ");
			}
		}
		System.out.println("), ");
	}

	public static void printSubsets(char[] tuple) {
		int N = tuple.length;
		int subsets = 1;
		for (int i = 1; i <= N; i++) {
			subsets *= 2;
		}

		System.out.println(subsets);

		for (int i = 0; i < subsets; i++) {
			int[] members = binRep(i, N);
			printSubSet(tuple, members);
		}
	}

	public static void main(String[] args) {
		char[] tuple = {'a', 'b', 'c'};

		printSubsets(tuple);
	}
}

class threeSum{
	public static int binSearch(int[] A, int n, int lo, int hi) {
		if (hi <= lo) return -1;

		int mid = ((hi + lo) / 2);
		if (n < A[mid]) return binSearch(A, n, lo, mid);
		else if (n > A[mid]) return binSearch(A, n, mid + 1, hi);
		else if (n == A[mid]) return mid;

		return -1;
	}

	public static void print3Sums(int[] vals) {
		int N = vals.length;
		Arrays.sort(vals);

		for (int i = 0; i < (N - 2); i++) {
			for (int j = i + 1; j < (N - 1); j++) {
				int sum = vals[i] + vals[j];

				int found = (binSearch(vals, (-1 * sum), j + 1, N));
				if (found > -1) {
					System.out.println(vals[i] + ", " + vals[j] + ", " + vals[found]);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {2, 3, 1, -2, -1, 0, 2, -3, 0};	
		Arrays.sort(array);
	
		print3Sums(array);
	}	
}

class getDecimal{
	public static int decimal(char c) {
		switch(c) {
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			default: return 0;
		}
	}

	public static int getDecimal(String roman) {
		char[] romanAry = roman.toCharArray();

		int sum = 0;
		for (int i = 0; i < roman.length() - 1; i++) {
			if (decimal(roman.charAt(i)) < decimal(roman.charAt(i + 1))) {
				sum -= decimal(roman.charAt(i));
			} else {
				sum += decimal(roman.charAt(i));
			}
		}
		sum += decimal(romanAry[roman.length() - 1]);
		return sum;
	}

	public static void main(String[] args){
		String r = "XXIV";

		System.out.println(getDecimal(r));
	}
}

class minTree{
	public static BinaryTree minTree(int[] A) {
		int N = A.length;
		int mid = N / 2;

		BinaryTree tree = new BinaryTree();
		tree.insert(A[mid]);

		int i = mid - 1, j = mid + 1;

		while (i >= 0 && j < N) {
			tree.insert(A[i--]);
			tree.insert(A[j++]);
		}

		if (N % 2 == 0) {
			tree.insert(A[i]);
		}

		return tree;
	}

	public static void main(String[] args) {
		int[] A = {1,3,5,7,8,9,12};

		BinaryTree tree = minTree(A);

		tree.printTree();
	}
}