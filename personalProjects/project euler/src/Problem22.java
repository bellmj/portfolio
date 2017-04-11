
import java.io.*;
import java.util.*;
public class Problem22 {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> scores = new ArrayList<Integer>();
		long totalScore = 0;
		Scanner scan = new Scanner(new File("../names.txt"));
		scan.useDelimiter("\"");
		for(int i = 1;scan.hasNext();i++){
			if(i%2!=0)
			names.add(scan.next().toLowerCase());
			else
			scan.next();
		}
		scan.close();
		Collections.sort(names);
		for(int i = 0;i<names.size();i++){
			int score = 0;
			char[] c = names.get(i).toCharArray();
			for(char chs:c){
				score += (int)chs-96;
			}
			score*= i+1;
			scores.add(score);
		}
		for(int i:scores){
			totalScore+=i;
		}
		System.out.println(totalScore);

	}

}
