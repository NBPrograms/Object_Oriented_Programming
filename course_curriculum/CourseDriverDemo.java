/**
 * Nov 28, 2020
 * FA2020 CSC2650 OOP - Java
 * Tuesday|Thursday 3:15 - 5:00PM
 * @author Nicholas Boes
 */
package course_curriculum;

public class CourseDriverDemo {
	
	public static void main(String[] args) {
		//Courses in curriculum
		Course course01 = new Course("Dunham School of Business", "Business", "Business Communication", 
				"BUS-1200", "Learning to communication in a business professional setting");
		
		Course course02 = new Course("Dunham School of Business", "Computer Science", "Object Oriented Programming", 
				"CSC-2660", "Learning the basics of OOP within the Java framework");
		
		Course course03 = new Course("Dunham School of Business", "Finance", "Principles of Finance", 
				"FIN-3400", "Learning the basics of corporate finance and the time value of money");
		
		//Prints courses
		System.out.println(course01);
		System.out.println(course02);
		System.out.println(course03);
	}

}
