import java.io.*;
import java.util.HashMap;

class readFile{
	public static int readFile(){
		int cnt = 0;
		try {
			String file = "test.txt";
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;

			while ((line = br.readLine()) != null) {
				String[] words = line.split("\\s");
				cnt += words.length;
			}
			br.close();
			return cnt;
		}
		catch (FileNotFoundException ex){
			System.out.println(ex.getMessage());
		}
		catch (IOException ex){
			System.out.println(ex.getMessage());
		}
		return cnt;
	}				

	public static void main(String[] args) {
		int c = readFile();
		System.out.println(c);
	}
}

class Zoo{
	public enum Family{
		MAMMAL, REPTILE, BIRD, FISH, BUG;
	}

	public abstract class Animal{
		public Family family;
		public double length_cm;
		public double weight_kg;

		public abstract void makeNoise();
	}

	public class Lion extends Animal {
		Family family;

		public void makeNoise() {
			System.out.println("roar");
		}

		public Lion(Family fam, double length, double weight) {
			this.family = fam;
			this.length_cm = length;
			this.weight_kg = weight;
		}
	}
}

