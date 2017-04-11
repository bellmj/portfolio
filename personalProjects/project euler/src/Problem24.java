import java.util.*;
/**this class solves problem 24 of the project euler set
 * "A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 *012   021   102   120   201   210
 * 
 *What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?"
 * @author Matt Bell
 *@since 3/3/14
 *@this class works and completes the question to euler standards. generally executes in around 1.2 seconds
 */
public class Problem24 {

	/**this is the main method and contains all of the code for this class
	 * @param args the string array passed at run time.
	 */
	public static void main(String[] args) {
		final long START_TIME = System.currentTimeMillis();
		ArrayList<String> stringArray = new ArrayList<String>();//this string array is what the permeations are added to
		for(int a = 0;a<=9;a++){//this giant nest of for loops generates all of the permeations of 0123456789 in lexicographic order.
			for(int b = 0;b<=9;b++){
				if(b==a)continue;
				for(int c = 0;c<=9;c++){
					if(c == a || c ==b )continue;
					for(int d = 0;d<=9;d++){
						if(d==c||d==b||d==a)continue;
						for(int e = 0;e<=9;e++){
							if(e==d||e==c||e==b||e==a)continue;
							for(int f = 0;f<=9;f++){
								if(f==e||f==d||f==c||f==b||f==a)continue;
								for(int g = 0;g<=9;g++){
									if(g==f||g==e||g==d||g==c||g==b||g==a)continue;
									for(int h = 0;h<=9;h++){
										if(h==g||h==f||h==e||h==d||h==c||h==b||h==a)continue;
										for(int i = 0;i<=9;i++){
											if(i==h||i==g||i==f||i==e||i==d||i==c||i==b||i==a)continue;
											for(int j = 0;j<=9;j++){
												if(j==i||j==h||j==g||j==f||j==e||j==d||j==c||j==b||j==a)continue;
												stringArray.add(""+a+b+c+d+e+f+g+h+i+j);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(stringArray.get(999999));//gets the Millionth element of this array
		final long END_TIME = System.currentTimeMillis();
        System.out.println("Executed in " + ((END_TIME - START_TIME)/1000.0) + " seconds");
	}


}
