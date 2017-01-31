package csci221;

public class Tester {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 100; i > 0; i--){
			sum += i;
		}
		if(sum == 5050){
			throw new IllegalArgumentException("arg1 cannot be null.");
		}
		System.out.print(sum);
	}

}
