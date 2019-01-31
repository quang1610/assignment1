package assignment1;

import java.lang.String;
import java.io.*;

public class CaesarCipher {

  public static void main(String[] args) throws Exception {
    
    PrintWriter pen = new PrintWriter(System.out, true);
    
    if (args.length != 2) {
      pen.println("Incorrect number of parameters");
    } else {
      
      if (args[0].equals("encode")) {
        printEncodedString(args[1]);
        
      } else if (args[0].equals("decode")) {
        
        printDecodedString(args[1]);
      } else {
        pen.println("Valid options are \"encode\" or \"decode\"");
      }
    }
  }

  public static void printEncodedString(String str) {

    PrintWriter pen = new PrintWriter(System.out, true);

    for (int key = 0; key < 26; key++) {
      pen.println("n = " + key + ": " + encode(str, key));
    }
  }

  public static String encode(String str, int key) {
    String encoded_string = new String();
    for (int n = 0; n < str.length(); n++) {
      int charInt = mod(str.charAt(n) - 'a' + key, 26);
      encoded_string += (char)(charInt + (int)'a');
    }
    return encoded_string;
  }

  public static void printDecodedString(String str) {
    PrintWriter pen = new PrintWriter(System.out, true);

    for (int key = 0; key < 26; key++) {
      pen.println("n = " + key + ": " + decode(str, key));
    }
  }
  
  public static String decode(String str, int key) {
    String decoded_string = new String();
    for (int n = 0; n < str.length(); n++) {
      int charInt = mod(str.charAt(n) - 'a' - key, 26);
      decoded_string += (char)(charInt + (int)'a');
    }
    return decoded_string;
  }
  
  public static int mod(int value, int modulus) {
    int returnValue = value % modulus;
    
    if(returnValue < 0)
    {
      returnValue += modulus;
    }
    return returnValue;
  }
}
