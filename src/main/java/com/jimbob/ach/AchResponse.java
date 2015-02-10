/********************************************************************
 * File Name:    AchResponse.java
 *
 * Date Created: 2015年2月10日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package com.jimbob.ach;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
import java.util.Date;
import java.util.List;

public class AchResponse
{
  public Date timestamp;
  public String traceCode;
  public AchStatus status;
  public List<String> errorMessages;
}
