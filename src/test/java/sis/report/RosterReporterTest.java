package sis.report;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import sis.report.RosterReporter;
import sis.session.CourseSession;
import sis.studentinfo.Course;
import sis.studentinfo.Student;
import static sis.report.ReportConstant.NEWLINE;

public class RosterReporterTest {
	private RosterReporter rosterReporter;
	@Before
	public void setUp() throws Exception {
		LocalDate startDate = LocalDate.of(2014, 9, 20);
		CourseSession session = CourseSession.createSession(new Course("ENGL","101"),startDate);
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
		rosterReporter = new RosterReporter(session);
		
	}

	@Test
	public void testRosterReport(){
		System.out.println(rosterReporter.getReport());

		assertEquals(CourseSession.ROSTER_REPORT_HEADER +
						"A" + NEWLINE +
						"B" + NEWLINE +
						CourseSession.ROSTER_REPORT_FOOTER +
						"2" + NEWLINE,  rosterReporter.getReport());
	}
}
