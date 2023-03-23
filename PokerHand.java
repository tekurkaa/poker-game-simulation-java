package proj4;

import java.util.*;

public class PokerHand
{
    ArrayList<Card> hand;
    private final int POKER_HAND_SIZE = 5;
    private final int FLUSH = 4;
    private final int TWO_PAIR = 3;
    private final int PAIR = 2;
    private final int HIGH_CARD = 1;

    /**
     * Construction for Poker Hands
     * @param cardList: list of cards
     */
    public PokerHand(ArrayList<Card> cardList)
    {
        hand = (ArrayList<Card>) cardList.clone();
    }

    /**
     * Adds a card to a hand
     * @param card: a card
     */
    public void addCard(Card card)
    {
        if (hand.size() < POKER_HAND_SIZE)
        {
            hand.add(card);
        }
    }

    /**
     * Getter method to get x'th card
     * @param index: (x) - position of the card in the list
     * @return: returns the x'th card
     */
    public Card getIthCard(int index)
    {
        if (index <= POKER_HAND_SIZE)
        {
            return hand.get(index);
        }
        else
        {
            return null;
        }
    }

    /**
     * Sorts the ranks of cards in a hand
     * @return: Sorted values
     */
    private ArrayList<Integer> ranksSorting()
    {
        ArrayList<Integer> ranks = new ArrayList<>();
        for (Card card : hand)
        {
            ranks.add(card.getRank());
        }
        Collections.sort(ranks);
        return ranks;
    }

    /**
     * Checks if a hand is a flush
     * @return: True/False
     */
    public boolean flush()
    {
        for (int i = 0; i < POKER_HAND_SIZE - 1; i++)
        {
            if (hand.get(i + 1).getSuit() != hand.get(i).getSuit())
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a hand is a two pair
     * @return: True/False
     */
    public boolean twoPair()
    {
        ArrayList<Integer> sortedRanks = new ArrayList<>();
        Set<Integer> sortedRanksSet = new HashSet<>();
        sortedRanks = ranksSorting();
        sortedRanksSet.addAll(sortedRanks);
        int pairs = 0;
        for (int i : sortedRanksSet)
        {
            int counter = 0;
            for (int j : sortedRanks)
            {
                if (i == j)
                {
                    counter += 1;
                }
            }
            if (counter >= 2)
            {
                pairs = pairs + counter/2;
            }
        }
        if (pairs == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Checks if a hand is a pair
     * @return: True/False
     */
    public boolean pair()
    {
        ArrayList<Integer> sortedRanks = new ArrayList<>();
        Set<Integer> sortedRanksSet = new HashSet<>();
        sortedRanks = ranksSorting();
        sortedRanksSet.addAll(sortedRanks);
        int pairs = 0;
        for (int i : sortedRanksSet)
        {
            int counter = 0;
            for (int j : sortedRanks)
            {
                if (i == j)
                {
                    counter += 1;
                }
            }
            if (counter >= 2)
            {
                pairs = pairs + counter/2;
            }
        }
        if (pairs == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    ArrayList<Integer> hand1Ranks = new ArrayList<>();
    ArrayList<Integer> hand2Ranks = new ArrayList<>();

    /**
     * checks for underlying possibilities in case of a tie of flushes
     * @param hand2: Array list of cards from hand 1
     * @return: 1/-1/0
     */
    public int flushTie(ArrayList<Card> hand2)
    {
        for (Card card : hand)
        {
            hand1Ranks.add(card.getRank());
        }
        for (Card card : hand2)
        {
            hand2Ranks.add(card.getRank());
        }

        Collections.sort(hand1Ranks, Collections.reverseOrder());
        Collections.sort(hand2Ranks, Collections.reverseOrder());

        for (int i = 0; i < POKER_HAND_SIZE; i++)
        {
            if (hand1Ranks.get(i) > hand2Ranks.get(i))
            {
                return 1;
            }
            else if (hand1Ranks.get(i) < hand2Ranks.get(i))
            {
                return -1;
            }
        }
        return 0;
    }

    /**
     * checks for underlying possibilities in case of a tie of two pairs or pairs
     * @param hand2: Array list of cards from hand 1
     * @return: 1/-1/0
     */
    public int pairsTie(ArrayList<Card> hand2)
    {
        for (Card card : hand)
        {
            hand1Ranks.add(card.getRank());
        }
        for (Card card : hand2)
        {
            hand2Ranks.add(card.getRank());
        }

        Collections.sort(hand1Ranks, Collections.reverseOrder());
        Collections.sort(hand2Ranks, Collections.reverseOrder());

        for (int i = 0; i < POKER_HAND_SIZE - 1; i++)
        {
            if (hand1Ranks.get(i) == hand1Ranks.get(i+1))
            {
                if (hand1Ranks.get(i) > hand2Ranks.get(i))
                {
                    return 1;
                }
                else if (hand1Ranks.get(i) < hand2Ranks.get(i))
                {
                    return -1;
                }
            }
            else if (hand2Ranks.get(i) == hand2Ranks.get(i+1))
            {
                if (hand1Ranks.get(i) > hand2Ranks.get(i))
                {
                    return 1;
                }
                else if (hand1Ranks.get(i) < hand2Ranks.get(i))
                {
                    return -1;
                }
            }
        }
        for (int j = 0; j < POKER_HAND_SIZE; j++)
        {
            if (hand1Ranks.get(j) != hand2Ranks.get(j))
            {
                if (hand1Ranks.get(j) > hand2Ranks.get(j))
                {
                    return 1;
                }
                else if (hand1Ranks.get(j) < hand2Ranks.get(j))
                {
                    return -1;
                }
            }
        }
        return 0;
    }

    /**
     * checks for underlying possibilities in case of a tie of high cards
     * @param hand2: Array list of cards from hand 1
     * @return: 1/-1/0
     */
    public int highCardTie(ArrayList<Card> hand2)
    {
        for (Card card : hand)
        {
            hand1Ranks.add(card.getRank());
        }
        for (Card card : hand2)
        {
            hand2Ranks.add(card.getRank());
        }

        Collections.sort(hand1Ranks, Collections.reverseOrder());
        Collections.sort(hand2Ranks, Collections.reverseOrder());

        for (int i = 0; i < POKER_HAND_SIZE; i++)
        {
            if (hand1Ranks.get(i) > hand2Ranks.get(i))
            {
                return 1;
            }
            else if (hand1Ranks.get(i) < hand2Ranks.get(i))
            {
                return -1;
            }
        }
        return 0;
    }

    /**
     * Assigns a power to the type of hand
     * @return: Power of the hand type
     */
    private int check()
    {
        if (flush())
        {
            return FLUSH;
        }
        else if (twoPair())
        {
            return TWO_PAIR;
        }
        else if (pair())
        {
            return PAIR;
        }
        else
        {
            return HIGH_CARD;
        }
    }

    /**
     * Determines which of the two poker hands is worth more. Returns an int which is either positive,
     * negative, or zero depending on the comparison
     * @param other: Array list of cards from hand 2
     * @return: -1 if self is worth LESS than other_hand, 0 if they are
     * worth the SAME (a tie), and 1 if self is worth MORE than other_hand
     */
    public int compareTo(PokerHand other)
    {
        int hand1Type = check();
        int hand2Type = other.check();
        ArrayList<Card> otherHand = other.hand;
        if (hand1Type > hand2Type)
        {
            return 1;
        }
        else if (hand1Type < hand2Type)
        {
            return -1;
        }
        else
        {
            if (hand1Type == FLUSH)
            {
                return flushTie(otherHand);
            }
            else if (hand1Type == TWO_PAIR)
            {
                return pairsTie(otherHand);
            }
            else if (hand1Type == PAIR)
            {
                return pairsTie(otherHand);
            }
            else if (hand1Type == HIGH_CARD)
            {
                return highCardTie(otherHand);
            }
            return 0;
        }
    }

    /**
     * Return printable string form of Poker Hand
     * @return: String form of Poker Hand
     */
    public String toString()
    {
        String handAsString = "";
        for (Card card : hand)
        {
            handAsString = handAsString + card + ", ";
        }
        return handAsString;
    }
}
