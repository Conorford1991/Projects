// Author: Conor Ford
// FileReader class
package algorithms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileReader {
    // FileReader constructor
     public String FileReader(String File) throws IOException{
        // Instantiate FileInputStream with File String input
        FileInputStream fstream = new FileInputStream(File);
        
        // Instantiate BufferedReader to read the file
        // BufferedReader Reads text from a InputStreamReader stream, 
        // buffering characters so as to provide for the efficient reading of 
        // characters and lines.
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        
        // try
        try {
          // Instantiates a StringBuilder
          StringBuilder sb = new StringBuilder();
          
          // String line takes the value of the BufferedReader readLine. 
          String line = br.readLine();
        
        // while line is not empty 
        while (line != null) {
         // Appends the characters of the string to the string builder
         sb.append(line);
         
         // text line seperation 
         // returns a system dependent line seperator
         sb.append(System.lineSeparator());
         
         //String line takes the value of the line seperated lines.
         line = br.readLine();
        }
        // convert the StringBuilder to a string and return
        return sb.toString();
        
        } finally {
        // close the BufferedReader
        br.close();
        }
    }
     // KeyReader for the RSA algorithm
     public String KeyReader() throws IOException{
        // Instantiate FileInputStream with File String input
        FileInputStream fstream = new FileInputStream("C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\AESkey.txt");
        
         // Instantiate BufferedReader to read the file
        // BufferedReader Reads text from a InputStreamReader stream, 
        // buffering characters so as to provide for the efficient reading of 
        // characters and lines.
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        
        // try
        try {
          // Instantiates a StringBuilder
          StringBuilder sb = new StringBuilder();
          
          // String line takes the value of the BufferedReader readLine. 
          String line = br.readLine();
        
        // while line is not empty 
        while (line != null) {
         // Appends the characters of the string to the string builder
         sb.append(line);
         
         // text line seperation 
         // returns a system dependent line seperator
         sb.append(System.lineSeparator());
         
         //String line takes the value of the line seperated lines.
         line = br.readLine();
        }
        // convert the StringBuilder to a string and return
        return sb.toString();
        
        } finally {
        // close the BufferedReader
        br.close();
        }
    }
    // write ciphertext to file
    void EncryptedFileWriter(String text, String AlgoType) throws FileNotFoundException, UnsupportedEncodingException{
         PrintWriter writer = new PrintWriter("C:\\Users\\Conor\\Desktop\\Project Demo\\Encrypted Files\\ "+AlgoType+" (Java).txt");
         writer.println(text);
         writer.close();
    }
    // write plaintext to file
    void DecryptedFileWriter(String text, String AlgoType) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("C:\\Users\\Conor\\Desktop\\Project Demo\\Decrypted Files\\ "+AlgoType+" (Java).txt");
         writer.println(text);
         writer.close();
    }
}
