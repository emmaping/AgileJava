package sis.studentinfo;

import java.util.HashMap;
import java.util.Map;

public class StudentDirectory {
	private Map<String, Student> students = new HashMap<String, Student>();
	public void  add(Student student) {
		students.put(student.getName(), student);
	}
	
	public Student findByName(String name) {
		return students.get(name);
	}

}
