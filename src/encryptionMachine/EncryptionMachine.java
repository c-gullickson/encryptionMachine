package encryptionMachine;

import java.util.Scanner;

public class EncryptionMachine {
	
	public static void main(String[] args) {
		
		IntroductoryMessage();
		MessageEncryptionInit();
			
	}
	
	private static void IntroductoryMessage() {
		
		System.out.println("Welcome to the Encryption Machine");
		System.out.println("This machine performs two functions:");
		System.out.println("Function 1: convert a standard text based message into an encrypted message");
		System.out.println("Function 2: Convert a cipher text based message into a decrypted message");
		System.out.println("All based on a user inputs and Ceaser Cipher encryption/decryption.");
		System.out.println("===============================================================================================");
	}
	
	private static void MessageEncryptionInit() {
		Scanner scanner = new Scanner(System.in);
		Encryption encryption = new Encryption();
		// ask user to encrypt or decrypt
		do {
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
		encryption.EncryptDecryptMessage(messageToEncrypt, isEncrypt);
		
		}while (IsUserContinue(scanner));
	}
	
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
	
	private static int UserSetShift(Scanner scanner) {
		int shiftAmount = 0;
		System.out.println("===============================================================================================");
		System.out.print("Please enter a shift integer: ");
		
		shiftAmount = scanner.nextInt();
		
		return shiftAmount;
	}
	
	private static String UserEncryptionDecryptionKey(Scanner scanner, boolean isEncrypt) {
		String keyToEncrypt = "";
		System.out.println("===============================================================================================");
		System.out.print("Please enter your cypher key: ");
		keyToEncrypt = scanner.next();
		
		//Should parse out unnecessary characters??
		
		String printMessage = isEncrypt == true ? "Your key to encrypt is: " + keyToEncrypt : "Your key to decrypt is: " + keyToEncrypt;
		System.out.println(printMessage);
		return keyToEncrypt;
	}
	
	private static String UserEncryptionDecryptionLetter(Scanner scanner, boolean isEncrypt) {
		String letterToEncrypt = "";
		System.out.println("===============================================================================================");
		System.out.print("Please enter a test letter: ");
		letterToEncrypt = scanner.next();
		
		String printMessage = isEncrypt == true ? "Your test letter to encrypt is: " + letterToEncrypt : "Your test letter to decrypt is: " + letterToEncrypt;
		System.out.println(printMessage);
		
		return letterToEncrypt;
	}
	
	private static String[] UserEncryptionDecryptionMessage(Scanner scanner, boolean isEncrypt) {
		int wordsToEncrypt = 0;
		String message = "";
		System.out.println("===============================================================================================");
		String printNumberOfWordsMessage = isEncrypt == true ? "Please enter the number of words to encrypt: " : "Please enter the number of words to decrypt: ";

		System.out.print(printNumberOfWordsMessage);
		wordsToEncrypt = scanner.nextInt();
		
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

