package task2_lab1;

public class MyCaesar {
	 public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 
			    'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			    'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
			    
			    private int n; // shift steps (right shift)
			    
			    public MyCaesar(int shiftSteps) {
			        this.n = shiftSteps;
			    }
			    
			 // Encrypt a character according to the given shif steps.
			 // Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET
			 // array
			    public char encryptChar(char c) {
			        if (!Character.isLetter(c)) {
			            return c; // Trả về các ký tự không phải chữ cái

			        }
			        
			        char upperCaseChar = Character.toUpperCase(c);
			        int index = (upperCaseChar - 'A' + n) % 26; // Lấy chỉ số sau khi dịch chuyển
			        return ALPHABET[index];
			    }
			    
			 // Encrypt a text using the above function for encrypting a charater.
			    public String encrypt(String input) {
			        StringBuilder encryptedString = new StringBuilder();
			        for (char c : input.toCharArray()) {
			            encryptedString.append(encryptChar(c));
			        }
			        return encryptedString.toString();
			    }
			    
			 // Decrypt a character according to the given shif steps.
			 // Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in the ALPHABET array
			    public char decryptChar(char c) {
			        if (!Character.isLetter(c)) {
			            return c; // Trả về các ký tự không phải chữ cái
			        }
			        
			        char upperCaseChar = Character.toUpperCase(c);
			        int index = (upperCaseChar - 'A' - n + 26) % 26; // Lấy chỉ mục gốc bằng cách đảo ngược ca
			        return ALPHABET[index];
			    }
			    
			 // Decrypt a encrypted text using the above function for decrypting a charater.
			    public String decrypt(String input) {
			        StringBuilder decryptedString = new StringBuilder();
			        for (char c : input.toCharArray()) {
			            decryptedString.append(decryptChar(c));
			        }
			        return decryptedString.toString();
			    }
	 public static void main(String[] args) {
		 MyCaesar caesar = new MyCaesar(3); 
	        
	        char encryptedChar = caesar.encryptChar('A');
	        System.out.println(encryptedChar); 
	        
	        System.out.println();
	       
	        char decryptedChar = caesar.decryptChar('D');
	        System.out.println(decryptedChar);
	        
	        System.out.println();
	    
	        String encryptedText = caesar.encrypt("HELLO");
	        System.out.println(encryptedText); 
	        
	        System.out.println();
	      
	        String decryptedText = caesar.decrypt("KHOOR");
	        System.out.println(decryptedText); 
	    }	
	}

	