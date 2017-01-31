package blackJack;
import cards.*;
import java.util.*;
/** This class holds a hand for blackJack. This class takes and returns Card Objects
 * @author Matt Bell
 * @since mar 2, 2014
 * @status this class appears to work fine.
 */
public class Hand {
	private ArrayList<Card> hand = new ArrayList<Card>();
	/**
	 * Makes a hand object holding nothing
	 */
	public Hand(){
		
	}
	/**
	 * this method gives this object a Card object to hold
	 * @param c a card object to hold
	 */
	public void holdCard(Card c){
		hand.add(c);
	}
	/**
	 * this method returns the actual arrayList of Cards with the expectation that the user of this arraylist of cards discards then and has makes this array empty.
	 * @return The hand araylist
	 */
	public ArrayList<Card> discardHand(){
		return hand;
	}
	/**
	 * returns the value of the black jack hand. calculation for aces being one or 11.
	 * @return the value of the black jack hand
	 */
	public int valueOfHand(){
		boolean handContainsAce = false;
		int tempValueOfHand = 0;
		for(Card c: hand){
			if(c.getNameOfCard().equals("ace")){
				handContainsAce = true;
			}
		}
		for(Card c:hand){
			if(c.getNameOfCard() == "ace")
				tempValueOfHand += 11;
			else
			tempValueOfHand += c.getValueOfCard();
		}
		if(handContainsAce && tempValueOfHand > 21){
			tempValueOfHand -= 10;
		}
		return tempValueOfHand;	
	}
	/**gives an copy of the hand
	 * @return the hand
	 */
	public ArrayList<Card> getHand() {
		return (ArrayList<Card>)hand.clone();
	}
}
