/********************************************************************
 * File Name:    ClockTest.java
 *
 * Date Created: 2015年2月11日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package sis.clock;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class ClockTest
{
  private Clock clock;
  private Object monitor = new Object(); // 1
  private Lock lock;
  private Condition receivedEnoughTics;

  @Before
  public void setUp() throws Exception
  {
    lock = new ReentrantLock();
    receivedEnoughTics = lock.newCondition();
  }

  // CONSTANTS ------------------------------------------------------

  @After
  public void tearDown() throws Exception
  {
  }

  @Test
  public void testClockBySynchronized() throws Exception
  {
    final int seconds = 5;
    final List<Date> tics = new ArrayList<Date>();
    ClockListener listener = new ClockListener()
    {
      private int count = 0;

      public void update(Date date)
      {
        tics.add(date);
        if (++count == seconds)
          synchronized (monitor)
          { // 2
            monitor.notifyAll(); // 3
          }
      }
    };
    clock = new Clock(listener);
    synchronized (monitor)
    { // 4
      monitor.wait(); // 5
    }
    clock.stop();
    verify(tics, seconds);
  }

  @Test
  public void testClockByLock() throws Exception
  {
    final int seconds = 2;
    final List<Date> tics = new ArrayList<Date>();
    ClockListener listener = createClockListener(tics, seconds);
    clock = new Clock(listener);
    lock.lock();
    try
    {
      receivedEnoughTics.await();
    }
    finally
    {
      lock.unlock();
    }
    clock.stop();
    verify(tics, seconds);
  }

  private void verify(List<Date> tics, int seconds)
  {
    assertEquals(seconds, tics.size());
    for (int i = 1; i < seconds; i++)
      assertEquals(1, getSecondsFromLast(tics, i));
  }

  private long getSecondsFromLast(List<Date> tics, int i)
  {
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(tics.get(i));
    int now = calendar.get(Calendar.SECOND);
    calendar.setTime(tics.get(i - 1));
    int then = calendar.get(Calendar.SECOND);
    if (now == 0)
      now = 60;
    return now - then;
  }

  private ClockListener createClockListener(final List<Date> tics, final int seconds)
  {
    return new ClockListener()
    {
      private int count = 0;

      public void update(Date date)
      {
        tics.add(date);
        if (++count == seconds)
        {
          lock.lock();
          try
          {
            receivedEnoughTics.signalAll();
          }
          finally
          {
            lock.unlock();
          }
        }
      }
    };
  }

}
