/********************************************************************
 * File Name:    AchTransactionData.java
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
import java.math.BigDecimal;

public class AchTransactionData
{
  public String description;
  public BigDecimal amount;
  public String aba;
  public String account;
  public String accountType;
}
