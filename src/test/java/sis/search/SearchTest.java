/********************************************************************
 * File Name:    SearchTest.java
 *
 * Date Created: 2015年2月11日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package sis.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sis.util.LineWrite;
import sis.util.TestUtil;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class SearchTest
{
  // private static final String URL = "http://www.langrsoft.com/";
  public static final String[] TEST_HTML = {
    "<html>",
    "<body>",
    "Book: Agile Java, by Jeff Langr<br />",
    "Synopsis: Mr Langr teaches you<br />",
    "Java via test-driven development.<br />",
    "</body></html>" };

  public static final String FILE = "testFileSearch.html";
  public static final String URL = "file:" + FILE;

  @Before
  public void setUp() throws Exception
  {
    TestUtil.delete(FILE);
    LineWrite.write(FILE, TEST_HTML);

  }

  // CONSTANTS ------------------------------------------------------

  @After
  public void tearDown() throws Exception
  {
    TestUtil.delete(FILE);

  }

  @Test
  public void testCreate() throws IOException
  {
    Search search = new Search(URL, "X");
    assertEquals(URL, search.getUrl());
    assertEquals("X", search.getText());
  }

  @Test
  public void testPositiveSearch() throws IOException
  {
    Search search = new Search(URL, "Jeff Langr");
    search.execute();
    assertTrue(search.matches() >= 1);
    assertFalse(search.errored());
  }

  @Test
  public void testNegativeSearch() throws IOException
  {
    final String unlikelyText = "&^*()_wuuw ca.aot";
    Search search = new Search(URL, unlikelyText);
    search.execute();
    assertEquals(0, search.matches());
    assertFalse(search.errored());
  }

  @Test
  public void testErroredSearch() throws IOException
  {
    final String badUrl = URL + "/zzzzzzzzzzzzz.html";
    Search search = new Search(badUrl, "whatever");
    search.execute();
    assertTrue(search.errored());
    assertEquals(FileNotFoundException.class, search.getError().getClass());
  }

  // CLASS VARIABLES ------------------------------------------------

  // INSTANCE VARIABLES ---------------------------------------------

  // CONSTRUCTORS ---------------------------------------------------

  // PUBLIC METHODS -------------------------------------------------

  // PROTECTED METHODS ----------------------------------------------

  // PRIVATE METHODS ------------------------------------------------

  // ACCESSOR METHODS -----------------------------------------------

}
