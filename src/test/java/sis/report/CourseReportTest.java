package sis.report;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

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
		LocalDate startDate = LocalDate.of(2014, 9, 20);
		report.add(CourseSession.createSession("ENGL", "101",startDate));
		report.add(CourseSession.createSession("CZEC", "200",startDate));
		report.add(CourseSession.createSession("ITAL", "410",startDate));
		assertEquals("CZEC 200" + NEWLINE +
					"ENGL 101" + NEWLINE +
					"ITAL 410" +NEWLINE, report.text());
	}

}
