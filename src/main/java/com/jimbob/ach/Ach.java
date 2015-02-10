/********************************************************************
 * File Name:    Ach.java
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
public interface Ach
{
  public AchResponse issueDebit(AchCredentials credentials, AchTransactionData data);

  public AchResponse markTransactionAsNSF(AchCredentials credentials, AchTransactionData
      data,
      String traceCode);

  public AchResponse refundTransaction(AchCredentials credentials, AchTransactionData data,
      String traceCode);

  public AchResponse issueCredit(AchCredentials credentials, AchTransactionData data);

  public AchResponse voidSameDayTransaction(AchCredentials credentials, AchTransactionData
      data, String traceCode);

  public AchResponse queryTransactionStatus(AchCredentials credentials, AchTransactionData
      data, String traceCode);

}
