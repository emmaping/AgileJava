package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CourseTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCourse() {
		Course course = new Course("CMSC", "120");
		assertEquals("CMSC", course.getDepartment());
		assertEquals("120", course.getNumber());
	}
	
	@Test
	public void testEquality(){
		Course course1 = new Course("CMSC", "120");
		Course course2 = new Course("CMSC", "120");
		assertEquals(course1, course2);
		
		Course course3 = new Course("CCSC", "120");
		assertFalse(course1.equals(course3));
	}

}
