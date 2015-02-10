/********************************************************************
 * File Name:    Accountable.java
 *
 * Date Created: 2015年2月10日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package sis.studentinfo;

import java.math.BigDecimal;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public interface Accountable
{
  public void credit(BigDecimal amount);

  public BigDecimal getBalance();

  public BigDecimal transactionAverage();

  public void setBankAba(String bankAba);

  public void setBankAccountNumber(String bankAccountNumber);

  public void setBankAccountType(
      Account.BankAccountType bankAccountType);

  public void transferFromBank(BigDecimal amount);

}
