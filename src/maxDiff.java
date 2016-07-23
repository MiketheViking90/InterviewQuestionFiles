import java.util.*;

class maxDiff{
	public static void maxDiff(int[] A){
		int min = A[0];
		int maxDiff = 0;
		int iPos = 0, jPos = 0, minPos = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] < min) {
				A[i] = min;
				minPos = i;
			} else {
				int diff = A[i] - min;
				if (diff > maxDiff) {
					maxDiff = diff;
					iPos = minPos;
					jPos = i;
				}
			}
		}
		System.out.println("i: " + iPos + ", j: " +  jPos);
	}

	public static char secondHiFreq(String s){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		char maxC = s.charAt(0), secondC = s.charAt(1);
		int maxCnt = 1, secondCnt = 1;
		Integer j;
		Character c;

		for (int i = 0; i < s.length(); i++){
			c = s.charAt(i);
			if (map.get(c) ==  null) {
				j = 1;
			} else {
				j = map.get(c);
				j++;
			}
			map.put(c,j);
			System.out.println(c + map.get(c));


			if (j > maxCnt) {
				secondCnt = maxCnt;
				secondC = maxC;
				maxCnt = j;
				maxC = c;
			} else if (j > secondCnt) {
				secondCnt = j;
				secondC = c;
			}
		}
		System.out.println(maxC + ", " + maxCnt);
		return secondC;
	}

	public static void main(String[] args){
		String s = "aabbbccccddddd";

		System.out.println(secondHiFreq(s));
	}
}