package studentinfo;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class CourseSessionTest {
	private CourseSession session;
	@Before
	public void setUp() {
		session = new CourseSession("ENGL","101");
	}

	@Test
	public void testCreate() {
		
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
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
	public void testCourseDates(){
		LocalDate startDate = LocalDate.of(2014, 1, 6);
		
		CourseSession sessionWithDateCourseSession = new CourseSession("ABCD", "103", startDate);
		LocalDate endDate = LocalDate.of(2014, 6, 6);
		assertEquals(endDate, sessionWithDateCourseSession.getEndDate());
	}

}
