package linkedIn;

/**This class is Made as a test suite for the Company class.
 * @see linkedIn.Company
 * @author Matt Bell
 * @since Feb 16, 2014
 * @status This class works 
 */
public class CompanyTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Company Owner = new Company("Master",1915,1000000000,'I');
		Company LinkedIn = new Company("LinkedIN",'D',Owner,1999,5000000,696969);
		Company LinkedInCopy = new Company(LinkedIn);
		LinkedInCopy.setName("LinkedInCopy");
		LinkedInCopy.setYearOfFounding(1414);
		Owner.setEmployees(5);
		Owner.setId(314159);
		Owner.setParent(LinkedIn);
		Owner.setYearOfFounding(1492);
		Owner.getCompanies();
		Owner.getEmployees();
		Owner.getId();
		Owner.getName();
		Owner.getParent();
		Owner.getType();
		Owner.getYearOfFounding();
		Owner.setType('O');
		LinkedInCopy.getParent().setName("Master Copy");
		System.out.println(LinkedIn + "\n" + Owner + "\n" + LinkedIn.isBigger(Owner) + "\n" + Company.isBigger(LinkedIn, Owner) + LinkedInCopy);
		

	}

}
