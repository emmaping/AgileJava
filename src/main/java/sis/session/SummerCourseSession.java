package sis.session;

import sis.studentinfo.Course;
import sis.studentinfo.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SummerCourseSession extends Session {
	private SummerCourseSession(Course course, LocalDate startDate) {
		super(course, startDate);
	}
	public static Session createSession(Course course, LocalDate startDate) {
		return new SummerCourseSession(course, startDate);
	}
	
	@Override
	protected int getSessionLength() {
		return 2;
	}
}
