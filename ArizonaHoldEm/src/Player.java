import java.util.ArrayList;
import java.util.List;

/*
 * Trevor Woodhouse, Jacob Rochester
 * Arizona HoldEm
 * CSC335, Spring 2014
 */

public class Player {
	
	private String name = "";
	private int balance;
	private List<Card> cards = new ArrayList<Card>();
	private Deck deck;
	
	public Player(String newName, int budget) {
		name = newName;
		cards.add(deck.drawCard());
	}
	
	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}
	
	public void changeBalance(int value) {
		balance += value;
	}

}
