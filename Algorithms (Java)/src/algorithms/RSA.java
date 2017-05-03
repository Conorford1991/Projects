
package algorithms;


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
import sun.misc.BASE64Encoder;

public class RSA {
     Cipher encipher,decipher;
     public RSA() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, InvalidKeySpecException{
        KeyPairGenerator keypair = KeyPairGenerator.getInstance("RSA");
        keypair.initialize(3072);
        KeyPair kp = keypair.genKeyPair();
        PublicKey publicKey = kp.getPublic();
        PrivateKey privateKey = kp.getPrivate();
       
        encipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        decipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        
        // Initialise ciphers
        encipher.init(Cipher.ENCRYPT_MODE, publicKey);
        decipher.init(Cipher.DECRYPT_MODE, privateKey);
        
    }
    public byte[] Encrypt(String Plaintext) throws BadPaddingException, IllegalBlockSizeException{
        // Convert plaintext to bytes
        byte[] bytePlaintext = Plaintext.getBytes();
        // Encrypt the bytes using doFinal method
        byte[] byteCiphertext = encipher.doFinal(bytePlaintext);
        // Encodes all bytes from the specified byteCiphertext array into a newly-allocated 
        // String using the Base64 encoding scheme.
        String Ciphertext = new BASE64Encoder().encode(byteCiphertext);
        System.out.println("RSA Ciphertext: "+Ciphertext);
        // return byteCipherText
        return byteCiphertext;
    }
    public void Decrypt(byte[] byteCiphertext) throws IllegalBlockSizeException, BadPaddingException{
        // Decrypt the bytes using doFinal method
        byte[] byteDecryptedtext = decipher.doFinal(byteCiphertext);
        // Bytes to plaintext
        String Plaintext = new String(byteDecryptedtext);
        System.out.println("RSA (AES key) after decryption: "+Plaintext);
    }
}
