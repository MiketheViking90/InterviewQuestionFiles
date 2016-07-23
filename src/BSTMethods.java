class printPaths {
	public static void printPaths(BST tree) {
		int[] path = new int[tree.height()];
		printPaths(tree.getRoot(), path, 0);
	}

	private static void printPaths(Node node, int[] path, int index) {
		if (node == null) {
			return;
		} 

		path[index++] = node.data;

		if (node.left == null && node.right == null) {
			printArray(path, index);
		}

		printPaths(node.left, path, index);
		printPaths(node.right, path, index);
	}

	private static void printArray(int[] array, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BST tree = BST.buildTree();
		System.out.println(tree.height());
		printPaths(tree);
	}
}

class mirrorTree{
	public static void mirrorTree(Node node) {
		if (node == null) return;

		mirrorTree(node.left);
		mirrorTree(node.right);

		Node tmp = node.left;
		node.left = node.right;
		node.right = tmp;
	}

	public static void main(String[] args) {
		BST tree = BST.buildTree();

		mirrorTree(tree.getRoot());
		tree.printTree();
	}
}

class printByLevel{
	public static void printByLevel(BST tree) {
		printByLevel(tree.getRoot());
	}

	public static void printByLevel(Node root) {
		int height = getHeight(root);

		for (int i = 0; i < height; i++) {
			printLevel(root, i);
			System.out.println();
		}
	}	

	private static void printLevel(Node node, int count) {
		if (node == null) return;

		if (count == 0) {
			System.out.print(node.data + " ");
			return;
		}

		printLevel(node.left, count - 1);
		System.out.print(" ");
		printLevel(node.right, count - 1);
	}

	private static int getHeight(Node node) {
		return getHeight(node, 0);
	}

	private static int getHeight(Node node, int curHeight) {
		if (node == null) return curHeight;

		int lHeight = getHeight(node.left, curHeight + 1);
		int rHeight = getHeight(node.right, curHeight + 1);

		return Math.max(lHeight, rHeight);
	}

	public static void main(String[] args) {
		BST tree = BST.buildTree();
		mirrorTree.mirrorTree(tree.getRoot());

		printByLevel(tree.getRoot());
	}
}

class doubleTree{
	public static void doubleTree(Node node) {
		if (node == null) return;

		doubleTree(node.left);
		doubleTree(node.right);

		Node lNode = node.left;
		Node rNode = node.right;

		int data = node.data;
		node.left = new Node(data);
		node.left.left = lNode;
	}

	public static void main(String[] args) {
		BST tree = BST.buildTree();

		doubleTree(tree.getRoot());
		printByLevel.printByLevel(tree.getRoot());
	}
}

class sameTree {
	public static boolean sameTree(Node a, Node b) {
		if (a == null && b == null) {
			return true;
		} else if (a != null && b != null) {
			boolean lSame = sameTree(a.left, b.left);
			boolean rSame = sameTree(a.right, b.right);
			return (lSame && rSame && (a.data == b.data));
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		BST t1 = BST.buildTree();
		BST t2 = BST.buildTree();

		System.out.println(sameTree(t1.getRoot(), t2.getRoot()));
		t2.getRoot().left = null;
		System.out.println(sameTree(t1.getRoot(), t2.getRoot()));
	}
}

class convert{
	public static Node convert(BST tree) {
		Node root = tree.getRoot();

		root = convert(root);
		root.left.right = null;
		root.left = null;
		return root;
	}

	private static Node convert(Node node) {
		if (node == null) return null;

		if (node.left == null && node.right == null) {
			node.left = node;
			node.right = node;
			return node;
		}

		Node p1 = convert(node.left);
		Node p3 = convert(node.right);
		Node tail3 = null;

		if (p1 != null) {
			concat(p1.left, node);
		} else {
			System.out.println(p3.left.data);
			concat(p3.left, node); 
		}

		if (p3 != null) {
			tail3 = p3.left;
			concat(node, p3);
		} else {
			concat(node, p1);
		}

		if (p1 != null && p3 != null) {
			concat(tail3, p1);
		}

		return (p1 == null ? node : p1);
	}

	private static void concat(Node n1, Node n2) {
		n1.right = n2;
		n2.left = n1;
	}

	public static void main(String[] args) {
		BST tree = BST.buildTree();

		Node head = convert(tree);
		System.out.println("list vals: ");
		while (head != null) {
			System.out.println(head.data);
			head = head.right;
		}
	}
}

class replaceSums {
	public static void replaceSums(BST tree) {
		Node root = tree.getRoot();
		replaceSums(root);
	}

	private static void replaceSums(Node node) {
		if (node == null) return;
		if (node.left == null && node.right == null) return;

		replaceSums(node.left);
		replaceSums(node.right);
		
		int sum = 0;
		if (node.left != null) sum += node.left.data;
		if (node.right != null) sum += node.right.data;

		node.data = sum;
	}

	public static void main(String[] args) {
		BST tree = BST.buildTree();
		printByLevel.printByLevel(tree);
		replaceSums(tree);
		printByLevel.printByLevel(tree);
	}
}


class getNext{
	public static int getNext(BST tree, int val) {
		Node next = getNext(tree.getRoot(), val, null);
		if (next == null) return Integer.MIN_VALUE;
		return next.data;
	}

	private static Node getNext(Node node, int val, Node prev) {
		if (node.data == val) {
			if (node.right != null) {
				return getMinGreater(node);
			} else {
				return prev;
			}
		} else if (node.data < val) {
			return getNext(node.right, val, prev);
		} else {
			return getNext(node.left, val, node);
		}
	}

	private static Node getMinGreater(Node root) {
		if (root.right != null) return root.right;
		return null;
	}

	public static void main(String[] args) {
		BST tree = BST.buildTree();

		System.out.println(getNext(tree, 4));
	}
}

class zigzagPrint{
	public static void zigzagPrint(BST tree) {
		int height = tree.height();
		zigzagPrint(tree.getRoot(), height - 1);
	}

	private static void zigzagPrint(Node node, int height) {
		boolean fromLeft = true;
		for (int i = 0; i < height; i++) {
			printLevel(node, i, fromLeft);
			System.out.println();
			fromLeft = !fromLeft;
		}
	}

	private static void printLevel(Node node, int level, boolean fromLeft) {
		if (node == null) return;
		if (level == 0) System.out.print(node.data + " ");

		if (fromLeft) {
			printLevel(node.left, level - 1, !fromLeft);
			printLevel(node.right, level - 1, !fromLeft);
		} else {
			printLevel(node.right, level - 1, !fromLeft);
			printLevel(node.left, level - 1, !fromLeft);
		}
	}

	public static void main(String[] args) {
		BST tree = BST.buildTree();

		zigzagPrint(tree);
	}
}

class LCA{
	private static Node findLCA(Node node, int v1, int v2) {
		if (node == null) return null;
		if (node.data == v1 || node.data == v2) return node;

		Node leftLCA = findLCA(node.left, v1, v2);
		Node rightLCA = findLCA(node.right, v1, v2);

		if (leftLCA != null && rightLCA != null) return node;
		else if (leftLCA == null && rightLCA == null) return null;
		else return (leftLCA == null ? rightLCA : leftLCA);
	}

	public static void main(String[] args) {
		BST tree = BST.buildTree();

		Node lca = findLCA(tree.getRoot(), 1, 4);
		System.out.println(lca.data);
	}
}

class pruneLeaves{
	public static void main(String[] args) {
		BST tree = BST.buildTree();

		pruneLeaves(tree.getRoot(), 11);
		tree.printTree();
	}

	private static void pruneLeaves(Node root, int val) {
		pruneLeaves(root, 0, val);
	}

	private static int pruneLeaves(Node node, int sum, int val) {
		if (node == null) return sum;

		sum += node.data;

		int lSum = pruneLeaves(node.left, sum, val);
		int rSum = pruneLeaves(node.right, sum, val);

		if (lSum < val) node.left = null;
		if (rSum < val) node.right = null;
		return Math.max(lSum, rSum);
	}
}

class repairTree{
	private static void swap(Node a, Node b) {
		int t = a.data;
		a.data = b.data;
		b.data = t;
	}

	public static Node repairTree(Node root) {
		if (root == null) return null;

		Node first, mid, last, prev;
		first = mid = last = prev = null;

		repairTreeUtil(root, first, mid, last, prev);

		if (first != null && mid != null) {
			swap(first, mid);
		} else if (first != null && last != null) {
			swap(first, last);
		}
		return root;
	}

	private static void repairTreeUtil(Node node, Node first, Node mid, Node last, Node prev) {
		if (node == null) return;
		//System.out.println();
		//System.out.print(node.data);
		//if (prev != null) System.out.println(", " + prev.data);
		repairTreeUtil(node.left, first, mid, last, prev);

		if (prev != null && node.data < prev.data) {
			if (first == null) {
				first = new Node(prev.data);
				mid = new Node(node.data);
			} else {
				last = new Node(node.data);
			}
		}

		prev = node;
		repairTreeUtil(node.right, first, mid, last, prev);
	}

	public static void main(String[] args) {
		BST tree = new BST(10);
		Node root = tree.getRoot();
		root.left = new Node(5);
		root.right = new Node(8);
		root.left.left = new Node(2);
		root.left.right = new Node(20);

		repairTree(root);
		//tree.preOrderPrint();
	}
}

class validBST{
	public static boolean isValidBST(Node root) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        return isValidBST(root, min, max);
    }
    
    private static boolean isValidBST(Node node, int min, int max) {
        if (node == null) return true;
        
        System.out.println(node.data + " " + min + " " + max);

        if (node.data > max || node.data <= min) return false;
        
        boolean lValid = isValidBST(node.left, min, node.data);
        boolean rValid = isValidBST(node.right, node.data, max);
        
        return lValid && rValid;
    }

    public static void main(String[] args) {
    	BST tree = new BST(1);
    	tree.getRoot().right = new Node(1);

    	System.out.println(isValidBST(tree.getRoot()));
    }
}

class numBST {
	public static int numBST(int n) {
		if (n <= 1) return 1;
		int[] mem = new int[n + 1];
		mem[0] = mem[1] = 1;

		for (int i = 2; i <= n; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += (mem[j] * mem[i - j - 1]);
			}
			mem[i] = sum;
		}

		return mem[n];
	}

	public static void main(String[] args) {
		System.out.println(numBST(6));
	}
}

class levelPrint{
	public static void levelPrint(Node root) {
		int height = getHeight(root, 0);

		for (int i = 0; i < height; i++) {
			printLevel(root, i);
			System.out.println();
		}
	}

	private static void printLevel(Node node, int cur) {
		if (node == null) return;
		if (cur == 0) {
			System.out.print(node.data + " ");
			return;
		}
		printLevel(node.left, cur - 1);
		printLevel(node.right, cur - 1);
	}

	private static int getHeight(Node node, int cur) {
		if (node == null) return cur;
		return Math.max(getHeight(node.left, cur + 1), getHeight(node.right, cur + 1));
	}

	public static void main(String[] args) {
		BST tree = BST.buildTree();
		levelPrint(tree.getRoot());
	}
}

class uniquePaths{
	public static int numPaths(int m, int n) {
		int[] mem = new int[m + 1];
		mem[1] = 1;

		for (int i = 0 ; i < n; i++) {
			for (int j = 1; j <= m; j++) {
				mem[j] += mem[j - 1];
			}
		}
		return mem[m];
	}

	public static void main(String[] args) {
		System.out.println(numPaths(2,2));
	}
}


















