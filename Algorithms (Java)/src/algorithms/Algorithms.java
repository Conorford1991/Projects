
package algorithms;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Algorithms {
    public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException, IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, InvalidKeySpecException, NoSuchProviderException{
       FileReader fl = new FileReader();
       String Plaintext = fl.FileReader();
       System.out.println("Plaintext prior to encryption: "+Plaintext);
      
       AES_call();
       DES_call();
       TDES_call();
       Blowfish_call();
       
       String Keytext = fl.KeyReader();
       System.out.println("RSA (AES key) prior to encryption: "+Keytext);
       
       RSA_call();
       
       
    }
    static void AES_call()throws IllegalBlockSizeException, BadPaddingException, IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        
        AES aes = new AES();        
        
        FileReader fl = new FileReader();
        String Plaintext = fl.FileReader();
        
        double Encryptstart = System.currentTimeMillis();
        // Encryption 
        byte[] byteCiphertext = aes.Encrypt(Plaintext);
        
        double Encryptstop = System.currentTimeMillis();
        System.out.println("AES time taken to encrypt (seconds): "+ (Encryptstop-Encryptstart)/1000);
        
        double Decryptstart = System.currentTimeMillis();
        // Decryption
        aes.Decrypt(byteCiphertext);
        
        double Decryptstop = System.currentTimeMillis();
        System.out.println("AES time taken to decrypt (seconds): "+ (Decryptstop-Decryptstart)/1000);
    }
    static void DES_call() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException, BadPaddingException, IllegalBlockSizeException{
         
        DES des = new DES();
        
        FileReader fl = new FileReader();
        String Plaintext = fl.FileReader();
        //System.out.println("Plaintext: "+Plaintext);
        
        double Encryptstart = System.currentTimeMillis();
        // Encryption 
        byte[] byteCiphertext = des.Encrypt(Plaintext);
        
        double Encryptstop = System.currentTimeMillis();
        System.out.println("DES time taken to encrypt (seconds): "+ (Encryptstop-Encryptstart)/1000);
        
        double Decryptstart = System.currentTimeMillis();
        // Decryption
        des.Decrypt(byteCiphertext);
        
        double Decryptstop = System.currentTimeMillis();
        System.out.println("DES time taken to decrypt (seconds): "+ (Decryptstop-Decryptstart)/1000);
    }
    static void TDES_call() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException, BadPaddingException, IllegalBlockSizeException{
        
        TDES tdes = new TDES();  
        FileReader fl = new FileReader();
        String Plaintext = fl.FileReader();
        //System.out.println("Plaintext: "+Plaintext);
        
        double Encryptstart = System.currentTimeMillis();
        // Encryption 
        byte[] byteCiphertext = tdes.Encrypt(Plaintext);
        
        double Encryptstop = System.currentTimeMillis();
        System.out.println("TDES time taken to encrypt (seconds): "+ (Encryptstop-Encryptstart)/1000);
        
        double Decryptstart = System.currentTimeMillis();
        // Decryption
        tdes.Decrypt(byteCiphertext);
        
        double Decryptstop = System.currentTimeMillis();
        System.out.println("TDES time taken to decrypt (seconds): "+ (Decryptstop-Decryptstart)/1000);
        
    }
    static void Blowfish_call() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException, BadPaddingException, IllegalBlockSizeException{
        
        Blowfish blowfish = new Blowfish();
                
        FileReader fl = new FileReader();
        String Plaintext = fl.FileReader();
        //System.out.println("Plaintext: "+Plaintext);
        
        double Encryptstart = System.currentTimeMillis();
        // Encryption 
        byte[] byteCiphertext = blowfish.Encrypt(Plaintext);
        
        double Encryptstop = System.currentTimeMillis();
        System.out.println("Blowfish time taken to encrypt (seconds): "+ (Encryptstop-Encryptstart)/1000);
        
        double Decryptstart = System.currentTimeMillis();
        // Decryption
        blowfish.Decrypt(byteCiphertext);
        
        double Decryptstop = System.currentTimeMillis();
        System.out.println("Blowfish time taken to decrypt (seconds): "+ (Decryptstop-Decryptstart)/1000);
    }
    static void RSA_call() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, InvalidKeySpecException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchProviderException{
       
        
        RSA rsa = new RSA();
        
        FileReader fl = new FileReader();
        String Plaintext = fl.KeyReader();
  
        
        // Encryption 
        byte[] byteCiphertext = rsa.Encrypt(Plaintext);
        
        
        // Decryption
        rsa.Decrypt(byteCiphertext);
    }
}
