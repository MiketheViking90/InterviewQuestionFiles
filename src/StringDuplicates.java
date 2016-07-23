import java.util.*;

class StringDuplicates{
	public static String remDups(String s, String lastRemoved){
		int N = s.length();
		String remStr;

		if (N <= 1) return s;
		else if (s.substring(0,1).equals(s.substring(1,2))) {
			lastRemoved = s.substring(0,1);
			return remDups(s.substring(2,N), lastRemoved);
		} else {
			remStr = s.substring(0,1) + remDups(s.substring(1,N), lastRemoved);
			if (remStr.substring(0,1).equals(lastRemoved)) {
				return s.substring(1);
			} else {
				return s;
			}
		}
	}

	public static int optSet(int[] path){
		int N = path.length;
		int[] T = new int[N+1];
		T[1] = path[0];

		for (int i = 2; i <= N; i++) {
			T[i] = Math.max(T[i-2] + path[i-1], T[i-1]);
			if ((T[i-2] + path[i-1]) > T[i-1]){
				System.out.println(i + ", " + path[i-1]);
			}
		}
		return T[N];
	}

	public static void main(String[] args){
		int[] path = {1,8,6,3,6};

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('c',2);
		System.out.println((map.get('c')));

		//System.out.println(optSet(path));
	}
}   