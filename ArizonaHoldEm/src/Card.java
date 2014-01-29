/*
 * Trevor Woodhouse, Jacob Rochester
 * Arizona HoldEm
 * CSC335, Spring 2014
 */

public class Card implements Comparable<Card> {

	private Rank rank;
	private Suit suit;

	public Card(Rank newRank, Suit newSuit) {
		rank = newRank;
		suit = newSuit;
	}

	public int getSuitIndex() {
		if (suit == Suit.Diamonds)
			return 0;
		else if (suit == Suit.Clubs)
			return 1;
		else if (suit == Suit.Hearts)
			return 2;
		else
			// Spades
			return 3;
	}

	public String getSuit() {
		return suit.getSuit();
	}

	public int getRank() {
		return rank.getRank();
	}

	protected int getRankArrayIndex() {
		return rank.getRank() - 2;
	}

	public String toString() {

		String suitChar = "C"; // clubs
		if (suit == Suit.Diamonds)
			suitChar = "D";
		if (suit == Suit.Hearts)
			suitChar = "H";
		if (suit == Suit.Spades)
			suitChar = "S";

		String rankChar = Integer.toString(rank.getRank());
		if (rank.getRank() == 14)
			rankChar = "A";
		if (rank.getRank() == 13)
			rankChar = "K";
		if (rank.getRank() == 12)
			rankChar = "Q";
		if (rank.getRank() == 11)
			rankChar = "J";

		return suitChar + "" + rankChar;
	}

	@Override
	public int compareTo(Card otherCard) {
		return this.getRank() - otherCard.getRank();
	}
}