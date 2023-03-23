package proj4;

import java.util.ArrayList;

public class CommunityCardSet
{
    private final int COMMUNITY_CARDS_SIZE = 5;
    private ArrayList<Card> communityCards;

    /**
     * Constructor for Community Card Set
     * @param cardsList Array list of community cards
     */
    public CommunityCardSet (ArrayList <Card> cardsList)
    {
        communityCards = cardsList;
    }

    /**
     * Adds a card to a Community Card Set
     * @param card: a card
     */
    public void addCard(Card card)
    {
        if (communityCards.size() < COMMUNITY_CARDS_SIZE)
        {
            communityCards.add(card);
        }
    }

    /**
     * Getter method to get x'th card
     * @param index: (x) - position of the card in the list
     * @return: returns the x'th card
     */
    public Card getIthCard(int index)
    {
        if (index <= COMMUNITY_CARDS_SIZE)
        {
            return communityCards.get(index);
        }
        else
        {
            return null;
        }
    }

    /**
     * Return printable string form of Community Card Set
     * @return: String form of Community Card Set
     */
    public String toString()
    {
        String communityCardsAsString = "";
        for (Card card : communityCards)
        {
            communityCardsAsString = communityCardsAsString + card + ", ";
        }
        return communityCardsAsString;
    }

}
