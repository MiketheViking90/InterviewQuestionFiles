class billboardRevenue{
	static int[] T;

	public static int revenue(int[] sites, int[] revenue) {
		int n = sites.length;
		int i;

		T = new int[n+1];

		for (i = 1; i <= n; i++) {
			int east = prev(sites, i-1);

			T[i] = Math.max((T[east] + revenue[i-1]), T[i-1]);
		}

		StringBuilder site = new StringBuilder();

		for (i = n; i > 0; i--) {
			int east = prev(sites, i-1);

			if (T[east] + revenue[i-1] > T[i-1]) {
				System.out.println(sites[i-1]);
				//site.append(String.valueOf(i) + ", ");
			}
		}

		System.out.println(site.toString());

		return T[n];
	}

	public static int prev(int[] sites, int s){
		if (s == 1) return 0;
		for (int i = s - 1; s > 0; i--) {
			if (sites[s] - sites[i] > 5) return i + 1;
		}
		return 0;
	}

	public static void main(String[] args){
		String s = "abc";
		String t = "bourne again";

		insertDash(s,t);
	}

	public static void insertDash(String s, String t){
		StringBuilder s1 = new StringBuilder();
		StringBuilder t1 = new StringBuilder();

		int M = s.length();
		int N = t.length();

		int[][] grid = new int[N+1][M+1];

		int i,j;

		//initialize grid values
		for (i = 0; i < N; i++) {
			grid[i][0] = i;
		}

		for (j = 0; j < M; j++) {
			grid[0][j] = j;
		}

		for (i = 1; i <= N; i++) {
			for (j = 1; j <= M; j++) {
				if (s.charAt(i-1) == t.charAt(j-1)) {
					grid[i][j] = grid[i-1][j-1];
				} else {
					grid[i][j] = Math.min(grid[i-1][j] + 1, grid[i][j-1] + 1);
				}
			}
		}

		for (i = N, j = M; i > 0 || j > 0; ) {
			if (i > 0 && (grid[i][j] == grid[i-1][j] + 1)) {
				s1.append(s.charAt(--i));
				t1.append("-");
			} else if (j > 0 && (grid[i][j] == grid[i][j-1] + 1)) {
				s1.append("-");
				t1.append(t.charAt(--j));
			} else if (grid[i][j] == grid[i-1][j-1]) {
				s1.append(s.charAt(--i));
				t1.append(t.charAt(--j));
			}
		}

		System.out.println(s1.reverse());
		System.out.println(t1.reverse());
	}
}