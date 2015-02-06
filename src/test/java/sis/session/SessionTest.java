package sis.session;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Cause;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import exceptions.SessionException;
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
	
	@Test
	public void testIterate(){
		Student student1 = new Student("Cain Divoe");
		session.enroll(student1);
		
		Student student2 = new Student("Test Monkey");
		session.enroll(student2);
		
		Student student3 = new Student("Dev Donkey");
		session.enroll(student3);
		
		List<Student> resultStudents = new ArrayList<Student>();
		
		for(Student student:session){
			resultStudents.add(student);
		}
		assertEquals(resultStudents, session.getAllStudents());
	}
	
	@Test
	public void testSessionUrl() throws SessionException{
		final String urlString = "http://www.google.com";
		session.setUrl(urlString);
		assertEquals(urlString, session.getUrl().toString());
	}
	
	@Test
	public void testInvalidSessionUrl(){
		final String urlString = "httap://www.google.com";
		try{
			session.setUrl(urlString);
			fail("Expected exception due to invalid protocaol in URL");
		}
		catch(SessionException e){
			Throwable cause = e.getCause();
			assertEquals(MalformedURLException.class, cause.getClass());
		}
	}
	protected abstract Session createSession(String department, String number, LocalDate startData) ;

}
