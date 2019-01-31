//package assignment1;

import java.lang.String;
import java.io.*;

public class CaesarCipher {

  public static void main(String[] args) throws Exception {
      // printEncodedString("helloworld");
    if (args.length != 2) {

    } else {
      if (args[0].equals("encode")) {
        printEncodedString(args[1]);
      } else if (args[0].equals("decode")) {
        decode(args[1]);
      } else {

      }
    }
  }

  public static void printEncodedString(String str) {

    PrintWriter pen = new PrintWriter(System.out, true);

    for (int key = 0; key < 26; key++) {
      pen.println(encode(str, key));
    }
  }

  public static String encode(String str, int key) {
    String encoded_string = new String();

    for (int n = 0; n < str.length(); n++) {
      encoded_string += (char)(((((int)str.charAt(n) - (int)'a') + key) % 26) + (int)'a');
    }

    return encoded_string;
  }

  public static void decode(String str) {

  }
}
