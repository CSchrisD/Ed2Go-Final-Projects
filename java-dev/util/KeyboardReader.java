package util;
import java.io.*;

public class KeyboardReader {

  private static BufferedReader in =
      new BufferedReader(new InputStreamReader(System.in));
  
  public KeyboardReader() { }
  
  public static String getPromptedString(String prompt) {
    String response = null;
    System.out.print(prompt);
    try {
      response = in.readLine();
    } catch (IOException e) {
      System.out.println("IOException occurred");
    }
    return response;
  }
  
  public static char getPromptedChar(String prompt) {
    return getPromptedString(prompt).charAt(0);
  }
  
  public static int getPromptedInt(String prompt) {
    return Integer.parseInt(getPromptedString(prompt));
  }
  
  public static float getPromptedFloat(String prompt) {
    return Float.parseFloat(getPromptedString(prompt));
  }
  public static double getPromptedDouble(String prompt) {
    return Double.parseDouble(getPromptedString(prompt));
  }
}
