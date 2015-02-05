package sis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import sis.report.CourseReportTest;
import sis.report.ReportCardTest;
import sis.report.RosterReporterTest;
import sis.session.CourseSessionTest;
import sis.session.SummerCourseSessionTest;
import sis.studentinfo.BasicGradingStrategyTest;
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
	HonorsGradingStrategyTest.class,
	SummerCourseSessionTest.class,
})

public class AllTest {  
}
