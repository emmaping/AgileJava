package sis.session;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sis.session.CourseSession;
import sis.studentinfo.Student;


public class CourseSessionTest extends SessionTest {

	
	@Test
	public void testCourseDates(){
		LocalDate startDate = LocalDate.of(2014, 1, 6);
		
		Session sessionWithDateCourseSession = createSession("ABCD", "103", startDate);
		LocalDate endDate = LocalDate.of(2014, 7, 6);
		assertEquals(endDate, sessionWithDateCourseSession.getEndDate());
	}
	
	protected Session createSession(String department, String number, LocalDate startData) {
		
		return CourseSession.createSession(department, number, startData);
	}

}
