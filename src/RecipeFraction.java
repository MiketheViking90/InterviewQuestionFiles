import java.util.*;

class RecipeFraction{
	public static double getFraction(String[] recipe, String[] ingredients){
		HashMap<String,Integer> ingMap = new HashMap<String,Integer>();
		int total = 0;
		boolean contains = false;
		String ing1 = ingredients[0];
		//read in ingredients as hashmap
		for (String ing:recipe) {
			String[] temp = ing.split(" ");
			String key = temp[1];
			if (key.equals(ing1)) contains = true;
			int val = Integer.parseInt(temp[0]);
			total += val;
			ingMap.put(key,val);
		}

		if (!contains) return 0.0;

		int val = 0;
		for (String ing:ingredients) {
			val += ingMap.get(ing);
		}
		return (double) val/total;
	}

	public static void main(String[] args){
		String[] r1 = {"1 A","1 B","1 C","5 D","4 E"};
		String[] ing1 = {"A","E"};

		System.out.println(getFraction(r1, ing1));
	}
}