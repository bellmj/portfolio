package ticktacktoe;

/**This class is the model for the TickTackToe project. It holds a 2d array of Boolean objects and has the values null for no space true for X and false for O
 * @author Matt Bell
 * @since Mar 12, 2014
 * @status
 */
public class Board extends Object {
	private Boolean[][] board = new Boolean[3][3];
	/**
	 * Makes a Board object with all of the spaces being null;
	 */
	public Board(){
		
	}
	public void placeToken(int r,int c,boolean x){
		if(spaceIsEmpty(r,c)){
			board[r][c] = x;
		}
	}
	public boolean spaceIsEmpty(int r,int c){
		return board[r][c] == null;
	}
	/**
	 * this method figures out if the board is done, as in there is a winner.
	 * @return true if there is a winner or the Board is full, false if not;
	 */
	public Boolean isDone(){
		boolean temp = false;
		for(int r = 0; r < board.length;r++){
			for(int c = 0; c < board[r].length; c++){
				if(board[r][c] == null){
					temp = true;
				}
			}
		}
		if(temp == false){
			return true; 
		}
		if((board[0][0] != null && board[0][0] == board[0][1]&& board[0][0] == board[0][2])|| (board[1][0] != null &&board[1][0] == board[1][1]&& board[1][0] == board[1][2]) || (board[2][0] != null && board[2][0] == board[2][1]&& board[2][0] == board[2][2])
				|| (board[0][0] != null && board[0][0] == board[1][0]&& board[0][0] == board[2][0]) ||  (board[0][1] != null && board[0][1] == board[1][1]&& board[0][1] == board[2][1]) ||  (board[0][2] != null && board[0][2] == board[1][2]&& board[0][2] == board[2][2])
				|| (board[0][0] != null && board[0][0] == board[1][1]&& board[0][0] == board[2][2]) ||  (board[2][0] != null &&board[2][0] == board[1][1]&& board[2][0] == board[0][2])){
			return true;
		}
		return false;
	}
	private boolean boardIsFull(){
		boolean temp = false;
		for(int r = 0; r < board.length;r++){
			for(int c = 0; c < board[r].length; c++){
				if(board[r][c] == null){
					temp = true;
				}
			}
		}
		if(temp == false){
			return true; 
		}
		return false;
	}
	/**
	 * this method will return the winner true for the player false for the cpu and null for a tie This method is reduntand and not at all optimized but it functions 
	 * @return should return true for the player's winn false for the CPU's win and null in the case of a tie.
	 */
	public Boolean findWinner(){
		if(boardIsFull()){
			if((board[0][0] == true && board[0][0] == board[0][1]&& board[0][0] == board[0][2])|| (board[1][0] == true &&board[1][0] == board[1][1]&& board[1][0] == board[1][2]) || (board[2][0] == true && board[2][0] == board[2][1]&& board[2][0] == board[2][2])
					|| (board[0][0] == true && board[0][0] == board[1][0]&& board[0][0] == board[2][0]) ||  (board[0][1] == true && board[0][1] == board[1][1]&& board[0][1] == board[2][1]) ||  (board[0][2] == true && board[0][2] == board[1][2]&& board[0][2] == board[2][2])
					|| (board[0][0] == true && board[0][0] == board[1][1]&& board[0][0] == board[2][2]) ||  (board[2][0] == true &&board[2][0] == board[1][1]&& board[2][0] == board[0][2])){
				return true;
			}
			else if((board[0][0] == false && board[0][0] == board[0][1]&& board[0][0] == board[0][2])|| (board[1][0] == false &&board[1][0] == board[1][1]&& board[1][0] == board[1][2]) || (board[2][0] == false && board[2][0] == board[2][1]&& board[2][0] == board[2][2])
					|| (board[0][0] == false && board[0][0] == board[1][0]&& board[0][0] == board[2][0]) ||  (board[0][1] == false && board[0][1] == board[1][1]&& board[0][1] == board[2][1]) ||  (board[0][2] == false && board[0][2] == board[1][2]&& board[0][2] == board[2][2])
					|| (board[0][0] == false && board[0][0] == board[1][1]&& board[0][0] == board[2][2]) ||  (board[2][0] == false &&board[2][0] == board[1][1]&& board[2][0] == board[0][2])){
				return false;
			}
		}
		else{
			if((board[0][0] != null && board[0][0].equals(true) && board[0][0].equals(board[0][1])&& board[0][0].equals(board[0][2]))|| 
			(board[1][0] != null && board[1][0].equals(true) && board[1][0].equals(board[1][1])&& board[1][0].equals(board[1][2])) || 
			(board[2][0] != null && board[2][0].equals(true) && board[2][0].equals(board[2][1])&& board[2][0].equals(board[2][2])) || 
			(board[0][0] != null && board[0][0].equals(true) && board[0][0].equals(board[1][0])&& board[0][0].equals(board[2][0])) || 
			(board[0][1] != null && board[0][1].equals(true) && board[0][1].equals(board[1][1])&& board[0][1].equals(board[2][1])) ||  
			(board[0][2] != null && board[0][2].equals(true) && board[0][2].equals(board[1][2])&& board[0][2].equals(board[2][2])) || 
			(board[0][0] != null && board[0][0].equals(true) && board[0][0].equals(board[1][1])&& board[0][0].equals(board[2][2])) || 
			(board[2][0] != null && board[2][0].equals(true) && board[2][0].equals(board[1][1])&& board[2][0].equals(board[0][2]))){
				return true;
			}
			else if((board[0][0] != null && board[0][0].equals(false) && board[0][0].equals(board[0][1])&& board[0][0].equals(board[0][2]))|| 
					(board[1][0] != null && board[1][0].equals(false) && board[1][0].equals(board[1][1])&& board[1][0].equals(board[1][2])) || 
					(board[2][0] != null && board[2][0].equals(false) && board[2][0].equals(board[2][1])&& board[2][0].equals(board[2][2])) || 
					(board[0][0] != null && board[0][0].equals(false) && board[0][0].equals(board[1][0])&& board[0][0].equals(board[2][0])) || 
					(board[0][1] != null && board[0][1].equals(false) && board[0][1].equals(board[1][1])&& board[0][1].equals(board[2][1])) ||  
					(board[0][2] != null && board[0][2].equals(false) && board[0][2].equals(board[1][2])&& board[0][2].equals(board[2][2])) || 
					(board[0][0] != null && board[0][0].equals(false) && board[0][0].equals(board[1][1])&& board[0][0].equals(board[2][2])) || 
					(board[2][0] != null && board[2][0].equals(false) && board[2][0].equals(board[1][1])&& board[2][0].equals(board[0][2]))){
						return false;
					}
		}
		return null;
	}
	/**
	 * this method clones the board and returns it as a Boolean[][] array 
	 * @return A Boolean[][] representation of the Board
	 */
	public Boolean[][] getBoard(){
		Boolean[][] x = new Boolean[board.length][board[0].length];
		for(int r = 0; r < board.length;r++){
			for(int c = 0; c < board[r].length; c++){
				x[r][c] = board[r][c];
			}
		}
		return x;
	}
	public static void main(String[] args) {
		Board b = new Board();
		b.placeToken(0, 0, true);
		b.placeToken(0, 1, true);
		b.equals(b);
		Display.displayBoard(b);
		System.out.println(b.isDone());
		System.out.println(b.board[2][1]);
	}
}
