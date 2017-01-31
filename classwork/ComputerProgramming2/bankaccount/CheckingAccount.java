package bankaccount;

/**
 * @author Matt Bell
 * @since Apr 2, 2014
 */
public class CheckingAccount extends BankAccount {
	private int numeberOfChecksLeft;
	private long startTime;
	/**
	 * This constructor creates a Checking account object
	 */
	public CheckingAccount(double firstBalance) {
		super(firstBalance);
		startTime = System.currentTimeMillis();
		this.numeberOfChecksLeft = 101;
	}
	/**
	 * prints the check to standard out and take the check out of the balance
	 * @param amount amount of the check 
	 * @param payee the payee of the check
	 */
	public void printCheck(double amount,String payee){
		this.numeberOfChecksLeft--;
		this.withDraw(amount);
		System.out.println("*** Check Number: " + numeberOfChecksLeft);
		System.out.printf("*** Amount: %10.2f\n", amount);
		System.out.println("*** Payee: " + payee);
	}
	/*
	 * (non-Javadoc)
	 * @see bankaccount.BankAccount#getBalance()
	 */
	public double getBalance(){
		if(((System.currentTimeMillis()-this.startTime)/1000)>= 60){
			startTime = System.currentTimeMillis();
			this.withDraw(1.00);
		
		}
		return super.getBalance();
	}

}
