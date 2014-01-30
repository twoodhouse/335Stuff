import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Lays out the available Suits of a set of Cards in a PokerHand
 * 
 * authors: Jacob Rochester and Rick Mercer
 * CSC335, Spring 2014
 */

//woohoo!!!

/**
 * Tests the PokerHand class and the enums
 * 
 * Rick includes all 52 cards to save you time (see end of file, after the @Test
 * methods)
 * 
 * There are also some additional test cases here. But this is in no way
 * complete. Many more are needed
 */
public class PokerHandTest {

	@Test
	public void testSuitEnum() {
		String result = "";
		for (Suit suit : Suit.values())
			result += suit + " ";
		assertEquals("Diamonds Clubs Hearts Spades", result.trim());
	}

	@Test
	public void testRankEnum() {
		String result = "";
		for (Rank rank : Rank.values())
			result += rank + " ";
		assertEquals(
				"Deuce Three Four Five Six Seven Eight Nine Ten Jack Queen King Ace",
				result.trim());
	}

	// Do not allow duplicate cards, throw an exception
	@Test(expected = DuplicateCardException.class)
	public void tryToAddTheSameCardTwiceA() {
		new PokerHand(C2, C3, C4, C5, C5);
	}

	@Test(expected = DuplicateCardException.class)
	public void testPair2() {
		PokerHand a = new PokerHand(H3, CA, D4, H6, DA);
		PokerHand b = new PokerHand(H3, C5, HA, SA, C6);
		assertTrue(a.compareTo(b) < 0);
	}

	@Test
	public void testTwoPairWhenOnePairIsEqual() {
		PokerHand a = new PokerHand(C4, HK, D4, H3, DK);
		PokerHand b = new PokerHand(H4, C10, CA, DA, S4);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testAceLowStraight() {
		PokerHand a = new PokerHand(CA, C2, C3, C4, H5);
		PokerHand b = new PokerHand(D2, D3, D4, D5, H6);
		boolean answer = a.compareTo(b) < 0;
		assertTrue(answer);
	}

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

	// TEST CARD HIGH HANDS

	private static PokerHand nothing72 = new PokerHand(C2, C3, C4, C5, D7);
	private static PokerHand nothing73 = new PokerHand(D2, D4, D5, D6, C7);
	private static PokerHand nothingJ = new PokerHand(C8, C9, C10, SJ, D3);
	private static PokerHand nothingK9 = new PokerHand(CK, CQ, CJ, D10, H9);
	private static PokerHand nothingK8 = new PokerHand(HK, HQ, HJ, H10, S8);
	private static PokerHand nothingA = new PokerHand(S9, SJ, SQ, SK, CA);

	@Test
	public void testNothing0() {
		assertTrue(nothing73.compareTo(nothing72) > 0);
	}

	@Test
	public void testNothing1() {
		assertTrue(nothingJ.compareTo(nothing73) > 0);
	}

	@Test
	public void testNothing2() {
		assertTrue(nothingK8.compareTo(nothingJ) > 0);
	}

	@Test
	public void testNothing3() {
		assertTrue(nothingK9.compareTo(nothingK8) > 0);
	}

	@Test
	public void testNothing4() {
		assertTrue(nothingA.compareTo(nothingK8) > 0);
		// Jake added tests
		assertFalse(nothingA.isStraightFlush());
		assertFalse(nothingA.isFourOfAKind());
		assertFalse(nothingA.isFullHouse());
		assertFalse(nothingA.isFlush());
		assertFalse(nothingA.isLowStraight());
		assertFalse(nothingA.isStraight());
		assertFalse(nothingA.isThreeOfAKind());
		assertFalse(nothingA.isTwoPair());
		assertFalse(nothingA.isPair());
	}

	// Many more tests needed

	@Test
	public void testIsStraightFlush() {
		PokerHand hand = new PokerHand(SJ, S10, SQ, SK, SA);
		assertTrue(hand.isStraightFlush());

		PokerHand nothing = new PokerHand(C2, C3, C4, C5, D7);
		assertTrue(hand.compareTo(nothing) > 0);
	}

	@Test
	public void testIsStraight() {
		PokerHand hand = new PokerHand(HJ, S10, SQ, SK, SA);
		assertTrue(hand.isStraight());

		PokerHand nothing = new PokerHand(C2, C3, C4, C5, D7);
		assertTrue(hand.compareTo(nothing) > 0);
	}

	@Test
	public void testIsLowStraight() {
		PokerHand hand = new PokerHand(HA, S3, S2, S4, S5);
		assertTrue(hand.isStraight());

		PokerHand nothing = new PokerHand(C2, C3, C4, C5, D7);
		assertTrue(hand.compareTo(nothing) > 0);
	}

	@Test
	public void testIsFourOfAKind() {
		PokerHand hand = new PokerHand(CA, SA, HA, DA, S5);
		assertTrue(hand.isFourOfAKind());

		PokerHand nothing = new PokerHand(C2, C3, C4, C5, D7);
		assertTrue(hand.compareTo(nothing) > 0);
	}

	@Test
	public void testIsFullHouse() {
		PokerHand hand = new PokerHand(CA, SA, HA, D5, S5);
		assertTrue(hand.isFullHouse());

		PokerHand nothing = new PokerHand(C2, C3, C4, C5, D7);
		assertTrue(hand.compareTo(nothing) > 0);
	}

	@Test
	public void testIsFlush() {
		PokerHand hand1 = new PokerHand(C2, C10, C6, C8, CA);
		assertTrue(hand1.isFlush());

		PokerHand hand2 = new PokerHand(DA, D2, D5, D4, D3);
		assertTrue(hand2.isFlush());

		PokerHand hand3 = new PokerHand(S10, SQ, SA, SK, SJ);
		assertTrue(hand3.isFlush());

		PokerHand hand4 = new PokerHand(HK, HA, H2, H4, H8);
		assertTrue(hand4.isFlush());

		PokerHand nothing = new PokerHand(S2, C3, C4, C5, D7);
		assertTrue(hand1.compareTo(nothing) > 0);
		assertTrue(hand2.compareTo(nothing) > 0);
		assertTrue(hand3.compareTo(nothing) > 0);
		assertTrue(hand4.compareTo(nothing) > 0);
	}

	@Test
	public void testIsThreeOfAKind() {
		PokerHand hand = new PokerHand(C2, C4, H4, D4, S6);
		assertTrue(hand.isThreeOfAKind());

		PokerHand nothing = new PokerHand(S2, C3, S4, C5, D7);
		assertTrue(hand.compareTo(nothing) > 0);
	}

	@Test
	public void testIsTwoPair() {
		PokerHand hand = new PokerHand(C2, C4, C6, H4, S6);
		assertTrue(hand.isTwoPair());

		PokerHand nothing = new PokerHand(S2, C3, S4, C5, D7);
		assertTrue(hand.compareTo(nothing) > 0);
	}

	@Test
	public void testIsPair() {
		PokerHand hand = new PokerHand(C2, C4, C6, H6, CA);
		assertTrue(hand.isPair());

		PokerHand nothing = new PokerHand(S2, C3, S4, C5, D7);
		assertTrue(hand.compareTo(nothing) > 0);
	}

	@Test
	public void testConstructor() {
		PokerHand hand = new PokerHand(CA, S3, D10, HQ, HK);
		assertEquals("S3 D10 HQ HK CA", hand.toString());
	}

	@Test
	public void testGetRank() {
		assertEquals(2, C2.getRank());
		assertEquals(3, D3.getRank());
		assertEquals(4, S4.getRank());
		assertEquals(5, H5.getRank());
		assertEquals(6, C6.getRank());
		assertEquals(7, C7.getRank());
		assertEquals(8, C8.getRank());
		assertEquals(9, C9.getRank());
		assertEquals(10, C10.getRank());
		assertEquals(11, DJ.getRank());
		assertEquals(12, SQ.getRank());
		assertEquals(13, HK.getRank());
		assertEquals(14, CA.getRank());
	}

	@Test
	public void testGetSuit() {
		assertEquals("Diamonds", DQ.getSuit());
		assertEquals("Clubs", C2.getSuit());
		assertEquals("Hearts", H5.getSuit());
		assertEquals("Spades", SA.getSuit());
	}

	@Test(expected = DuplicateCardException.class)
	public void testDupeCardsInConstructor1() {
		PokerHand hand = new PokerHand(HA, HA, HA, HA, HA);
	}

	@Test(expected = DuplicateCardException.class)
	public void testDupeCardsInConstructor2() {
		PokerHand hand = new PokerHand(H3, HA, HA, HA, HA);
	}

	@Test(expected = DuplicateCardException.class)
	public void testDupeCardsInConstructor3() {
		PokerHand hand = new PokerHand(SA, CK, HA, HA, HA);
	}

	@Test(expected = DuplicateCardException.class)
	public void testDupeCardsInConstructor4() {
		PokerHand hand = new PokerHand(H10, H4, C4, HA, HA);
	}
}