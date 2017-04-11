/**
 * 
 */

/**
 * @author matt
 *
 */
public class Euler28 {
	private static final int ARRAY_SIZE = 1001;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] spiral = new int[ARRAY_SIZE][ARRAY_SIZE];
		for(int i = 1; i <= Math.pow(ARRAY_SIZE, 2);i++){
			if(i==1){
				spiral[(ARRAY_SIZE -1)/2][(ARRAY_SIZE -1)/2] = i;
			}
			//TODO finish the creation of the spiral
		}

	}

}
