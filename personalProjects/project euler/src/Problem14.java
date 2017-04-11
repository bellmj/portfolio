//solved
public class Problem14 {

	public static void main(String[] args) {
		long longestChain = 0;
		long optimalStartingN =0;
		for(long startingN = 1000000;startingN>0;startingN--){
			long tempN = startingN;
			long tempLongestChain = 0;
			while(tempN!=1){
				if(tempN%2==0){
					tempN = tempN/2;
				}
				else{
					tempN = (3*tempN)+1;
				}
				tempLongestChain++;
			}
			if(tempLongestChain>longestChain){
				longestChain = tempLongestChain;
				optimalStartingN = startingN;
			}
		}
		System.out.println(longestChain + "  " + optimalStartingN);

	}

}
