package sis.studentinfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScoreTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCaptureScore() {
		Scorer scorer = new Scorer();
		assertEquals(75, scorer.score("75"));
	}
	@Test
	public void testBadScore() {
		Scorer scorer = new Scorer();
		try{
		scorer.score("abc");
		fail("Expected NumberFormatException on bad input");
		}
		catch(NumberFormatException success){
			
		}
	}
	@Test
	public void testIsValid(){
		Scorer scorer = new Scorer();
		assertTrue(scorer.isValid("75"));
		assertFalse(scorer.isValid("bd"));
	}

}
