import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * Trevor Woodhouse, Jacob Rochester
 * Arizona HoldEm
 * CSC335, Spring 2014
 */

public class TestGame {
	
	private int numPlayers = 5;
	private ArizonaHoldEm game = new ArizonaHoldEm(numPlayers);
	
	// Set up 52 cards so we can use C2 instead of new Card(Rank.Deuce,
	// Suit.Clubs)
	private final static Card C2 = new Card(Rank.Deuce, Suit.Clubs);
	private final static Card C3 = new Card(Rank.Three, Suit.Clubs);
	private final static Card C4 = new Card(Rank.Four, Suit.Clubs);
	private final static Card C5 = new Card(Rank.Five, Suit.Clubs);
	private final static Card C6 = new Card(Rank.Six, Suit.Clubs);
	private final static Card C7 = new Card(Rank.Seven, Suit.Clubs);
	private final static Card C8 = new Card(Rank.Eight, Suit.Clubs);
	private final static Card C9 = new Card(Rank.Nine, Suit.Clubs);
	private final static Card C10 = new Card(Rank.Ten, Suit.Clubs);
	private final static Card CJ = new Card(Rank.Jack, Suit.Clubs);
	private final static Card CQ = new Card(Rank.Queen, Suit.Clubs);
	private final static Card CK = new Card(Rank.King, Suit.Clubs);
	private final static Card CA = new Card(Rank.Ace, Suit.Clubs);

	private final static Card D2 = new Card(Rank.Deuce, Suit.Diamonds);
	private final static Card D3 = new Card(Rank.Three, Suit.Diamonds);
	private final static Card D4 = new Card(Rank.Four, Suit.Diamonds);
	private final static Card D5 = new Card(Rank.Five, Suit.Diamonds);
	private final static Card D6 = new Card(Rank.Six, Suit.Diamonds);
	private final static Card D7 = new Card(Rank.Seven, Suit.Diamonds);
	private final static Card D8 = new Card(Rank.Eight, Suit.Diamonds);
	private final static Card D9 = new Card(Rank.Nine, Suit.Diamonds);
	private final static Card D10 = new Card(Rank.Ten, Suit.Diamonds);
	private final static Card DJ = new Card(Rank.Jack, Suit.Diamonds);
	private final static Card DQ = new Card(Rank.Queen, Suit.Diamonds);
	private final static Card DK = new Card(Rank.King, Suit.Diamonds);
	private final static Card DA = new Card(Rank.Ace, Suit.Diamonds);

	private final static Card H2 = new Card(Rank.Deuce, Suit.Hearts);
	private final static Card H3 = new Card(Rank.Three, Suit.Hearts);
	private final static Card H4 = new Card(Rank.Four, Suit.Hearts);
	private final static Card H5 = new Card(Rank.Five, Suit.Hearts);
	private final static Card H6 = new Card(Rank.Six, Suit.Hearts);
	private final static Card H7 = new Card(Rank.Seven, Suit.Hearts);
	private final static Card H8 = new Card(Rank.Eight, Suit.Hearts);
	private final static Card H9 = new Card(Rank.Nine, Suit.Hearts);
	private final static Card H10 = new Card(Rank.Ten, Suit.Hearts);
	private final static Card HJ = new Card(Rank.Jack, Suit.Hearts);
	private final static Card HQ = new Card(Rank.Queen, Suit.Hearts);
	private final static Card HK = new Card(Rank.King, Suit.Hearts);
	private final static Card HA = new Card(Rank.Ace, Suit.Hearts);

	private final static Card S2 = new Card(Rank.Deuce, Suit.Spades);
	private final static Card S3 = new Card(Rank.Three, Suit.Spades);
	private final static Card S4 = new Card(Rank.Four, Suit.Spades);
	private final static Card S5 = new Card(Rank.Five, Suit.Spades);
	private final static Card S6 = new Card(Rank.Six, Suit.Spades);
	private final static Card S7 = new Card(Rank.Seven, Suit.Spades);
	private final static Card S8 = new Card(Rank.Eight, Suit.Spades);
	private final static Card S9 = new Card(Rank.Nine, Suit.Spades);
	private final static Card S10 = new Card(Rank.Ten, Suit.Spades);
	private final static Card SJ = new Card(Rank.Jack, Suit.Spades);
	private final static Card SQ = new Card(Rank.Queen, Suit.Spades);
	private final static Card SK = new Card(Rank.King, Suit.Spades);
	private final static Card SA = new Card(Rank.Ace, Suit.Spades);
	
	@Test
	public void testPokerHandPair() {
		ArrayList<Card> tableDeck = new ArrayList<Card>();
		tableDeck.add(S2);
		tableDeck.add(S10);
		tableDeck.add(H9);
		tableDeck.add(CJ);
		tableDeck.add(D4);
		ArrayList<Card> playerDeck = new ArrayList<Card>();
		playerDeck.add(C4);
		playerDeck.add(CK);
		PokerHand hand = new PokerHand(tableDeck, playerDeck);
		assertTrue(hand.isPair());
	}
	
	@Test
	public void testPokerHandIsFlush() {
		ArrayList<Card> tableDeck = new ArrayList<Card>();
		tableDeck.add(S2);
		tableDeck.add(S10);
		tableDeck.add(S9);
		tableDeck.add(SJ);
		tableDeck.add(D4);
		ArrayList<Card> playerDeck = new ArrayList<Card>();
		playerDeck.add(S4);
		playerDeck.add(CK);
		PokerHand hand = new PokerHand(tableDeck, playerDeck);
		assertTrue(hand.isPair());
		System.out.println(hand.toString());
		assertTrue(hand.isFlush());
	}
	
	@Test
	public void testDeck() {
		Deck deck = new Deck();
		assertTrue(deck.size() == 52);
	}
	
	@Test
	public void testTakeAnte() {
		Player aPlayer = new Player("Steve", 100);
		assertTrue(aPlayer.getBalance() == 100);
		game.takeAnte(2);
		assertTrue(aPlayer.getBalance() == 98);
	}
}
