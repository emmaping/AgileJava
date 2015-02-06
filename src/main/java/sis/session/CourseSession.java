package sis.session;
import java.util.List;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.IntToLongFunction;

import org.omg.CORBA.PUBLIC_MEMBER;

import sis.studentinfo.Course;
import sis.studentinfo.Student;


/**
 * Provides a representation of a single-semester
 * session of a specific university course
 * @author Emma_Ping
 *
 */
public class CourseSession extends Session{
	
	
	/**
	 * Constructs a CourseSession starting on a specific date
	 * @param department
	 * @param number
	 * @param startDate the date on which the CourseSession begins
	 */
	public CourseSession(Course course, LocalDate startDate) {
		super(course, startDate);
	}
	
	public static CourseSession createSession(Course course, LocalDate startDate){
		
		return new CourseSession(course, startDate);
		
	}
	
	
	protected int getSessionLength() {
		return 6;
	}

}
