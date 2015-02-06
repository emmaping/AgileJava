package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import exceptions.StudentNameFormatException;
import java.util.logging.*;

public class Student {
	private String name;
	private int credits = 0;
	private String state ="";
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "OR";
	private List<Grade> grades = new ArrayList<>();
	private GradingStrategy gradingStrategy;
	static final int maxNameParts = 3;
	static final String TOO_MANY_NAME_PART_MSG = "Student name '%s' contains more than %d parts";
	static final Logger logger = Logger.getLogger(Student.class.getName());
	public static enum Grade {
		A(4),
		B(3),
		C(2),
		D(1),
		F(0);
		private int points;
		private Grade(int points) {
			this.points = points;
		}
		int getPoints(){
			return points;
		}
	};
	
	private String firstName = "";
	private String lastName = "";
	private String middleName = "";
	
	public Student(String fullName){
		this.name = fullName ;
		this.gradingStrategy = new BasicGradingStrategy();
		SplitName(fullName);
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public boolean isFullTime(){
		return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
	}

	public int getCredits() {
		return credits;
	}

	public void addCredits(int credits) {
		this.credits += credits;
	}
	
	public boolean isInState(){
		return state.equals(Student.IN_STATE);
	}
	
	public void setState(String state){
		this.state = state;
	}

	public void addGrade(Grade grade){
		grades.add(grade);
	}
	
	public double getGpa(){
		
		double total = 0.0;
		if (grades.isEmpty()) return total;
		for (Grade grade : grades){
			total += gradingStrategy.getGradePointsFor(grade);
		}
		return total / grades.size();
		
	}
	
	public void setGradingStrategy(GradingStrategy gradingStrategy){
		this.gradingStrategy = gradingStrategy;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	private void SplitName(String fullName) {
		String[] nameParts = fullName.split(" ");
		if (nameParts.length > maxNameParts){
			String message = String.format(TOO_MANY_NAME_PART_MSG, fullName, maxNameParts);
			log(message);
			throw new StudentNameFormatException(message);
		}
		if(nameParts.length == 1){
			setLastName(nameParts[0]);
		}
		else if (nameParts.length == 2) {
			setFirstName(nameParts[0]);
			setLastName(nameParts[1]);
		}
		else if (nameParts.length == 3) {
			setFirstName(nameParts[0]);
			setMiddleName(nameParts[1]);
			setLastName(nameParts[2]);
		}
	}
	private void log(String message) {
		
		logger.info(message);
	}
}

