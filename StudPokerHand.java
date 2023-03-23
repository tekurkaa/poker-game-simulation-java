package proj4;

import java.util.ArrayList;

public class StudPokerHand
{
    private final int TWO_CARD_HAND_SIZE = 2;
    private final int STUD_POKER_HAND_SIZE = 7;
    private final int COMMUNITY_CARDS_SIZE = 5;
    CommunityCardSet communityCards;
    ArrayList<Card> twoCardHand;

    /**
     * Construction for Stud Poker Hands
     * @param cc community cards
     * @param cardList Hole Cards
     */
    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList)
    {
        communityCards = cc;
        twoCardHand = cardList;
    }

    /**
     * Adds a card to a Two Card Hand
     * @param card: a card
     */
    public void addCard(Card card)
    {
        if (twoCardHand.size() < TWO_CARD_HAND_SIZE)
        {
            twoCardHand.add(card);
        }
    }

    /**
     * Getter method to get x'th card
     * @param index: (x) - position of the card in the list
     * @return: returns the x'th card
     */
    public Card getIthCard(int index)
    {
        if (index <= TWO_CARD_HAND_SIZE)
        {
            return twoCardHand.get(index);
        }
        else
        {
            return null;
        }
    }

    /**
     * Determines how this hand compares to another hand, using the
     * community card set to determine the best 5-card hand it can
     * make. Returns positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(StudPokerHand other)
    {
        PokerHand fiveCardHand1 = getBestFiveCardHand();
        PokerHand fiveCardHand2 = other.getBestFiveCardHand();
        return fiveCardHand1.compareTo(fiveCardHand2);
    }

    /**
     * Get the best possible five card hand out of the list of all possible five card hands
     * @return best five card hand
     */
    private PokerHand getBestFiveCardHand()
    {
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(0);
        for (int i = 1; i < hands.size(); i++)
        {
            if (hands.get(i).compareTo(bestSoFar) > 0)
            {
                bestSoFar = hands.get(i);
            }
        }
        return bestSoFar;
    }

    /**
     * Get the list of all possible 5 card hands out of the community cards and the hole cards
     * @return list of all possible 5 card hands
     */
    private ArrayList<PokerHand> getAllFiveCardHands()
    {
        ArrayList<PokerHand> allFiveCardHands = new ArrayList<>();
        ArrayList<Card> commCards = new ArrayList<>();
        for (int i = 0; i < COMMUNITY_CARDS_SIZE; i++) {
            commCards.add(communityCards.getIthCard(i));
        }
        for (int i = 0; i < STUD_POKER_HAND_SIZE - 1; i++)
        {
            for (int j = i+1; j < STUD_POKER_HAND_SIZE; j++)
            {
                ArrayList<Card> cardList = new ArrayList<>();
                cardList.addAll(commCards);
                cardList.addAll(twoCardHand);
                cardList.remove(j);
                cardList.remove(i);
                PokerHand hand = new PokerHand(cardList);
                allFiveCardHands.add(hand);
            }
        }
        return allFiveCardHands;
    }

    /**
     * Return printable string form of Stud Poker Hand
     * @return: String form of Stud Poker Hand
     */
    public String toString()
    {
        String studPokerHandAsString = "";
        for (Card card : twoCardHand)
        {
            studPokerHandAsString = studPokerHandAsString + card + ", ";
        }
        return studPokerHandAsString;
    }
}
