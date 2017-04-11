import java.math.BigInteger;

/**This program solves Problem 20 of the project euler set
 * @author Matt
 * @since 1/27/14
 */
public class Problem20 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger fact = new BigInteger("100");
		BigInteger count = fact.add(new BigInteger("-1"));
		while(count.compareTo(new BigInteger("0")) > 0){
			fact = fact.multiply(count);
			count = count.add(new BigInteger("-1"));
		}
		String factString = fact.toString();
		System.out.println(factString);
		char[] charArrayofFact = new char[factString.length()-1];
		for(int x = 0; x < charArrayofFact.length;x++){
			charArrayofFact[x] = factString.charAt(x);
		}
		long factNumberCount = 0;
		for(char a:charArrayofFact){
			factNumberCount += java.lang.Character.getNumericValue(a);
		}
		System.out.println(factNumberCount);



	}

}
