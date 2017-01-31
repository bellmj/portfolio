package ticktacktoe;

/** This interface sets up behaviors for the player object This parent class is used to gain polymorphism.
 * More might be added to this class later depending on the functionality wanted for player objects  
 * @author Matt Bell
 * @since Mar 20, 2014
 * @status this class works
 */
public interface Player {
	/**
	 * This method should Take the TickTackToe turn and create and return a Turn Object it is the responsibility of the instation of this method to do everything 
	 * necessary in order to complete the turn. 
	 * @return A immutable Turn object contating the players selected turn 
	 */
	public abstract Turn takeTurn();

}
