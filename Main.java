import java.util.*;

class Main {
  public static void main(String[] args) {
    ATMController atm = new ATMController(setExamples());
    Set<String> namesOfCompatibleCards = atm.getCompatibleCardNames();
    //Start of input/output:
    System.out.println("Welcome to this ATM! Here are the cards that are compatible with this ATM: " + namesOfCompatibleCards);
    System.out.println("Insert your card by typing your card name: ");
    Scanner input = new Scanner(System.in);
    String userCardName = input.nextLine();

    int insertAttempts = 0;
    while (namesOfCompatibleCards.contains(userCardName) == false){
      insertAttempts++;
      if (insertAttempts > 9){   //allows up to 10 inserts before terminating
        System.out.println("You have tried to insert too many incompatible cards");
        System.exit(0);
      }
      System.out.println("Your card is not compatible with this ATM. Please insert another card (" + (10-insertAttempts) + " attempt(s) left): ");
      userCardName = input.nextLine();
    }
    System.out.println("Enter the PIN for this card: ");
    int attemptedPIN = input.nextInt();
    
    int pinAttempts = 0;
    while (atm.insertCardPIN(userCardName, attemptedPIN) == null){
      pinAttempts++;
      if (pinAttempts > 2){
        System.out.println("You have entered the PIN incorrectly too many times.");
        System.exit(0);
      }
      System.out.println("PIN is incorrect. Re-enter the PIN (" + (3-pinAttempts) + " attempt(s) left): ");
      attemptedPIN = input.nextInt();
    }
    HashMap<String, Account> accountsInCard = atm.insertCardPIN(userCardName, attemptedPIN).get(userCardName).getAccounts(attemptedPIN);
    System.out.println("Login to card successful! Select the account you want to use by typing it's name: " + accountsInCard.keySet());

    int accAttempts = 0;
    String inputtedAccName = input.nextLine();
    while (atm.insertCardPIN(userCardName, attemptedPIN).get(userCardName).getAccounts(attemptedPIN).keySet().contains(inputtedAccName) == false){
      accAttempts++;
      if (accAttempts > 4){
        System.out.println("You have entered an invalid account name too many times.");
        System.exit(0);
      }
      System.out.println("Please re-enter a valid account name (" +(5-accAttempts)+" attempt(s) left): ");
      inputtedAccName = input.nextLine();
    }
    System.out.println("What would you like to do with this account? Enter 0 to see balance, enter 1 to deposit, and enter 2 to withdraw: ");
    int accountAction = input.nextInt();
    Account chosenAcc = atm.insertCardPIN(userCardName, attemptedPIN).get(userCardName).getAccounts(attemptedPIN).get(inputtedAccName);
    int actionAttempts = 0;
    while (accountAction != 0 && accountAction != 1 && accountAction != 2){
      actionAttempts++;
      if (actionAttempts > 4){
        System.out.println("You have failed to enter a valid action number too many times.");
        System.exit(0);
      }
      System.out.println("Please re-enter a valid action number ("+(5-actionAttempts) + " attempt(s) left): ");
      accountAction = input.nextInt();
    }
    if (accountAction == 0){
      System.out.println("The balance for this account is: " + chosenAcc.seeBalance());
    }
    else if (accountAction == 1){
      System.out.println("How much money would you like to deposit? ");
      int depositAmount = input.nextInt();
      chosenAcc.deposit(depositAmount);
      System.out.println("Deposit completed.");
    }
    else if (accountAction == 2){
      System.out.println("How much money would you like to withdraw? ");
      int withdrawAmount = input.nextInt();
      chosenAcc.withdraw(withdrawAmount);
      System.out.println("Withdrawal completed.");
    }
    input.close();
  }


  private static HashMap<String, Card> setExamples(){    // sets up the example cards
    //set up to make testCard1:
    Account testAccount1 = new Account("Mike's cash acc", 100);
    Account testAccount2 = new Account("Mike's pocket money acc", 200);
    Account testAccount3 = new Account("Mike's spare acc", 300);
    HashMap<String, Account> card1Accounts = new HashMap<String, Account>();
    card1Accounts.put(testAccount1.getAccountName(), testAccount1);
    card1Accounts.put(testAccount2.getAccountName(), testAccount2);
    card1Accounts.put(testAccount3.getAccountName(), testAccount3);
    Card testCard1 = new Card("Mike's Wells Fargo Bronze Card", 123456, card1Accounts);
    
    //set up to make testCard2:
    Account testAccount4 = new Account("Veronica's credit acc", 400);
    Account testAccount5 = new Account("Veronica's coupon money acc", 500);
    Account testAccount6 = new Account("Veronica's savings acc", 600);
    Account testAccount7 = new Account("Veronica's pension acc", 700);
    HashMap<String, Account> card2Accounts = new HashMap<String, Account>();
    card2Accounts.put(testAccount4.getAccountName(), testAccount4);
    card2Accounts.put(testAccount5.getAccountName(), testAccount5);
    card2Accounts.put(testAccount6.getAccountName(), testAccount6);
    card2Accounts.put(testAccount7.getAccountName(), testAccount7);
    Card testCard2 = new Card("Veronica's Visa Silver Card", 987654, card2Accounts);

    //set up to make testCard3:
    Account testAccount8 = new Account("Alice's savings acc", 233);
    Account testAccount9 = new Account("Alice's salary money acc", 9800);
    Account testAccount10 = new Account("Alice's fixed deposit acc", 4234);
    Account testAccount11 = new Account("Alice's current acc", 212);
    Account testAccount12 = new Account("Alice's checking acc", 512);
    Account testAccount13 = new Account("Alice's money market acc", 40);
    Account testAccount14 = new Account("Alice's stocks acc", 1253);
    HashMap<String, Account> card3Accounts = new HashMap<String, Account>();
    card3Accounts.put(testAccount8.getAccountName(), testAccount8);
    card3Accounts.put(testAccount9.getAccountName(), testAccount9);
    card3Accounts.put(testAccount10.getAccountName(), testAccount10);
    card3Accounts.put(testAccount11.getAccountName(), testAccount11);
    card3Accounts.put(testAccount12.getAccountName(), testAccount12);
    card3Accounts.put(testAccount13.getAccountName(), testAccount13);
    card3Accounts.put(testAccount14.getAccountName(), testAccount14);
    Card testCard3 = new Card("Alice's American Express Platinum Card", 112358, card3Accounts);

    //set up to make testCard4:
    Account testAccount15 = new Account("Bob's wage acc", 2342);
    Account testAccount16 = new Account("Bob's investments acc", 7823);
    HashMap<String, Account> card4Accounts = new HashMap<String, Account>();
    card4Accounts.put(testAccount15.getAccountName(), testAccount15);
    card4Accounts.put(testAccount16.getAccountName(), testAccount16);
    Card testCard4 = new Card("Bob's Mastercard Gold Card", 342390, card4Accounts);

    HashMap<String, Card> compatibleCards = new HashMap<String, Card>();
    compatibleCards.put(testCard1.getName(), testCard1);
    compatibleCards.put(testCard2.getName(), testCard2);
    compatibleCards.put(testCard3.getName(), testCard3);
    compatibleCards.put(testCard4.getName(), testCard4);
    return compatibleCards;
  }
}
