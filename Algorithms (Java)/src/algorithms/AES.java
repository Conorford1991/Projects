// Author: Conor Ford
// AES class
package algorithms;

// imports
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;


public class AES {
      // Instantiate Cipher objects: encipher (encryption) and decipher (decryption)
     Cipher encipher,decipher;
     // Instantiate FileReader class
     FileReader fl = new FileReader();
     
     // AES constructor
     public AES() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException{
        // Instantiation of an AES key generator
        KeyGenerator key = KeyGenerator.getInstance("AES");
        
        // Instantiation of a secretkey
        // Generate an AES secret key using the key generator. 
        SecretKey secretkey = key.generateKey();
        
        // Generate encryption cipher (AES, Cipher Feedback Block, Public-Key Cryptography Standards-5 Padding )
        encipher = Cipher.getInstance("AES/CFB/PKCS5Padding");
        
        // Generate decryption cipher (AES, Cipher Feedback Block, Public-Key Cryptography Standards-5 Padding )
        decipher = Cipher.getInstance("AES/CFB/PKCS5Padding");
        
        // Generate random initial vector(iv)
        // SecureRandom class is used to generate a cryptographically strong 
        // pseudo random number by using SHA1 and a Psuedo Random Number Generator Algorithm (SHA1PRNG). 
        // The following are the advantages of using SecureRandom over Random. 
        // 1. SecureRandom produces a cryptographically strong pseudo random number generator. 
        // 2. SecureRandom produces cryptographically strong sequences 
        SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
        
        // KeySize in bits
        // ** JCE limits the AES keysize to 128 bits
        int KeySize = 128;
        
        // Block size
        int BlockSize = 8;
        
        // Instantiate a byte array (iv) that size is = keysize divided by the blocksize 
        byte[] iv = new byte[KeySize/BlockSize];
        
        // Generate the inital vector based on the array byte iv and the random generator
        rand.nextBytes(iv);
        
        // Creates an IvParameterSpec object using the iv bytes as the inital vector.
        IvParameterSpec paramSpec = new IvParameterSpec(iv);
        
        // Initialise ciphers
        // Encrypt cipher
        encipher.init(Cipher.ENCRYPT_MODE, secretkey, paramSpec);
        
        // Decrypt cipher
        decipher.init(Cipher.DECRYPT_MODE, secretkey, paramSpec);
        
    }
    public byte[] Encrypt(String Plaintext) throws BadPaddingException, IllegalBlockSizeException, FileNotFoundException, UnsupportedEncodingException{
        // Byte array takes byte value from the plaintext string
        byte[] bytePlaintext = Plaintext.getBytes();
        
        // Byte array byteCiphertext takes the byte value of the encrypt operation from
        // the encryption cipher and the doFinal method that takes in 
        // the bytePlaintext byte array. 
        byte[] byteCiphertext = encipher.doFinal(bytePlaintext);
        
        // Encodes all bytes from the specified byteCiphertext array into a newly-allocated 
        // String using the Base64 encoding scheme.
        String Ciphertext = new String(java.util.Base64.getMimeEncoder().encode(byteCiphertext),StandardCharsets.UTF_8);
        
        // Write ciphertext to file
        fl.EncryptedFileWriter(Ciphertext,"AES");
        
         // Print
        System.out.println("AES encryption complete. Ciphertext write to file sucessful");
        
        // return byteCipherText
        return byteCiphertext;
    }
    public void Decrypt(byte[] byteCiphertext) throws IllegalBlockSizeException, BadPaddingException, FileNotFoundException, UnsupportedEncodingException{
        // Byte array byteCiphertext takes the byte value of the decrypt operation from
        // the decryption cipher and the doFinal method that takes in 
        // the byteCiphertext byte array. 
        byte[] byteDecryptedtext = decipher.doFinal(byteCiphertext);
        
        // String Plaintext takes String value from the byte array
        String Plaintext = new String(byteDecryptedtext);
        
        // Write plaintext to file
        fl.DecryptedFileWriter(Plaintext,"AES");
        
         // Print
        System.out.println("AES decryption complete. Plaintext write to file sucessful");
    }
}
