import java.util.ArrayList;

class findProductInt {
	public static int prodInt(int n) {
		ArrayList<Integer> factors = getFactors(n);

		for (int a : factors) {
			System.out.print(a + " ");
		}
		System.out.println();
		return factors.size();
	}

	private static ArrayList<Integer> getFactors(int n) {
		ArrayList<Integer> factors = new ArrayList<Integer>();

		while (n % 2 == 0) {
			n /= 2;
			factors.add(2);
		}

		for (int i = 3; i <= n/i; i += 2) {
			while (n % i == 0) {	
				n /= i;
				factors.add(i);
			}
		}
		if (n != 1) {
			addInIndex(n, factors);
		}

		return factors;
	}

	private static void addInIndex(int n, ArrayList<Integer> factors) {
		int i = 0;
		while (i < factors.size()) {
			if (factors.get(i) < n) {
				i++;
			} else {
				factors.add(i, n);
				return;
			}
		}
		factors.add(i, n);
	}

	public static void main(String[] args) {
		prodInt(360);
	}
}

class printValidParen{
	public static void printValidParen(int n) {
		if (n == 0) return;
		String cur = "(";
		printValidParen(cur, n - 1, n);
	}

	private static void printValidParen(String cur, int left, int right) {
		if (left > right) return;
		if (left == 0 && right == 0) {
			System.out.println(cur);
		}
		if (left > 0) printValidParen(cur + "(", left - 1, right);
		if (right > 0) printValidParen(cur + ")", left, right - 1);
	}

	public static void main(String[] args) {
		printValidParen(3);
	}
}

class sieve{
	public static void printPrimes(int n) {
		boolean[] primes = new boolean[n + 1];

		if (n <= 1) return;
		primes[2] = true;
		for (int i = 3; i < n; i += 2) {
			primes[i] = true;
		} 

		for (int i = 3; i <= n / i; i++) {
			for (int j = 2; j <= n / i; j++) {
				primes[i * j] = false;
			}
		}

		for (int i = 0; i < n; i++) {
			if (primes[i]) System.out.println(i);
		}
	}
	public static void main(String[] args) {
		int n = 100;
		printPrimes(100);
	}
}

class frogRecur{
	public static int nWays(int n) {
		if (n <= 2) return n;

		int[] steps = new int[n + 1];
		steps[0] = 0;
		steps[1] = 1;
		steps[2] = 2;
		for (int i = 3; i <= n; i++) {
			steps[i] = steps[i - 1] + steps[i - 2];
		}
		return steps[n];
	}

	public static void main(String[] args) {
		int d = 4;
		System.out.println(nWays(d));
	}
}

class spiralMatrix{
	public static void printMatrix(int[][] matrix, int step) {
		int N = matrix.length;
		if (step * 2 >= N) return;

		int row = step;
		for (int j = step; j < N; j++) {
			System.out.print(matrix[row][j] + " ");
		}
		int col = N - step - 1;
		for (int j = step + 1; j < N - step; j++) {
			System.out.print(matrix[j][col] + " ");
		}
		row = N - step - 1;
		for (int j = N - step - 2; j >= step; j--) {
			System.out.print(matrix[row][j] + " ");
		}
		col = step;
		for (int j = N - step - 2; j >= step + 1; j--) {
			System.out.print(matrix[j][col] + " ");
		}
		System.out.println();

		printMatrix(matrix, step + 1);
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4,5},
							{5,6,7,8,9},
								{9,10,11,12,13},
									{13,14,15,16,17}};
		printMatrix(matrix, 0);
	}
}

class maxSub{
	public static int maxSubSum(int[] A) {
		int N = A.length;

		if (N == 1) return A[0];
		if (N == 2) return Math.max(A[0], A[1]);

		int[] mem = new int[N];
		mem[0] = A[0];
		mem[1] = Math.max(A[0], A[1]);
		for (int i = 2; i < N; i++) {
			if (Math.max(mem[i - 2] + A[i], mem[i - 1]) == mem[i - 1]) {
			} else {
				System.out.println(A[i]);
			}
			mem[i] = Math.max(mem[i - 2] + A[i], mem[i - 1]);
		}
		return mem[N - 1];
	}

	public static void main(String[] args) {
		int[] A = {3, 2, 7, 10,100};

		System.out.println(maxSubSum(A));
	}
}

class nextLargest{
	public static int nextLargest(int n) {
		char[] digits = String.valueOf(n).toCharArray();
		int len = digits.length;
		if (len <= 1) return n;

		int i = len - 1;
		while (i > 0) {
			if (digits[i - 1] < digits[i]) {
				i--;
				break;
			} else {
				i--;
			}
		}

		if (i == 0) return n;

		swapVals(digits, i);
		String sVal = String.valueOf(digits);
		return Integer.parseInt(sVal);
	}

	private static void swapVals(char[] digits, int index) {
		char val = digits[index];
		int i = index + 1;
		char nextVal = digits[i];
		int nextIndex = i;

		while (i < digits.length - 1) {
			if (digits[i] > val && digits[i] < nextVal) {
				nextVal = digits[i];
				nextIndex = i;
			} 
			i++;
		}

		digits[index] = nextVal;
		digits[nextIndex] = val;
	}


	private static void editNode(Node node) {
		node.data = 120;
	}

	public static void main(String[] args) {
		Node node = new Node(3);
		editNode(node);
		int a, b, c;
		a = b = c = 0;

		System.out.println(node.data);
	}
}

class LCS{
	public static String LCS(String X, String Y) {
		int m = X.length();
		int n = Y.length();

		int[][] mem = new int[m + 1][n + 1];
		int val = 0;
		int pos = 0;

		for (int i = 0; i <= m; i++) {
			mem[i][0] = 0;
		}
		for (int j = 0; j <= n; j++) {
			mem[0][j] = 0;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					mem[i][j] = mem[i - 1][j - 1] + 1;
					if (mem[i][j] > val) {
						val = mem[i][j];
						pos = i;
					}
				} else {
					mem[i][j] = 0;
				}
			}
		}
		return X.substring(pos - val, pos);
	}

	public static void main(String[] args) {
		String a = "testing";
		String b = "ingrate";

		System.out.println(LCS(a, b));
	}
}

class stockSpread{
	public static int[] findSpreads(int[] prices) {
		int len = prices.length;
		int[] actions = new int[len];
		for (int i = 0; i < len; i++) actions[i] = 1;

		int profit = 0;
		int money = 0;

		for (int i = len - 1; i >= 0; i--) {
			if (money <= prices[i]) {
				actions[i] = 0;
				money = prices[i];
			}
			profit += (money - prices[i]);
		}
		System.out.println(profit);
		return actions;
	}

	public static void main(String[] args) {
		int[] prices = {5,3,2,3,4,2,1,5};

		int[] actions = findSpreads(prices);
		for (int a : actions) {
			System.out.println(a);
		}
	}
}

class binSearch{
	public static int findIndex(int[] A, int target)  {
		int n = A.length - 1;

		if (A[0] >= target) return 0;
		if (A[n] < target) return n + 1;
		if (A[n] == target) return n;

		return binSearch(A, target, 0, n);
	}

	private static int binSearch(int[] A, int target, int lo, int hi) {
		int mid = (hi + lo) / 2;
		System.out.println(lo + ", " + hi);
		if (A[mid] ==  target) return mid;
		else if (A[mid] < target && A[mid + 1] > target) return mid + 1;
		else if (A[mid] < target) return binSearch(A, target, mid, hi);
		else return binSearch(A, target, lo, mid);
	}

	public static void main(String[] args) {
		int[] A = {1,3};
		int target = 3;

		System.out.println(findIndex(A, target));
	}
}

class romanToInt {
    public static int romanToInt(String s) {
        int len = s.length();
        int sum = 0;
        
        for (int i = len - 1; i >= 0; i--) {
            sum = sum + getVal(s.charAt(i), sum);    
            System.out.println(getVal(s.charAt(i), sum));
        }
        return sum;
    }
    
    private static int getVal(char c, int sum) {
        if (c == 'I') return (sum >= 5 ? -1 : 1);
        else if (c == 'V') return 5;
        else if (c == 'X') return (sum >= 50 ? -10 : 10);
        else if (c == 'L') return 50;
        else if (c == 'C') return (sum >= 500 ? -100 : 100);
        else if (c == 'D') return 500;
        else if (c == 'M') return 1000;
        else return 0;
    }

    public static void main(String[] args) {
    	String roman = "DCXXI";

    	System.out.println(romanToInt(roman));
    }
}

class AddOne{
	public static int[] plusOne(int[] digits) {
        int cur = digits.length - 1;
        
        while (cur >= 0) {
            digits[cur]++;
            if (digits[cur] == 0) {
                cur--;
            } else break;
        }
        
        if (digits[0] != 0) return digits;
        else {
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }

    public static void main(String[] args) {
    	int[] A = {1};

    	A = plusOne(A);

    	for (int a : A) {
    		System.out.print(a);
    	}

    	System.out.println();
    }
}


class longSub{
	public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
        String longest = strs[0];
        int j = longest.length();
        for (int i = 1; i < strs.length; i++) {
            j = Math.min(getOverlap(longest, strs[i]), j);
            System.out.println(j);
        }
        return longest.substring(0, j);
    }
    
    private static int getOverlap(String str1, String str2) {
        int i = 0;
        int min = Math.min(str1.length(), str2.length());
        while (i < min && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return i;
    }

    private static int[] test() {
    	int[] myArray =  {-1, -1};
    	return myArray;
    }

    public static void main(String[] args) {
    	int[] A = test();

    	for (int a : A) System.out.println(a);
    }
}

class NextPermutation{
	    public static void nextPermutation(int[] num) {
        int N = num.length;
        if (N <= 1) return;
        
        int index = N - 1;
        while (index > 0) {
        	if (num[index - 1] > num[index]) index--;
        	else break;
        }
        index--;

        if (index == 0) return;

        int minIndex = index + 1;
        int min = num[minIndex];

        for (int i = minIndex; i < N; i++) {
        	if (num[i] > num[index] && num[i] < num[minIndex]) {
        		min = num[i];
        		minIndex = i;
        	}
        }

        int t = num[minIndex];
        num[minIndex] = num[index];
        num[index] = t;

        sort.mergeSort(num, new int[N], index + 1, N - 1);
    }

    public static void main(String[] args) {
    	int[] A = {3,1,4,1,5,9,2};

    	nextPermutation(A);
    	for (int a : A) {
    		System.out.println(a);
    	}
    }
}

class sort {
	public static void mergeSort(int[] A) {
		int[] tmp = new int[A.length];
		mergeSort(A, tmp, 0, A.length - 1);
	}

	public static void mergeSort(int[] A, int[] tmp, int lo, int hi) {
		if (lo >= hi) return;

		int mid = (hi + lo) / 2;
		mergeSort(A, tmp, lo, mid);
		mergeSort(A, tmp, mid + 1, hi);
		merge(A, tmp, lo, mid, hi);
	}

	private static void merge(int[] A, int[] tmp, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			tmp[i] = A[i];
		}

		int i = lo;
		int j = mid + 1;
		int k = lo;

		while (i <= mid && j <= hi) {
			if (tmp[i] <= tmp[j]) A[k++] = tmp[i++];
			else A[k++] = tmp[j++];
		}

		while (i <= mid) {
			A[k++] = tmp[i++];
		}
	}

	public static void main(String[] args) {
		int[] A = {3,1,4,1,5,9,2,6};

		mergeSort(A);
		for (int a : A) System.out.println(a);
	}
}


class LongestPalinSub{
	public static String longestSub(String s) {
		int len = s.length();
		if (len <= 1) return s;

		String max = s.substring(0,1);
		int maxLen = 1;

		for (int i = 1; i < len; i++) {
			String str1 = expandAround(s, i, i);
			if (str1.length() > maxLen) {
				max = str1;
				maxLen = str1.length();
			}

			str1 = expandAround(s, i - 1, i);
			System.out.println(str1);
			if (str1.length() > maxLen) {
				max = str1;
				maxLen = str1.length();
			}
		}
		return max;
	}

	private static String expandAround(String s, int l, int r) {
		while (l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r))) {
			l--;
			r++;
		}
		return s.substring(l + 1, r);
	}

	public static void main(String[] args) {
		String s = "cabc";
		System.out.println(longestSub(s));
	}
}


class uniquePaths{
	public static int uniquePaths(int m, int n) {
		if (m <= 1 || n <= 1) return 1;

		int mem[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) 
				mem[i][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) 
				mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
		}

		return mem[m - 1][n - 1];
    }
	
	public static void main(String[] args) {
		System.out.println(uniquePaths(4,5));
	}
}

class Compress {
	public static String compress(String original) { 
		int len = original.length();
		StringBuilder sb = new StringBuilder();

		char first = original.charAt(0);

		int cnt = 0;

		for (int i = 0; i < len; i++) {
			if (original.charAt(i) == first) {
				cnt++;
			} else {
				sb.append(first);
				sb.append(cnt);
				first = original.charAt(i);
				cnt = 1;
			}
		}

		sb.append(first);
		sb.append(cnt);

		return sb.toString();
	}


	public static void main(String[] args) {
		String s = "abbbbbbc";
		System.out.println(compress(s));
	}
}

class UniqueTrees{
	public static int numTrees(int n) {
		if (n <= 1) return 1;
		if (n == 2) return 2;

		int[] mem = new int[n + 1];
		mem[0] = mem[1] = 1;
		mem[2] = 2;

		for (int i = 3; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				mem[i] += (mem[j] * mem[i - j - 1]);
			}
			System.out.println(mem[i]);
		}
		return mem[n];
	}

	public static void main(String[] args) {
		int n = numTrees(3);
		System.out.println(n);
	}
}

class GenParentheses{
	public static void genParentheses(int n){
		genParen("(", n - 1, n);
	}

	private static void genParen(String cur, int left, int right) {
		if (left == 0 && right == 0) {
			System.out.println(cur);
			return;
		} 

		if (left > right) return;

		if (left > 0) genParen(cur + "(", left - 1, right);
		if (right > 0) genParen(cur + ")", left, right - 1);
	}

	public static void main(String[] args) {
		genParentheses(3);
	}
}























