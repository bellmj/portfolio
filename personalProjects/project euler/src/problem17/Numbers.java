/**
 * 
 */
package problem17;

/**
 * @author matt
 *
 */
public class Numbers {
	private String stringValue;
	
	public Numbers(int n){
		stringValue = getStringFromInt(n);	
	}
	/**
	 * @return the stringValue
	 */
	public String getStringValue() {
		return stringValue;
	}
	
	private static String getStringFromInt(int n){
		switch (n){
		case 0:
			return "";
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		case 10:
			return "ten";
		case 11:
			return "eleven";
		case 12:
			return "twelve";
		case 13:
			return "thirteen";
		case 14:
			return "fourteen";
		case 15:
			return "fifteen";
		case 16:
			return "sixteen";
		case 17:
			return "seventeen";
		case 18:
			return "eighteen";
		case 19:
			return "nineteen";
		}
		switch (n/10){
		case 2:
			return "twenty" + getStringFromInt(n%10);
		case 3:
			return "thirty" + getStringFromInt(n%10);
		case 4:
			return "forty" + getStringFromInt(n%10);
		case 5:
			return "fifty" + getStringFromInt(n%10);
		case 6:
			return "sixty" + getStringFromInt(n%10);
		case 7:
			return "seventy" + getStringFromInt(n%10);
		case 8:
			return "eighty" + getStringFromInt(n%10);
		case 9:
			return "ninety" + getStringFromInt(n%10);
		default:
			if(n<1000){
				if(n%100 == 0)
					return getStringFromInt(n/100) +"hundred";
				return getStringFromInt(n/100) +"hundredand"+ getStringFromInt(n%100);
			}
			else if(n<10000)
				return getStringFromInt(n/1000)+"thousand" + getStringFromInt(n%100);
		}
		return null;
	}
	public static void main (String [] args){
		/*for(int x = 1; x <= 1000; x++){
			System.out.println(getStringFromInt(x));
		}
		*/
		System.out.println(getStringFromInt(115).length());
	}

}
