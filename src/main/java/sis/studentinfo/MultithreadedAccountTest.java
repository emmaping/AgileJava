/********************************************************************
 * File Name:    MultithreadedAccountTest.java
 *
 * Date Created: 2015年2月11日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package sis.studentinfo;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class MultithreadedAccountTest
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
  public void testConcurrency() throws Exception
  {
    final Account account = new Account();
    account.credit(new BigDecimal("100.00"));
    Thread t1 = new Thread(new Runnable()
    {

      @Override
      public void run()
      {
        account.withdraw(new BigDecimal("80"));

      }
    });

    Thread t2 = new Thread(new Runnable()
    {

      @Override
      public void run()
      {
        account.withdraw(new BigDecimal("80"));

      }
    });
    t1.start();
    t2.start();
    t1.join();
    t2.join();

    assertEquals(new BigDecimal("20.00"), account.getBalance());

  }

  // CLASS VARIABLES ------------------------------------------------

  // INSTANCE VARIABLES ---------------------------------------------

  // CONSTRUCTORS ---------------------------------------------------

  // PUBLIC METHODS -------------------------------------------------

  // PROTECTED METHODS ----------------------------------------------

  // PRIVATE METHODS ------------------------------------------------

  // ACCESSOR METHODS -----------------------------------------------

}
