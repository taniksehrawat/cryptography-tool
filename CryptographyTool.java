import java.util.Scanner;
public class CryptographyTool {    
    public static String encryptCaesar(String message, int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + key) % 26 + base);
            }
            encryptedMessage.append(ch);
        }
        return encryptedMessage.toString();
    }
    public static String decryptCaesar(String encryptedMessage, int key) {
        return encryptCaesar(encryptedMessage, 26 - (key % 26));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Cryptography Tool!");
        System.out.println("Choose an option:");
        System.out.println("1. Encrypt a message (Caesar Cipher)");
        System.out.println("2. Decrypt a message (Caesar Cipher)");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        if (choice == 1 || choice == 2) {
            System.out.print("Enter the message: ");
            String message = scanner.nextLine();
            System.out.print("Enter the encryption key (integer): ");
            int key = scanner.nextInt();
            if (choice == 1) {
                String encryptedMessage = encryptCaesar(message, key);
                System.out.println("Encrypted Message: " + encryptedMessage);
            } else {
                String decryptedMessage = decryptCaesar(message, key);
                System.out.println("Decrypted Message: " + decryptedMessage);
            }
        } else {
            System.out.println("Invalid choice! Exiting the program.");
        }
        scanner.close();
    }
}
