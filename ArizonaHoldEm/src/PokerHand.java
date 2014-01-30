import java.util.ArrayList;

/*
 * Trevor Woodhouse, Jacob Rochester
 * Arizona HoldEm
 * CSC335, Spring 2014
 */

public class PokerHand implements Comparable<PokerHand> {
	
	
	ArrayList<Card> hand = new ArrayList<Card>(7);

	int[] tallyRanks = new int[13];
	int[] tallySuits = new int[4];
	
	//Constructor for ArizonaHoldEm (7 Cards)
	public PokerHand(ArrayList<Card> tableCards, ArrayList<Card> playerCards) {
		for(Card card : tableCards) {
			hand.add(card);
		}
		for(Card card : playerCards) {
			hand.add(card);
		}
		
		orderCards();
		
		//tally ranks
		for(Card card : hand) {
			tallyRanks[card.getRankArrayIndex()]++;
		}
		//tally suits
		for(Card card : hand) {
			tallySuits[card.getSuitIndex()]++;
		}
	}
	
	//Constructor for normal poker (5 Cards)
	public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		hand.add(c1);

		if (!hand.contains(c2))
			hand.add(c2);
		else
			throw new DuplicateCardException();

		if (!hand.contains(c3))
			hand.add(c3);
		else
			throw new DuplicateCardException();

		if (!hand.contains(c4))
			hand.add(c4);
		else
			throw new DuplicateCardException();

		if (!hand.contains(c5))
			hand.add(c5);
		else
			throw new DuplicateCardException();

		orderCards();

		tallyRanks[c1.getRankArrayIndex()]++;
		tallyRanks[c2.getRankArrayIndex()]++;
		tallyRanks[c3.getRankArrayIndex()]++;
		tallyRanks[c4.getRankArrayIndex()]++;
		tallyRanks[c5.getRankArrayIndex()]++;

		for(Card card : hand) {
			tallySuits[card.getSuitIndex()]++;
		}
	}

	private void orderCards() {
		for (int i = 0; i < hand.size() - 1; i++) {
			for (int j = i; j < hand.size(); j++) {
				if (hand.get(i).getRank() > hand.get(j).getRank()) {
					hand.add(i, hand.remove(j));
					// adds at index i the card at index j, because j should be
					// before i. card previously at index i is now at index
					// (i+1)
				}
			}
		}
	}

	private int declareHand() {

		if (isStraightFlush())
			return 9;
		if (isFourOfAKind())
			return 8;
		if (isFullHouse())
			return 7;
		if (isFlush())
			return 6;
		if (isLowStraight())
			return 4;
		if (isStraight())
			return 5;
		if (isThreeOfAKind())
			return 3;
		if (isTwoPair())
			return 2;
		if (isPair())
			return 1;
		else
			return 0;
	}

	protected boolean isPair() {
		for (int i = 0; i < tallyRanks.length; i++) {
			if (tallyRanks[i] == 2)
				return true;
		}
		return false;
	}

	protected boolean isTwoPair() {
		int numPairs = 0;
		for (int i = 0; i < tallyRanks.length; i++) {
			if (tallyRanks[i] == 2)
				numPairs++;
		}
		return numPairs == 2;
	}

	protected boolean isThreeOfAKind() {
		for (int i = 0; i < tallyRanks.length; i++) {
			if (tallyRanks[i] == 3)
				return true;
		}
		return false;
	}

	protected boolean isStraight() {
		int cardRank0 = hand.get(0).getRank();
		// if it is a low straight or "wheel"
		if (isLowStraight())
			return true;
		else {
			for (int i = 1; i < hand.size(); i++) {
				if (hand.get(i).getRank() - cardRank0 != i)
					return false;
			}
			return true;
		}
	}

	protected boolean isLowStraight() {
		return (hand.get(4).getRank() == 14 
				&& hand.get(0).getRank() == 2
				&& hand.get(1).getRank() == 3 
				&& hand.get(2).getRank() == 4 
				&& hand.get(3).getRank() == 5);
	}
	
	protected boolean isFlush() {
		for(int rank : tallySuits) {
			if(rank >= 5)
				return true;
		}
		return false;
	}
	
	//old method
//	protected boolean isFlush() {
//		String suit0 = hand.get(0).getSuit();
//		for (Card card : hand) {
//			if (!card.getSuit().equals(suit0))
//				return false;
//		}
//		return true;
//	}

	protected boolean isFullHouse() {
		return isThreeOfAKind() && isPair();
	}

	protected boolean isFourOfAKind() {
		for (int i = 0; i < tallyRanks.length; i++) {
			if (tallyRanks[i] == 4)
				return true;
		}
		return false;
	}

	protected boolean isStraightFlush() {
		return isStraight() && isFlush();
	}

	@Override
	public int compareTo(PokerHand otherHand) {
		// Catch cheating
		for (Card card : hand) {
			for (Card otherCard : otherHand.hand) {
				if (card.equals(otherCard))
					throw new DuplicateCardException();
			}
		}

		// Compare hands
		int comp = this.declareHand() - otherHand.declareHand();
		return comp == 0 ? compareCards(otherHand, 4) : comp;
	}

	private int compareCards(PokerHand otherHand, int index) {
		int comp = this.hand.get(index).getRank() - otherHand.hand.get(index).getRank();
		return comp == 0 ? compareCards(otherHand, index - 1) : comp;
	}

	public String toString() {
		String str = "";
		for (Card card : hand) {
			str += card.toString() + " ";
		}
		return str.trim();
	}
}
