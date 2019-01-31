package assignment1;

import java.lang.String;
import java.io.*;

public class CaesarCipher {

  /*
   * input: an array of Strings
   * 
   * the first argument is either encode or decode
   * the second argument is an alphabetical lower-case non-white space String.
   * 
   * output: print 26 possible encryptions or decryptions for the given string.
   * 
   * throw error if the argument is in wrong format.
   */
  public static void main(String[] args) throws Exception {
    
    if (args.length != 2) {
      System.err.println("Incorrect number of parameters");
      System.exit(2);
    } else {
      
      if (args[0].equals("encode")) {
        printEncodedString(args[1]);
        
      } else if (args[0].equals("decode")) {
        
        printDecodedString(args[1]);
      } else {
        System.err.println("Valid options are \"encode\" or \"decode\"");
        System.exit(1);
      }
    }
  }

  /*
   * input: a String to be encoded
   * 
   * output: print 26 lines with all 26 possible encryptions of the input using Caesar cipher.
   */
  public static void printEncodedString(String str) {

    PrintWriter pen = new PrintWriter(System.out, true);

    for (int key = 0; key < 26; key++) {
      pen.println("n = " + key + ": " + encode(str, key));
    }
  }

  /*
   * input: a String to be encoded
   *        an integer key (from 0 to 25) to encode.
   * output: return the encoded String using input key and Caesar cipher.
   *
   */
  public static String encode(String str, int key) {
    String encoded_string = new String();
    for (int n = 0; n < str.length(); n++) {
      
      //charInt is the integer representation of the encoded char if we consider 'a' is 0.
      int charInt = mod(str.charAt(n) - 'a' + key, 26);
      encoded_string += (char)(charInt + (int)'a');
    }
    return encoded_string;
  }

  /*
   * input: a String to be decoded
   * 
   * output: print 26 lines with all 26 possible decryptions of the input using Caesar cipher.
   */
  public static void printDecodedString(String str) {
    PrintWriter pen = new PrintWriter(System.out, true);

    for (int key = 0; key < 26; key++) {
      pen.println("n = " + key + ": " + decode(str, key));
    }
  }
  
  /*
   * input: a String to be decode.
   *        an integer key (from 0 to 25) to decode.
   * output: return the decoded String using input key and Caesar cipher.
   *
   */
  public static String decode(String str, int key) {
    String decoded_string = new String();
    for (int n = 0; n < str.length(); n++) {
      
    //charInt is the integer representation of the decoded char if we consider 'a' is 0.
      int charInt = mod(str.charAt(n) - 'a' - key, 26);
      decoded_string += (char)(charInt + (int)'a');
    }
    return decoded_string;
  }
  
  /*
   * input: integer value and integer modulus
   * output: return value mod modulus (between 0 and modulus)
   */
  public static int mod(int value, int modulus) {
    int returnValue = value % modulus;
    
    if(returnValue < 0)
    {
      returnValue += modulus;
    }
    return returnValue;
  }
}
