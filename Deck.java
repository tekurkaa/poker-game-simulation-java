package proj4;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Deck
{
    private final int DEFAULT_DECK_SIZE = 52;
    private final int NUMBER_OF_SUITS = 4;
    private final int NUMBER_OF_RANKS = 13;
    private final int FIRST_CARD_INDEX = 2;
    private final int LAST_CARD_INDEX = 14;

    public ArrayList<Card> deck;
    private int nextToDeal;

    /**
     * Constructor for Deck
     */
    public Deck()
    {
        deck = new ArrayList<>(DEFAULT_DECK_SIZE);
        nextToDeal = 0;
        createDeck();
    }

    /**
     * Helper method to create a deck
     */
    private void createDeck()
    {
        ArrayList<String> suits = new ArrayList<>(NUMBER_OF_SUITS);
        suits.add("Spades");
        suits.add("Hearts");
        suits.add("Diamonds");
        suits.add("Clubs");

        ArrayList<Integer> ranks = new ArrayList<>(NUMBER_OF_RANKS);
        for (int i = FIRST_CARD_INDEX; i <= LAST_CARD_INDEX; i++)
        {
            ranks.add(i);
        }

        for (int i = 0; i <= 3; i++)
        {
            for (int j : ranks)
            {
                Card card = new Card(j, i);
                deck.add(card);
            }
        }
    }

    /**
     * Shuffles the deck of cards
     */
    public void shuffle()
    {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        for (int i = 0; i < deck.size(); i++)
        {
            int randomIndex = rand.nextInt(deck.size());
            Card card = deck.get(i);
            deck.set(i, deck.get(randomIndex));
            deck.set(randomIndex, card);
        }
    }

    /**
     * Deals the top card from the deck
     * @return: The top card from the deck
     */
    public Card deal()
    {
        if (isEmpty())
        {
            return null;
        }
        else
        {
            Card card = deck.get(nextToDeal);
            nextToDeal++;
            return card;
        }
    }

    /**
     * Checks if the deck is empty
     * @return: True/False
     */
    public boolean isEmpty()
    {
        if (size() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Gives the size of the deck
     * @return: Deck length (size)
     */
    public int size()
    {
        return deck.size() - nextToDeal;
    }

    /**
     * "gathers" the dealt cards
     */
    public void gather()
    {
        nextToDeal = 0;
    }

    /**
     * Return printable string form of Deck
     * @return: String form of Deck
     */
    public String toString()
    {
        String deckAsString = "";
        for (Card card : deck)
        {
            deckAsString = deckAsString + card + ", ";
        }
        return deckAsString;
    }
}
