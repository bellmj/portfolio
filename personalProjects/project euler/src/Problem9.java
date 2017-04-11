import java.util.*;
/**
* This class is a solution to Problem 9 of the Project Euler problem set.
* This is an esoteric soluton showing the computation power of modern PCs.
* This algorithm is a guess and check algorithm, that could easily become more efficient by disallowing repeat guessing, as well as guessing only 2 values while deriving the third.
* across 100 trials the average execution time was found to be 14.55207 Seconds on a Macbook pro i7. This immplies that generally this solution will execute in under 60 seconds making it correct to euler standards,
*/
public class Problem9{
		public static void main (String [] args){
			double avergTime = 0;
			//  for( int i = 0; i < 100; i++){ //this code calculated the average run time of the algorithm
				long start = System.currentTimeMillis();

				Random rand = new Random();
				int a = 1;
				int b = 1;
				int c = 1;

				while(true)
				{
					if((a+b+c == 1000) && ((a*a)+(b*b)==(c*c)))
					{
						System.out.println("" + a + " " + b +" "+ c +" "+ (a*b*c));
						break;
					}
					a = (rand.nextInt(999)+1);
					b = (rand.nextInt(999)+1);
					c = (rand.nextInt(999)+1);
				}

			    long end = System.currentTimeMillis();

			    System.out.println("Executed in " + ((end - start)/1000.0) + " seconds");
				//  	avergTime += ((end - start)/1000.0);//this code calculated the average run time of the algorithm
				//  }
				//  avergTime = avergTime/ 100.0;
				//  System.out.println("The average time across 100 trials was: " + avergTime);


	}

}
