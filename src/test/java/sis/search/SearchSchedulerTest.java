/********************************************************************
 * File Name:    SearchSchedulerTest.java
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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sis.util.LineWrite;
import sis.util.TestUtil;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class SearchSchedulerTest
{
  private int actualResultsCount = 0;

  @Before
  public void setUp() throws Exception
  {
    TestUtil.delete(SearchTest.FILE);
    LineWrite.write(SearchTest.FILE, SearchTest.TEST_HTML);

  }

  // CONSTANTS ------------------------------------------------------

  @After
  public void tearDown() throws Exception
  {
    TestUtil.delete(SearchTest.FILE);
  }

  @Test
  public void testRepeatedSearch() throws Exception
  {
    final int searchInterval = 3000;
    Search search = new Search(SearchTest.URL, "xxx");

    ResultListener listener = new ResultListener()
    {
      public void executed(Search search)
      {
        ++actualResultsCount;
      }
    };

    SearchScheduler scheduler = new SearchScheduler(listener);
    scheduler.repeat(search, searchInterval);

    final int expectedResultsCount = 3;
    Thread.sleep((expectedResultsCount - 1) * searchInterval + 1000);

    scheduler.stop();
    assertEquals(expectedResultsCount, actualResultsCount);
  }

}
