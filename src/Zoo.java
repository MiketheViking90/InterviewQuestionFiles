import java.util.ArrayList;

abstract class Animal{
	abstract void noise();
}

class Lion extends Animal{
	public void noise() {
		System.out.println("rooar!");
	}

	void death() {
		System.out.println("LUKE I AM YOUR FATHERRR!");
	}
}

class Penguin extends Animal{
	public void noise() {
		System.out.println("squeeee!");
	}
}

class Monkey extends Animal{
	public void noise() {
		System.out.println("ou ou ou!");
	}

	public void throwPoop() {
		System.out.println("splat!");
	}
}

abstract class Employee{}

class CareTaker extends Employee{}

class Manager extends Employee{}

class Cage{
	Animal animal;

	void Cage(Animal inCage) {
		animal = inCage;
	}
}

class Zoo {
	private final double PRICE_OF_ADMISSION = 5.00;

	double totalIncome;
	double dailyIncome;
	int visitorCount;
	ArrayList<Animal> animals;
	ArrayList<Employee> employees;
	Cage[] cages;

	public Zoo(int nCages) {	
		cages = new Cage[nCages];
	}

	public void visitorArrives() {
		visitorCount++;
		dailyIncome += PRICE_OF_ADMISSION;

		System.out.println("Visitor " + visitorCount + " has arrived.");
		System.out.println("Daily income: " + dailyIncome);
		System.out.println();
	}

	public void visitorDeparts() {
		System.out.println("Visitor " + visitorCount + " has departed.");
		visitorCount--;
	}

	public void zooCloses() {
		totalIncome += dailyIncome;
		String formatIncome = String.format("%.2f", dailyIncome);
		System.out.println("Today the zoo generated $" + formatIncome + ".");
		System.out.println("See you tomorrow.");

		dailyIncome = 0;
		visitorCount = 0;
	}

	public void swapAnimal(Animal a1, Animal a2){
		return;
	}

	public void zooOpens() {
		for (Animal a : animals) {
			a.noise();
		}
	}
}

class ZooTest{
	public static void main(String[] args) {
		Zoo zoo = new Zoo(25);

		/* add animals */
		Lion lion1 = new Lion();
		

		/* visitors come and go */
		zoo.zooOpens();
		zoo.visitorArrives();
		zoo.visitorDeparts();
		zoo.visitorArrives();
		zoo.visitorArrives();

		zoo.zooCloses();
	}
}