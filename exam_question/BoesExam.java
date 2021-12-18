/**
 * Nov 25, 2020
 * FA2020 CSC2650 OOP - Java
 * Tuesday|Thursday 3:15 - 5:00PM
 * @author Nicholas Boes
 */
package exam_question;

import java.util.Scanner;

public class BoesExam {
	//Variables
	private String question, answer, user_answer; 
	int result;
	
	//Empty Constructor
	public BoesExam() {}
	
	//Constructor
	public BoesExam(String question, String answer, String user_answer, int result) {
		this.question = question;
		this.answer = answer;
		this.user_answer = user_answer;
		this.result = result;
	}
	
	//Getters and Setters
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getUser_answer() {
		return user_answer;
	}

	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	//toString
	@Override
	public String toString() {
		return "BoesExam [question=" + question + ", answer=" + answer + ", user_answer=" + user_answer + ", result="
				+ result + "]";
	}
	
	//Add method
	public void add_question(int q_num) {
		//Scanner takes in question and answer input
		Scanner input_QandA = new Scanner(System.in);
		
		System.out.println("\nQuestion " + (q_num + 1) + " - Please write the question:");
		question = input_QandA.nextLine();
		
		System.out.println("\nQuestion " + (q_num + 1) + " - Please write the answer:");
		answer = input_QandA.nextLine();
	}
	
	//Assign method
	public void assign_exam(BoesExam question, int count) {
		//Scanner takes in user answer
		Scanner input_answer = new Scanner(System.in);
		
		System.out.println("\nQuestion " + (count + 1) + ": " + question.getQuestion() + "\nAnswer:");
		user_answer = input_answer.nextLine();
		
		//Checks results
		if (user_answer.equalsIgnoreCase(answer)) {
			result = 1;
		}
		else {
			result = 0;
		}
	}
}