package Design;

import java.util.ArrayList;

public class deckOfCards {

	private ArrayList<Cards> cards;

	deckOfCards() {

	}

	public deckOfCards(ArrayList<Cards> cards) {
		this.cards = cards;
	}

	public static void main(String args[]) {

		ArrayList<Cards> listCards = new ArrayList<Cards>();
		for (SUITE i : SUITE.values()) {
			for (int j = 1; j <= 13; j++) {
				listCards.add(new Cards(i, j));
			}
		}
		deckOfCards d = new deckOfCards(listCards);

		System.out.println(d.cards);
	}

}

class Cards {

	private SUITE suite;
	private int value;

	public Cards(SUITE suite, int value) {
		this.suite = suite;
		this.value = value;
	}

	public String toString() {
		return "\n" + value + " of " + suite;
	}

}

enum SUITE {

	JACK, SPADE, HEART, DIAMOND
}