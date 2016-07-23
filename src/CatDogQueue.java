import java.util.LinkedList;

class Pet{
	String type;
	String name;
	int order;

	public Pet(String t, String n, int o){
		type = t;
		name = n;
		order = o;
	}
}

class CatDogQueue{
	LinkedList<Pet> cats = new LinkedList<Pet>();
	LinkedList<Pet> dogs = new LinkedList<Pet>();
	int count = 0;

	void add(String type, String name) {
		Pet newPet = new Pet(type, name, count);

		if (type.equals("cat")) {
			cats.add(newPet);
			count++;
		} else if (type.equals("dog")) {
			dogs.add(newPet);
			count++;
		}
	}

	Pet adoptCat() {
		if (cats != null) {
			return cats.pop();
		} else {
			return null;
		}
	}

	Pet adoptDog() {
		if (dogs != null) {
			return dogs.pop();
		} else {
			return null;
		}
	}

	Pet adopt() {
		Pet lastCat = cats.getFirst();
		Pet lastDog = dogs.getFirst();

		if (lastDog.order < lastCat.order) {
			return dogs.pop();
		} else {
			return cats.pop();
		}
	}

	void printPets() {
		System.out.println("cats: ");
		for (Pet cat : cats) {
			System.out.println("\t" + cat.name + ", " + cat.order);
		}

		System.out.println("dogs: ");
		for (Pet dog : dogs) {
			System.out.println("\t" + dog.name + ", " + dog.order);
		}
	}
}

class petTest{
	public static void main(String[] args) {
		CatDogQueue pound = new CatDogQueue();

		pound.add("cat", "fluffy");
		pound.add("dog", "ralph");
		pound.add("cat", "oscar");
		//pound.adopt();
		pound.adoptCat();

		pound.printPets();
	}
}














