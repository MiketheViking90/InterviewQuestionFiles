class Node {
	int data;
	Node left;
	Node right;

	Node (int d) {
		data = d;
		left = null;
		right = null;
	}
}

public class BST{
	private Node root;

	public BST(int d) {
		root = new Node(d);
	}

	public BST(Node n) {
		root = n;
	}

	public Node getRoot() {
		return root;
	}

	public boolean lookup(int d) {
		return recurLookup(root, d);
	}

	boolean recurLookup(Node n, int d) {
		if (n == null) {
			return false;
		} else if (n.data == d) {
			return true; 
		}else {
			if (d <= n.left.data) {
				return recurLookup(n.left, d);
			} else {
				return recurLookup(n.right, d);
			}
		}
	}

	public void insert(int d) {
		root = rInsert(root, d);
	}

	private Node rInsert(Node n, int d) {
		if (n == null) {
			n = new Node(d);
			return n;
		} else {
			if (d <= n.data) {
				n.left = rInsert(n.left, d);
			} else {
				n.right = rInsert(n.right, d);
			}
			return n;
		}
	}

	public int size() {
		return rSize(root);
	}

	private int rSize(Node n) {
		if (n == null) {
			return 0;
		} else {
			return (rSize(n.left) + 1 + rSize(n.right));
		}
	}

	public void printTree() {
		printTree(root);
	}

	private void printTree(Node n) {
		if (n == null) return;

		printTree(n.left);
		System.out.println(n.data);
		printTree(n.right);
	}

	public void preOrderPrint() {
		preOrderPrint(root);
	}

	private void preOrderPrint(Node node) {
		if (node == null) return;

		System.out.println(node.data);
		preOrderPrint(node.left);
		preOrderPrint(node.right);
	}

	public int height() {
		return height(root, 0);
	}

	private int height(Node node, int curHeight) {
		if (node == null) return curHeight;

		int lHeight = height(node.left, curHeight + 1);
		int rHeight = height(node.right, curHeight + 1);

		return Math.max(lHeight, rHeight);
	}

	public static BST buildTree() {
		BST tree = new BST(5);
		tree.insert(7);
		tree.insert(8);
		tree.insert(3);
		tree.insert(4);
		tree.insert(2);
		tree.insert(1);

		return tree;
	}
}




























