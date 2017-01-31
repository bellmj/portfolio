package bankaccount;

import java.util.Scanner;

/**This class is the Logic for the Banking process it also handles IO. I relize that that isn't proper form and I don't really care.
 * @author Matt Bell
 * @since Apr 2, 2014
 * @status This class Works
 */
public class Bank {
	private CheckingAccount a = null;
	private SavingsAccount b = null;
	private Scanner scan = new Scanner(System.in);
	private long startTime;
	/**
	 * This constructor creates a Bank object and sets the system time 
	 */
	public Bank() {
		startTime = System.currentTimeMillis();
	}
	/**
	 * This method is the method what starts the bank program off.
	 */
	public void run(){
		while(!executeValidUserInput()){
			if((System.currentTimeMillis()-startTime)/1000 >= 30){
				if(a!=null){
					a.getBalance();
				}
				else if(b!=null){
					b.getBalance();
				}
			}
		}
	}
	/**
	 * this method is intended to get user input and select the correct command that the user wants
	 * I understand its long and I probably should of used helper methods but it works so its whatever.
	 * 
	 * @return true if user enter the end command false if not
	 */
	private boolean executeValidUserInput(){
		System.out.print(">");
		
		String command = scan.nextLine();//scans for user input
		String[] commandArray;
		if(command.length()>0)
			commandArray = command.split(" ");//puts user input into a command array of strings
		else 
			commandArray = new String[0];
		if(commandArray.length >= 1){//dertimines if the user entered input or not

			if (commandArray[0].equals("end")) {
				return true;
			} else if (commandArray[0].equals("create")) {
				if (commandArray.length == 3 && (commandArray[1].equalsIgnoreCase("checking") || commandArray[1].equalsIgnoreCase("savings"))
						&& new Scanner(commandArray[2]).hasNextDouble()) {
					if (commandArray[1].equalsIgnoreCase("checking")) {
						a = new CheckingAccount(Double.parseDouble(commandArray[2]));
					} else if (commandArray[1].equalsIgnoreCase("savings")) {
						b = new SavingsAccount(Double.parseDouble(commandArray[2]));
					}
				} else {
					System.out.println("invalid input has been entered");
				}

			} else if (commandArray[0].equals("withdraw")) {
				if (b == null) {
					System.out.println("You dont have a savings account created please a savings account if you wish to use this function ");
				} else {
					if (commandArray.length == 2 && new Scanner(commandArray[1]).hasNextDouble()) {
						if (Double.parseDouble(commandArray[1]) > b.getBalance()) {
							System.out.println("you can not take money out because youre poor");
						} else {
							b.withDraw(Double.parseDouble(commandArray[1]));
						}
					}
				}

			} else if (commandArray[0].equals("balance")) {
				if (a != null) {
					System.out.println("$" + a.getBalance());
				} else if (b != null) {
					System.out.println("$" + b.getBalance());
				} else {
					System.out.println("thre are no accounts created no get a balance on");
				}

			} else if (commandArray[0].equals("check")) {
				if (a == null) {
					System.out.println("You dont have a checking account created please create a checking account if you wish to write checks ");

				} else {
					if (commandArray.length >= 3 && new Scanner(commandArray[1]).hasNextDouble()) {
						if (Double.parseDouble(commandArray[1]) > a.getBalance()) {
							System.out.println("you can not write this check because youre poor");

						} else {
							String payee = "";
							for (int i = 2; i < commandArray.length; i++) {//i know its weird to have a for loop in like 3 if statements in a switch but it works i promise
								payee += commandArray[i] + " ";
							}
							a.printCheck(Double.parseDouble(commandArray[1]), payee);
						}
					}
				}

			} else if (commandArray[0].equals("deposit")) {
				if (b == null) {
					System.out.println("There is no account to deposit into");

				} else if (commandArray.length == 2 && new Scanner(commandArray[1]).hasNextDouble()) {
					b.deposit(Double.parseDouble(commandArray[1]));
				}

			} else if (commandArray[0].equals("close")) {
				a = null;
				b = null;

			} else {
				System.out.println("An invalid input has been entered ");
			}
		}
		else{//This is executed if the user doesnt not input a command and just presses enter
			if(a == null && b == null){
				System.out.println("Enter one of these commands:\n"+ 
					"create savings <amount>\n"+ 
					"create checking <amount>");
			}
			else if(a != null){
				System.out.println("Enter one of these commands: \nbalance \ndeposit <amount>\ncheck <amount> <payee>\nclose");
			}
			else {
				System.out.println("Enter one of these commands:\nbalance\ndeposit <amount>\nwithdraw <amount>\nclose");
			}
			executeValidUserInput();
		}
		return false;
	}
	
	

}
