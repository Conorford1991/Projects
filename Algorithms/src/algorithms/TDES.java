
package algorithms;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import sun.misc.BASE64Encoder;

public class TDES {
    Cipher encipher,decipher;
    public TDES() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException{
        // Generate 3DES key (default keylength of 168 bits (56 x 3))
        KeyGenerator key = KeyGenerator.getInstance("DESede");
        SecretKey secretkey = key.generateKey();
        
        
       // Generate ciphers (DESede(3DES), CBC(Cipher Block Chaining),PKCS5Padding )
        encipher = Cipher.getInstance("DESede/CFB/PKCS5Padding");
        decipher = Cipher.getInstance("DESede/CFB/PKCS5Padding");
        
        // Generate random initial vector(iv)
        // SecureRandom class is used to generate a cryptographically strong 
        // pseudo random number by using a Psuedo Random Number Generator Algorithm. 
        // The following are the advantages of using SecureRandom over Random. 
        // 1. SecureRandom produces a cryptographically strong pseudo random number generator. 
        // 2. SecureRandom produces cryptographically strong sequences 
        SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
        // KeySize in bits
        int KeySize = 64;
        byte[] iv = new byte[KeySize/8];
        rand.nextBytes(iv);
        // Pass in the iv
        AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
        
        // Initialise ciphers
        encipher.init(Cipher.ENCRYPT_MODE, secretkey, paramSpec);
        decipher.init(Cipher.DECRYPT_MODE, secretkey, paramSpec);
        
    }
    public byte[] Encrypt(String Plaintext) throws BadPaddingException, IllegalBlockSizeException{
        // Convert plaintext to bytes
        byte[] bytePlaintext = Plaintext.getBytes();
        // Encrypt the bytes using doFinal method
        byte[] byteCiphertext = encipher.doFinal(bytePlaintext);
        // Encodes all bytes from the specified byteCiphertext array into a newly-allocated 
        // String using the Base64 encoding scheme.
        String Ciphertext = new BASE64Encoder().encode(byteCiphertext);
        System.out.println("TDES Ciphertext: "+Ciphertext);
       
        return byteCiphertext;
    }
    public void Decrypt(byte[] byteCiphertext) throws IllegalBlockSizeException, BadPaddingException{
        // Decrypt the bytes using doFinal method
        byte[] byteDecryptedtext = decipher.doFinal(byteCiphertext);
        // Bytes to plaintext
        String Plaintext = new String(byteDecryptedtext);
        System.out.println("TDES Plaintext after decryption: "+Plaintext);
    }
}
