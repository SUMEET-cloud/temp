import javax.crypto.*;
import java.security.*;
import java.util.Scanner;
import java.io.*;

class AES {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException,
            InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException,
            BadPaddingException {

        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();

        byte[] myMessage = message.getBytes();

        KeyGenerator Mygenerator = KeyGenerator.getInstance("AES");
        SecretKey myAesKey = Mygenerator.generateKey();

        Cipher myCipher = Cipher.getInstance("AES");
        myCipher.init(Cipher.ENCRYPT_MODE, myAesKey);
        byte[] myEncryptedBytes = myCipher.doFinal(myMessage);
        myCipher.init(Cipher.DECRYPT_MODE, myAesKey);
        byte[] myDecryptedBytes = myCipher.doFinal(myEncryptedBytes);

        String encrypteddata = new String(myEncryptedBytes);
        String decrypteddata = new String(myDecryptedBytes);

        System.out.println("Message : " + message + "\n");
        System.out.println("Encrypted - " + encrypteddata + "\n");
        System.out.println("Decrypted Message - " + decrypteddata);

        sc.close();
    }
}