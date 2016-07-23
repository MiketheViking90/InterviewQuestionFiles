import java.util.HashMap;

class rotate{
	public static int[][] rotate90(int[][] matrix) {
		int N = matrix.length;
		int M = matrix[0].length;

		int[][] transpose = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				transpose[j][i] = matrix[N - i - 1][j];
			}
		}

		return transpose;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4},
							{5, 6, 7, 8},
								{9, 10, 11, 12 }};
		int[][] transpose = rotate90(matrix);

		for (int i = 0; i < transpose.length; i++) {
			for (int j = 0; j < transpose[0].length; j++) {
				System.out.print(transpose[i][j] + ", ");
			}
			System.out.println();
		}

	}
}

class printChars {
	public static void findChars(String sentence) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();

		for (int i = 0; i < sentence.length(); i++) {
			String c = sentence.substring(i, i + 1);
			if (map.get(c) == null) {
				map.put(c, true);
			}
		}
		for (String s : map.keySet()) {
			if (map.get(s)) {
				System.out.println(s);
			}
		}
	}

	public static void main(String[] args) {
		String s = "iqjwoefwqheohhsdaa;lsdl";

		findChars(s);
	}
}

class matrixDP{
	public static int nSteps(int M, int N) {
		int[][] mem = new int[M + 1][N + 1];

		for (int i = 0; i <= M; i++) {
			mem[i][0] = 1;
		}

		for (int i = 0; i <= N; i++) {
			mem[0][i] = 1;
		}

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
			}
		}
		return mem[M - 1][N - 1];
	}

	public static void main(String[] args) {
		//int nPaths = nSteps(8, 3);
		//System.out.println(nPaths);
		System.out.println(args[0]);
	}
}

class Node {
	int data;
	Node next;

	public Node(int d) {
		data = d;
	}
}

class reverseList{
	public static Node reverseList(Node head) {
		Node ptr = head;
		Node nextNode = head.next;
		ptr.next = null;

		while (nextNode != null) {
			ptr = nextNode;
			nextNode = nextNode.next;

			head = moveNode(head, ptr);
		}
		return head;
	}

	private static Node moveNode(Node head, Node ptr) {
		ptr.next = head;
		return ptr;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList(1);
		list.append(2);
		list.append(3);
		list.append(4);

		Node rev = reverseList(list.getHead());
		while (rev != null) {
			System.out.println(rev.data);
			rev = rev.next;
		}
	}
}

class interweave{

}

class binarySearch {
	public static int firstOccur(int[] A) {
		return firstOccur(A, 0, A.length - 1);
	}

	private static int firstOccur(int[] A, int lo, int hi) {
		if (lo > hi) return -1;
		if (A[lo] == 1 || A[hi] == 0) return -1;

		int mid = (hi + lo) /2 ;

		if (A[mid] == 0 && A[mid + 1] == 0) return firstOccur(A, mid, hi);
		else if (A[mid] ==  1 && A[mid + 1] ==  1) return firstOccur(A, lo, mid);
		else return mid + 1;
	}

	public static void main(String[] args) {
		int[] A = {0};

		System.out.println(firstOccur(A));
	}
}

class countInversions{
	public static int countInversions(int[] A) {
		return 1;
	}

	public static void main(String[] args) {
		int[] A = {6,4,2,5,7,9,21,0};
		System.out.println(countInversions(A));
	}
}

class findMedian{
	public static int getMedian(int[] A1, int[] A2) {
		int n = A1.length;
		return getMedian(A1, A2, 0, n - 1, n);
	}

	private static int getMedian(int[] A1, int[] A2, int lo, int hi, int len) {
		if (lo > hi) return getMedian(A2, A1, 0, len - 1, len); 

		int i = (hi + lo) / 2;
		int j = len - i - 1;

		if (A1[i] > A2[j] && (j == len - 1 || A1[i] <= A2[j + 1])) {
			if (i == 0 || A2[j] > A1[i - 1]) {
				return (A1[i] + A2[j]) / 2;
			} else {
				return (A1[i] + A1[i - 1]) / 2;
			}
		} else if (A1[i] > A2[j] && (j != len - 1 && A1[i] > A2[i + 1])) {
			return getMedian(A1, A2, 0, i - 1, len);
		} else {
			return getMedian(A1, A2, i + 1, hi, len);
		}
	}

	public static void main(String[] args) {
		int[] A = {1, 3, 4, 13, 15};
		int[] B = {11, 17, 23, 43, 50};

		System.out.println(getMedian(A, B));
	}
}
























