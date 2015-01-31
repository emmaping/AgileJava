package studentinfo;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Provides a representation of a single-semester
 * session of a specific university course
 * @author Emma_Ping
 *
 */
public class CourseSession {
	private String department;
	private String number;
	private List<Student> allStudents = new ArrayList<>();
	private LocalDate startDate;
	
	public CourseSession(String department, String number) {
		this.department = department;
		this.number = number;
	}
	/**
	 * Constructs a CourseSession starting on a specific date
	 * @param department
	 * @param number
	 * @param startDate the date on which the CourseSession begins
	 */
	public CourseSession(String department, String number, LocalDate startDate) {
		this(department, number);
		this.startDate = startDate;
		
	}
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	int getNumberOfStudents(){
		return allStudents.size();
	}
	
	void enroll(Student student){
		allStudents.add(student);
	}
	
	Student get(int index){
		return allStudents.get(index);
	}
	/**
	 * 
	 * @return Date the last date of the course session
	 */
	LocalDate getEndDate(){
		return startDate.withMonth((startDate.getMonthValue() + 5) % 12);
	}
	

}
