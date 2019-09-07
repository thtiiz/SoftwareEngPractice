package Bank;
import Comparator.Comparable;

public class BankAccount implements Comparable {
  private int accountID;
  private double balance = 0.00;

  public BankAccount(int accountID, double balance){
    this.accountID = accountID;
    this.balance = balance;
  }

  public double getBalance(){
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public int getAccountID() {
    return accountID;
  }

  public void setAccountID(int accountID) {
    this.accountID = accountID;
  }

  public int compareTo(Object other){
    BankAccount otherAccount = (BankAccount)other;
    if(this.getBalance() < otherAccount.getBalance())
      return -1;
    else if (this.getBalance() == otherAccount.getBalance())
      return 0;
    else
      return 1;
  }
}
