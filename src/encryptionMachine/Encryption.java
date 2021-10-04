/**
 * Cody Gullickson
 * CSCI 717 
 * Encryption Machine project
 * Encryption class
 * 
 * The purpose of this class is to take the defined user inputs of a letter, word, and message, and 
 * encode/decode each input based on an entered shift code using a constant alphabet and a dynamic shift value.
 * 
 */
package encryptionMachine;

public class Encryption {

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private static int shift = 0;
	
	
	public Encryption() {
		
	}
	
	/**
	 * User set shift value 
	 * @param shiftValue; integer value that will always be positive from user input
	 */
	public void SetShiftAmount(int shiftValue) {
		shift = shiftValue;
		System.out.println("Your shift value is equal to: " + shift);
		System.out.print("===============================================================================================");
	}
	
	/**
	 * Method for encrypting or decrypting a user defined string value key.
	 * @param key; User defined string value to encrypt or decrypt.
	 * @param isEncrypt; User defined boolean value to determine if an encryption or decryption should be used in Ceasers Cipher.
	 */
	public void EncryptDecryptKey(String key, boolean isEncrypt) {
		String encryptDecryptKey = "";
		encryptDecryptKey = CeaserCipher(key, isEncrypt);
		
		String printMessage = isEncrypt == true ? "Your encrypted key result is equal to: " + encryptDecryptKey : "Your decrypted key result is equal to: " + encryptDecryptKey;
		System.out.println(printMessage);
		System.out.print("===============================================================================================");
	}
	
	/**
	 * Method for encrypting or decrypting a user defined string value character.
	 * @param letter; User defined string value letter to encrypt or decrypt.
	 * @param isEncrypt; User defined boolean value to determine if an encryption or decryption should be used in Ceasers Cipher.
	 */
	public void EncryptDecryptLetter(String letter, boolean isEncrypt) {
		String encryptDecryptLetter = "";
		encryptDecryptLetter = CeaserCipher(letter, isEncrypt);
		
		String printMessage = isEncrypt == true ? "Your encrypted letter result is equal to: " + encryptDecryptLetter : "Your decrypted letter result is equal to: " + encryptDecryptLetter;
		System.out.println(printMessage);
		System.out.print("===============================================================================================");
	}
	
	/**
	 * Method for encrypting or decrypting an array of user defined string value words.
	 * @param messageWordArray; User defined array of string value words to encrypt or decrypt.
	 * @param isEncrypt; User defined boolean value to determine if an encryption or decryption should be used in Ceasers Cipher.
	 */
	public void EncryptDecryptMessage(String[] messageWordArray, boolean isEncrypt) {
		String encryptDecryptMessage = "";
		
		for(int i = 0; i < messageWordArray.length; i++) {
			encryptDecryptMessage += CeaserCipher(messageWordArray[i], isEncrypt) + " ";
		}
		
		String printMessage = isEncrypt == true ? "Your encrypted message result is equal to: " + encryptDecryptMessage : "Your decrypted message result is equal to: " + encryptDecryptMessage;
		System.out.println(printMessage);
		System.out.print("===============================================================================================");
	}
	
	/**
	 * The method that controls the CeaserCipher algorithm for encrypting or decrypting passed attributes.
	 * @param plaintext; User defined value who's characters will be shifted by "shift" defined amount.
	 * @param isEncrypt; User defined value to determine if characters will be added to or subtracted from the current value.
	 * @return A string of the encrypted or decrypted value.
	 */
	private static String CeaserCipher(String plaintext, boolean isEncrypt) {
		StringBuilder stringBuilder = new StringBuilder();
		
		if (isEncrypt) { // encrypt plaintext value passed by adding the shift value to the character index.
			for(int i = 0; i < plaintext.length(); i++){
				char singleChar = (plaintext.charAt(i));
			    
			    int singleCharIndex = ALPHABET.indexOf(singleChar);
			    int addedCharIndex = (singleCharIndex + shift) % ALPHABET.length();
	
			    stringBuilder.append(ALPHABET.charAt(addedCharIndex));			
			}		    
		}
		else {	// decrypt plaintext value passed by subtracting the shift value to the character index.
			for(int i = 0; i < plaintext.length(); i++){
				char singleChar = (plaintext.charAt(i));
			    
			    int singleCharIndex = ALPHABET.indexOf(singleChar);
			    int addedCharIndex = Math.abs((singleCharIndex - shift + ALPHABET.length()) % ALPHABET.length());
	
			    stringBuilder.append(ALPHABET.charAt(addedCharIndex));			
			}
		}
		return stringBuilder.toString();
	}
}
