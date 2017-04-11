import java.math.*;
/**
 * This class solves the problem 48 of the project euler set
 * @author Matt Bell
 * @since 5/30/14
 * @Status this class works
 */
public class Problem48 {
	/**
	 * The main method
	 * @param args the String array of arguments passed to vjm at runtime
	 */
	public static void main(String[] args) {
		BigInteger sum = new BigInteger("0");
		for(int x = 1; x<= 1000 ;x++){
			sum = sum.add((new BigInteger("" + x)).pow(x));
		}
		System.out.println(sum.toString().substring(sum.toString().length()-10,sum.toString().length()));
	}

}
