/**
 * Cody Gullickson
 * CSCI 717 
 * Encryption Machine project
 * Encryption Machine class
 * 
 * The purpose of this application is to take a user input letter, word, and message, and 
 * encode/decode each input based on an entered shift code.
 * 
 */
package encryptionMachine;
import java.util.Scanner;

public class EncryptionMachine {
	
	/**
	 * Main driver method to initialize program.
	 */
	public static void main(String[] args) {
		
		MessageEncryptionInit();
	}
	
	/**
	 * Initialization of scanner and encryption classes used for collecting user input and encrypting/decrypting.
	 */
	private static void MessageEncryptionInit() {
		IntroductoryMessage();
		
		Scanner scanner = new Scanner(System.in);
		Encryption encryption = new Encryption();
		
		do {
			// ask user if they would like to run the application as encrypt or decrypt.
			boolean isEncrypt = IsUserEncrypt(scanner);
			
			int shiftValue = UserSetShift(scanner);
			encryption.SetShiftAmount(shiftValue);
			
			// get user cipher key to encrypt or decrypt
			String keyToEncrypt = UserEncryptionDecryptionKey(scanner, isEncrypt);
			encryption.EncryptDecryptKey(keyToEncrypt, isEncrypt);
			
			// get test letter to encrypt or decrypt encryption
			String letterToEncrypt = UserEncryptionDecryptionLetter(scanner, isEncrypt);
			encryption.EncryptDecryptLetter(letterToEncrypt, isEncrypt);
			
			// get user message to encrypt or decrypt
			String[] messageToEncrypt = UserEncryptionDecryptionMessage(scanner, isEncrypt);
			if (messageToEncrypt != null) {
				encryption.EncryptDecryptMessage(messageToEncrypt, isEncrypt);
			}
			
		
		}while (IsUserContinue(scanner));
	}
	
	/**
	 * Print message to user about what program does.
	 */
	private static void IntroductoryMessage() {
		
		System.out.println("Welcome to the Encryption Machine");
		System.out.println("This machine performs two functions:");
		System.out.println("Function 1: convert a standard text based message into an encrypted message");
		System.out.println("Function 2: Convert a cipher text based message into a decrypted message");
		System.out.println("All based on a user inputs and Ceaser Cipher encryption/decryption.");
		System.out.println("===============================================================================================");
	}
	
	/**
	 * Get user input based on the options to encrypt, decrypt, or end the application.
	 * @param scanner; for user keyboard inputs
	 * @return a boolean value that will determine if the user is going to run the applicaiton as encrypting (true or false)
	 * A false value will be treated as decrypting.
	 */
	private static boolean IsUserEncrypt(Scanner scanner) {
		boolean isEncrypt = true;
		System.out.println("===============================================================================================");
		System.out.println("Please select an option: (encrypt) (decrypt) (end)");

		String flag = scanner.next();
		
		if (flag.equalsIgnoreCase("encrypt")) {
			isEncrypt = true;
		}
		else if (flag.equalsIgnoreCase("decrypt")) {
			isEncrypt = false;
		}
		else if (flag.equalsIgnoreCase("end")) {
			System.out.println("System ending.");
			System.exit(1);
		}
		else {
			System.out.println("Invalid Option {"+ flag + "}: Please retry with a valid option.");
			IsUserEncrypt(scanner);
		}
		
		return isEncrypt;
	}
	
	/**
	 * Get user input based on the value to set the amount of ceasar cipher shift.
	 * @param scanner; for user keyboard inputs
	 * @return an absolute value integer value will will be returned to be set as the amount of shift characters
	 * to be used for either encrypting or decrypting messages. If an invalid character is returned, the shift value will default to 0.
	 */
	private static int UserSetShift(Scanner scanner) {
		int shiftAmount = 0;
		System.out.println("===============================================================================================");
		System.out.print("Please enter a shift integer: ");
		
		try {
			shiftAmount = scanner.nextInt();
		} catch (Exception ex){
			System.out.print("Invalid value for the shift character value. Defaulting shift value to 0.");
			scanner.nextLine();
			return 0;
		}
		
		return Math.abs(shiftAmount);
	}
	
	/**
	 * User input method for entering a key that can be encrypted or decrypted.
	 * @param scanner; for user keyboard inputs
	 * @param isEncrypt; a boolean value that determines if the user will be encrypting or decrypting the entered key.
	 * @return A string value is returned to later be passed to the encryption class.
	 */
	private static String UserEncryptionDecryptionKey(Scanner scanner, boolean isEncrypt) {
		String keyToEncrypt = "";
		System.out.println("===============================================================================================");
		System.out.print("Please enter your cypher key: ");
		keyToEncrypt = scanner.next();
				
		String printMessage = isEncrypt == true ? "Your key to encrypt is: " + keyToEncrypt : "Your key to decrypt is: " + keyToEncrypt;
		System.out.println(printMessage);
		
		return keyToEncrypt;
	}
	
	/**
	 * User input method for entering a string letter that can be encrypted or decrypted.
	 * @param scanner; for user keyboard inputs
	 * @param isEncrypt; a boolean value that determines if the user will be encrypting or decrypting the entered letter.
	 * @return A string value is returned to later be passed to the encryption class.
	 */
	private static String UserEncryptionDecryptionLetter(Scanner scanner, boolean isEncrypt) {
		String letterToEncrypt = "";
		System.out.println("===============================================================================================");
		System.out.print("Please enter a test letter: ");
		letterToEncrypt = scanner.next();
		
		String printMessage = isEncrypt == true ? "Your test letter to encrypt is: " + letterToEncrypt : "Your test letter to decrypt is: " + letterToEncrypt;
		System.out.println(printMessage);
		
		return letterToEncrypt;
	}
	
	/**
	 * User input method for entering an array of words key that can be encrypted or decrypted.
	 * @param scanner; for user keyboard inputs
	 * @param isEncrypt; a boolean value that determines if the user will be encrypting or decrypting the entered key.
	 * @return A string array value is returned to later be passed to the encryption class where each word in the array will be encrypted or decrypted.
	 * 		The return could be a null array list if the user enters in an invalid value for number of words in message.
	 */
	private static String[] UserEncryptionDecryptionMessage(Scanner scanner, boolean isEncrypt) {
		int wordsToEncrypt = 0;
		String message = "";
		System.out.println("===============================================================================================");
		String printNumberOfWordsMessage = isEncrypt == true ? "Please enter the number of words to encrypt: " : "Please enter the number of words to decrypt: ";

		System.out.print(printNumberOfWordsMessage);
		try {
			wordsToEncrypt = scanner.nextInt();			
		} catch (Exception ex){
			System.out.print("Invalid value for number of words to enter. ");
			scanner.nextLine();
			return null;
		}
		
		String[] messageToEncrypt = new String[wordsToEncrypt];
		
		for(int i = 0; i < wordsToEncrypt; i++) {
			System.out.print("Please enter in word " + (i + 1) + ":");
			//Should parse out unnecessary characters??

			String word = scanner.next();
			messageToEncrypt[i] = word;
			System.out.println();
			message += word + " ";
		}
		
		String printMessage = isEncrypt == true ? "Your message to encrypt was: " + message : "Your message to decrypt was: " + message;
		System.out.println(printMessage);

		return messageToEncrypt;
	}
	
	/**
	 * A user input check to see if they would like the application to continue, or exit
	 * @param scanner; for user keyboard inputs
	 * @return a boolean flag interpreted as continuing to run or to exit 
	 */
	private static boolean IsUserContinue(Scanner scanner) {
		boolean action = true;
		System.out.println("===============================================================================================");
		System.out.println("Please select an option: (run) (end)");
		System.out.println("===============================================================================================");

		String flag = scanner.next();
		
		if (flag.equalsIgnoreCase("run")) {
			action = true;
		}
		else if (flag.equalsIgnoreCase("end")) {
			System.out.println("System ending.");
			System.exit(1);
		}
		else {
			System.out.println("Invalid Option {"+ flag + "}: Please retry with a valid option.");
			IsUserContinue(scanner);
		}
		
		return action;
	}
}

