class CandyBoxes{
	public static int remainingCandies(int[] boxes){
		int N = boxes.length;
		int min, max;

		while (true) { 
			min = boxes[0];
			max = boxes[0];

			for (int i = 0; i < N; i++) {
				 if (boxes[i] < min) min = boxes[i];
			     if (boxes[i] > max) {
			     	max = boxes[i];
			     	boxes[i] = boxes[0];
			     	boxes[0] = max;
			     }
			}
			if (min == max) break;
			else boxes[0] -= min;
		}
		return boxes[0];
	}
		public static void main(String[] args){
			int[] boxes = {366, 549, 915, 183, 549, 549, 183, 366, 915, 549, 915, 366};

			System.out.println(remainingCandies(boxes));
		}
	}