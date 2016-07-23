import java.util.*;

class subsetSum{
	public static int genSums(int[] weights, int W){
		int[][] M = new int[weights.length+1][W+1];
		int N = weights.length;

		for (int i = 1; i <= N; i++){
			for (int w = 0; w <= W; w++) {
				if (weights[i-1] > w) M[i][w] = M[i-1][w]; 
				else {
					M[i][w] = Math.max(M[i-1][w], M[i-1][w-weights[i-1]] + weights[i-1]);	
					System.out.println("a: " + (M[i-1][w-weights[i-1]] + weights[i-1]) + " b: " + M[i-1][w]);
				}
			}
		}
		return M[N][W];
	}
	public static void main(String[] args){
		int[] weights = {3,1,4,12};
		int W = 14;

		System.out.println("answer: " + genSums(weights, W));
	}
}