package blackJack;

/**this class kicks off the game of black jack.
 * @author Matt Bell
 * @since Feb 26, 2014
 * This class appears to work in all cases 
 */
public class BlackJackRunner {

	/**this method makes a blackJack object and evokes the play method 
	 * @param args
	 */
	public static void main(String[] args) {
		BlackJack b = new BlackJack();
		b.play();
	}

}
