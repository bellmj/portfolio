/**
 * 
 */
package problem17;

/**
 * @author matt
 *
 */
public class Problem17 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long count = 0;
		for(int c = 1; c<=1000;c++){
			Numbers n = new Numbers(c);
			count += n.getStringValue().length();
			//System.out.println(n.getStringValue() + " " + count);
		}
		System.out.println(count);

	}

}
