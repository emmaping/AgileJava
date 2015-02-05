package sis.report;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import sis.report.RosterReporter;
import sis.session.CourseSession;
import sis.studentinfo.Student;
import static sis.report.ReportConstant.NEWLINE;

public class CourseReportTest {
	@Test
	public void testReport(){
		CourseReport report = new CourseReport();
		report.add(CourseSession.create("ENGL", "101"));
		report.add(CourseSession.create("CZEC", "200"));
		report.add(CourseSession.create("ITAL", "410"));
		assertEquals("CZEC 200" + NEWLINE +
					"ENGL 101" + NEWLINE +
					"ITAL 410" +NEWLINE, report.text());
	}

}
