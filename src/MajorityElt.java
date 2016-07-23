import java.util.*;

class MajorityElt{
	public static boolean hasMajorityElt(int[] elts){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

		int N = elts.length;

		for (int i = 0; i < N; i++) {
			Integer count = map.get(elts[i]); 
				if (count == null) {
					map.put(i,1);
				} else {
					if ((++count) > N/2) return true;
					map.put(elts[i],count);
				}
			System.out.println(elts[i] + ", " + count);
		}

		return false;
	}

	public static void main(String[] args){
		int[] test = {1,2,4,5,1,1,1,1,5};
		System.out.println(hasMajorityElt(test));
	}
}	