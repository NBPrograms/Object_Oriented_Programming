/**
 * Nov 28, 2020
 * FA2020 CSC2650 OOP - Java
 * Tuesday|Thursday 3:15 - 5:00PM
 * @author Nicholas Boes
 */
package course_curriculum;

public class School {
	//Variable
	private String school;
	
	//Constructor
	public School(String school) {
		this.school = school;
	}
	
	//Getters and Setters
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	//toString
	public String toString() {
		String firstString;
		firstString = "\n------COURSE INFORMATION------\nSchool: " + school;
		return firstString;
	}
}
