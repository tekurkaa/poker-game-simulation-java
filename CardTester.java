package proj4;

import static proj4.Testing.*;

public class CardTester
{
    public static void main(String[] args)
    {
        startTests();
        getRankTest1();
        getRankTest2();
        getRankTest3();
        getSuitTest1();
        getSuitTest2();
        getSuitTest3();
        finishTests();
    }

    private static void getRankTest1()
    {
        Card card = new Card("13", "Clubs");
        assertEquals("getRank Test", 13, card.getRank());
    }

    private static void getRankTest2()
    {
        Card card = new Card("King", "Clubs");
        assertEquals("getRank Test", 13, card.getRank());
    }

    private static void getRankTest3()
    {
        Card card = new Card(13, 0);
        assertEquals("getRank Test", 13, card.getRank());
    }

    private static void getSuitTest1()
    {
        Card card = new Card("7", "Hearts");
        assertEquals("getSuit Test", "Hearts", card.getSuit());
    }

    private static void getSuitTest2()
    {
        Card card = new Card("Seven", "Hearts");
        assertEquals("getSuit Test", "Hearts", card.getSuit());
    }

    private static void getSuitTest3()
    {
        Card card = new Card(7, 1);
        assertEquals("getSuit Test", "Hearts", card.getSuit());
    }
}
