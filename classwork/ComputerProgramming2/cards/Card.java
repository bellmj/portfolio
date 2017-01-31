package cards;
import java.util.*;
/**This class represents a playing card. These objects are immutable.   
 * note: aces are always represented by the value of 1
 * @author Matt Bell
 * @since Feb 24, 2014
 * @status this class works fine
 */
public class Card implements CardsInterface {	
	private String nameOfCard;
	private int valueOfCard;
	private String suitOfCard;
	
	/**
	 * This constructor creates a card object with the value corresponding to the numerical input. This constructor is package protected to prevent cheating.
	 * @param i takes in a number (1-52)corresponding to the Card desired in numerical suit order (clubs, followed by diamonds, hearts, and spades) so the ace of clubs is 1, and the King of spades is 52
	 * @preCondition the value of i must be an integer between 1 and 52 inclusive 
	 */
	 Card(int i){
		if(i % 4 == 0){
			suitOfCard = "spades"; 
		}
		else if(i % 4 == 3){
			suitOfCard = "hearts";
		}
		else if(i % 4 == 2){
			suitOfCard = "diamonds";
		}
		else{
			suitOfCard = "clubs";
		}
		
		int temp = (i-1)/4;// this will result in a number 0-12 inclusive that corresponds to the type of the card
		switch (temp){
		case 0:
			valueOfCard = 1;
			nameOfCard = "ace";
			break;
		case 1:
			valueOfCard = 2;
			nameOfCard = "two";
			break;
		case 2:
			valueOfCard = 3;
			nameOfCard = "three";
			break;
		case 3:
			valueOfCard = 4;
			nameOfCard = "four";
			break;
		case 4:
			valueOfCard = 5;
			nameOfCard = "five";
			break;
		case 5:
			valueOfCard = 6;
			nameOfCard = "six";
			break;
		case 6:
			valueOfCard = 7;
			nameOfCard = "seven";
			break;
		case 7:
			valueOfCard = 8;
			nameOfCard = "eight";
			break;
		case 8:
			valueOfCard = 9;
			nameOfCard = "nine";
			break;
		case 9:
			valueOfCard = 10;
			nameOfCard = "ten";
			break;
		case 10:
			valueOfCard = 10;
			nameOfCard = "jack";
			break;
		case 11:
			valueOfCard = 10;
			nameOfCard = "queen";
			break;
		case 12:
			valueOfCard = 10;
			nameOfCard = "king";
		}
	}
	/**gives the Name of the card; as in "one" "two" "jack" "king"
	 * @return the name of the card
	 */
	public String getNameOfCard() {
		return nameOfCard;
	}
	/**returns the numerical value of the card, 1 for aces ten for face cards
	 * @return the value Of the Card
	 */
	public int getValueOfCard() {
		return valueOfCard;
	}
	/**returns the suit of the card, diamonds, clubs, spades, hearts;
	 * @return the suit Of the Card
	 */
	public String getSuitOfCard() {
		return suitOfCard;
	}
	/** this method returns a string representing the this card object "ace of clubs" for the ace of clubs for example;
	 * @return a string representation of the card 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + this.nameOfCard + " of " + this.suitOfCard;
	}
	public static void main(String[] args){
		ArrayList<Card> cards = new ArrayList<Card>();
		for(int i = 1;i <= 52;i++){
			cards.add(new Card(i));
		}
		Collections.shuffle(cards);
		System.out.println(cards);
	}

}
