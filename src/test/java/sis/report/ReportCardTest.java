package sis.report;
import sis.studentinfo.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sis.studentinfo.Student;

public class ReportCardTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMessage() {
		ReportCard card = new ReportCard();
		assertEquals(ReportCard.A_MESSAGE, card.getMessage(Student.Grade.A));
		assertEquals(ReportCard.B_MESSAGE, card.getMessage(Student.Grade.B));
		assertEquals(ReportCard.C_MESSAGE, card.getMessage(Student.Grade.C));
		assertEquals(ReportCard.D_MESSAGE, card.getMessage(Student.Grade.D));
		assertEquals(ReportCard.F_MESSAGE, card.getMessage(Student.Grade.F));
	}

}
