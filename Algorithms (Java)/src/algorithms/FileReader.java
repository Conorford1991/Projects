
package algorithms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {
     public String FileReader() throws IOException{
        FileInputStream fstream = new FileInputStream("C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Testing.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        try {
          StringBuilder sb = new StringBuilder();
          String line = br.readLine();

        while (line != null) {
         sb.append(line);
         sb.append(System.lineSeparator());
         line = br.readLine();
        }
        return sb.toString();
        
        } finally {
        br.close();
        }
    }
     public String KeyReader() throws IOException{
        FileInputStream fstream = new FileInputStream("C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\AESkey.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        try {
          StringBuilder sb = new StringBuilder();
          String line = br.readLine();

        while (line != null) {
         sb.append(line);
         sb.append(System.lineSeparator());
         line = br.readLine();
        }
        return sb.toString();
        
        } finally {
        br.close();
        }
    }
}
