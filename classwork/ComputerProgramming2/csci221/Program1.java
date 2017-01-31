package csci221;
import java.util.*;
/**This class is a runner that will take a string input via System.in and display the longest string(s) between spaces including letters punctuation and numbers. 
 * The program will read until the keyword "ENDINPUT" is inputed. 
 * @author Matt Bell
 * @since Jan 27, 2014
 * @status This program works. 
 */
public class Program1 {

	public static void main(String[] args) {
		int longestWordCount = 0;
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> longestWordsPositions = new ArrayList<Integer>();
		ArrayList<String> longestWords = new ArrayList<String>();
		ArrayList<String> stringArray = new ArrayList<String>();
		
		while(scan.hasNext() && !(scan.hasNext("ENDINPUT"))){
			stringArray.add(scan.next());
		}
		scan.close();
		
		byte count = 1;
		
		for(String tempString:stringArray){
			if(tempString.length()>longestWordCount){
				longestWordCount = tempString.length();
			}
			count++;
		}
		
		count = 1;
		
		for(String tempString:stringArray){
			if(tempString.length()==longestWordCount){
				longestWords.add(tempString);
				longestWordsPositions.add(new Integer(count));
			}
			count++;
			
		}
		
		System.out.println("The longest String(s) in the input is/are \"" + longestWords + "\" with (a) position(s) of " + longestWordsPositions + ".");

	}
}
