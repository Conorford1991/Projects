// Author: Conor Ford
// Main class
package algorithms;

// imports
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class Algorithms {
    // main method
    public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException, IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, InvalidKeySpecException, NoSuchProviderException{
       // UserInput method call
        UserInput();
    }
    // AES_call method, implements the AES class
    static void AES_call(String DataSizeSelect)throws IllegalBlockSizeException, BadPaddingException, IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        // AES class instantiation
        AES aes = new AES();        
        
        // FileReader class instantiation
        FileReader fl = new FileReader();
        
        // String Plaintext takes the value of the FileReader method, 
        // which has the DataSizeSelect String passed into it
        String Plaintext = fl.FileReader(DataSizeSelect);
        
        // Start timer (Encryption)
        double Encryptstart = System.currentTimeMillis();
        
        // byte array byteCiphetext takes the value of the AES class: Encrypt method,
        // which has the Plaintext String passed into it
        byte[] byteCiphertext = aes.Encrypt(Plaintext);
        
        // End timer (Decryption)
        double Encryptstop = System.currentTimeMillis();
        
        // Start timer (Decryption)
        double Decryptstart = System.currentTimeMillis();
        
        // AES class: Decrypt method call, 
        // which has the byteCipherText byte array passed into it
        aes.Decrypt(byteCiphertext);
        
        // End timer (Decryption)
        double Decryptstop = System.currentTimeMillis();
        
        // Print time
        System.out.println("AES time taken to encrypt (seconds): "+ (Encryptstop-Encryptstart)/1000);
        System.out.println("AES time taken to decrypt (seconds): "+ (Decryptstop-Decryptstart)/1000);
    }
    // DES_call method, implements the DES class
    static void DES_call(String DataSizeSelect) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException, BadPaddingException, IllegalBlockSizeException{
        // DES class instantiation
        DES des = new DES();
        
        // FileReader class instantiation
        FileReader fl = new FileReader();
        
        // String Plaintext takes the value of the FileReader method, 
        // which has the DataSizeSelect String passed into it
        String Plaintext = fl.FileReader(DataSizeSelect);
       
        // Start timer (Encryption)
        double Encryptstart = System.currentTimeMillis();
        
        // byte array byteCiphetext takes the value of the DES class: Encrypt method,
        // which has the Plaintext String passed into it
        byte[] byteCiphertext = des.Encrypt(Plaintext);
        
        // End timer (Decryption)
        double Encryptstop = System.currentTimeMillis();
        
        // Start timer (Decryption)
        double Decryptstart = System.currentTimeMillis();
        
        // DES class: Decrypt method call, 
        // which has the byteCipherText byte array passed into it
        des.Decrypt(byteCiphertext);
        
        // End timer (Decryption)
        double Decryptstop = System.currentTimeMillis();
        
        // Print time
        System.out.println("DES time taken to encrypt (seconds): "+ (Encryptstop-Encryptstart)/1000);
        System.out.println("DES time taken to decrypt (seconds): "+ (Decryptstop-Decryptstart)/1000);
    }
    // TDES_call method, implements the TDES class
    static void TDES_call(String DataSizeSelect) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException, BadPaddingException, IllegalBlockSizeException{
        // TDES class instantiation
        TDES tdes = new TDES();        
        
        // FileReader class instantiation
        FileReader fl = new FileReader();
        
        // String Plaintext takes the value of the FileReader method, 
        // which has the DataSizeSelect String passed into it
        String Plaintext = fl.FileReader(DataSizeSelect);
        
        // Start timer (Encryption)
        double Encryptstart = System.currentTimeMillis();
        
        // byte array byteCiphetext takes the value of the TDES class: Encrypt method,
        // which has the Plaintext String passed into it
        byte[] byteCiphertext = tdes.Encrypt(Plaintext);
        
        // End timer (Decryption)
        double Encryptstop = System.currentTimeMillis();
        
        // Start timer (Decryption)
        double Decryptstart = System.currentTimeMillis();
        
        // TDES class: Decrypt method call, 
        // which has the byteCipherText byte array passed into it
        tdes.Decrypt(byteCiphertext);
        
        // End timer (Decryption)
        double Decryptstop = System.currentTimeMillis();
        
        // Print time
        System.out.println("TDES time taken to encrypt (seconds): "+ (Encryptstop-Encryptstart)/1000);
        System.out.println("TDES time taken to decrypt (seconds): "+ (Decryptstop-Decryptstart)/1000);
    }
    // Blowfish_call method, implements the Blowfish class
    static void Blowfish_call(String DataSizeSelect) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException, BadPaddingException, IllegalBlockSizeException{
        // Blowfish class instantiation
        Blowfish blowfish = new Blowfish();        
        
        // FileReader class instantiation
        FileReader fl = new FileReader();
        
        // String Plaintext takes the value of the FileReader method, 
        // which has the DataSizeSelect String passed into it
        String Plaintext = fl.FileReader(DataSizeSelect);
        
        // Start timer (Encryption)
        double Encryptstart = System.currentTimeMillis();
        
        // byte array byteCiphetext takes the value of the Blowfish class: Encrypt method,
        // which has the Plaintext String passed into it
        byte[] byteCiphertext = blowfish.Encrypt(Plaintext);
        
        // End timer (Decryption)
        double Encryptstop = System.currentTimeMillis();
        
        // Start timer (Decryption)
        double Decryptstart = System.currentTimeMillis();
        
        // Blowfish class: Decrypt method call, 
        // which has the byteCipherText byte array passed into it
        blowfish.Decrypt(byteCiphertext);
        
        // End timer (Decryption)
        double Decryptstop = System.currentTimeMillis();
        
        // Print time
        System.out.println("Blowfish time taken to encrypt (seconds): "+ (Encryptstop-Encryptstart)/1000);
        System.out.println("Blowfish time taken to decrypt (seconds): "+ (Decryptstop-Decryptstart)/1000);
    }
    // RSA_call method, implements the RSA class
    static void RSA_call() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, InvalidKeySpecException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchProviderException{
        // RSA class instantiation
        RSA rsa = new RSA();
        
        // FileReader class instantiation
        FileReader fl = new FileReader();
        
        // String Plaintext takes the value of the KeyReader method, 
        String Plaintext = fl.KeyReader();
  
        // Start timer (Encryption)
        double Encryptstart = System.currentTimeMillis();
        
        // byte array byteCiphetext takes the value of the RSA class: Encrypt method,
        // which has the Plaintext String passed into it
        byte[] byteCiphertext = rsa.Encrypt(Plaintext);
        
        // End timer (Decryption)
        double Encryptstop = System.currentTimeMillis();
        
        // Start timer (Decryption)
        double Decryptstart = System.currentTimeMillis();
        
        // RSA class: Decrypt method call, 
        // which has the byteCipherText byte array passed into it
        rsa.Decrypt(byteCiphertext);
        
        // End timer (Decryption)
        double Decryptstop = System.currentTimeMillis();
        
        // Print time
        System.out.println("RSA time taken to encrypt (seconds): "+ (Encryptstop-Encryptstart)/1000);
        System.out.println("RSA time taken to decrypt (seconds): "+ (Decryptstop-Decryptstart)/1000);
    }
    // UserInput method 
    static void UserInput() throws IllegalBlockSizeException, BadPaddingException, IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, InvalidKeySpecException, NoSuchProviderException{
         // Scanner instantiation 
         Scanner input = new Scanner(System.in);
         
         // Print
         System.out.println("Start or End execution");
         
         // String ExecutionSelect takes the value of the execution choice
         String ExecutionSelect = input.nextLine();
         
         // Selction while loop
         // while the user does not select "End", continue loop
         while(!"End".equals(ExecutionSelect)){
         
         // Print
         System.out.println("Select Data size (MB): Testing (1KB), 20, 40, 60, 80, 100");
         
         // String DataSizeSelect takes the value of the datasize choice
         String DataSizeSelect = input.nextLine();
         
         // Print
         System.out.println("Select Algorithm: AES, Blowfish, TDES, DES, RSA, All (all algorithms)");
         
         // String AlgoSelect takes the value of the algorithm choice
         String AlgoSelect = input.nextLine();
         
         // if statements based on the datasize choice
         // "Testing" size
         if("Testing".equals(DataSizeSelect)){
             DataSizeSelect = "C:\\\\Users\\\\Conor\\\\Desktop\\\\Computer Science\\\\Project\\\\Testing.txt";
         }
         // "20" MB size
         else if("20".equals(DataSizeSelect)){
             DataSizeSelect = "C:\\\\Users\\\\Conor\\\\Desktop\\\\Computer Science\\\\Project\\\\Test 20.txt";
         }
         // "40" MB size
         else if("40".equals(DataSizeSelect)){
             DataSizeSelect = "C:\\\\Users\\\\Conor\\\\Desktop\\\\Computer Science\\\\Project\\\\Test 40.txt";
         }
         // "60" MB size
         else if("60".equals(DataSizeSelect)){
             DataSizeSelect = "C:\\\\Users\\\\Conor\\\\Desktop\\\\Computer Science\\\\Project\\\\Test 60.txt";
         }
         // "80" MB size
         else if("80".equals(DataSizeSelect)){
             DataSizeSelect = "C:\\\\Users\\\\Conor\\\\Desktop\\\\Computer Science\\\\Project\\\\Test 80.txt";
         }
         // "100" MB size
         else if("100".equals(DataSizeSelect)){
             DataSizeSelect = "C:\\\\Users\\\\Conor\\\\Desktop\\\\Computer Science\\\\Project\\\\Test 100.txt";
         }
         // If anything else == incorrect input
         else{
             System.out.println("Invalid data input, try again");
             // Recursive call to the UserInput method 
             UserInput();
         }
             
         
         // if statements based on the algorithm choice
         // "AES" algorithm
         if ("AES".equals(AlgoSelect)){
              // AES_call method, which takes in the DataSizeSelect
              AES_call(DataSizeSelect);
              
              // Recursive call to the UserInput method 
              UserInput();
         }
         // "Blowfish" algorithm
         else if("Blowfish".equals(AlgoSelect)){
             // Blowfish_call method, which takes in the DataSizeSelect
             Blowfish_call(DataSizeSelect);
             
             // Recursive call to the UserInput method 
             UserInput();
         }
         // "TDES" algorithm
         else if("TDES".equals(AlgoSelect)){
             // TDES_call method, which takes in the DataSizeSelect
             TDES_call(DataSizeSelect);
             
             // Recursive call to the UserInput method 
             UserInput();
         }
         // "DES" algorithm 
         else if("DES".equals(AlgoSelect)){
             // DES_call method, which takes in the DataSizeSelect
             DES_call(DataSizeSelect);
             
             // Recursive call to the UserInput method 
             UserInput();
         }
         // "RSA" algorithm
         else if("RSA".equals(AlgoSelect)){
             // RSA_call method, which takes in the DataSizeSelect
             RSA_call();
             
              // Recursive call to the UserInput method 
             UserInput();
         }
         // "All" algorithms
         else if("All".equals(AlgoSelect)){
             // All algorithm call methods, along with the UserInput recursive call
              AES_call(DataSizeSelect);
              DES_call(DataSizeSelect);
              TDES_call(DataSizeSelect);
              Blowfish_call(DataSizeSelect);
              RSA_call();
              UserInput();
         }
         // Any other input
         else{
             System.out.println("Invalid algorithm input, try again");
             UserInput();
         }
         // break from the loop when "End" is selected
         break;
       }
         
    }
}
