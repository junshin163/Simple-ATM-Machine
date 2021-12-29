class Account {
  private String accountName;
  private int balance;

  public Account(String accountName, int balance){
    this.accountName = accountName;
    this.balance = balance;
  }
  
  public int seeBalance(){
    return balance;
  }

  public void deposit(int amount){
    balance += amount;
  }

  public void withdraw(int amount){
    balance -= amount;
  }

  public String getAccountName(){
    return accountName;
  }
}
