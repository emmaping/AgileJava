package sis.studentinfo;
import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import exceptions.StudentNameFormatException;
import sis.studentinfo.Student;

//import org.junit.Test;

public class StudentTest{
	final String firStudentNameString = "Jane Doe";
	final String secStudentNameString = "Joe Doe";
	final String thdStudentNameString = "Emma coco Ping";
	private static final double GRADE_TOLERANCE = 0.05;

	@Test
	public void testCreate(){	
		Student firStudent = new Student(firStudentNameString);
		assertEquals(firStudentNameString, firStudent.getName());
		assertEquals("Jane",firStudent.getFirstName());
		assertEquals("Doe", firStudent.getLastName());
		assertEquals("", firStudent.getMiddleName());
		
		Student secStudent = new Student(secStudentNameString);
		assertEquals(secStudentNameString, secStudent.getName());
		assertEquals("Joe", secStudent.getFirstName());
		assertEquals("Doe", secStudent.getLastName());
		assertEquals("", secStudent.getMiddleName());
		
		Student thdStudent = new Student(thdStudentNameString);
		assertEquals(thdStudentNameString, thdStudent.getName());
		assertEquals("Emma", thdStudent.getFirstName());
		assertEquals("Ping", thdStudent.getLastName());
		assertEquals("coco", thdStudent.getMiddleName());
	}
	
	@Test
	public void testBadlyFormattedName(){
		TestHandler handler = new TestHandler();
		Student.logger.addHandler(handler);
		try {
			new Student("a b c d");
			fail("Expected exception from 4 - part name");
		} catch (StudentNameFormatException e) {
			assertEquals(String.format(Student.TOO_MANY_NAME_PART_MSG, "a b c d", Student.maxNameParts), e.getMessage());
			assertTrue(wasLogged(e.getMessage(), handler));
		}
	}
	@Test
	public void testSet(){
		Student firStudent = new Student(firStudentNameString);
		assertEquals(firStudentNameString, firStudent.getName());

		firStudent.setName(secStudentNameString);
		assertEquals(secStudentNameString, firStudent.getName());
	}
	@Test
	public void testFullTime(){
		Student student = new Student("a");
		assertFalse(student.isFullTime());
		student.addCredits(12);
		assertTrue(student.isFullTime());
	}
	
	@Test
	public void testCredits(){
		Student student = new Student("a");
		assertEquals(0, student.getCredits());
		student.addCredits(3);
		assertEquals(3, student.getCredits());
		student.addCredits(4);
		assertEquals(7, student.getCredits());
	}
	
	@Test
	public void testInState(){
		Student student = new Student("b");
		assertFalse(student.isInState());
		student.setState(Student.IN_STATE);
		assertTrue(student.isInState());
		student.setState("MD");
		assertFalse(student.isInState());
	}
	
	@Test
	public void testGpaByGradingStrategy() {
		Student student = new Student("a");
		assertGpa(student, 0.0);
		student.addGrade(Student.Grade.A);
		assertGpa(student, 4.0);
		student.addGrade(Student.Grade.B);
		assertGpa(student, 3.5);
		student.addGrade(Student.Grade.C);
		assertGpa(student, 3.0);
		student.addGrade(Student.Grade.D);
		assertGpa(student, 2.5);
		student.addGrade(Student.Grade.F);
		assertGpa(student, 2.0);
	}

	@Test
	public void TestGpaByHonorsGradingStrategy(){
		Student student = new Student("b");
		student.setGradingStrategy(new HonorsGradingStrategy());
		assertGpa(student, 0.0);
		student.addGrade(Student.Grade.A);
		assertGpa(student, 5.0);
		student.addGrade(Student.Grade.B);
		assertGpa(student, 4.5);
		student.addGrade(Student.Grade.C);
		assertGpa(student, 4.0);
		student.addGrade(Student.Grade.D);
		assertGpa(student, 3.5);
		student.addGrade(Student.Grade.F);
		assertGpa(student, 2.8);
	}
	
	@Test
	public void testFlags(){
		Student student = new Student("a");
		student.set(Student.Flag.ON_CAMPUS,
				Student.Flag.TAX_EXEMPT,
				Student.Flag.MINOR);
		assertTrue(student.isOn(Student.Flag.ON_CAMPUS));
		assertTrue(student.isOn(Student.Flag.TAX_EXEMPT));
		assertTrue(student.isOn(Student.Flag.MINOR));
		
		assertFalse(student.isOff(Student.Flag.ON_CAMPUS));
		assertTrue(student.isOff(Student.Flag.TROUBLEMAKER));
		
		student.unset(Student.Flag.ON_CAMPUS);
		assertTrue(student.isOff(Student.Flag.ON_CAMPUS));
		assertTrue(student.isOn(Student.Flag.TAX_EXEMPT));
		assertTrue(student.isOn(Student.Flag.MINOR));
	}
	private void assertGpa(Student student, double expectedGpa){
		assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
	}
	
	private boolean wasLogged(String message, TestHandler handler) {
		return message.equals(handler.getMessage());
	}

}
