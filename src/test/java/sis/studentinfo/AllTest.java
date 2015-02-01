package sis.studentinfo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import sis.report.RosterReporterTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	StudentTest.class,
	CourseSessionTest.class,
	RosterReporterTest.class
})

public class AllTest {  
}
