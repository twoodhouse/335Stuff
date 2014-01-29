/*
 * Trevor Woodhouse, Jacob Rochester
 * Arizona HoldEm
 * CSC335, Spring 2014
 */

public enum Suit {
	Diamonds("Diamonds"), Clubs("Clubs"), Hearts("Hearts"), Spades("Spades");
	
	private String suit;
	private Suit(String str) {
		suit = str;
	}
	
	public String getSuit() {
		return suit;
	}
}
