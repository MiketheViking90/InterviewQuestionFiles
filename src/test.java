import java.util.*;

class Test{
	public static int numRejected(int[] requests){
		boolean[] offered = new boolean[101];
		int nRejected = 0;

		for (int i : requests) {
			if (offered[i]){
				nRejected++;
			} else {
				offered[i] = true;
			}
		}
		return nRejected;
	}

	public static boolean equalSets(int[] A, int[] B, int cap){
		if (A.length != B.length) return false;

		for (int i = 0; i < A.length; i++){
			if ((A[i] > B[i] + cap) || (A[i] < B[i] - cap)){
				return false;
			}
		}
		return true;
	}

	public static String swapChar(String s, int first, int second){
		char[] t = s.toCharArray();

		char temp = t[first];
		t[first] = t[second];
		t[second] = temp;

		String swapString = new String(t);
		return swapString;
	}

	public static String fix(String sentence, int[] times, String[] dictionary){
		//first find the words
		int N = sentence.length();
		char[] chAry = sentence.toCharArray();
		final ArrayList<String> dict = new ArrayList<String>(Arrays.asList(dictionary));

		int i = 0;
		int j; //second pointer 
		while (i < N) {
			j = i + 1;
			while (sentence.charAt(j) != ' ') {
				if (j < N) {
					j++;
				}
			}
			System.out.println(sentence.substring(i,j+1));
			i = (j + 1);
		}
		String rv = new String(chAry);
		return rv;
	}

	public static void strTest(String s){
		char[] c = s.toCharArray();

		for (char a : c) {
			System.out.println(a);
		}
	}

	public static String longPre(String a, String b){
		int N = Math.min(a.length(), b.length());
		int i;

		StringBuffer s = new StringBuffer();
		for (i = 0; i < N; i++){
			if (a.charAt(i) == b.charAt(i)){
				s.append(a.charAt(i));
			}
		}

		if (i <= 1) return a.substring(0,1);
		else return s.toString();
	}

	public static String longestRepeatedSub(String s){
		int N = s.length();
		String[] suffixes = new String[N];

		for (int i = 0; i < N - 1; i ++){
			suffixes[i] = s.substring(i, N - 1);
			System.out.println(suffixes[i]);
		}

		return "d";
	}

	public static String decompress(String s){
		StringBuffer rv = new StringBuffer();

		for (int i = 0; i < s.length(); i ++){
			char c = s.charAt(i);
			if (c != '&') {
				rv.append(c);
			} else {
				int j = i + 1;
				while (s.charAt(j) != '-') j++;
				int beg = Integer.parseInt(s.substring(i+1,j));

				int k = j + 1;
				while (Character.isDigit(s.charAt(k)) && (k < s.length() - 1)) k++;
				int end = Integer.parseInt(s.substring(j+1,k));

				rv.append(s.substring(beg,end));
				i = k+1;
			}
		}
		return rv.toString();
	}

	public static int SearchDisks(String disks, String d){
		String[] diskAry = disks.split(" ");
		int cnt = 0;

		for (int i = diskAry.length - 1; i > 0; i--){
			if (diskAry[i].equals(d)){
				return cnt;
			} else cnt++;
		}

		return cnt;
	}

	public static int add(String eq, String[] vars){
		String[] vals = eq.split("\\+");
		HashMap<String, Integer> hash = new HashMap<String, Integer>();  
		int sum = 0;
		
		for (String var: vars) {
			String[] coord = var.split(" ");
			System.out.println(var);

			String key = coord[0];
			Integer val = Integer.parseInt(coord[1]);
			hash.put(key, val);
		}

		return sum;
	}

	public static int findVal(String code){
		int N = code.length();
		String sVal = "0";

		char c = code.charAt(0);
		if (Character.isDigit(c)) {
			return Integer.parseInt(code);
		}

		for (int i = N - 1; i > 0; i--) {
			c = code.charAt(i);
			if (!(Character.isDigit(c))){
				sVal = code.substring(i + 3, N);
			}
		}

		return Integer.parseInt(sVal);
	}

	public static void test(){
		Stack stack = new Stack();
	}

	public static String[] getSubstrings(String s) {
		int N = s.length();
		String[] suffixes = new String[N];

		for (int i = 0; i < N; i++) {
			suffixes[i] = s.substring(i, N);
		}		
		return suffixes;
	}

	public static String longestCommonPrefix(String s, String t, int maxLen) {
		StringBuilder rv = new StringBuilder();

		int minLen = Math.min(s.length(), t.length());
		for (int i = 0; i < minLen; i++) {
			if (s.charAt(i) == t.charAt(i) && (rv.length() < maxLen)) {
				rv.append(s.charAt(i));
			}
		}
		return rv.toString();
	}

	public static String longestRepeat(String str) {
		int len = str.length();

		for (int i = (len / 2); i >= 1; i--)  {
			for (int j = 0; j < len && (j + i <= len); j++) {
				for (int k = j + i; (k < len) && (k + i <= len); k++) {
					String subStr1 = str.substring(j, j + i).trim();
					String subStr2 = str.substring(k, k + i).trim();

					if (subStr1.equals(subStr2)){
						return subStr1;
					}				
				}
			}
		}
		return "";
	}

	public static void main(String[] args){
		String str = "banana";
		System.out.println(longestRepeat(str));
	}
}