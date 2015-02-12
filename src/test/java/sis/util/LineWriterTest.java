/********************************************************************
 * File Name:    LineWriterTest.java
 *
 * Date Created: 2015年2月11日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package sis.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class LineWriterTest
{

  @Before
  public void setUp() throws Exception
  {
  }

  // CONSTANTS ------------------------------------------------------

  @After
  public void tearDown() throws Exception
  {
  }

  @Test
  public void testMultipleRecords() throws IOException
  {
    final String file = "LineWriteTest.testCreate.txt";
    try
    {
      LineWrite.write(file, new String[] { "a", "b" });

      BufferedReader reader = null;
      try
      {
        reader = new BufferedReader(new FileReader(file));
        assertEquals("a", reader.readLine());
        assertEquals("b", reader.readLine());
        assertNull(reader.readLine());
      }
      finally
      {
        if (reader != null)
          reader.close();
      }
    }
    finally
    {
      TestUtil.delete(file);
    }
  }

  // CLASS VARIABLES ------------------------------------------------

  // INSTANCE VARIABLES ---------------------------------------------

  // CONSTRUCTORS ---------------------------------------------------

  // PUBLIC METHODS -------------------------------------------------

  // PROTECTED METHODS ----------------------------------------------

  // PRIVATE METHODS ------------------------------------------------

  // ACCESSOR METHODS -----------------------------------------------

}
