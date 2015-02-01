package sis.report;

import sis.studentinfo.CourseSession;
import sis.studentinfo.Student;

public class RosterReporter {
	private CourseSession session;
	public RosterReporter(CourseSession session) {
		this.session = session;
	}
	
	String getReport() {
		StringBuilder builder = new StringBuilder();
		writeHeader(builder);
		writeBody(builder);
		writeFooter(builder);
		return builder.toString();
	}
	
	void writeHeader(StringBuilder builder){
		builder.append(CourseSession.ROSTER_REPORT_HEADER);
	}
	
	void writeBody(StringBuilder builder){
		int size = session.getNumberOfStudents();
		for (int i=0; i<size; i++){
			Student student = session.get(i);
			builder.append(student.getName());
			builder.append(CourseSession.NEWLINE);
		}
	}
	
	void writeFooter(StringBuilder builder){
		builder.append(CourseSession.ROSTER_REPORT_FOOTER + session.getNumberOfStudents() + CourseSession.NEWLINE);
	}

}
