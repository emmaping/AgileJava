package sis.util;

import static org.junit.Assert.*;

import java.io.*;

import org.hibernate.cfg.CreateKeySecondPass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IOUtilTest {
	static final String FILENAME1 = "IOUtilTest1.txt";
	static final String FILENAME2 = "IOUtilTest2.txt";

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeleteSingleFile() throws IOException {
		create(FILENAME1);
		assertTrue(IOUtil.delete(FILENAME1));
		TestUtil.assertGone(FILENAME1);
	}
	
	@Test
	public void testDeleteMultiFiles() throws IOException {
		create(FILENAME1, FILENAME2);
		assertTrue(IOUtil.delete(FILENAME1, FILENAME2));
		TestUtil.assertGone(FILENAME1,FILENAME2);
	}
	
	@Test
	public void testDeleteNoFile() throws IOException {
		TestUtil.delete(FILENAME1);
		assertFalse(IOUtil.delete(FILENAME1));
	}
	
	@Test
	public void testDeletePartiallySuccessful() throws IOException {
		create(FILENAME1);
		TestUtil.delete(FILENAME2);
		assertFalse(IOUtil.delete(FILENAME1, FILENAME2));
		TestUtil.assertGone(FILENAME1);
	}
	
	private void create(String...filenames) throws IOException{
		for(String filename:filenames){
			TestUtil.delete(filename);
			new File(filename).createNewFile();
		}
	}
}
