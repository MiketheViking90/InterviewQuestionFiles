import java.util.*;

class RandomWalks{

	public static String generateWalk(int seed){
		StringBuffer walk = new StringBuffer();
		duple origin = new duple(0,0);
		duple curLoc = new duple(0,0);

		seed = newVal(seed);
		increment(generate(seed), walk, curLoc);

		int counter = 0;
		while (!curLoc.equals(origin) && counter <= 200) {
			seed = newVal(seed);
			increment(generate(seed), walk, curLoc);
			counter++;
		}
		if (counter == 200) return "";
		return walk.toString();
	}

	private static int newVal(int prev){
		return ((prev * 25173 + 13849)) % 65536;
	}

	private static int generate(int val){
		return val/16384;
	}

	private static void increment(int d, StringBuffer path, duple location){
		if (d == 0) {
			location.y++;
			path.append('U');
		} else if (d == 1) {
			location.y--;
			path.append('D');
		} else if (d == 2) {
			location.x--;
			path.append('L');
		} else {
			location.x++;
			path.append('R');
		}
		System.out.println(location.x + ", " +location.y);
	}

	public static void main(String[] args){
		int seed = 9;

		System.out.println(generateWalk(seed));
	}
}