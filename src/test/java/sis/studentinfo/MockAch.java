/********************************************************************
 * File Name:    MockAch.java
 *
 * Date Created: 2015年2月10日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package sis.studentinfo;

import com.jimbob.ach.Ach;
import com.jimbob.ach.AchCredentials;
import com.jimbob.ach.AchResponse;
import com.jimbob.ach.AchTransactionData;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class MockAch implements Ach
{
  public AchResponse issueDebit(AchCredentials credentials, AchTransactionData data)
  {
    return null;
  }

  public AchResponse markTransactionAsNSF(AchCredentials credentials, AchTransactionData data, String traceCode)
  {
    return null;
  }

  public AchResponse refundTransaction(AchCredentials credentials, AchTransactionData data, String traceCode)
  {
    return null;
  }

  public AchResponse issueCredit(AchCredentials credentials, AchTransactionData data)
  {
    return null;
  }

  public AchResponse voidSameDayTransaction(AchCredentials credentials, AchTransactionData data, String traceCode)
  {
    return null;
  }

  public AchResponse queryTransactionStatus(AchCredentials credentials, AchTransactionData data, String traceCode)
  {
    return null;
  }

}
