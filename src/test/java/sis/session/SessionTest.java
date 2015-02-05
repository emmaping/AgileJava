package sis.session;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import sis.studentinfo.Student;

public abstract class SessionTest {
	private Session session;
	LocalDate startDate ;
	@Before
	public void setUp() {
		startDate = LocalDate.of(2014, 3, 16);
		session = createSession("ENGL","101", startDate);
	}

	@Test
	public void testCreate() {		
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
	}
	@Test
	public void testCreateCourseSession(){
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(startDate, session.getStartDate());
	}
	
	@Test
	public void testEnrollStudents(){

		Student student1 = new Student("Cain Divoe");
		session.enroll(student1);
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		
		Student student2 = new Student("Test Monkey");
		session.enroll(student2);
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
	}
	protected abstract Session createSession(String department, String number, LocalDate startData) ;

}