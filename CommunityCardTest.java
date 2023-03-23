package proj4;

import java.util.ArrayList;
import java.util.Arrays;

import static proj4.Testing.*;

public class CommunityCardTest
{
    public static void main (String[] args)
    {
        startTests();
        addCardTest();
        getIthCardTest();
        finishTests();
    }

    private static void addCardTest()
    {
        ArrayList<Card> commCards = new ArrayList<>();
        CommunityCardSet cc = new CommunityCardSet(commCards);
        Card card = new Card("King", "Diamond");
        cc.addCard(card);
        assertEquals("addCard Test", true, commCards.size() == 1);
    }

    private static void getIthCardTest()
    {
        ArrayList<Card> commCards = new ArrayList<>(Arrays.asList(new Card(3,0), new Card(13,2),
                new Card(10,1), new Card(5,2), new Card(6,0)));
        CommunityCardSet cc = new CommunityCardSet(commCards);
        assertEquals("getIthCard Test", commCards.get(2), cc.getIthCard(2));
    }
}
