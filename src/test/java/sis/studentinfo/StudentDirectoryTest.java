package sis.studentinfo;

import static org.junit.Assert.*;

import java.io.*;

import sis.studentinfo.Student;

import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.aop.ThrowsAdvice;

public class StudentDirectoryTest {
	private StudentDirectory dir;
	static final int numberOfStudents = 10;

	@Before
	public void setUp() throws IOException {
		dir = new StudentDirectory();
	}
	@After
	public void tearDown() throws IOException{
		dir.close();
		dir.remove();
	}

	@Test
	public void testStoreAndRetrieve() throws IOException{
		Student student1 = new Student("emm ping");
		StudentDirectory directory = new StudentDirectory();
		directory.add(student1);
		assertTrue(student1.equals(directory.findByName("emm ping")));
	}
	
	@Test
	public void testRandomAccess() throws IOException{
		for (int i = 0; i< numberOfStudents; i++){
			addStudent(dir, i);;
		}
		dir.close();
		
		dir = new StudentDirectory();
		for (int i = 0; i<numberOfStudents; i++){
			verifyStudentLookup(dir,i);
		}
	}
	
	void addStudent(StudentDirectory dir, int i) throws IOException{
		Student student = new Student(Integer.toString(i));
		student.addCredits(i);
		dir.add(student);
	}
	
	void verifyStudentLookup(StudentDirectory dir, int i) throws IOException{
		String name = Integer.toString(i);
		Student student = dir.findByName(name);
		assertEquals(name, student.getName());
		assertEquals(name, student.getLastName());
		assertEquals(i, student.getCredits());
	}
}
