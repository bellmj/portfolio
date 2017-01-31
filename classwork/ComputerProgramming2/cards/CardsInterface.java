package cards;

/**this interface is for the global card class it provides the necessary methods to make an immutable card class
 * @author Matt Bell
 * @since Mar 3, 2014
 * @status this interface seems to work under the cases I have tested it under 
 */
public interface CardsInterface {
	/**gives the Name of the card; as in "one" "two" "jack" "king"
	 * @return the name of the card
	 */
	public String getNameOfCard();
	/**returns the suit of the card, diamonds, clubs, spades, hearts;
	 * @return the suit Of the Card
	 */
	public String getSuitOfCard();
	/**returns the numerical value of the card, 1 for aces ten for face cards
	 * @return the value Of the Card
	 */
	public int getValueOfCard();
	/** this method returns a string representing the this card object "ace of clubs" for the ace of clubs for example;
	 * @return a string representation of the card 
	 * @see java.lang.Object#toString()
	 */
	public String toString();

}
