package sis;

import org.junit.runner.RunWith;

import org.junit.runners.Suite;

import sis.report.RosterReporterTest;
import sis.studentinfo.StudentTest;
import sis.studentinfo.CourseSessionTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	StudentTest.class,
	CourseSessionTest.class,
	RosterReporterTest.class
})

public class AllTest {  
}
