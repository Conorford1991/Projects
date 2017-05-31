// Author: Conor Ford
// TDES class
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


public class TDES {
      // Instantiate Cipher objects: encipher (encryption) and decipher (decryption)
     Cipher encipher,decipher;
     // Instantiate FileReader class
     FileReader fl = new FileReader();
     
     // TDES constructor
     public TDES() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException{
        // Instantiation of a TDES key generator
        KeyGenerator key = KeyGenerator.getInstance("DESede");
        
        // Instantiation of a secretkey
        // Generate a TDES secret key using the key generator. 
        SecretKey secretkey = key.generateKey();
        
        // Generate encryption cipher (TDES, Cipher Feedback Block, Public-Key Cryptography Standards-5 Padding )
        encipher = Cipher.getInstance("DESede/CFB/PKCS5Padding");
        
        // Generate decryption cipher (TDES, Cipher Feedback Block, Public-Key Cryptography Standards-5 Padding )
        decipher = Cipher.getInstance("DESede/CFB/PKCS5Padding");
        
        // Generate random initial vector(iv)
        // SecureRandom class is used to generate a cryptographically strong 
        // pseudo random number by using SHA1 and a Psuedo Random Number Generator Algorithm (SHA1PRNG). 
        // The following are the advantages of using SecureRandom over Random. 
        // 1. SecureRandom produces a cryptographically strong pseudo random number generator. 
        // 2. SecureRandom produces cryptographically strong sequences 
        SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
        
        // KeySize in bits
        int KeySize = 64;
        
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
        
        // write ciphertext to file
        fl.EncryptedFileWriter(Ciphertext,"TDES");
        
         // Print
        System.out.println("TDES encryption complete. Ciphertext write to file sucessful");
        
        // return byteCipherText
        return byteCiphertext;
    }
    public void Decrypt(byte[] byteCiphertext) throws IllegalBlockSizeException, BadPaddingException, FileNotFoundException{
        // Byte array byteCiphertext takes the byte value of the decrypt operation from
        // the decryption cipher and the doFinal method that takes in 
        // the byteCiphertext byte array. 
        byte[] byteDecryptedtext = decipher.doFinal(byteCiphertext);
        
        // String Plaintext takes String value from the byte array
        String Plaintext = new String(byteDecryptedtext);
        
        // write plaintext to file
        fl.DecryptedFileWriter(Plaintext,"TDES");
        
         // Print
        System.out.println("TDES decryption complete. Plaintext write to file sucessful");
    }
}
