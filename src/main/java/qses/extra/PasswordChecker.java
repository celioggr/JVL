package qses.extra;

public class PasswordChecker {

  public static final int MIN_LENGTH = 8;
  public static final int MAX_LENGTH = 12;
  private static final String SPECIAL_CHARS = "?!$@";
  
  public static boolean isValid(String password) {
    if (password == null) {
      return false;
    }
    if (   password.length() < MIN_LENGTH 
        || password.length() > MAX_LENGTH) {
      return false;
    }
    int m=0; //minusculas
    int M=0; //maiusculas
    int d=0; //digitos
    int i=0; // chars invalidos
    
    for (int pos = 0; pos < password.length(); pos++) {
      char c = password.charAt(pos);
      if (   c >= '0' 
          && c <= '9') {
        ++d;
      }
      else 
      if (   c >= 'a'
          && c <= 'z') {
        ++m;
      }
      else 
      if (   c >= 'A'
          && c <= 'Z') {
        ++M;
      }
      else 
      if (SPECIAL_CHARS.indexOf(c) < 0) {
        i++;
      }
    }
    return 
           m > 0
        && M > 0
        && d > 0
        && i == 0;
  }

  public PasswordChecker() {

  }

}
