import java.util.HashSet;
import java.util.ArrayList;

class getSentence{
	public static String getSentence(String s, HashSet<String> dict) {
		ArrayList<String> listOfWords = new ArrayList<String>();
		boolean properSentence = getWords(s, dict, listOfWords);

		StringBuilder rv = new StringBuilder();
		for (int i = listOfWords.size() - 1; i >= 0; i--) {
			rv.append(listOfWords.get(i));
			rv.append(" ");
		}
		if (properSentence) {
			return rv.toString();
		} else {
			return "you messed up";
		}
	}

	public static boolean getWords(String s, HashSet<String> dict, ArrayList<String> listOfWords) {
		int N = s.length();
		if (N == 0) return true;

		for (int i = 1; i <= N; i++) {
			String curWord = s.substring(0, i);
			if (dict.contains(curWord) && getWords(s.substring(i), dict, listOfWords)) {
				listOfWords.add(curWord);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		HashSet<String> words = new HashSet<String>();
		String s = "IwillworkatTwitter";

		words.add("I");
		words.add("will");
		words.add("work");
		words.add("at");
		words.add("Twitter");

		System.out.println(getSentence(s, words));
	}
}

class printSubsets{
	public static void printSubsets(String curPermutation, String s) {
		if (s.length() == 1) {
			System.out.println(curPermutation + s);
			System.out.println(curPermutation + "*");
		} else {
			printSubsets(curPermutation + s.substring(0,1), s.substring(1));
			printSubsets(curPermutation + "*", s.substring(1));
		}
	}

	public static void main(String[] args) {
		String s = "abc";

		printSubsets("", "abc");
	}
}

class numTrees{
	public static int numTrees(int n) {
		if (n <= 1) return 1;

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			int left = numTrees(i - 1);
			int right = numTrees(n - i);
			sum += (left * right);
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
}

class romanToInt{
	public static int getVal(char c) {
		switch (c) {
			case ('X') : return 10;
			case ('V') : return 5;
			case ('I') : return 1;
		}
		return 0;
	}

	public static int romanToInt(String s) {
		int i = 0;
		int sum = 0;

		while (i < s.length() - 1) {
			int cur = getVal(s.charAt(i));
			int next = getVal(s.charAt(i + 1));

			if (cur >= next) {
				sum += cur;
			} else {
				sum -= cur;
			}
			i++;
		}
		sum += getVal(s.charAt(i));
		return sum;
	}

	public static void main(String[] args) {
		String s = "XXIV";
		System.out.println(romanToInt(s));
	}
}


class random{
	public static int getRandomInt(int[] A, double[] W) {
		double val = Math.random();

		int i = 0;
		while (val > 0) {
			val -= W[i++];
		}
		return A[i - 1];
	}

	public static void main(String[] args){
		int[] counts = new int[3];

		int[] A = {1, 2, 3};
		double[] W = {.2, .5, .3};

		for (int i = 0; i < 1000; i++) {
			int val = getRandomInt(A, W);
			if (val == 1) {
				counts[0]++;
			} else if (val == 2) {
				counts[1]++;
			} else if (val == 3) {
				counts[2]++;
			}
		}

		for (int a : counts) {
			System.out.println(a);
		}
	}
}

class repeat{
	public static String longestRepeat(String s) {
		int N = s.length();

		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < (N - i + 1); j++) {
				String sub = s.substring(j, j+i);
				if (isRepeat(sub, s, j)) {
					return sub;
				}
			}
		}
		return "";
	}

	public static boolean isRepeat(String sub, String s, int start) {
		for (int i = start + 1; i <= (s.length() - sub.length()); i++) {
			String sub1 = s.substring(i, i +  sub.length());
			if (sub.equals(sub1)) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String s = "abcdefbcd";
		System.out.println(longestRepeat(s));
	}
}

class permutations{
	public static void printPermutations(String s, String current) {
		int N = s.length();
		if (N == 0) {
			System.out.println(current);
			return;
		}
		
		String head = s.substring(0,1);
		String tail = s.substring(1);

		if (current.length() == 0) {
			printPermutations(tail, head);
		} else {
			for (int i = 0; i <= current.length(); i++) {
				String perm = insertAt(i, current, head);
				printPermutations(tail, perm);
			}
		}
	}

	public static String insertAt(int i, String perm, String s) {
		String first = perm.substring(0,i);
		String second = perm.substring(i, perm.length());
		return first + s + second;
	}

	public static void main(String[] args) {
		String s = "abcd";

		printPermutations(s, "");
	}
}

class max{
	public static int max(int a, int b) {
		return 1;
	}

	public static void main(String[] args) {
		int a = 12;
		int b = 15;
		int n = 125;

		int cnt = 0;
		while (n > 0) {
			cnt += (n & 1);
			n = n >> 1;
			System.out.println(n);
		}

		System.out.println(cnt);
	}
}

class Binary{
	public static String toBinary(int n) {
		StringBuilder binaryForm = new StringBuilder();

		while (n > 0) {
			int remainder = (n % 2);
			binaryForm.append(Integer.toString(remainder));

			n /= 2;
		}

		return binaryForm.reverse().toString();
	}
	public static void main(String[] args) {
		String s = "8923";

		int n = (int) s.charAt(2) - '0';

		System.out.println(2 % 0);
	}
}
