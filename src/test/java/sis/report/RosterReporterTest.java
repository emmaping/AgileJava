package sis.report;

import static org.junit.Assert.*;

import java.io.*;
import java.time.LocalDate;

import org.hibernate.sql.Delete;
import org.junit.Before;
import org.junit.Test;

import sis.report.RosterReporter;
import sis.session.Session;
import sis.session.CourseSession;
import sis.studentinfo.Course;
import sis.studentinfo.Student;
import static sis.report.ReportConstant.NEWLINE;

public class RosterReporterTest {
	private Session session;
	@Before
	public void setUp() throws Exception {
		LocalDate startDate = LocalDate.of(2014, 9, 20);
		session = CourseSession.createSession(new Course("ENGL","101"),startDate);
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
	}

	@Test
	public void testRosterReport() throws IOException{
		RosterReporter rosterReporter = new RosterReporter(session);
		Writer writer = new StringWriter();
		rosterReporter.writeReport(writer);
		assertReportContents(writer.toString());


	}
	
	@Test
	public void testFileRosterReport() throws IOException{
		final String filename = "testFileRosterReport.txt";
		try {
			delete(filename);
			new RosterReporter(session).writeReport(filename);
			
			StringBuilder builder = new StringBuilder();
			String lineString;
			
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while((lineString = reader.readLine())!=null){
				builder.append(String.format(lineString + "%n"));
			}
			reader.close();
			assertReportContents(builder.toString());
			
		} finally {
			delete(filename);
		}

	}
	
	private void assertReportContents(String rosterReport){
		assertEquals(String.format(CourseSession.ROSTER_REPORT_HEADER) +
				"A" + NEWLINE +
				"B" + NEWLINE +
				String.format(CourseSession.ROSTER_REPORT_FOOTER , 2), rosterReport);
	}
	
	private void delete(String filename){
		File file = new File(filename);
		if(file.exists()){
			assertTrue("unable to delete" + filename, file.delete());
		}
	}
}
