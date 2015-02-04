package sis.report;

import java.util.*;

import sis.studentinfo.*;
import static sis.report.ReportConstant.NEWLINE;

public class CourseReport {
	private List<CourseSession> sessions = new ArrayList<CourseSession>();
	public void add(CourseSession session) {
		sessions.add(session);
		Collections.sort(sessions);
	}
	
	public String text() {
		StringBuilder builder = new StringBuilder();
		for (CourseSession session: sessions){
			builder.append(
					session.getDepartment() + " " +
					session.getNumber() + NEWLINE);
		}
		return builder.toString();
		
	}
	

}
