import java.util.*;

class removeArrayList{
	public static ArrayList<Integer> removePosition(ArrayList<Integer> A, ArrayList<Integer> B) {
		Integer val;
		Integer count = 1;

		for (int i = 0; i < B.size(); i++){
			val = B.get(i);
			B.set(i, val - (count++));
		}

		for (Integer I : B) {
			int i = I;
			A.remove(i);
		}

		for (Integer j : A) {
			System.out.println(j);
		}
		return A;
	}

	public static void main(String[] args){
		int[] aList = {2,3,5,8};
		ArrayList<Integer> A = new ArrayList<Integer>(aList.length);

		for (int i = 0; i < aList.length; i++)
  			A.add(Integer.valueOf(aList[i]));

  		int[] bList = {1,3};
		ArrayList<Integer> B = new ArrayList<Integer>(bList.length);

		for (int i = 0; i < bList.length; i++) {
  			B.add(Integer.valueOf(bList[i]));
  		}

		removePosition(A,B);
	}	
}