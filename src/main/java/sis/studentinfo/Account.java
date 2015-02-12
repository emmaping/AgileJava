package sis.studentinfo;

import com.jimbob.ach.Ach;
import com.jimbob.ach.AchCredentials;
import com.jimbob.ach.AchResponse;
import com.jimbob.ach.AchStatus;
import com.jimbob.ach.AchTransactionData;

import java.math.BigDecimal;

public class Account implements Accountable
{
  private BigDecimal balance = new BigDecimal("0");
  private int transactionCount = 0;
  private String bankAba;
  private String bankAccountNumber;
  private BankAccountType bankAccountType;
  private Ach ach;

  public enum BankAccountType
  {
    CHECKING("ck"), SAVINGS("sv");
    private String value;

    private BankAccountType(String value)
    {
      this.value = value;
    }

    @Override
    public String toString()
    {
      return value;
    }
  }

  public void credit(BigDecimal credit)
  {
    balance = balance.add(credit);
    transactionCount++;
  }

  public BigDecimal getBalance()
  {
    return this.balance;
  }

  public BigDecimal transactionAverage()
  {
    return balance.divide(new BigDecimal(transactionCount), BigDecimal.ROUND_HALF_UP);
  }

  public void setBankAba(String bankAba)
  {
    this.bankAba = bankAba;
  }

  public void setBankAccountNumber(String bankAccountNumber)
  {
    this.bankAccountNumber = bankAccountNumber;
  }

  public void setBankAccountType(Account.BankAccountType type)
  {
    this.bankAccountType = type;
  }

  public void transferFromBank(BigDecimal amount)
  {
    AchResponse achResponse = ach.issueDebit(creatCredentials(), createData(amount));
    if (achResponse.status == AchStatus.SUCCESS)
      credit(amount);
  }

  private AchCredentials creatCredentials()
  {
    AchCredentials credentials = new AchCredentials();
    credentials.merchantId = "12345";
    credentials.userName = "sismerc1920";
    credentials.password = "pitseleh411";
    return credentials;

  }

  private AchTransactionData createData(BigDecimal amount)
  {
    AchTransactionData data = new AchTransactionData();
    data.description = "Transfer from bank";
    data.amount = amount;
    data.aba = bankAba;
    data.account = bankAccountNumber;
    data.accountType = bankAccountType.toString();
    return data;

  }

  private Ach getAch()
  {
    return ach;
  }

  void setAch(Ach ach)
  {
    this.ach = ach;
  }

  public synchronized void withdraw(BigDecimal amount)
  {
    if (amount.compareTo(balance) > 0)
      return;
    try
    {
      Thread.sleep(100);
    }
    catch (InterruptedException e)
    {
      // TODO: handle exception
    }
    balance = balance.subtract(amount);
  }

}
