import java.util.*;

class Align{
	static Math M;
	static System S;

	static int[][] mem;

	public static String[] align(String s, String t, int x){
		char[] sAry = s.toCharArray();
		char[] tAry = t.toCharArray();

		int m = s.length();
		int n = t.length();
		mem = new int[m+1][n+1];

		for (int i = 0; i <= m; i++) {
			mem[i][0] = i;
		}

		for (int j = 0; j <= n; j++) {
			mem[0][j] = j;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <z= n; j++) {
				if (s.charAt(i-1) == t.charAt(j-1)) {
					mem[i][j] = mem[i-1][j-1];
				}
				else {
					mem[i][j] = M.min(mem[i-1][j], mem[i][j-1]) + x;
				}
			}
		}

		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();

		int i,j; 
		for (i = m, j = n; i > 0 || j > 0; ){
			if (i > 0 && mem[i][j] == mem[i-1][j] + 1) {
				s1.append(s.charAt(--i));
				s2.append("-");
			}
			else if (j > 0 && mem[i][j] == mem[i][j-1] + 1) {
				s1.append("-");
				s2.append(t.charAt(--j));
			} else if (i > 0 && j > 0) {
				s1.append(s.charAt(--i));
				s2.append(t.charAt(--j));
			}
		}

		String[] rv = new String[2];
		rv[0] = s1.reverse().toString();
		rv[1] = s2.reverse().toString();

		return rv;
	}

	public static void main(String[] args){
		String s = "abc";
		String t = "ace";

		String[] val = align(s,t,1);

		S.out.println(val[0]);
		System.out.println(val[1]);
      }
}