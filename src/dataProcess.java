class dataProcess{
	public static int maxProcessed(int[] data, int[] schedule) {
		int N = data.length;
		int[][] M = new int[N+1][N+1];

		int i,j;
		for (i = 1; i <= N; i++) {
			M[N][i] = Math.min(schedule[i-1],data[N-1]);
		}

		for (i = 1; i <= N; i++) {
			for (j = 1; j <= N; j++) {
				M[i][j] = Math.max((M[i-1][j-1] + Math.min(data[j-1],schedule[i-1])),(M[i-1][1]));
			}
		}
		return M[N][N];
	}

	public static void main(String[] args){
		int[] data = {10,1,7,7};
		int[] schedule = {8,4,2,1};

		System.out.println((maxProcessed(data,schedule)));
	}
}