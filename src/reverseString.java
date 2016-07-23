class reverseString{
	public static String reverseString(String s){
		char[] s1 = s.toCharArray();
		int N = s1.length;
		char t;

		for(int i = 0; i < N/2; i++){
			t = s1[i];
			s1[i] = s1[N-i-1];
			s1[N-i-1] = t;
		}
		return new String(s1);
	}

	public static boolean allUnique(String s){
		int N = s.length();

		for (int i = 0; i < N - 1; i++) {
			for (int j = i; j < N; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static String replace(String s){
		int i,j;
		int count = 0; 

		for (i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') count++;
		}

		char[] s1 = new char[s.length() + (2 * count)];

		j = 0;
		for (i = 0; i < s.length(); i++){
			if (s.charAt(i) != ' '){
				s1[j++] = s.charAt(i);
			} else {
				s1[j++] = '%';
				s1[j++] = '2';
				s1[j++] = '0';
			}
		}
		return new String(s1);
	}

	public static String stringCompress(String s){
		StringBuilder s1 = new StringBuilder();

		int count = 1;
		char cur;

		for (int i = 0; i < s.length(); i++) {
			cur = s.charAt(i);
			for (int j = i + 1; j < s.length(); j++){
				if (s.charAt(i) == s.charAt(j)) count++;
				else {
					i = j - 1;
					break;
				}
			}

			if (count > 1) {
				s1.append(cur);
				s1.append(count);
			} else {
				s1.append(cur);
			}
			count = 1;
		}
		return new String(s1);
	}

	public static void zeroMatrix(int[][] matrix){
		int M = matrix.length;
		int N = matrix[0].length;
		boolean[] rows = new boolean[M];
		boolean[] cols = new boolean[N];
		int[][] zeros = new int[M][N];

		int i,j;

		for (i = 0; i < M; i++){
			for (j = 0; j < N; j++){
				if (matrix[i][j] == 0){
					if (!rows[i]) rows[i] = true;
					if (!cols[j]) cols[j] = true;
				}
			}
		}

		for (i = 0; i < M; i++) {
			for(j = 0; j < N; j++){
				if (rows[i] || cols[j]){
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static boolean isSubstring(String s, String t){
		int M = s.length();
		int N = t.length();

		for (int i = 0; i <= M - N; i++){
			System.out.println(s.substring(i,i+M));
			if (s.substring(i,i+M-2).equals(t)) return true;
		}
		return false;
	}

	public static boolean isRotation(String s, String t){
		int N = t.length();
		String first,last;

		for (int i = 0; i < N; i++){
			first = t.substring(0,i);
			last = t.substring(i);
			if (s.contains(first) && s.contains(last)){
				System.out.println(last+first);
				if ((last+first).equals(s)) return true;
			}
		}
		return false;
	}

	public static void listTest(){
		LinkedList l = new LinkedList();

		if (l.isEmpty()) {
			l.head = new LinkedList.Node();
			l.head.data = 4;
		}

		System.out.println(l.head.data);
	}

	public static boolean isRotation1(String s, String t){
		String tt = t + t;
		return tt.contains(s);
	}


	public static void main(String[] args){
		String s = "hello";
		String t = "ohell";
		listTest();
	}
}