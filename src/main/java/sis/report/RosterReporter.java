package sis.report;

import sis.session.Session;
import static sis.report.ReportConstant.NEWLINE;
import sis.studentinfo.Student;

import java.io.*;

public class RosterReporter {
	private Session session;
	private Writer writer;
	public RosterReporter(Session session) {
		this.session = session;
	}
	
	void writeReport(Writer writer) throws IOException{
		this.writer = writer;
		writeHeader();
		writeBody();
		writeFooter();
	}
	
	void writeReport(String filename) throws IOException{
		Writer writer = new BufferedWriter(new FileWriter(filename));
		try{
			writeReport(writer);
		}
		finally{
			writer.close();
		}
	}
	
	String getReport() {
		StringBuilder builder = new StringBuilder();
		writeHeader(builder);
		writeBody(builder);
		writeFooter(builder);
		return builder.toString();
	}
	
	void writeHeader(StringBuilder builder){
		builder.append(Session.ROSTER_REPORT_HEADER);
	}
	
	void writeHeader()throws IOException{
		writer.write(String.format(Session.ROSTER_REPORT_HEADER));
	}
	
	void writeBody(StringBuilder builder){
		int size = session.getNumberOfStudents();
		for (int i=0; i<size; i++){
			Student student = session.get(i);
			builder.append(student.getName());
			builder.append(NEWLINE);
		}
	}
	
	void writeBody() throws IOException{
		int size = session.getNumberOfStudents();
		for (int i=0; i<size; i++){
			Student student = session.get(i);
			writer.write(String.format(student.getName() + "%n"));
		}
	}
	
	void writeFooter(StringBuilder builder){
		builder.append(Session.ROSTER_REPORT_FOOTER + session.getNumberOfStudents() + NEWLINE);
	}
	
	void writeFooter() throws IOException{
		writer.write(String.format(Session.ROSTER_REPORT_FOOTER , session.getNumberOfStudents()));
	}

}
