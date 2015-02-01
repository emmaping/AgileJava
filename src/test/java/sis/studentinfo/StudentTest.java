package sis.studentinfo;
import static org.junit.Assert.*;

import org.junit.Test;

import sis.studentinfo.Student;

//import org.junit.Test;

public class StudentTest{
	final String firStudentNameString = "Jane Doe";
	final String secStudentNameString = "Joe Doe";
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
	

}
