import java.math.BigInteger;
public class Problem16 {

	public static void main(String[] args) {
		long sumOfDigits = 0;
		BigInteger big = new BigInteger("2");
		String intString = (big.pow(1000)).toString();
		char[] charArray = intString.toCharArray();
		for(char chs:charArray){
			sumOfDigits += java.lang.Character.getNumericValue(chs);
		}
		System.out.print(sumOfDigits);
	}
}
