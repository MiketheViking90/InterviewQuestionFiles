class GetChange{
	public static int[] getChange(int amt){
		int q,d,n,p;
		q = d = n = p = 0;

		if (amt >= 25) {
			q = (amt / 25);
			amt = (amt % 25);
		} 
		if (amt >= 10) {
			d = (amt / 10);
			amt = (amt % 10);
		}
		if (amt >= 5) {
			n = (amt / 5);
			amt = (amt % 5);
		}
		if (amt >= 1) {
			p = amt;
		}

		int[] rv = {q,d,n,p};
		return rv;
	}

	public static void main(String[] args){
		int amt = 85;
		
		int[] rv = getChange(amt);
		for (int val : rv) 
			System.out.println(val);
	}
}