/********************************************************************
 * File Name:    StringUtilTtest.java
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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class StringUtilTtest
{
  private static final String TEXT = "this is it, isn't it";

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
  public void testOccurrenceOne()
  {
    assertEquals(1, StringUtil.occurrences(TEXT, "his"));
  }

  @Test
  public void testOccurrenceNone()
  {
    assertEquals(0, StringUtil.occurrences(TEXT, "hisss"));
  }

  @Test
  public void testOccurrenceMany()
  {
    assertEquals(3, StringUtil.occurrences(TEXT, "is"));
    assertEquals(2, StringUtil.occurrences(TEXT, "it"));
  }

  @Test
  public void testOccurrenceTooLarge()
  {
    assertEquals(0, StringUtil.occurrences(TEXT, TEXT + "sdfas"));
  }

  // CLASS VARIABLES ------------------------------------------------

  // INSTANCE VARIABLES ---------------------------------------------

  // CONSTRUCTORS ---------------------------------------------------

  // PUBLIC METHODS -------------------------------------------------

  // PROTECTED METHODS ----------------------------------------------

  // PRIVATE METHODS ------------------------------------------------

  // ACCESSOR METHODS -----------------------------------------------

}
