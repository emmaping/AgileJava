package sis.studentinfo;
import static org.junit.Assert.*;

import org.junit.Test;

import sis.studentinfo.Student;

//import org.junit.Test;

public class StudentTest{
	final String firStudentNameString = "Jane Doe";
	final String secStudentNameString = "Joe Doe";
	private static final double GRADE_TOLERANCE = 0.05;
	@Test
	public void testCreate(){	
		Student firStudent = new Student(firStudentNameString);
		assertEquals(firStudentNameString, firStudent.getName());
		
		Student secStudent = new Student(secStudentNameString);
		assertEquals(secStudentNameString, secStudent.getName());
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
	public void testRegularGradingStrategy(){
		Student student = new Student("a");
		student.setGradingStrategy(new RegularGradingStrategy());
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
	public void HonorsGradingStrategy(){
		Student student = new Student("b");
		student.setGradingStrategy(new HonorsGradingStrategy());
		assertGpa(student, 0.0);
		student.addGrade(Student.Grade.A);
		assertGpa(student, 4.0);;
		student.addGrade(Student.Grade.B);
		assertGpa(student, 3.5);;
		student.addGrade(Student.Grade.C);
		assertGpa(student, 3.0);;
		student.addGrade(Student.Grade.D);
		assertGpa(student, 2.5);;
		student.addGrade(Student.Grade.F);
		assertGpa(student, 2.0);;
	}
	private void assertGpa(Student student, double expectedGpa){
		assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
	}
}
