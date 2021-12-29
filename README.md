# Simple ATM Machine

The main task in this project was to create a secure ATM Controller class that does not expose the PIN to the user or the ATM and only checks if the attempted PIN is correct without ever using the actual correct PIN. There are 3 classes: ATMController, Card, and Account. I designed these classes in a way to ensure that the user only interacts with the ATMController class by making an object of type ATMController and using its methods. The insertCardPIN method in the ATMController class checks if attemptedPIN is correct by comparing the result of hashing attemptedPIN with the result of hashing the real PIN. The hash function used was the built-in hashCode() method in the Integer class. This way, the ATM never gets access to the correct PIN, just the result of hashing it which is secure because one can't reverse a hash function. Without the correct PIN, the user only gets access to the names of the cards or the names of the accounts which is safe because these names are nothing but strings and aren't the actual objects containing money data.

In the Main method I simply included some code to set up an example and implemented a simple console UI that just asks the user for information using text I/O. To briefly outline the steps, the user has to insert a card by typing the name of the card. If the card is compatible with this ATM machine (the user gets a list of compatible cards), it asks the user to type the PIN. If the PIN is correct, the user gets a list of accounts on this card. The user must choose an account by typing the name. The user can either see balance, withdraw, or deposit into the account. For each of these steps, there is a limit on the number of invalid answers the user can give before the program terminates and tells the user they gave too many invalid answers.

One can simply run the main method to "test" how the program works by following the directions printed on the console. To do actual testing with test case sets, one could create the test set separately and read it line by line in the main method, inputting the text into the appropriate methods in ATMController. The test set can be made as a simple .txt file with strings like card nam, PIN (which will be converted to int), account name, action number, amount (for deposit and withdraw) in its own line. This way the scanner in the main method can simply read the inputs line by line and pass them onto the ATMController methods. In 

To clone this project, one can simply use the git clone command on terminal after copying the link to this repository.
