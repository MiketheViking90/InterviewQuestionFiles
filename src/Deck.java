import java.util.ArrayList;

enum Suites{
	HEARTS, DIAMONDS, SPADES, CLOVER
}

class Card{
	Suites suite;
	int val;

	public Card(Suites suite, int val) {
		this.suite = suite;
		this.val = val;
	}

	public String toString() {
		String outVal = String.valueOf(val);

		if (outVal.equals("1")) outVal = "Ace";
		if (outVal.equals("11")) outVal = "Jack";
		if (outVal.equals("12")) outVal = "Queen";
		if (outVal.equals("13")) outVal = "King";

		return outVal + " of " + suite;
	}
}

class Deck{
	private ArrayList<Card> deck;

	public Deck() {
		deck = new ArrayList<Card>();

		int cnt = 0;
		for (Suites suite : Suites.values()) {
			for (int i = 1; i <= 13; i++) {
				Card card = new Card(suite, i);
				deck.add(card);
			}
		}
	}

	public void shuffle() {
		for (int i = 0; i < deck.size(); i++) {
			int index = getRand(0,i);

			Card tmp = deck.get(i);
			deck.set(i, deck.get(index));
			deck.set(index, tmp);
		}
	}

	private int getRand(int low, int high) {
		int add = (int) (Math.random() * (high - low + 1));
		return low + add;
	}

	public void print() {
		for (int i = 0; i < 52; i++) {
			System.out.println(deck.get(i).toString());
		}
	}

	public Card draw() {
		Card draw = deck.get(0);
		deck.remove(0);
		return draw;
	}

	public int size() {
		return deck.size();
	}
}

class DeckTeprivate
	public static void main(String[] args) {
		Deck deck = new Deck();


		deck.draw();
		deck.draw();
		System.out.println(deck.size());
	}
}