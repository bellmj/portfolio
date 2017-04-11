
public class Problem12 {

	//solved
	public static void main(String[] args) {

		for(long x = 1; true;x++){//this loop makes triangle numbers stored in triangleNumberCount
			long triangleNumberCount = (x*(x+1))/2;
			if(MyUtil.numberOfDivisors(triangleNumberCount)>=500){
				System.out.println(triangleNumberCount);
				break;
			}
		}



	}

}
