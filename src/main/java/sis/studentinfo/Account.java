package sis.studentinfo;

import java.math.BigDecimal;

public class Account {
	private BigDecimal balance = new BigDecimal("0");
	public void credit(BigDecimal credit) {
		balance = balance.add(credit);
	}
	
	public BigDecimal getBalance() {
		return this.balance;
	}

}
