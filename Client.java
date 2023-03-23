package proj4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple game of Poker
 */
public class Client
{
    static final int POKER_HAND_SIZE = 5;
    static final int TWO_CARD_HAND_SIZE = 2;

    public static void main (String[] args)
    {
        boolean game = true;
        int playerPoints = 0;
        Deck deck = new Deck();
        deck.shuffle();
        ArrayList<Card> communityCards = new ArrayList<>();
        CommunityCardSet communityCardSet = new CommunityCardSet(communityCards);
        for (int i = 0; i < POKER_HAND_SIZE; i++) {
            Card card = deck.deal();
            communityCardSet.addCard(card);
        }
        while (game && deck.size() >= TWO_CARD_HAND_SIZE * 2) {
            ArrayList<Card> holeCards1 = new ArrayList<>();
            ArrayList<Card> holeCards2 = new ArrayList<>();
            for (int i = 0; i < TWO_CARD_HAND_SIZE; i++)
            {
                holeCards1.add(deck.deal());
                holeCards2.add(deck.deal());
            }
            StudPokerHand hand1 = new StudPokerHand(communityCardSet, holeCards1);
            StudPokerHand hand2 = new StudPokerHand(communityCardSet, holeCards2);

            System.out.println("Community Cards: " + communityCards);
            System.out.println("Stud Hand 1: " + hand1);
            System.out.println("Stud Hand 2: " + hand2);

            Scanner myObj = new Scanner(System.in);
            System.out.println("Who is the winner? (1 if Hand 1 / -1 if Hand 2 / 0 if tie):");
            int playerChoice = myObj.nextInt();

            int actualWinner = hand1.compareTo(hand2);

            if (playerChoice == actualWinner)
            {
                playerPoints += 1;
            }
            else
            {
                game = false;
            }
        }
        System.out.println("Game Over");
        System.out.println("Player points = " + playerPoints);
    }
}
