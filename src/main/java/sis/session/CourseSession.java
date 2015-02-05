package sis.session;
import java.util.List;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.IntToLongFunction;

import org.omg.CORBA.PUBLIC_MEMBER;

import sis.studentinfo.Student;


/**
 * Provides a representation of a single-semester
 * session of a specific university course
 * @author Emma_Ping
 *
 */
public class CourseSession extends Session implements Comparable<CourseSession>{
	
	
	/**
	 * Constructs a CourseSession starting on a specific date
	 * @param department
	 * @param number
	 * @param startDate the date on which the CourseSession begins
	 */
	public CourseSession(String department, String number, LocalDate startDate) {
		super(department, number, startDate);
	}
	
	private CourseSession createCourseSession(){
		LocalDate startDate = LocalDate.of(2014, 1, 1);
		return CourseSession.createSession("ENGL", "101", startDate);
	}
	
	public static CourseSession createSession(String department, String number, LocalDate startDate){
		return new CourseSession(department, number, startDate);
		
	}
	
	
	protected int getSessionLength() {
		return 6;
	}


}
