/********************************************************************
 * File Name:    Clock.java
 *
 * Date Created: 2015年2月11日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package sis.clock;

import java.util.Date;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class Clock implements Runnable
{
  private ClockListener listener;
  private boolean run = true;

  public Clock(ClockListener listener)
  {
    this.listener = listener;
    new Thread(this).start();
  }

  public void stop()
  {
    run = false;
  }

  public void run()
  {
    long lastTime = System.currentTimeMillis();
    while (run)
    {
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
      }

      long now = System.currentTimeMillis();
      if ((now / 1000) - (lastTime / 1000) >= 1)
      {
        listener.update(new Date(now));
        lastTime = now;
      }

    }
  }
}
