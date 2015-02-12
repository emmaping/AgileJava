/********************************************************************
 * File Name:    LineWrite.java
 *
 * Date Created: 2015年2月11日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package sis.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class LineWrite
{
  public static void write(String filename, String[] records)
      throws IOException
  {
    BufferedWriter writer = null;
    try
    {
      writer = new BufferedWriter(new FileWriter(filename));
      for (int i = 0; i < records.length; i++)
      {
        writer.write(records[i]);
        writer.newLine();
      }
    }
    finally
    {
      if (writer != null)
        writer.close();
    }
  }

}
