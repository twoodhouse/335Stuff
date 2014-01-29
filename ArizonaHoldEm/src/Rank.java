/*
 * Trevor Woodhouse, Jacob Rochester
 * Arizona HoldEm
 * CSC335, Spring 2014
 */

public enum Rank {
	Deuce(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13), Ace(14);
	
	int value;
	
	Rank(int newValue) {
		value = newValue;
	}
	
	public int getRank() {
		return value;
	}
}
