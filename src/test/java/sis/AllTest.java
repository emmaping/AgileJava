package sis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import sis.report.CourseReportTest;
import sis.report.ReportCardTest;
import sis.report.RosterReporterTest;
import sis.studentinfo.BasicGradingStrategyTest;
import sis.studentinfo.CourseSessionTest;
import sis.studentinfo.HonorsGradingStrategyTest;
import sis.studentinfo.StudentTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	StudentTest.class,
	CourseSessionTest.class,
	RosterReporterTest.class,
	CourseReportTest.class,
	ReportCardTest.class,
	BasicGradingStrategyTest.class,
	HonorsGradingStrategyTest.class
})

public class AllTest {  
}
