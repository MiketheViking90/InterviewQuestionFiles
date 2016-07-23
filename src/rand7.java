class rand7{
	public static int rand7(){
		int t = (rand5() + rand5() + rand5() + rand5() + rand5() + rand5() + rand5());
		return t/5;
	}

	public static int rand5(){
		return (int) ((Math.random() * 5) + 1);
	}

	public static void main(String[] args){
		for (int i = 0; i < 100; i++)
			System.out.println(rand7());
	}
}