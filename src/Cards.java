import java.util.*;

enum Suites {
	HEARTS, DIAMONDS, CLUBS, SPADES;
}

class Card{
	Suites suite;
	int val;

	Card(Suites suite1, int num1) {
		suite = suite1;
		val = num1;
	}

	public String toString() {
		return val + " of " + suite;
	}
}

class Deck{
	ArrayList<Card> deck;

	Deck() {
		deck = new ArrayList<Card>();

		for (Suites s : Suites.values()) {
			for (int i = 1; i <= 13; i++) {
				Card card = new Card(s, i);
				deck.add(card);
			}
		}
	}

	void shuffle() {
		int N = deck.size();

		for (int i = 0; i < N; i++) {
			int t = i + ((int) ((N - i ) *Math.random()));

			Card tempCard = deck.get(i);
			deck.set(i, deck.get(t));
			deck.set(t, tempCard);
		}
	}

}

class cardTest{
	public static void main(String[] args){
		Card draw = new Card(Suites.HEARTS, 5);
		Deck deck = new Deck();

		deck.shuffle();
		for (Card c : deck.deck) {
			System.out.println(c.toString());
		}
	}		
}
