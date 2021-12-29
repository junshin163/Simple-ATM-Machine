import java.util.*;

class ATMController {
  private HashMap<String, Card> compatibleCards;

  public ATMController(HashMap<String, Card> compatibleCards){
    this.compatibleCards = compatibleCards;
  }

  public HashMap<String, Card> insertCardPIN(String cardName, int attemptedPIN){  //returns String containing account names IF PIN is correct
    Card c = compatibleCards.get(cardName);
    Integer wrappedAttemptedPIN = new Integer(attemptedPIN);
    if (c.getHashedPIN() == wrappedAttemptedPIN.hashCode()){
      return compatibleCards;
    }
    else{
      return null;
    }
  }
  
  /* we return the set of strings containing card names instead of actual card objects
  to not give access to any cards unless the user has the correct PIN for a card: */
  public Set<String> getCompatibleCardNames(){
    return compatibleCards.keySet();
  }
}
