import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* Stores a list of Cards
 * 
 * Trevor Woodhouse, Jacob Rochester
 * Arizona HoldEm
 * CSC335, Spring 2014
 */

public class Deck {
	
	private List<Card> theDeck = new LinkedList<Card>();
	
	public Deck() {
		for(Rank rank : Rank.values()) {
			for(Suit suit : Suit.values()) {
				Card card = new Card(rank, suit);
				theDeck.add(card);
			}
		}
		this.shuffle();
	}
	
	public int size() {
		return theDeck.size();
	}
	
	public void shuffle() {
		Collections.shuffle(theDeck);

	}

	public Card drawCard() {
		return theDeck.remove(0);
	}
}