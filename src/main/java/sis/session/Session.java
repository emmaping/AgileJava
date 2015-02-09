package sis.session;

import java.time.LocalDate;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import antlr.JavaCodeGeneratorPrintWriterManager;
import exceptions.SessionException;
import sis.studentinfo.Course;
import sis.studentinfo.Student;

public abstract class Session implements Comparable<Session>, Iterable<Student>, java.io.Serializable{

	private Course course;
	private LocalDate startDate;
	private URL url;
	private int numberOfCredit;
	private transient List<Student> allStudents = new ArrayList<>();
	public final static String ROSTER_REPORT_HEADER = "Student %n - %n";
	public final static String ROSTER_REPORT_FOOTER = "%n# students = %d%n";
	
	public Session(Course course, LocalDate startDate) {
		super();
		this.course = course;
		this.startDate = startDate;
	}
	
	abstract protected int getSessionLength();
	
	public String getDepartment() {
		return course.getDepartment();
	}

	public String getNumber() {
		return course.getNumber();
	}

	
	public int getNumberOfCredit() {
		return numberOfCredit;
	}

	public void setNumberOfCredit(int numberOfCredit) {
		this.numberOfCredit = numberOfCredit;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	
	public int compareTo(Session that){
		return this.getDepartment().compareTo(that.getDepartment());
	}
	/**
	 * 
	 * @return Date the last date of the course session
	 */
	public LocalDate getEndDate(){
		return getStartDate().withMonth((getStartDate().getMonthValue() + getSessionLength()) % 12);
	}
	public int getNumberOfStudents(){
		return allStudents.size();
	}
	
	public void enroll(Student student){
		allStudents.add(student);
	}
	
	public Student get(int index){
		return allStudents.get(index);
	}
	
	protected List<Student> getAllStudents() {
		return this.allStudents;
	}
	
	public Iterator<Student> iterator() {
		return allStudents.iterator();
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(String urlString) throws SessionException{
		try{
			this.url = new URL(urlString);
		}
		catch (MalformedURLException e){
			log(e);
			throw new SessionException(e);
		}
	}
	private void log(Exception e) {
		e.printStackTrace();
		
	}
	
	private void writeObject(ObjectOutputStream outputStream) throws IOException{
		outputStream.defaultWriteObject();
		outputStream.writeInt(allStudents.size());
		for(Student student: allStudents){
			outputStream.writeObject(student.getLastName());;
		}
	}
	
	private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException{
		inputStream.defaultReadObject();
		allStudents = new ArrayList<Student>();
		int size = inputStream.readInt();
		for(int i=0; i< size; i++){
			String lastName = (String)inputStream.readObject();
			allStudents.add(Student.findByLastName(lastName));
		}
	}
	
}
