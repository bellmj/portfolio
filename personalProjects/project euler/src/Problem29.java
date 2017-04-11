import java.math.BigInteger;
import java.util.ArrayList;
//This solution is still incomplete
public class Problem29 {
	public static void main(String[] args){
		ArrayList<BigInteger> tempDistinctPowersList = new ArrayList<BigInteger>();
		ArrayList<BigInteger> distinctPowersList = new ArrayList<BigInteger>();
		for(BigInteger a = new BigInteger("2");a.compareTo(new BigInteger("6"))<0;a = a.add(new BigInteger("1"))){
			for(BigInteger b = new BigInteger("2");b.compareTo(new BigInteger("6"))<0;b = b.add(new BigInteger("1"))){
				tempDistinctPowersList.add(bigPow(a,b));
				System.out.println("" + a +" "+ b);
				System.out.println(bigPow(a,b));
			}
		}
		System.out.println(tempDistinctPowersList.size());
		for(BigInteger t : tempDistinctPowersList){
			if(!distinctPowersList.contains(t)){
				distinctPowersList.add(t);
			}
		}
		System.out.println(distinctPowersList);
		System.out.println(distinctPowersList.size());
	}
	private static BigInteger bigPow(BigInteger a, BigInteger b){
		if(b.compareTo(new BigInteger("0"))<0){
			return bigPow(new BigInteger("1").divide(a),b.multiply(new BigInteger("-1")));
		}
		else if(b.compareTo(new BigInteger("0"))==0){
			return new BigInteger("1");
		}
		else if(b.compareTo(new BigInteger("0")) == 1){
			return a;
		}
		else if(b.mod(new BigInteger("2")).compareTo(new BigInteger("0"))==0){
			return bigPow(a.pow(2),b.divide(new BigInteger("2")));
		}
		else{
			return a.multiply(bigPow(a.pow(2),(b.add(new BigInteger("-1")).divide(new BigInteger("2")))));
		}
	}
}
