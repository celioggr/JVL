package qses.extra;

import static org.junit.Assert.*;

import org.junit.Test;

public class PITPasswordCheckerTest {
		
	  @Test
	  public void testNullPassword() {
	    assertFalse(PasswordChecker.isValid(null));
	  }
	  
	  @Test
	  public void PasswordCheckerInstance() {
		  assertNotNull(new PasswordChecker());
	  }
  
	  /**
	  * Este teste mata o conditional boundary password.length() <= MIN_LENGTH 
	  * ou seja password.lenght == 8
	  */
	  @Test
	  public void testPasswordWithMinLengthChars() {
	    assertTrue(PasswordChecker.isValid("Abcdefg1"));
	  }
	  
	  /**
	   * Este teste mata o conditional boundary password.length() >= MAX_LENGTH 
	   * ou seja password.lenght == 12
	   */
	  @Test
	  public void testPasswordWithMaxLengthChars() {
	    assertTrue(PasswordChecker.isValid("Abcdefg1abcZ"));
	  }
 
	  /**
	   * Este teste mata o conditional boundary SPECIAL_CHARS.indexOf(c) <= 0 criado pelo PIT
	   * dado que '?' encontra-se no indice 0 de SPECIAL_CHARS
	   */
	  @Test
	  public void testPasswordWithSpecialChar() {
	 	    assertTrue(PasswordChecker.isValid("?bcD1fgzq"));
	  }
 
	  
	 /**
	  * Este teste mata os conditional boundaries c > '0'  && c < '9'
	  * Ou seja para aquele input 0 e 9 nao iriam ser satisfazer a condicao
	  */
	  @Test
	  public void testPasswordWithBoundaryDigits() {
		  assertTrue(PasswordChecker.isValid("0Abc9abcd"));
	  }
	  
	 
	 @Test
	 public void testLenghtLowerThanMin() {
		 assertFalse(PasswordChecker.isValid("ab1Abcz"));
	 }
	  
	
	 
	 /**
	  * Este teste mata o mutante m >= 0. Ou seja, a nao existencia de minusculas
	  */
	 @Test
	 public void testNoLowercaseChars() {
		assertFalse(PasswordChecker.isValid("ABCDEFG1I")); 
	 	} 
	 /**
	  * Este teste mata o mutante M >= 0. Ou seja, a nao existencia de maisculas
	  */
	 @Test 
	 public void testNoUppercaseChars() {
		 assertFalse(PasswordChecker.isValid("abcdefg1i"));
	 }
	 
	 /**
	  * Este teste mata o mutante d >= 0. Ou seja, a nao existencia de digitos
	  */
	 @Test
	 public void testNodigits() {
		 assertFalse(PasswordChecker.isValid("Abcdefghi"));
	 }
	  	 
}

