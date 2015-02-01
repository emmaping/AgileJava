package sis.report;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sis.report.RosterReporter;
import sis.studentinfo.CourseSession;
import sis.studentinfo.Student;

public class RosterReporterTest {
	private RosterReporter rosterReporter;
	@Before
	public void setUp() throws Exception {
		CourseSession session = new CourseSession("ENGL","101");
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
		rosterReporter = new RosterReporter(session);
		
	}

	@Test
	public void testRosterReport(){
		System.out.println(rosterReporter.getReport());

		assertEquals(CourseSession.ROSTER_REPORT_HEADER +
						"A" + CourseSession.NEWLINE +
						"B" + CourseSession.NEWLINE +
						CourseSession.ROSTER_REPORT_FOOTER +
						"2" + CourseSession.NEWLINE,  rosterReporter.getReport());
	}
}
