import java.util.HashMap;
import java.util.ArrayList;

class fillCharMatrix{
	public static char[][] fillCharMatrix(String s, int r) {
		int N = s.length();
		int c = (N % r == 0 ? N / r : (N / r) + 1);

		char[][] matrix = new char[r][c];
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				int index = (i * r) + j;
				if (index < N) {
					matrix[j][i] = s.charAt(index);
				} else {
					matrix[j][i] = ' ';
				}
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		String s = "abcdefg";
		int r = 3;
		char[][] matrix = fillCharMatrix(s, r);

		for (int col = 0; col < matrix[0].length; col++) {
			for (int row = 0; row < r; row ++) {
				System.out.println(matrix[row][col]);
			}
		}
	}
}

class printKeypad{
	public static void printKeypad(String input) {
	 	HashMap<Character, ArrayList<Character>> map = new HashMap<Character, ArrayList<Character>>();
		int N = input.length();
	}

	/* 
		1: a b c
		2: d e f
		3: g h i
		4: j k l
		5: m n o
		6: p q r
		7: s t u
		8: v w x
		9: y z
	*/
}