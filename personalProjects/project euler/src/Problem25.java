import java.math.BigInteger;
//import java.util.ArrayList;
public class Problem25 {
	/**
	* Solution to Problem 25 of the Project Euler set.
	* This solution is complete
	*/
	public static void main(String[] args) {
		BigInteger rsum = new BigInteger("0");
		BigInteger fib = new BigInteger("1");
		BigInteger nfib = new BigInteger("1");
		BigInteger temp;
        long counter = 2;
        while(true) {
            if(nfib.mod(new BigInteger("2")).compareTo(new BigInteger("0"))==0){
                rsum = rsum.add(nfib);
            }
            temp = fib.add(nfib);
            fib = nfib;
            nfib = temp;
            if(rsum.toString().length()==1000){
            	break;
            }
            counter++;
        }
        System.out.println(rsum + " \n  " + counter);

    }

}
