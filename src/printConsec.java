import java.util.*;

class printConsec{
	public static void printConsec(String s){
		char[] cAry = s.toCharArray();

		System.out.print(s.charAt(0));
		for (int i = 0; i < cAry.length - 1; i++) {
			if (cAry[i+1] == cAry[i] + 1) {
				System.out.print(cAry[i + 1]);
			} else {
				System.out.println();
				System.out.print(cAry[i + 1]);
			}
		}
	}

	public static void main(String[] args){
		String s = "ABEFGMNOIOJWOFJEIOFJXYZ";

		printConsec(s);
	}
}

class sortBinArray{
	public static void sortAry(int[] Ary){
		int i = 0;
		int j = Ary.length - 1;

		while (i < j) {
			if (Ary[i] == 1 && Ary[j] == 0) {
				Ary[i++] = 0;
				Ary[j--] = 1;
			} else if (Ary[i] == 0 && Ary[j] == 0) {
				i++;
			} else if (Ary[i] == 1 && Ary[j] == 1) {
				j--;
			} else {
				i++;
				j--;
			}
		}
	}
	public static void main(String[] args){
		int[] A = {0,1,0,1,1,1,0,0,1,1,1,1};

		sortAry(A);
		for(int i : A) System.out.println(i);
	}
}

class closestPalindrome{
	public static String reverse(String s){
		char[] cAry = s.toCharArray();
		int N = s.length();

		for (int i = 0; i < N/2; i++){
			char t = s.charAt(i);
			cAry[i] = cAry[N - i - 1];
			cAry[N - i - 1] = t;
		}
		return String.valueOf(cAry);
	}

	public static String closestPalindrome(int n){
		String sInput = String.valueOf(n);
		String first, last, palindrome, m;
		char fMid, lMid;
		int N = sInput.length();

		if (N % 2 != 0) {
			m = sInput.substring(N/2,N/2+1);
			first = sInput.substring(0,N/2);
			last = sInput.substring(N/2 + 1);
			fMid = first.charAt(N/2 - 1);
			lMid = last.charAt(0);
		} else {
			m = "";
			first = sInput.substring(0,N/2);
			last = sInput.substring(N/2);
			fMid = first.charAt(N/2 - 1);
			lMid = last.charAt(0);
		}

		if (fMid > lMid) {
			palindrome = first + m + reverse(first);
			return palindrome;
		} else if (fMid < lMid) {
			int t = Character.getNumericValue(fMid);
			t++;
			first = first.substring(0,N/2 - 1) + String.valueOf(t);
			palindrome = first + m + reverse(first);
			return palindrome;
		} else {
			if (Integer.parseInt(first) < Integer.parseInt(reverse(last))) {
				System.out.println(reverse(last));
				int t = Character.getNumericValue(fMid);
				t++;
				first = first.substring(0,N/2 - 1) + String.valueOf(t);
				palindrome = first + m + reverse(first);
				return palindrome;
			} else {
				palindrome = first + m +reverse(first);
				return palindrome;
			}
		}
	}
	public static void main(String[] args) {
		int n = 1234311;
		System.out.println(closestPalindrome(n));
	}
} 

