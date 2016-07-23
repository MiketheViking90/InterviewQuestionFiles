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
		return node;
	}

	public static void main(String[] args) {
		BST tree = BST.buildTree();

		tree.printTree();
	}
}