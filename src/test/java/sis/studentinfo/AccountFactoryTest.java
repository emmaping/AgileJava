/********************************************************************
 * File Name:    AccountFactoryTest.java
 *
 * Date Created: 2015年2月10日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package sis.studentinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sis.security.Permission;
import sis.security.PermissionException;

/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public class AccountFactoryTest

{
  private List<Method> updateMethods;
  private List<Method> readOnlyMethods;

  @Before
  public void setUp() throws Exception
  {
    updateMethods = new ArrayList<Method>();
    addUpdateMethod("setBankAba", String.class);
    addUpdateMethod("setBankAccountNumber", String.class);
    addUpdateMethod("setBankAccountType", Account.BankAccountType.class);
    addUpdateMethod("transferFromBank", BigDecimal.class);
    addUpdateMethod("credit", BigDecimal.class);

    readOnlyMethods = new ArrayList<Method>();
    addReadOnlyMethod("getBalance");
    addReadOnlyMethod("transactionAverage");
  }

  private void addUpdateMethod(String name, Class parmClass) throws Exception
  {
    // TODO Auto-generated method stub
    updateMethods.add(Accountable.class.getDeclaredMethod(name, parmClass));

  }

  private void addReadOnlyMethod(String name) throws Exception
  {
    // TODO Auto-generated method stub
    Class[] noParms = new Class[] {};
    readOnlyMethods.add(Accountable.class.getDeclaredMethod(name, noParms));

  }

  @Test
  public void testUpdateAccess() throws Exception
  {
    Accountable account = AccountFactory.create(Permission.UPDATE);
    for (Method method : readOnlyMethods)
      verifyNoException(method, account);
    for (Method method : updateMethods)
      verifyNoException(method, account);

  }

  @Test
  public void testReadOnlyAccess() throws Exception
  {
    Accountable account = AccountFactory.create(Permission.READ_ONLY);
    for (Method method : updateMethods)
      verifyException(PermissionException.class, method, account);
    for (Method method : readOnlyMethods)
      verifyNoException(method, account);
  }

  private void verifyException(Class exceptionType, Method method, Object object) throws Exception
  {
    try
    {
      method.invoke(object, nullParmsFor(method));
      fail("expected exception");
    }
    catch (InvocationTargetException e)
    {
      assertEquals("expected exception",
          exceptionType, e.getCause().getClass());
    }
  }

  private void verifyNoException(Method method, Object object)
      throws Exception
  {
    try
    {
      method.invoke(object, nullParmsFor(method));
    }
    catch (InvocationTargetException e)
    {
      assertFalse(
          "unexpected permission exception",
          PermissionException.class == e.getCause().getClass());
    }
  }

  private Object[] nullParmsFor(Method method)
  {
    return new Object[method.getParameterTypes().length];
  }

}
