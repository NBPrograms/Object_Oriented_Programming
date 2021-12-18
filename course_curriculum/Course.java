/**
 * Nov 28, 2020
 * FA2020 CSC2650 OOP - Java
 * Tuesday|Thursday 3:15 - 5:00PM
 * @author Nicholas Boes
 */
package course_curriculum;

public class Course extends Department{
	//Variables
	private String title, number, description;
	
	//Constructors
	public Course(String school, String department, String title, String number, String description) {
		super(school, department);
		this.title = title;
		this.number = number;
		this.description = description;
	}
	
	//Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	//toString (add on)
	public String toString() {
		String thirdString;
		thirdString = super.toString() + "\nTitle: " + title + "\nNumber: "
				+ number + "\nDescription: " + description;
		return thirdString;
	}
}
