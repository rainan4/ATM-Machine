package firstPackage;

import java.time.LocalDate;
import java.util.Scanner;
/** 
 * 
 * Main Class
 * @author rainanarayan 
 * */
public class ATMMachine {

				/** 
				 * Main Method
				 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		Scanner input = new Scanner(System.in);

		// creating three account objects
		//in the argument, it takes the number of account and the input of the user
		Account account1 = accountCreate(1, input);// creates first account
		Account account2 = accountCreate(2, input);// creates second account
		Account account3 = accountCreate(3, input);// creates third account

		
		/* While the condition is true, it will display the the ATM prompt
		 * and tells the user to enter an ID that was created for the three accounts.
		 * The if loop is nested in while loop so when a user enters the correct ID,
		 * it will prompt the ATM Menu and same applies to other two accounts. 
		 * If the id is not valid, it will prompt the user regarding the invalid ID input
		 * */
		boolean id = true; // boolean ID is set to true so the while loop can execute when the condition is true.
		while (id) {// loop for when user is inputing one of the three id's
			System.out.println("Weclome to ATM");
			System.out.println("Enter an ID:");
			int enterID = input.nextInt();
			input.nextLine();//this is placed to clear the buffer

			// id must match the three objects
			if (enterID == account1.getAccountID()) {
				//"getAccountID" gets the value that was stored in account1
				// If the account1 ID matches, show the ATM menu for account1
				atmMenu(account1, input);
				id = false; //id is set to false so it wont prompt to enter the id again
				
			} else if (enterID == account2.getAccountID()) {
				// If the account2 ID matches, show the ATM menu for account2
				atmMenu(account2, input);
				id = false;
			} else if (enterID == account3.getAccountID()) {
				// If the account3 ID matches, show the ATM menu for account3
				atmMenu(account3, input);
				id = false;
			} else {
				// if neither ID matches, display this prompt
				System.out.println("ID does not exist");
			}
		}

	}// end of main method class

	
	/** this method is for the creation of account. the parameters take in the integer value of account
	 * and the user input. this is a static return method that belongs to the class itself which returns the Account object
	 * @param account an integer type 
	 * @param input Text Scanner
	 * @return Account object */
	public static Account accountCreate(int account, Scanner input) {

		String firstName; // string type for first name and last name
		String lastName;

		int month; // integer type for month and day
		int day;
		
		System.out.println("Enter Account Holder Information");
		// this prompts the user to enter their first and last name for each account number
		System.out.println("Enter First Name for " + account + ": ");
		input.nextLine(); // this is created so when the user creates the second and third account, it wont skip over first name to last name
		firstName = input.nextLine(); //user must input a string text here

		System.out.println("Enter Last Name: " + account + ": ");
		lastName = input.nextLine();
		
		
		/* The do-while loop is used for the month and day validation
		 *  The condition for month is that the number must be greater than 1 or less than 12
		 *  if its neither, it will display the prompt again until the user inputs the right number
		 *  
		 * The same applies for day condition. the number has to be greater than one and less than 31
		 * */
		
		do {// month validation
			
			// code block to be executed
			System.out.println("Enter month of birth: ");
			month = input.nextInt();
			
		} while (month < 1 || month > 12); // input is less than 1 and greater than 12 then execute the month prompt again until user inputs the correct condition

		
		do {// date validation
			
			System.out.println("Enter day of birth: ");
			day = input.nextInt();
			
		} while (day < 1 || day > 31); // input is less than 1 and greater than 21 then execute the day prompt again until user inputs the correct condition

		
		/*The user can input any number for year. there is no condition set.*/
		// any year of user input
		System.out.println("Enter year of birth: ");
		int year = input.nextInt();
		input.nextLine(); // this code is placed here to clear out the buffer

		
		// this creates a LocalDate object for the date of birth
		LocalDate dob = LocalDate.of(year, month, day);
		

		/* Do-while loop is used for ID validation.
		 * An ID is considered valid if it is between 11111 and 9999 inclusive.
		 */
		int accountID;
		do {// account ID Validation
			System.out.println("Enter an ID:");
			accountID = input.nextInt();
			
		} while (accountID < 1111 || accountID > 9999);
			
		
		/* there is no condition set for account balance. 
		 * the user can put any values and it can be whole or decimal numbers
		 * */
		System.out.println("Enter account initial balance: ");
		double balance = input.nextDouble();
		
		
		// this creates a Person object for user's identification
		Person person = new Person(firstName, lastName, dob);
		
		/* this creates an Account object which stores the user's input 
		 * for account ID, balance, identification, and the current date when the account is created
		 */
		Account accountNum = new Account(accountID, balance, person, LocalDate.now());
		

		System.out.print("Account Holder Information \n");
		accountNum.displayAccountDetails(); //displays account details

		return accountNum; // Account object is returned in the variable accountNum
 
	}// end of accountCreate method

	
	/**AtmMenu method is created to display the menu options and calculations of account balance.
	 * this is a static void method that belongs to the class itself.
	 * this method takes the Account object in its parameters and Scanner input. 
	 * 
	 * @param account Account object
	 * @param input Text Scanner */
	public static void atmMenu(Account account, Scanner input) {
		
		boolean exit = false;// boolean is set to false
		
		
		/* while and switch loop is used for the menu of the ATM, computation of the balance,
		 * and the account details.
		 * The condition is that if it is not false, prompt the main menu details.
		 * When the user enters one of the 5 options, it will prompt the balance, withdrawal, deposit
		 * and account details. when the user picks the 5th option then it will display "Goodbye" 
		 * and it will exit the ATM Menu.
		 * */
		while (!exit) {// when the condition is not FALSE, execute the prompt below
			System.out.println("MAIN MENU");
			System.out.println("1: Check Balance" + "\n" + "2: Withdraw" + "\n" + "3: Deposit" + "\n"
					+ "4: Account Details" + "\n" + "5: EXIT" + "\n" + "Enter a choice");

			int choice = input.nextInt();
			input.nextLine();

			switch (choice) {// condition is set to choice so when the user inputs one of the 5 options, it will prompt the options below

			case 1:
				System.out.println("The balance is $" + account.getBalance()); // "getBalance()" gets the balance that was initially set by the user when creating an account
				break;
			
			case 2:
				System.out.println("Enter the withdrawal amount: $");
				double withdrawAmount = input.nextDouble();
				account.calculateWithdraw(withdrawAmount); // amount is subtracted from the user input and the new balance is set.
				break;
			
			case 3:
				System.out.println("Enter despoit amount: $");
				double depositAmount = input.nextDouble();
				account.calculateDeposit(depositAmount); // amount is added from the user input and the new balance is set.
				break;

			case 4:
				System.out.println("Account Details: ");
				account.displayAccountDetails(); // Displays person details and new account details 
				break;
			
			case 5:

				System.out.println("Goodbye ");

				break;
			}
				//exit= true;// end of atm menu. it wont prompt again
		}

	}// end of atmMenu method

}// end of class ATMMachine

	
	
	
	
	
	

