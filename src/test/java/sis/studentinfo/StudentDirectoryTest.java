package sis.studentinfo;

import static org.junit.Assert.*;
import sis.studentinfo.Student;

import java.io.*;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;

public class StudentDirectoryTest {
	private StudentDirectory dir;

	@Before
	public void setUp() throws Exception {
		dir = new StudentDirectory();
	}

	@Test
	public void testStoreAndRetrieve() throws IOException{
		final int numberOfStudents = 10;
		Student student1 = new Student("emm ping");
		StudentDirectory directory = new StudentDirectory();
		directory.add(student1);
		assertEquals(student1, directory.findByName("emm ping"));
	}
}
