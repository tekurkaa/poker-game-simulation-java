package proj4;

import java.util.ArrayList;
import java.util.Arrays;

import static proj4.Testing.*;

public class StudPokerHandTest
{
    public static void main (String[] args)
    {
        startTests();
        addCardTest();
        getIthCardTest();
        compareToTest();
        finishTests();
    }

    private static void addCardTest()
    {
        ArrayList<Card> studHand = new ArrayList<>();
        CommunityCardSet cc = new CommunityCardSet(new ArrayList<>(Arrays.asList(new Card(3,0), new Card(13,2),
                new Card(10,1), new Card(5,2), new Card(6,0))));
        StudPokerHand studPokHand = new StudPokerHand(cc,studHand);
        Card card = new Card("King", "Diamond");
        studPokHand.addCard(card);
        assertEquals("addCard Test", true, studHand.size() == 1);
    }

    private static void getIthCardTest()
    {
        ArrayList<Card> holeCards = new ArrayList<>(Arrays.asList(new Card(5,1), new Card(14, 0)));
        ArrayList<Card> commCards = new ArrayList<>(Arrays.asList(new Card(3,0), new Card(13,2),
                new Card(10,1), new Card(5,2), new Card(6,0)));
        CommunityCardSet cc = new CommunityCardSet(commCards);
        StudPokerHand studHand = new StudPokerHand(cc,holeCards);
        assertEquals("getIthCard Test", holeCards.get(1), studHand.getIthCard(1));
    }

    private static void compareToTest()
    {
        CommunityCardSet commCards = new CommunityCardSet(new ArrayList<>(Arrays.asList(new Card(7,0),
                new Card(14,2), new Card(8,1), new Card(13,1), new Card(14,1))));
        ArrayList<Card> holeCards1 = new ArrayList<>(Arrays.asList(new Card(4,1), new Card(12,1)));
        ArrayList<Card> holeCards2 = new ArrayList<>(Arrays.asList(new Card(11,1), new Card(10,1)));
        StudPokerHand studHand1 = new StudPokerHand(commCards, holeCards1);
        StudPokerHand studHand2 = new StudPokerHand(commCards, holeCards2);
        assertEquals("CompareTo Test 1", 1, studHand1.compareTo(studHand2));
        assertEquals("CompareTo Test 2", -1, studHand2.compareTo(studHand1));
    }
}
