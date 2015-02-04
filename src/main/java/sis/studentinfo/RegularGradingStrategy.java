package sis.studentinfo;

import sis.studentinfo.Student.Grade;

public class RegularGradingStrategy implements GradingStrategy{
	public int getGradePointsFor(Student.Grade grade){
		if(grade == Grade.A){
			return 4;
		}
		if (grade == Grade.B){
			return 3;
		}
		if (grade == Grade.C){
			return 2;
		}
		if (grade == Grade.D){
			return 1;
		}
		return 0;
	}
}
