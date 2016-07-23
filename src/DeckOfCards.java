enum Suite {H, D, S, C};

class Card {
	Suite suite;
	int val;

	public Card(Suite s, int v) {
		suite = s;
		v = val;
	}
}

class Deck {
	ArrayList<Card> deck;

	public Deck() {
		deck = new ArrayList<Card>();

		for (Suite s : Suite.values()) {
			
		}
	}
}