import java.util.HashMap;

class maxRightArray{
	public static int[] maxRightArray(int[] A) {
		return null;
	}

	public static void main(String[] args) {
		String s = "asfasfd";
		System.out.println(s.substring(2));
	}	
}

class nextPalin{
	public static int nextPalin(int val) {
		String sVal = String.valueOf(val);
		int len = sVal.length();
		boolean isOddLength = (len % 2 != 0);

		if (allNines(sVal)) {
			return increment(len);
		}

		if (len <= 1) return val;

		int pivot = len / 2;
		int compareTo = pivot;
		String mid = "";
		if (isOddLength) {
			mid = sVal.substring(pivot, pivot + 1);
			compareTo++;
		}

		String beginning = sVal.substring(0, pivot);

		if (beginning.charAt(pivot - 1) > sVal.charAt(compareTo)) {
			String combine = beginning + mid  + reverse(beginning);
			return Integer.parseInt(combine);
		} else {
			int beginInt = Integer.parseInt(beginning);
			beginning = String.valueOf(++beginInt);

			String combine = beginning + mid + reverse(beginning);
			return Integer.parseInt(combine);
		}
	}
	private static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	private static int increment(int len) {
		StringBuilder rv = new StringBuilder();

		rv.append("1");
		for (int i = 0; i < len; i++) {
			rv.append("0");
		}
		rv.append("1");
		return Integer.parseInt(rv.toString());
	}

	private static boolean allNines(String s) {
		for (char c : s.toCharArray()) {
			if (c != '9') return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 1234;
		String s = "abcd";
		System.out.println(nextPalin(n));
	}

}

class distBT{
	public static int distTwoNodesBinaryTree(Node n1, Node n2) {
		return 2;
	}

	public static void main(String[] args) {

	}
}

class BSTTest{
	public static void printVerticalSums(BST tree) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Node root = tree.getRoot();

		printVerticalSums(root, map, 0);
		System.out.println(map.entrySet());
	}

	private static void printVerticalSums(Node node, HashMap<Integer, Integer> map, int level) {
		if (node == null) return;

		printVerticalSums(node.left, map, level - 1);
		printVerticalSums(node.right, map, level + 1);

		if (map.get(level) ==  null) {
			map.put(level, node.data);
		} else {
			int curSum = map.get(level);
			curSum += node.data;
			map.put(level, curSum);
		}
	}

	public static void main(String[] args) {
		BST tree = new BST(5);
		tree.insert(7);
		tree.insert(8);
		tree.insert(3);
		tree.insert(4);
		tree.insert(2);
		tree.insert(1);

		printVerticalSums(tree);
	}
}

class MaxElts {
	public static MinHeap maxElts(int[] stream) {
		int len = stream.length;
		int heapSize = 10;
		MinHeap heap = new MinHeap(heapSize);

		for (int i = 0; i < heapSize; i++) {
			heap.insert(stream[i]);
		}

		for (int i = heapSize; i < stream.length; i++) {
			if (stream[i] > heap.peek()) {
				heap.swapTop(stream[i]);
				heap.heapifyDown(0);
			}
		}

		return heap;
	}

	public static void main(String[] args) {
		//int[] stream = {2,4,5,6,89,9,6,3,1,3,4,6};

		int[] stream = {20,14,9,6,4,5,1,99,99,99,99,99,99,99,99};
		MinHeap heap = maxElts(stream);
		heap.printVals();
	}
}

class MirrorTree{
	public static BST mirrorTree(BST tree) {
		Node root = tree.getRoot();
		mirrorTree(root);
		return tree;
	}

	public static void mirrorTree(Node node) {
		if (node == null) return;

		mirrorTree(node.left);
		mirrorTree(node.right);

		Node tmp = node.left;
		node.left = node.right;
		node.right = tmp;
	}

	public static void main(String[] args) {
		BST tree = new BST(5);
		tree.insert(7);
		tree.insert(8);
		tree.insert(3);
		tree.insert(4);
		tree.insert(2);
		tree.insert(1);

		tree = mirrorTree(tree);
		BSTTest.printVerticalSums(tree);
	}
}





























