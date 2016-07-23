class printSums{
	public static void printSums(int n){
		if (n == 2) {
			System.out.print("1 + 1");
			System.out.println();
		} else {
			System.out.println("1 + " + (n - 1));
			System.out.print("1 + ");
			printSums(n - 1);
		}
	}

	public static void main(String[] args){
		printSums(12);
	}
}