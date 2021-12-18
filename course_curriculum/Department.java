/**
 * Nov 28, 2020
 * FA2020 CSC2650 OOP - Java
 * Tuesday|Thursday 3:15 - 5:00PM
 * @author Nicholas Boes
 */
package course_curriculum;

public class Department extends School{
	//Variable
	private String department;
	
	//Constructor
	public Department(String school, String department) {
		super(school);
		this.department = department;
	}
	
	//Getters and Setters
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	//toString (add on)
	public String toString() {
		String secondString;
		secondString = super.toString() + "\nDepartment: " + department;
		return secondString;
	}
}
