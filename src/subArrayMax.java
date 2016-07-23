class subArrayMax{
	public static int maxSubarray(int[] elts){
		int locMax = 0;
		int gloMax = 0;
		int maxNeg = 0;


		for (int elt : elts) {
			locMax = Math.max(0, locMax + elt);
			gloMax = Math.max(gloMax, locMax);
		}

		if (gloMax > 0 )return gloMax;
		else return maxNeg;
	}

	public static void main(String[] args){
		int[] elts = {-2, -11, -4, -13, -5, -2};

		System.out.println(maxSubarray(elts));
	}
}