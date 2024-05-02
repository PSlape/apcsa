package Lesson_17;
/**
   A bank account has a balance that can be changed by
   deposits and withdrawals.
*/
public class CheckingAccount
{
  private final double CHECK_CHARGE = 0.15;
  private double myBalance;

  /**
    Constructs a bank account with a zero balance
  */
  public CheckingAccount()
  {
    myBalance = 0;
  }

  /**
    Constructs a bank account with a given balance
    @param initialBalance the initial balance
  */
  public CheckingAccount(double initialBalance)
  {
      if(initialBalance < 0) throw new IllegalArgumentException("Initial balance cannot be less than zero.");
      myBalance = initialBalance;
  }

  /**
    Deposits money into the bank account.
    @param amount the amount to deposit
  */
  public void deposit(double amount)
  {
      if(amount < 0) throw new IllegalArgumentException("Amount deposited cannot be less than zero.");
      myBalance = myBalance + amount;
  }

  /**
    Withdraws money from the bank account.
    @param amount the amount to withdraw
  */
  public void withdraw(double amount)
  {
      if(amount < 0) throw new IllegalArgumentException("Amount withdrawn cannot be less than zero.");
      if(myBalance - amount - CHECK_CHARGE < 0) throw new UnsupportedOperationException("Insufficient funds.");
      myBalance = myBalance - amount - CHECK_CHARGE;
  }

  /**
    Gets the current balance of the bank account.
    @return the current balance
  */
  public double getBalance()
  {
    return myBalance;
  }
}