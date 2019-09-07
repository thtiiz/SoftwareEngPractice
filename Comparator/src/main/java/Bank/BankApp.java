package Bank;

import Comparator.Data;

public class BankApp {
  public static void main(String[] args) {
    BankAccount b1 = new BankAccount(1,30);
    BankAccount b2 = new BankAccount(3,10);
    BankAccount b3 = new BankAccount(2,20);
    BankAccount b4 = new BankAccount(4,33);
    BankAccount b5 = new BankAccount(5,30);
    BankAccount[] accounts = {b1, b2, b3, b4, b5};
    Data.sort(accounts);
    for (BankAccount b : accounts) {
      System.out.println(b.getBalance());
    }
  }
}
