package ticktacktoe;

/**
 * @author Matt Bell
 * @since Mar 20, 2014
 */
public class CPUPlayer implements Player {
	Board board;
	
	public CPUPlayer(Board b){
		board = b;
	}
	/* (non-Javadoc)
	 * @see ticktacktoe.Player#takeTurn()
	 */
	@Override
	public Turn takeTurn() {
		int r = (int)(Math.random() *3);
		int c = (int)(Math.random()*3);
		while(!board.spaceIsEmpty(r, c)){
			r = (int)(Math.random() *3);
			c = (int)(Math.random()*3);
		}
		return new Turn((byte)r,(byte)c,false);
	}
	/*public static void main(String[] args) {
		Board b = new Board();
		Player player1 = new CPUPlayer(b);
		Player player2 = new PersonPlayer(b);
		
		
		
	}
	*/

}
