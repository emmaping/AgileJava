package sis.session;

import java.time.LocalDate;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exceptions.SessionException;
import sis.studentinfo.Student;

public abstract class Session implements Comparable<Session>, Iterable<Student>{

	private String department;
	private String number;
	private LocalDate startDate;
	private URL url;
	private List<Student> allStudents = new ArrayList<>();
	public final static String ROSTER_REPORT_HEADER = "I am header";
	public final static String ROSTER_REPORT_FOOTER = "I'm footer";
	
	public Session(String department, String number, LocalDate startDate) {
		super();
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}
	
	abstract protected int getSessionLength();
	
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
}
