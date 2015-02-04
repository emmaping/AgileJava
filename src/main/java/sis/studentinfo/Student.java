package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private int credits = 0;
	private String state ="";
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "OR";
	private List<Grade> grades = new ArrayList<>();
	private GradingStrategy gradingStrategy;
	enum Grade {A,B,C,D,F};
	
	public Student(String name){
		this.name = name ;
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
}
