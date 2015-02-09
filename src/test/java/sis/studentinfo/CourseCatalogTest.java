package sis.studentinfo;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sis.session.CourseSession;
import sis.session.Session;

public class CourseCatalogTest {
	private CourseCatalog catalog;
	private Session session1;
	private Session session2;
	private Course course1;
	private Course course2;

	@Before
	public void setUp() throws Exception {
		catalog = new CourseCatalog();
		course1 = new Course("a","1");
		course2 = new Course("a", "1");
		session1 = CourseSession.createSession(course1, LocalDate.of(2015, 2, 9));
		session1.setNumberOfCredit(3);
		session2 = CourseSession.createSession(course2, LocalDate.of(2015, 1, 17));
		session2.setNumberOfCredit(5);
		session2.enroll(new Student("b"));
		catalog.add(session1);
		catalog.add(session2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStoreAndLoad() throws IOException {
		final String filename = "CourseCatalogTest.txt";
		catalog.store(filename);
		catalog.clearAll();
		assertEquals(0, catalog.getSessions().size());
		catalog.load(filename);
		List<Session> sessions = catalog.getSessions();
		assertEquals(2, sessions.size());
		assertSession(session1, sessions.get(0));
		assertSession(session2, sessions.get(1));
	}
	
	@Test
	public void testStoreAndLoadByStream() throws Exception {
		final String filename = "CourseCatalogTest.txt";
		catalog.storeByStream(filename);
		catalog.clearAll();
		assertEquals(0, catalog.getSessions().size());
		catalog.loadByStream(filename);
		List<Session> sessions = catalog.getSessions();
		assertEquals(2, sessions.size());
		assertSession(session1, sessions.get(0));
		assertSession(session2, sessions.get(1));
		
		Session session = sessions.get(1);
		assertSession(session2, session);
		Student student = session.get(0);
		assertEquals("b", student.getLastName());
	}
	
	private void assertSession(Session expected, Session actual){
		assertNotSame(expected, actual);
		assertEquals(expected.getNumberOfCredit(), actual.getNumberOfCredit());
		assertEquals(expected.getDepartment(), actual.getDepartment());
		assertEquals(expected.getStartDate(), actual.getStartDate());
	}

}
