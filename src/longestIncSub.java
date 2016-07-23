import java.util.*;

class longestIncSub{
	public static ArrayList<Integer> longestSub(Integer[] A){
		ArrayList<Integer> localLong = new ArrayList<Integer>();
		ArrayList<Integer> globalLong = new ArrayList<Integer>();

		Integer cur = A[0];
		localLong.add(cur);
		globalLong.add(cur);

		for (int i = 1; i < A.length; i++) {
			if (A[i] > cur) {
				localLong.add(A[i]);
				cur = A[i];
			} else {
				localLong = new ArrayList<Integer>();
				cur = A[i];
				localLong.add(cur);
			}
			if (localLong.size() > globalLong.size()) {
				globalLong = localLong;
			}
		}

		return globalLong;
	}

	public static void main(String[] args){
		Integer[] a = {1,2,3,4,4,5,-1};

		ArrayList<Integer> rv = longestSub(a);

		for (Integer i : rv) 
			System.out.println(i);
	}
}