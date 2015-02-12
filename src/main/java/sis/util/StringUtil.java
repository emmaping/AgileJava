/********************************************************************
 * File Name:    StringUtil.java
 *
 * Date Created: 2015年2月11日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package sis.util;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class StringUtil
{
  static public int occurrences(String string, String substring)
  {
    int occurrence = 0;
    int length = substring.length();
    final boolean ignoreCase = true;
    for (int i = 0; i < string.length() - substring.length() + 1; i++)
    {
      if (string.regionMatches(ignoreCase, i, substring, 0, length))
      {
        occurrence++;
      }
    }
    return occurrence;
  }

}
