package bankaccount;

/**This abstract class sets up the templet for Checking account and Savings account 
 * @author Matt Bell
 * @since Apr 2, 2014
 * @status this class works
 * 
 */
public abstract class BankAccount {
	double balance;
	int accountNumber;
	/**
	 * the Deafaut constructor for all accounts  
	 * @param firstBalance the balance to initally put in
	 */
	public BankAccount(double firstBalance){
		balance = firstBalance;
		accountNumber = (int)(Math.random()*999999999);
	}
	/**
	 * this method deposits into the account
	 * @param a amount to deposit 
	 */
	public void deposit(double a){
		balance +=a;
	}
	/**
	 * this method withdraws from the account 
	 * @param a amount to withdraw
	 */
	public void withDraw(double a){
		balance-=a;
	}
	/**
	 * this method gives the balance 
	 * @return the balance of the account
	 */
	public double getBalance(){
		return balance;
	}
	/**
	 * the account number of this account
	 * @return the account number of this account
	 */
	public int getAccountNumber(){
		return accountNumber;
	}

}
