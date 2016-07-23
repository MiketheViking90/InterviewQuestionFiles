class duple{
	int x;
	int y;

	public duple(int a, int b){
		x = a;
		y = b;
	}

	public boolean equals(duple d1){
		return ((x == d1.x) && (y == d1.y));
	}
}
