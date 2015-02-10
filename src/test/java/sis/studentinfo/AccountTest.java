package sis.studentinfo;

import static org.junit.Assert.assertEquals;

import com.jimbob.ach.Ach;
import com.jimbob.ach.AchCredentials;
import com.jimbob.ach.AchResponse;
import com.jimbob.ach.AchStatus;
import com.jimbob.ach.AchTransactionData;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class AccountTest
{
  static final String ABA = "102000012";
  static final String ACCOUNT_NUMBER = "194431518811";
  private Account account;

  @Before
  public void setUp() throws Exception
  {
    account = new Account();
    account.setBankAba(ABA);
    account.setBankAccountNumber(ACCOUNT_NUMBER);
    account.setBankAccountType(Account.BankAccountType.CHECKING);
  }

  @Test
  public void testTransations()
  {
    Account account = new Account();
    account.credit(new BigDecimal("0.10"));
    account.credit(new BigDecimal("11.00"));
    assertEquals(new BigDecimal("11.10"), account.getBalance());
  }

  @Test
  public void testTransferFromBank()
  {
    account.setAch(createMockAch(AchStatus.SUCCESS));
    final BigDecimal amount = new BigDecimal("50.00");
    account.transferFromBank(amount);
    assertEquals(new BigDecimal("50.00"), account.getBalance());
  }

  @Test
  public void testFailedTransferFromBank()
  {
    account.setAch(createMockAch(AchStatus.FAILURE));
    final BigDecimal amount = new BigDecimal("50.00");
    account.transferFromBank(amount);
    assertEquals(new BigDecimal("0"), account.getBalance());
  }

  private Ach createMockAch(final AchStatus status)
  {
    return new MockAch()
    {
      public AchResponse issueDebit(AchCredentials credentials, AchTransactionData data)
      {
        Assert.assertTrue(data.account.equals(AccountTest.ACCOUNT_NUMBER));
        Assert.assertTrue(data.aba.equals(AccountTest.ABA));

        AchResponse response = new AchResponse();
        response.timestamp = new Date();
        response.traceCode = "1";
        response.status = status;
        return response;
      }
    };

  }
}
