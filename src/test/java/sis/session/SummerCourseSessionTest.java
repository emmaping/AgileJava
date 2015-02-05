package sis.session;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import sis.session.SummerCourseSession;

public class SummerCourseSessionTest extends SessionTest{


	@Test
	public void testgetEndDate(){
		LocalDate startDate = LocalDate.of(2014, 1, 16);
		
		Session sessionWithDateCourseSession = createSession("ABCD", "103", startDate);
		LocalDate endDate = LocalDate.of(2014, 3, 16);
		assertEquals(endDate, sessionWithDateCourseSession.getEndDate());
		assertEquals("ABCD", sessionWithDateCourseSession.getDepartment());
	}
	protected Session createSession(String department, String number, LocalDate startData) {
		
		return SummerCourseSession.createSession(department, number, startData);
	}

}
