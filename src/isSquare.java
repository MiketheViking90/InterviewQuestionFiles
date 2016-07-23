class Point{
	int x, y;

	Point(int x1, int y1) {
		x = x1;
		y = y1;
	}

	double distance(Point b) {
		int xDist = x - b.x;
		int yDist = y - b.y;

		return Math.sqrt(Math.pow(xDist,2) + Math.pow(yDist, 2));
	}

	void printPoint() {
		System.out.println(x + ", " + y);
	}
}

class isSquare{
	public static Point[] opposite(Point p1, Point p2, Point p3, Point p4) {
		double d1, d2, d3;

		Point[] rv = new Point[3];
		d1 = p1.distance(p2);
		d2 = p1.distance(p3);
		d3 = p1.distance(p4);

		if (d1 == d2) {
			rv[0] = p4;
			rv[1] = p2;
			rv[2] = p3;
		} else if (d1 == d3) {
			rv[0] = p3;
			rv[1] = p2;
			rv[2] = p4;
		} else {
			rv[0] = p2;
			rv[1] = p3;
			rv[2] = p4;
		}
		return rv;
	}

	public static boolean formsSquare(Point p1, Point p2, Point p3, Point p4) {
		double d1, d2, d3;

		d1 = p1.distance(p2);
		d2 = p1.distance(p3);
		d3 = p1.distance(p4);

		boolean equidistant = ((d1 == d2) || (d2 == d3) || (d3 == d1));

		if (!equidistant) {
			return false;
		} else {
			Point[] testThese = opposite(p1, p2, p3, p4);

			for (Point p : testThese) {
				p.printPoint();
			}

			Point opp = testThese[0];
			Point adj1 = testThese[1];
			Point adj2 = testThese[2];

			return (opp.distance(adj1) == opp.distance(adj2));
		}
	}

	public static void main(String[] args){
		Point p1 = new Point(0, 0);
		Point p2 = new Point(4, 3s);
		Point p3 = new Point(0, 4);
		Point p4 = new Point(4, 0);

		System.out.println(formsSquare(p1, p2, p3, p4));
	}
}