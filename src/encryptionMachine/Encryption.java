package encryptionMachine;

public class Encryption {

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private static int shift = 0;
	
	
	public Encryption() {
		
	}
	
	public void SetShiftAmount(int shiftValue) {
		shift = shiftValue;
		System.out.println("Your shift value is equal to: " + shift);
		System.out.print("===============================================================================================");
	}
	
	public void EncryptDecryptKey(String key, boolean isEncrypt) {
		String encryptDecryptKey = "";
		encryptDecryptKey = CeaserCipher(key, isEncrypt);
		
		String printMessage = isEncrypt == true ? "Your encrypted key result is equal to: " + encryptDecryptKey : "Your decrypted key result is equal to: " + encryptDecryptKey;
		System.out.println(printMessage);
		System.out.print("===============================================================================================");
	}
	
	public void EncryptDecryptLetter(String letter, boolean isEncrypt) {
		String encryptDecryptLetter = "";
		encryptDecryptLetter = CeaserCipher(letter, isEncrypt);
		
		String printMessage = isEncrypt == true ? "Your encrypted letter result is equal to: " + encryptDecryptLetter : "Your decrypted letter result is equal to: " + encryptDecryptLetter;
		System.out.println(printMessage);
		System.out.print("===============================================================================================");
	}
	
	public void EncryptDecryptMessage(String[] messageWordArray, boolean isEncrypt) {
		String encryptDecryptMessage = "";
		
		for(int i = 0; i < messageWordArray.length; i++) {
			encryptDecryptMessage += CeaserCipher(messageWordArray[i], isEncrypt) + " ";
		}
		
		String printMessage = isEncrypt == true ? "Your encrypted message result is equal to: " + encryptDecryptMessage : "Your decrypted message result is equal to: " + encryptDecryptMessage;
		System.out.println(printMessage);
		System.out.print("===============================================================================================");
	}
	
	private static String CeaserCipher(String plaintext, boolean isEncrypt) {
		StringBuilder stringBuilder = new StringBuilder();
		
		if (isEncrypt) {
			for(int i = 0; i < plaintext.length(); i++){
				char singleChar = (plaintext.charAt(i));
			    
			    int singleCharIndex = ALPHABET.indexOf(singleChar);
			    int addedCharIndex = (singleCharIndex + shift) % ALPHABET.length();
	
			    stringBuilder.append(ALPHABET.charAt(addedCharIndex));			
			}		    
		}
		else {
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
