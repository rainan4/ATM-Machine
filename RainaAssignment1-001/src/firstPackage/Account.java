package firstPackage;

import java.time.LocalDate;

/** 
 * public is an access modifier and Account class can be access in other classes
 * 
 * 
 * */
public class Account {

	/** these are the four data fields:
	 *  - accountID uses integer type
	 *  - balance uses double type
	 *  - person is used from the class Person to grab the user's firstname, lastname and date of birth
	 *  - accountDate uses LocalDate for when the account is created */
	
	private int accountID;
	private double balance;
	private Person person;
	private LocalDate accountDate;

	
	/** this is the default constructor which takes no parameters */
	public Account() {
		// this initializes the account with the current date when it's created
		accountDate = LocalDate.now();
	}

	/** this is the second constructor that accepts parameters for all fields
	 * @param accountID
	 * an integer type
	 * @param balance
	 * a double type
	 * @param person
	 * Person object class
	 * @param accountDate
	 * LocalDate object */
	public Account(int accountID, double balance, Person person, LocalDate accountDate) {
		// "this" is used because the constructor contains parameters with the same name
		// each data field is initialized 
		this.accountID = accountID;
		this.balance = balance;
		this.person = person;
		this.accountDate = LocalDate.now();
		

	}

	/**The set method is created to set the value of the variable and the get method returns the variable value.
	 * The get and set methods is used to access and update the value of a private variable
	 * 
	 * @param accountID
	 * an integer type */
	// Set method for accountID
	public void setAccountID(int accountID) {
		this.accountID = accountID;

	}

	// Get method for accountID
	/**
	 * @return accountID returns account id*/
	public int getAccountID() {

		return accountID;

	}

	// Set method for balance
	/**
	 * @param balance double type
	 * */
	public void setBalance(double balance) {

		this.balance = balance;
	}

	// Get method for balance
	/**
	 * @return balance returns balance
	 * */
	public double getBalance() {

		return balance;

	}

	// Set method for person
	/**
	 * @param person Person object
	 * */
	public void setPerson(Person person) {

		this.person = person;

	}

	// Get method for person
	
	/**
	 * @return person returns person
	 * 
	 * */
	public Person getPerson() {

		return person;

	}

	/**a void method "withdraw" that withdraws a specified amount from the account.
	 * calculateWithdraw takes amount in its parameters and when the user inputs a number to withdraw,
	 * the withdrawal amount is calculated
	 * @param amount double type*/

	public void calculateWithdraw(double amount) {
		// user enters amount to withdraw
		// balance minus the amount entered to get the withdrawal
		balance -= amount;
		System.out.println("Amount withdrawn: $" + amount);

	}

	/** a void deposit method that adds the amount to the account balance
	 * @param amount double type */
	public void calculateDeposit(double amount) {
		// users enters the amount to deposit
		// deposit amount adds to the balance
		balance += amount;
		System.out.println("Amount deposited: $" + amount);
	}

	/** void display method to display all account details including person details */
	public void displayAccountDetails() {
		
		person.displayPersonDetails(); // this displays the person details from the Person class
		System.out.println("Account ID: " + accountID + "\n" + "Account balance: " + balance + "\n" + "Date created: "
				+ accountDate + "\n");

	}

}
