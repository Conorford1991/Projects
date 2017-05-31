// Author: Conor Ford
// RSA class
package algorithms;

// imports
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {
     // Instantiate Cipher objects: encipher (encryption) and decipher (decryption)
     Cipher encipher,decipher;
     // Instantiate FileReader class
     FileReader fl = new FileReader();
     
     // RSA constructor
     public RSA() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, InvalidKeySpecException{
        // Instantiation of an RSA key pair generator
        KeyPairGenerator keypair = KeyPairGenerator.getInstance("RSA");
        
        // Initialise the keypair generator using key length of 3072 bits
        keypair.initialize(3072);
        
        // Instantiate the keypair and generate the keys
        KeyPair kp = keypair.genKeyPair();
        
        // Instantiate the public key 
        PublicKey publicKey = kp.getPublic();
        
        // Instantiate the private key 
        PrivateKey privateKey = kp.getPrivate();
       
        // Generate encryption cipher (RSA, Electronic Code Book, Public-Key Cryptography Standards-1 Padding )
        encipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        
        // Generate decryption cipher (RSA, Electronic Code Book, Public-Key Cryptography Standards-1 Padding )
        decipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        
        // Initialise ciphers
        // Encrypt cipher
        encipher.init(Cipher.ENCRYPT_MODE, publicKey);
        
        // Decrypt cipher
        decipher.init(Cipher.DECRYPT_MODE, privateKey);
        
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
        fl.EncryptedFileWriter(Ciphertext,"RSA");
        
         // Print
        System.out.println("RSA encryption complete. Ciphertext write to file sucessful");
        
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
        fl.DecryptedFileWriter(Plaintext,"RSA");
        
         // Print
        System.out.println("RSA decryption complete. Plaintext write to file sucessful");
    }
}
