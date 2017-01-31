package cards;
import java.util.ArrayList;
import java.util.Collections;
/**this class represents a deck object. It shuffles and keeps the card objects. 
 * It is the responsibility of the user of these deck objects to never try to withdraw a card when there are 52 cards lent; and to always use the discard() method when done with the cards.  
 * This deck automatically shuffles itself when necessary
 * @author Matt Bell
 * @since Feb 24, 2014
 * @status this class works fine and has been tested under normal circumstances 
 */
public class Deck {
	private ArrayList<Card> possessedCards = new ArrayList<Card>();
	private ArrayList<Card> lentCards = new ArrayList<Card>();
	private long numberOfCardsDelt;
	
	/**
	 * creates a standard deck of 52 cards. shuffled.
	 */
	public Deck(){
		for(int i = 1;i<=52;i++){
			possessedCards.add(new Card(i));
		}
		numberOfCardsDelt = 1;
		Collections.shuffle(possessedCards);
	}
	/**
	 * Gives a card from the top of the deck.
	 * @return A card object
	 */
	public Card getCard(){
		if(numberOfCardsDelt % 52 == 0){
			Collections.shuffle(possessedCards);
		}
		Card temp = possessedCards.get(0);
		lentCards.add(temp);
		possessedCards.remove(0);
		numberOfCardsDelt++;
		return temp;
	}
	/**
	 * Takes a card that is no longer being used by the game. It is the resposibilty of the game designer to return cards when they are not being used.
	 * @param discard the card object that is being discarded
	 */
	public void discard(Card discard){
		assert lentCards.contains(discard);
		lentCards.remove(discard);
		possessedCards.add(possessedCards.size(), discard);
	}
	/**
	 * gives the number of cards in play. 52 - this number gives the number of cards in the deck.
	 * @return the number of cards in play.
	 */
	public int getNumberOfLentCards(){
		return lentCards.size();
	}
}
