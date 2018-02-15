package qses.extra;

import static org.junit.Assert.*;

import org.junit.Test;

public class ISPPasswordCheckerTest {

	  @Test
	  public void testNullString() {
	    assertFalse(PasswordChecker.isValid(null));
	  }
	  
	  @Test
	  public void testSmallString() {
	    assertFalse(PasswordChecker.isValid("9AB!"));
	  }
	  
	  @Test
	  public void testUppercaseString() {
	    /*(8 <= L <= 12, M > 0)*/
		  assertFalse(PasswordChecker.isValid("ABCDEFGH"));
	  }
	  
	  @Test
	  public void testLowerCaseString() {
	    /*(8 <= L <= 12, L > 0)*/
		  assertFalse(PasswordChecker.isValid("abcdefgh"));
	  }
	  
	  @Test
	  public void testDigitString() {
	    /*(8 <= L <= 12, d > 0)*/
		  assertFalse(PasswordChecker.isValid("12345678"));
	  }
	  

	  @Test
	  public void testInvalidCharsOnString() {
	    /*(8 <= L <= 12, i > 0)*/
		  assertFalse(PasswordChecker.isValid("########"));
	  }
	  

	  @Test
	  public void testUpperAndLowerString() {
	    /*(M >0, m > 0)*/
		  assertFalse(PasswordChecker.isValid("AbCdEfGh"));
	  }
	  
	  @Test
	  public void testUpperAndDigitString() {
	    /*(M >0, d > 0)*/
		  assertFalse(PasswordChecker.isValid("A1B2C3D4"));
	  }
	  
	  
	  @Test
	  public void testUpperAndInvalidString() {
	    /*(M >0, i > 0)*/
		  assertFalse(PasswordChecker.isValid("#A#B#C#D"));
	  }
	  
	  @Test
	  public void testLowerAndDigitString() {
	    /*(m >0, d > 0)*/
		  assertFalse(PasswordChecker.isValid("a1b2c3d4"));
	  }
	  
	  @Test
	  public void testDigitAndInvalidString() {
		    /*(d >0, i > 0)*/
			  assertFalse(PasswordChecker.isValid("!1!2!3!4"));
		  }
	  
	  @Test
	  public void testLongString() {
		    /*(m >0, d > 0)*/
			  assertFalse(PasswordChecker.isValid("#A1b2C9z5Z4a"));
		  }  
}

