/********************************************************************
 * File Name:    SearchScheduler.java
 *
 * Date Created: 2015年2月11日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package sis.search;

import java.util.Timer;
import java.util.TimerTask;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class SearchScheduler
{
  private ResultListener listener;
  private Timer timer;

  public SearchScheduler(ResultListener listener)
  {
    this.listener = listener;
  }

  public void repeat(final Search search, long interval)
  {
    timer = new Timer();
    TimerTask task = new TimerTask()
    {
      public void run()
      {
        search.execute();
        listener.executed(search);
      }
    };
    timer.scheduleAtFixedRate(task, 0, interval);
  }

  public void stop()
  {
    timer.cancel();
  }

}
