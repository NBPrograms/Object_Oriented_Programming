/**
 * Nov 25, 2020
 * FA2020 CSC2650 OOP - Java
 * Tuesday|Thursday 3:15 - 5:00PM
 * @author Nicholas Boes
 */
package exam_question;

import java.text.NumberFormat;

public class BoesExamTime {

	public static void main(String[] args) {
		//Creates exam objects and percent format
		BoesExam[] exam = new BoesExam[25];
		NumberFormat percFormat = NumberFormat.getPercentInstance();
		
		//Variables
		int count = 0, correct = 0;
		double score;
		
		System.out.println("Please input your exam questions");
		
		//Adds questions to exam
		for (count = 0; count < exam.length; count++) {
			exam[count] = new BoesExam();
			exam[count].add_question(count);
		}
		
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("-----------------------------------------------------------");
		System.out.println("---------------------EXAM IS BEGINNING---------------------");
		System.out.println("-----------------------------------------------------------");
		System.out.println("-----------------------------------------------------------");
		
		//User answers and results are recorded
		count = 0;
		for (BoesExam question: exam) {
			question.assign_exam(question, count);
			correct += question.getResult();
			count++;
		}
		
		//Score is calculated
		score = (double) correct/count;
		System.out.println("\nYour Score: " + percFormat.format(score));
	}
}
