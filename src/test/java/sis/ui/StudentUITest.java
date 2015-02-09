package sis.ui;

import static org.junit.Assert.*;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sis.studentinfo.Student;

public class StudentUITest {
	static private final String name = "coco lin";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateStudent() throws IOException {
		StringBuilder expectedOutput = new StringBuilder();
		StringBuilder input = new StringBuilder();
		setup(expectedOutput, input);
		byte[] buffer = input.toString().getBytes();
		
		InputStream inputStream = new ByteArrayInputStream(buffer);	
		OutputStream outputStream = new ByteArrayOutputStream();

		InputStream consoleIn = System.in;
		PrintStream consoleOut = System.out;
		
		System.setIn(inputStream);
		System.setOut(new PrintStream(outputStream));
		
		try{
			StudentUI ui = new StudentUI();
			ui.run();
			assertEquals(expectedOutput.toString(), outputStream.toString());
			assertStudents(ui.getAddedStudents());}
		finally {
			System.setIn(consoleIn);
			System.setOut(consoleOut);
		}
	}
	
	private String line(String input){
		return String.format("%s%n", input);
	}
	
	private void setup(StringBuilder expectedOutput, StringBuilder input){
		expectedOutput.append(StudentUI.MENU);
		input.append(line(StudentUI.ADD_OPTION));
		expectedOutput.append(StudentUI.NAME_PROMPT);
		input.append(line(name));
		expectedOutput.append(line(StudentUI.ADDED_MESSAGE));
		expectedOutput.append(StudentUI.MENU);
		input.append(line(StudentUI.QUIT_OPTION));
	}
	
	private void assertStudents(List<Student> students){
		assertEquals(1, students.size());
		Student student = students.get(0);
		assertEquals(name, student.getName());
	}

}
