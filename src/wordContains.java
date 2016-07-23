class wordContains{
	public static boolean areAnagrams(char[] inputChars, String t){
		int[] tCharCounts = new int[58];
		int i;

		for (i = 0; i < t.length(); i++) {
			char c2 = t.charAt(i);

			tCharCounts[c2 - 65]++;
		} 

		for (i = 0; i < 58; i++){
			if (inputChars[i] != tCharCounts[i]) return false;
		}

		return true;
	}

	public static boolean contains(String s, String t){
		char[] inputChars = new char[58];

		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			inputChars[c - 65]++;
		}

		int sLen = s.length();
		int N = t.length() - sLen + 1;
		String[] suffixes = new String[N];

		int j = 0;
		for (int i = t.length() - sLen; i >= 0; i--){
			suffixes[j++] = t.substring(i,i+sLen);
			System.out.println(suffixes[j-1]);
		}
		
		for (String suffix : suffixes) {
			if (areAnagrams(inputChars, suffix)) return true;
		}
		return false;
	}

	public static void main(String[] args){
		String s = "ate";
		String t = "tea";

		char[] inputChars = new char[128];

		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			inputChars[c-65]++;
		}

		System.out.println(contains("ate","pihitea"));
	}
}