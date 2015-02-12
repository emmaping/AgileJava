package sis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import sis.db.DataFileTest;
import sis.db.KeyFileTest;
import sis.report.CourseReportTest;
import sis.report.ReportCardTest;
import sis.report.RosterReporterTest;
import sis.search.SearchTest;
import sis.search.ServerTest;
import sis.session.CourseSessionTest;
import sis.session.SummerCourseSessionTest;
import sis.studentinfo.AccountTest;
import sis.studentinfo.BasicGradingStrategyTest;
import sis.studentinfo.CourseCatalogTest;
import sis.studentinfo.CourseTest;
import sis.studentinfo.HonorsGradingStrategyTest;
import sis.studentinfo.ScoreTest;
import sis.studentinfo.StudentDirectoryTest;
import sis.studentinfo.StudentTest;
import sis.ui.StudentUITest;
import sis.util.IOUtilTest;
import sis.util.LineWriterTest;
import sis.util.StringUtilTtest;

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
  ScoreTest.class,
  CourseTest.class,
  AccountTest.class,
  StudentUITest.class,
  CourseCatalogTest.class,
  StudentDirectoryTest.class,
  DataFileTest.class,
  KeyFileTest.class,
  IOUtilTest.class,
  StringUtilTtest.class,
  SearchTest.class,
  ServerTest.class,
  LineWriterTest.class,
})
public class AllTest
{
}
