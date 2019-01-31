package assignment1;

import java.io.PrintWriter;

public class VigenereCipher {

  /*
   * input: an array of Strings
   * 
   * the first argument is either encode or decode. The second argument is an alphabetical
   * lower-case non-white space String. The third argument is the encryption key, an alphabetical
   * lower-case non-white space String.
   * 
   * output: print the encryptions or decryptions for the given String using the key and Vigenere
   * Cipher.
   * 
   * throw error if the arguments are in wrong format.
   */
  public static void main(String[] args) throws Exception {

    if (args.length != 3) {
      System.err.println("Incorrect number of parameters");
      System.exit(2);
    } else {
      PrintWriter pen = new PrintWriter(System.out, true);
      if (args[0].equals("encode")) {
        pen.println(encode(args[1], args[2]));

      } else if (args[0].equals("decode")) {

        pen.println(decode(args[1], args[2]));
      } else {
        System.err.println("Valid options are \"encode\" or \"decode\"");
        System.exit(1);
      }
    }
  }

  /*
   * input: a String to be encoded and a String key to encode. 
   * output: return the encoded String using input key and Vignere cipher.
   *
   */
  public static String encode(String str, String key) {
    String encoded_string = new String();
    for (int n = 0; n < str.length(); n++) {

      // charInt is the integer representation of the decoded char if we consider 'a' is 0.
      int charInt = mod(str.charAt(n) + key.charAt(n % key.length()) - 2 * 'a', 26);
      encoded_string += (char) (charInt + (int) 'a');
    }
    return encoded_string;
  }

  /*
   * input: a String to be decoded and String key to decode. 
   * output: return the decoded String using input key and Vignere cipher.
   */
  public static String decode(String str, String key) {
    String decoded_string = new String();
    for (int n = 0; n < str.length(); n++) {

      // charInt is the integer representation of the decoded char if we consider 'a' is 0.
      int charInt = mod(str.charAt(n) - key.charAt(n % key.length()), 26);
      decoded_string += (char) (charInt + (int) 'a');
    }
    return decoded_string;
  }

  /*
   * input: integer value and integer modulus.
   * output: return value mod modulus (between 0 and modulus)
   */
  public static int mod(int value, int modulus) {
    int returnValue = value % modulus;

    if (returnValue < 0) {
      returnValue += modulus;
    }
    return returnValue;
  }
}
