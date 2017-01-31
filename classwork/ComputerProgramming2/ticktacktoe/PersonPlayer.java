package ticktacktoe;
import java.util.*;
/** This class represents a Human Player in TackTackToe this class implements the  Player interface.
 * @author Matt Bell
 * @since Mar 20, 2014
 * @status this class works
 */
public class PersonPlayer implements Player {
	private Scanner scan;
	private Board board;
	/**
	 * Creates a PersonPlayer Object and initializes the Scanner and the Board
	 * @param b The board that the player is playing on.
	 */
	public PersonPlayer(Board b){
		board = b;
		scan = new Scanner(System.in);
	}
	/** Takes the Turn after the Human Player gives input. see ticktacktoe.Player.takeTurn()
	 * @return Turn a Turn object with the row and column that the player wishes to place. The this method should always return a Turn Object 
	 * with the instance variable being true; This is how TickTackToe identifies the player  
	 */
	public Turn takeTurn() {
		byte r = 0;
		byte c = 0;
		Display.promptPlayer();
		
		r = (byte)(scan.nextInt()-1);
		c = (byte)(scan.nextInt()-1);
		while((r>3||r < 0)||(c>3 || c<0) || !board.spaceIsEmpty(r, c)){
			Display.playerErrorMessage();
			Display.promptPlayer();
			r = (byte)(scan.nextInt()-1);
			c = (byte)(scan.nextInt()-1);
		}
		return new Turn(r,c,true);
	}
	/*public static void main(String[] args) {
		Board b = new Board();
		while(!b.isDone()){
		Turn x = new PersonPlayer(b).takeTurn();
		b.placeToken(x.getRow(), x.getColumn(), x.getToken());
		Display.displayBoard(b);
		}
		
	}*/

}
