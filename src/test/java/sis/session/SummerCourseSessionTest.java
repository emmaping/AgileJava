package sis.session;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import sis.session.SummerCourseSession;
import sis.studentinfo.Course;

public class SummerCourseSessionTest extends SessionTest{


	@Test
	public void testgetEndDate(){
		LocalDate startDate = LocalDate.of(2014, 1, 16);
		
		Session sessionWithDateCourseSession = createSession(new Course("ABCD", "103"), startDate);
		LocalDate endDate = LocalDate.of(2014, 3, 16);
		assertEquals(endDate, sessionWithDateCourseSession.getEndDate());
		assertEquals("ABCD", sessionWithDateCourseSession.getDepartment());
	}
	protected Session createSession(Course course, LocalDate startData) {
		
		return SummerCourseSession.createSession(course, startData);
	}

}
