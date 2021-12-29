import java.util.*;

class Card {
  private String cardName;
  private int PIN;
  private HashMap<String, Account> accounts;

  public Card(String cardName, int PIN, HashMap<String, Account> accountsOnCard){
    this.cardName = cardName;
    this.PIN = PIN;
    accounts = accountsOnCard;
  }
  
  public int getHashedPIN(){
    Integer wrappedPIN = new Integer(PIN);
    return wrappedPIN.hashCode();
  }

  public HashMap<String, Account> getAccounts(int attemptedPIN){
    Integer wrappedAttemptedPIN = new Integer(attemptedPIN);
    Integer wrappedPIN = new Integer(this.PIN);
    if (wrappedAttemptedPIN.hashCode() == wrappedPIN.hashCode()){
      return accounts;
    }
    return null;
  }

  public String getName(){
    return cardName;
  }
}
