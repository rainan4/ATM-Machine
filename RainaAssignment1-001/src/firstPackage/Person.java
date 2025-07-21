package firstPackage;

import java.time.LocalDate;

/**
 * public is an access modifier and Person class can be access in other classes
 * 
 * */
public class Person {

	/** These are the three data types for the class Person 
	 * which contains string type for first name and last name.
	 * LocalDate is used for the date of birth
	 * */
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	

	/** This class contains one constructor that accepts parameters for firstname,lastname, and date of birth (LocalDate)
	 * @param firstName string type
	 * @param lastName string type
	 * @param dateOfBirth LocalDate type
	 * 
	 * */
	public Person(String firstName, String lastName, LocalDate dateOfBirth) {
	// "this" is used because the constructor contains parameters with the same name
		// each data field is initialized
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;

	}

	/**the three getter methods is created to allow access to the private fields in the Person class. 
	 * Get method for first name which is a String type 
	 * @return firstName returns the first name
	 * */
	public String getFirstName() {
		// the get method returns the variable value for each fields
		return firstName;
	}

	// Get method for lastname which is a String type
	/**
	 * @return lastName returns the last name*/
	public String getLastName() {

		return lastName;

	}

	// Get method for date of birth which is a LocalDate type
	
	/**
	 * @return dateOfBirth returns date of birth
	 * */
	public LocalDate getDateofBirth() {

		return dateOfBirth;
	}

	

	/** this non static void method is created to display a person's detail that prints out the prompt for three fields */
	public void displayPersonDetails() {
		// this displays the first name, last name, and date of birth of the person
		System.out.println("Enter First name: " + firstName);
		System.out.println("Enter Last name: " + lastName);
		System.out.println("Enter Date of birth: " + dateOfBirth);

	}

}
