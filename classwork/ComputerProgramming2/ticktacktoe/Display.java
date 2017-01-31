package ticktacktoe;
/** This is a static class for the Display needs of TickTackToe
 * @author Matt Bell
 * @since Mar 20, 2014
 */
public class Display extends Object {
	/**
	 * this static method will take in a Board Object and will print the ticktacktoe board this is accomplished by converting the 2d array of Boolean objects into 
	 * a char array then looping through the char array to print out the board in a nice format 
	 * @param b The board object to display 
	 */
	public static void displayBoard(Board b){
		Boolean[][] x = b.getBoard();
		char[][] charBoard = new char[3][3];
		  for(int row=0;row<x.length;row++)
	        {
	            for(int column=0;column< x[row].length;column++)
	            {
	                 if(x[row][column]==null){
	                	 charBoard[row][column] = '_';
	                 }
	                 else if(x[row][column].equals((Boolean)true)){
	                	 charBoard[row][column] = 'X';
	                 }
	                 else if(x[row][column].equals((Boolean)false)){
	                	 charBoard[row][column] = 'O';
	                 }
	            }
	        }
		  for(int r = 0; r < charBoard.length;r++){
				for(int c = 0; c < charBoard[r].length; c++){
					System.out.print(""+charBoard[r][c]+"\t");
				}
				System.out.println();
			}
		  System.out.println();
		  
	}
	/**
	 * prints a preTurn Player prompt to console 
	 */
	public static void promptPlayer(){
		System.out.println("Please enter your turn in the format \"row column\"");
	}
	/**
	 * prints an invalid input message to the console 
	 */
	public static void playerErrorMessage(){
		System.out.println("This is an invalid Input please try again");
	}
	/**
	 * Prints the message to show in the case of a tie game
	 */
	public static void tieMessage() {
		System.out.println("Tie Game");
	}
	/**
	 * prints the win message to the console 
	 */
	public static void winMessage(){
		System.out.println("Winner Winner Chiken Dinner");
	}
	/**
	 * Prints a lose message to the console 
	 */
	public static void loseMessage(){
		System.out.println("HA suck you lost");
	}
	/*
	public static void main(String[] args) {
		Board b = new Board();
		b.placeToken(0, 0, true);
		b.placeToken(2, 0, true);
		b.placeToken(1, 0, true);
		b.placeToken(0, 0, false);
		displayBoard(b);
	
	}*/

}
