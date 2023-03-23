package proj4;

import static proj4.Testing.*;

public class DeckTester
{
    public static void main (String[] args)
    {
        startTests();
        shuffleTest();
        dealTest();
        isEmptyTest();
        sizeTest();
        gatherTest();
        finishTests();
    }

    private static void shuffleTest()
    {
        Deck deck = new Deck();
        Deck deck2 = new Deck();
        deck2.shuffle();
        assertEquals("shuffleDeck Test 1", true, !deck.toString().equals(deck2.toString()));

        int clubsCounter = 0;
        int spadesCounter = 0;
        int heartsCounter = 0;
        int diamondsCounter = 0;

        for (Card card: deck2.deck) {
            String suit = card.getSuit();
            if (suit.equals("Clubs")) {
                clubsCounter += 1;
            }
            else if (suit.equals("Hearts")) {
                heartsCounter += 1;
            }
            else if (suit.equals("Spades")) {
                spadesCounter += 1;
            }
            else {
                diamondsCounter += 1;
            }
        }
        assertEquals("shuffleDeck Test 2", true, clubsCounter == 13 && heartsCounter == 13 && spadesCounter == 13
        && diamondsCounter == 13 && deck2.size() == 52);
    }

    private static void dealTest()
    {
        Deck deck = new Deck();
        assertEquals("deal Test", new Card(2, 0).toString(), deck.deal().toString());
    }

    private static void isEmptyTest()
    {
        Deck deck = new Deck();
        assertEquals("isEmpty Test1", false, deck.isEmpty());

        for (int i = 0; i < 52; i++) {
            deck.deal();
        }
        assertEquals("isEmpty Test2", true, deck.isEmpty());
    }

    private static void sizeTest()
    {
        Deck deck = new Deck();
        assertEquals("size Test 1", 52, deck.size());

        for (int i = 0; i < 2; i++) {
            deck.deal();
        }
        assertEquals("size Test 2", 50, deck.size());
    }

    private static void gatherTest()
    {
        Deck deck = new Deck();
        for (int i = 0; i < 2; i++) {
            deck.deal();
        }
        deck.gather();

        assertEquals("size Test 1", 52, deck.size());
    }
}
