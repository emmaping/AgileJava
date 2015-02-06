package sis.session;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sis.session.CourseSession;
import sis.studentinfo.Course;
import sis.studentinfo.Student;


public class CourseSessionTest extends SessionTest {

	
	@Test
	public void testCourseDates(){
		LocalDate startDate = LocalDate.of(2014, 1, 6);
		Course course = new Course("ABCD", "103");
		
		Session sessionWithDateCourseSession = createSession(course, startDate);
		LocalDate endDate = LocalDate.of(2014, 7, 6);
		assertEquals(endDate, sessionWithDateCourseSession.getEndDate());
	}
	
	protected Session createSession(Course course, LocalDate startData) {
		
		return CourseSession.createSession(course, startData);
	}

}
