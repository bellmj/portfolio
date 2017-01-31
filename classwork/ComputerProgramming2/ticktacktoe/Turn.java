package ticktacktoe;

/**
 * @author Matt Bell
 * @since Mar 20, 2014
 */
public class Turn {
	private byte row;
	private byte column;
	private Boolean token;
	/**
	 * Makes a Turn object that is immutable to hold the row column and the
	 * @param r
	 * @param c
	 * @param t
	 */
	public Turn(byte r, byte c, boolean t){
		row = r;
		column = c;
		token = t;
	}

	/**
	 * @return the row
	 */
	public byte getRow() {
		return row;
	}

	/**
	 * @return the column
	 */
	public byte getColumn() {
		return column;
	}
	public Boolean getToken(){
		return (Boolean)token;
	}
	

}
