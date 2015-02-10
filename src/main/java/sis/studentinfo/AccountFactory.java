/********************************************************************
 * File Name:    AccountFactory.java
 *
 * Date Created: 2015年2月10日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package sis.studentinfo;

import java.lang.reflect.Proxy;

import sis.security.Permission;
import sis.security.SecureProxy;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class AccountFactory
{
  public static Accountable create(Permission permission)
  {
    switch (permission)
    {
      case UPDATE:
        return new Account();
      case READ_ONLY:
        return createSecuredAccount();
      default:
        return null;
    }
  }

  private static Accountable createSecuredAccount()
  {
    SecureProxy secureAccount = new SecureProxy(new Account(),
        "credit",
        "setBankAba",
        "setBankAccountNumber",
        "setBankAccountType",
        "transferFromBank");
    return (Accountable) Proxy.newProxyInstance(Accountable.class.getClassLoader(), new Class[] { Accountable.class },
        secureAccount);

  }

}
