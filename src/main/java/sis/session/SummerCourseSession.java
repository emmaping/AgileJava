package sis.session;

import sis.studentinfo.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SummerCourseSession extends Session {
	private SummerCourseSession(String department, String number, LocalDate startDate) {
		super(department, number, startDate);
	}
	public static Session createSession(String department, String number, LocalDate startDate) {
		return new SummerCourseSession(department, number, startDate);
	}
	
	@Override
	protected int getSessionLength() {
		return 2;
	}
}
