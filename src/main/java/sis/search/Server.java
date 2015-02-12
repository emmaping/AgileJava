/********************************************************************
 * File Name:    Server.java
 *
 * Date Created: 2015年2月11日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package sis.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class Server extends Thread
{
  // private List<Search> queue = Collections.synchronizedList(new LinkedList<Search>());
  private BlockingQueue<Search> queue = new LinkedBlockingQueue<Search>();
  static final String START_MSG = "started";
  static final String END_MSG = "finished";

  private static ThreadLocal<List<String>> threadLog =
      new ThreadLocal<List<String>>()
      {
        protected List<String> initialValue()
        {
          return new ArrayList<String>();
        }
      };

  private List<String> completeLog = Collections.synchronizedList(new ArrayList<String>());

  private ResultListener listener;

  public Server(ResultListener listener)
  {
    this.listener = listener;
    start();
  }

  public void run()
  {
    while (true)
    {
      try
      {
        execute(queue.take());
      }
      catch (InterruptedException e)
      {
        // TODO: handle exception
      }
    }
  }

  public void add(Search search) throws Exception
  {
    queue.put(search);
  }

  private void execute(final Search search)
  {
    new Thread(new Runnable()
    {

      @Override
      public void run()
      {
        log(START_MSG, search);
        search.execute();
        log(END_MSG, search);

        listener.executed(search);
        completeLog.addAll(threadLog.get());

      }
    }).start();
  }

  public void shutdown() throws Exception
  {
    this.interrupt();
  }

  // ...
  public List<String> getLog()
  {
    return completeLog;
  }

  private void log(String message, Search search)
  {
    threadLog.get().add(search + " " + message + " at " + new Date());
  }

}
