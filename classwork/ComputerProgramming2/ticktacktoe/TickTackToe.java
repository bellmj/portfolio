package ticktacktoe;

/**This class is the Logic for ticktacktoe
 * @author Matt Bell
 * @since Mar 12, 2014
 * @status this class should work
 */
public class TickTackToe extends Object{
	private Board board;
	private Player aiPlayer;
	private Player personPlayer;
	/**
	 * makes a new TickTackToe Object
	 */
	public TickTackToe(){
	board = new Board();
	aiPlayer = new CPUPlayer(board);
	personPlayer = new PersonPlayer(board);
	}
	public void play(){
		while(!board.isDone()){
			Turn x = aiPlayer.takeTurn();
			board.placeToken(x.getRow(), x.getColumn(), x.getToken());
			if(board.isDone()){
				Display.displayBoard(board);
				break;
			}
			Display.displayBoard(board);
			Turn y = personPlayer.takeTurn();
			board.placeToken(y.getRow(), y.getColumn(), y.getToken());
			Display.displayBoard(board);
			}
		if(board.findWinner() == null){
			Display.tieMessage();
		}
		else if(board.findWinner() == true){
			Display.winMessage();
		}
		else{
			Display.loseMessage();
		}
	}
	public static void main(String[] args) {
		

	}

}
