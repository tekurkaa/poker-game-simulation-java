package proj4;

import java.util.ArrayList;
import java.util.Arrays;

import static proj4.Testing.*;

public class PokerComparisonTests
{
    public static void main (String[] args)
    {
        startTests();
        flushVsTwoPair();
        flushVsPair();
        flushVsHighCard();
        twoPairVsPair();
        twoPairVsHighCard();
        pairVsHighCard();
        flushTie();
        twoPairTie();
        pairTie();
        highCardTie();
        tie();
        finishTests();
    }

    private static void flushVsTwoPair()
    {
        PokerHand hand1 = new PokerHand( new ArrayList<>(Arrays.asList(new Card(12, 0), new Card(11, 0),
                new Card(6, 0), new Card(13, 0), new Card(4, 0))));
        PokerHand hand2 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("12", "Diamonds"), new Card("11", "Hearts"),
                new Card("12", "Clubs"), new Card("11", "Diamonds"), new Card("4", "Hearts"))));
        assertEquals("Flush vs Two-Pair", 1, hand1.compareTo(hand2));
        assertEquals("Flush vs Two-Pair", -1, hand2.compareTo(hand1));
    }

    private static void flushVsPair()
    {
        PokerHand hand1 = new PokerHand(new ArrayList<>(Arrays.asList(new Card(12, 0), new Card(11, 0),
                new Card(6, 0), new Card(13, 0), new Card(4, 0))));
        PokerHand hand2 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("12", "Diamonds"), new Card("11", "Hearts"),
                new Card("12", "Clubs"), new Card("3", "Diamonds"), new Card("4", "Hearts"))));
        assertEquals("Flush vs Pair", 1, hand1.compareTo(hand2));
        assertEquals("Flush vs Pair", -1, hand2.compareTo(hand1));
    }

    private static void flushVsHighCard()
    {
        PokerHand hand1 = new PokerHand(new ArrayList<>(Arrays.asList(new Card(12, 0), new Card(11, 0),
                new Card(6, 0), new Card(13, 0), new Card(4, 0))));
        PokerHand hand2 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("2", "Diamonds"), new Card("11", "Hearts"),
                new Card("12", "Clubs"), new Card("3", "Diamonds"), new Card("4", "Hearts"))));
        assertEquals("Flush vs High Card", 1, hand1.compareTo(hand2));
        assertEquals("Flush vs High Card", -1, hand2.compareTo(hand1));
    }

    private static void twoPairVsPair()
    {
        PokerHand hand1 = new PokerHand(new ArrayList<>(Arrays.asList(new Card(12, 3), new Card(11, 0),
                new Card(6, 0), new Card(12, 0), new Card(6, 1))));
        PokerHand hand2 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("2", "Diamonds"), new Card("11", "Hearts"),
                new Card("12", "Clubs"), new Card("2", "Spades"), new Card("4", "Hearts"))));
        assertEquals("Two Pair vs Pair", 1, hand1.compareTo(hand2));
        assertEquals("Two Pair vs Pair", -1, hand2.compareTo(hand1));
    }

    private static void twoPairVsHighCard()
    {
        PokerHand hand1 = new PokerHand(new ArrayList<>(Arrays.asList(new Card(12, 3), new Card(11, 0),
                new Card(6, 0), new Card(12, 0), new Card(6, 1))));
        PokerHand hand2 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("2", "Diamonds"), new Card("11", "Hearts"),
                new Card("12", "Clubs"), new Card("3", "Diamonds"), new Card("4", "Hearts"))));
        assertEquals("Two Pair vs High Card", 1, hand1.compareTo(hand2));
        assertEquals("Two Pair vs High Card", -1, hand2.compareTo(hand1));
    }

    private static void pairVsHighCard()
    {
        PokerHand hand1 = new PokerHand(new ArrayList<>(Arrays.asList(new Card(12, 3), new Card(11, 0),
                new Card(5, 0), new Card(12, 0), new Card(6, 1))));
        PokerHand hand2 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("2", "Diamonds"), new Card("11", "Hearts"),
                new Card("12", "Clubs"), new Card("3", "Diamonds"), new Card("4", "Hearts"))));
        assertEquals("Pair vs High Card", 1, hand1.compareTo(hand2));
        assertEquals("Pair vs High Card", -1, hand2.compareTo(hand1));
    }

    private static void flushTie()
    {
        PokerHand hand1 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("12", "Spades"), new Card("11", "Spades"),
                new Card("6", "Spades"), new Card("13", "Spades"), new Card("4", "Spades"))));
        PokerHand hand2 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("12", "Diamonds"), new Card("3", "Diamonds"),
                new Card("14", "Diamonds"), new Card("11", "Diamonds"), new Card("4", "Diamonds"))));
        assertEquals("Flush vs Flush", -1, hand1.compareTo(hand2));
        assertEquals("Flush vs Flush", 1, hand2.compareTo(hand1));
    }

    private static void twoPairTie()
    {
        PokerHand hand1 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("12", "Diamonds"), new Card("11", "Spades"),
                new Card("6", "Spades"), new Card("12", "Spades"), new Card("6", "Hearts"))));
        PokerHand hand2 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("2", "Diamonds"), new Card("11", "Hearts"),
                new Card("13", "Clubs"), new Card("2", "Spades"), new Card("13", "Hearts"))));
        assertEquals("Two Pair vs Two Pair", -1, hand1.compareTo(hand2));
        assertEquals("Two Pair vs Two Pair", 1, hand2.compareTo(hand1));
    }

    private static void pairTie()
    {
        PokerHand hand1 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("12", "Diamonds"), new Card("11", "Spades"),
                new Card("6", "Spades"), new Card("5", "Spades"), new Card("6", "Hearts"))));
        PokerHand hand2 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("3", "Diamonds"), new Card("11", "Hearts"),
                new Card("13", "Clubs"), new Card("2", "Spades"), new Card("13", "Hearts"))));
        assertEquals("Pair vs Pair", -1, hand1.compareTo(hand2));
        assertEquals("Pair vs Pair", 1, hand2.compareTo(hand1));
    }

    private static void highCardTie()
    {
        PokerHand hand1 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("12", "Diamonds"), new Card("11", "Spades"),
                new Card("6", "Spades"), new Card("14", "Spades"), new Card("5", "Hearts"))));
        PokerHand hand2 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("2", "Diamonds"), new Card("14", "Hearts"),
                new Card("8", "Clubs"), new Card("3", "Spades"), new Card("13", "Hearts"))));
        assertEquals("High Card vs High Card", -1, hand1.compareTo(hand2));
        assertEquals("High Card vs High Card", 1, hand2.compareTo(hand1));
    }

    private static void tie()
    {
        PokerHand hand1 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("12", "Diamonds"), new Card("11", "Spades"),
                new Card("6", "Spades"), new Card("14", "Spades"), new Card("5", "Hearts"))));
        PokerHand hand2 = new PokerHand(new ArrayList<>(Arrays.asList(new Card("14", "Diamonds"), new Card("12", "Hearts"),
                new Card("6", "Clubs"), new Card("5", "Spades"), new Card("11", "Hearts"))));
        assertEquals("Tie", 0, hand1.compareTo(hand2));
        assertEquals("Tie", 0, hand2.compareTo(hand1));
    }
}

