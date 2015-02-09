package sis.studentinfo;

import java.util.HashMap;
import java.io.*;
import java.util.Map;
import sis.db.*;

public class StudentDirectory {
	private static final String DIR_BASENAME = "studentdir";
	private DataFile db;
	
	public StudentDirectory() throws IOException{
		db = DataFile.open(DIR_BASENAME);
	}
	
	public void  add(Student student) throws IOException {
		db.add(student.getName(), student);
	}
	
	public Student findByName(String name) throws IOException {
		return (Student)db.findBy(name);
	}
	
	public void close() throws IOException {
		db.close();
	}
	
	public void remove() {
		db.deleteFiles();
	}

}
