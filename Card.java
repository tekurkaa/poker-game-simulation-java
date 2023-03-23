package proj4;

public class Card
{
    public final static String[] SUITS = {"Spades","Hearts","Clubs","Diamonds"};

    private int rank;
    private String suit;
    private enum ranks
    {
        two, three, four, five, six, seven, eight, nine, ten, jack, queen, king, ace
    }

    /**
     * constructor
     * @param rank String: whole cards (2-10) can either be spelled
     * out like "two" or numeric like "2". Case-insensitive.
     * @param suit String: "Spades", "Hearts", "Clubs", or "Diamonds"
     */
    public Card(String rank, String suit)
    {
        try
        {
            this.rank = Integer.parseInt(rank);
        }
        catch (NumberFormatException e)
        {
            this.rank = ranks.valueOf(rank.toLowerCase()).ordinal() + 2;    // '2' to avoid the fist 2 indices
        }
        this.suit = suit;
    }

    /**
     * constructor
     * @param rank integer between 2-14
     * @param suit integer: 0=Spades, 1=Hearts, 2=Clubs, or 3=Diamonds
     */
    public Card(int rank, int suit)
    {
        this.rank = rank;
        this.suit = SUITS[suit];
    }

    /**
     * Getter method for a rank of a card
     * @return: rank
     */
    public int getRank()
    {
        return rank;
    }

    /**
     * Getter method for a suit of a card
     * @return: suit
     */
    public String getSuit()
    {
        return suit;
    }

    /**
     * Return printable string form of Card
     * @return: String form of Card
     */
    public String toString()
    {
        String rankAsString;
        if (rank == 11)
        {
            rankAsString = "Jack";
        }
        else if (rank == 12)
        {
            rankAsString = "Queen";
        }
        else if (rank == 13)
        {
            rankAsString = "King";
        }
        else if (rank == 14)
        {
            rankAsString = "Ace";
        }
        else
        {
            rankAsString = Integer.toString(rank);
        }
        return rankAsString + " of " + suit;
    }
}