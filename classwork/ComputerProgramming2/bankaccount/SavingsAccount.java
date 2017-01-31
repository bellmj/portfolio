package bankaccount;

/**This class is a BankAccount and repersents a Savings Account 
 * @author Matt Bell
 * @since Apr 2, 2014
 */
public class SavingsAccount extends BankAccount {
	private long startTime;
	private final double intrestRate = .01; 
	/**
	 * This constructor Creates a savings account object
	 */
	public SavingsAccount(double a) {
		super(a);
		startTime = System.currentTimeMillis();
	}
	/*
	 * (non-Javadoc)
	 * @see bankaccount.BankAccount#getBalance()
	 */
	public double getBalance(){
		if(((System.currentTimeMillis()-this.startTime)/1000)>= 60){
			startTime = System.currentTimeMillis();
			this.deposit(this.getBalance() * intrestRate);
		
		}
		return super.getBalance();
	}
	
	

}
