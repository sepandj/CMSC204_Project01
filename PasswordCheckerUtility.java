/**
 * @author Sepand Jahrominejad
 * CMSC 204
 * project 01
 */



import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;


public class PasswordCheckerUtility {
	public static void comparePasswords(String password, String passwordConfirm) {
		
	}
	/**
	 * comparePasswordsWithReturn compares the two passwords entered by the user to check if they match or not.
	 * @param password The password entered by the user
	 * @param passwordConfirm The confirmation of the password entered by the user
	 * @return returns true if the two passwords match and false if they don't.
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		
		if(password.equals(passwordConfirm))
			return true;
		else
			return false;
	}
	
	
	/**
	 * Checks to see if the password has between 6-9 characters
	 * @param password The password entered by the user.
	 * @return returns true if the password has between 6-9 characters, false if not.
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		
		if(password.length()>=6 & password.length()<=9)
			return true;
		else
			return false;
	}
	
	
	/**
	 * Checks to see if the password entered by the user contains any numbers.
	 * @param password The password entered by user.
	 * @return returns true if password contains any numbers.
	 * @throws NoDigitException if the password does not contain any numbers.
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		
		char[] pass = password.toCharArray();
		
		for(char c: pass) {
			if(Character.isDigit(c))
				return true;
		}
		throw new NoDigitException();
	}
	
	
	/**
	 * Checks to see if the password entered by user has any lower chase letters.
	 * @param password The password entered by user
	 * @return returns true if the password has any lower case letters.
	 * @throws NoLowerAlphaException if password does not contain any lower case letters.
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		
		char[] pass = password.toCharArray();
		
		for(char c: pass) {
			if(Character.isLowerCase(c))
				return true;
		}
		throw new NoLowerAlphaException();
	}
	
	
	/**
	 * Checks to see if the password entered by user has any special characters.
	 * @param password The password entered by user.
	 * @return returns true if the password has any special characters.
	 * @throws NoSpecialCharacterException if password does not contain any special characters.
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		
		Pattern myPattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
		Matcher myMatch = myPattern.matcher(password);
		
		if(myMatch.find() == true)
			return true;
		else
			throw new NoSpecialCharacterException();
	}
	
	
	/**
	 * Checks to see if the password entered by user has any upper chase letters.
	 * @param password The password entered by user.
	 * @return returns true if the password contains any upper case letters.
	 * @throws NoUpperAlphaException if password does not contain any upper chase letters.
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		
		char[] pass = password.toCharArray();
		
		for(char c : pass) {
			if(Character.isUpperCase(c))
				return true;
		}
		throw new NoUpperAlphaException();
	}
	
	
	/**
	 * Checks to see if the password has a valid length which is 6 or more characters long
	 * @param password The password entered by user.
	 * @return returns true if the password contains at least 6 characters.
	 * @throws LengthException if the password has less than 6 characters.
	 */
	public static boolean isValidLength(String password) throws LengthException {
		
		if(password.length() >= 6)
			return true;
		else
			throw new LengthException();
	}
	
	
	/**
	 * Checks to see if the password repeats a character more than twice in sequence.
	 * @param password The password entered by user.
	 * @return returns true if password does not have a letter repeat more than twice in sequence.
	 * @throws InvalidSequenceException if the password repeats a letter more than twice in sequence.
	 */
	public static boolean noSameCharInSequence(String password) throws InvalidSequenceException {
		
		for(int i=0; i<password.length()-2; i++) {
			if(password.charAt(i)==password.charAt(i+1) & password.charAt(i+1)==password.charAt(i+2))
				throw new InvalidSequenceException();
		}
		return true;
	}
	
	
	/**
	 * Checks the validity of password entered by user by looking for:
	 * 1-more than 6 characters in a password
	 * 2-upper chase letters
	 * 3-lower chase letters
	 * 4-special characters
	 * 5-numbers
	 * 6-repeat of a character more than twice in a sequence
	 * @param password The password entered by user.
	 * @return returns true if all the 6 conditions of a valid password are met.
	 * @throws NoDigitException if the password does not contain any numbers.
	 * @throws NoLowerAlphaException if password does not contain any lower case letters.
	 * @throws NoUpperAlphaException if password does not contain any upper chase letters.
	 * @throws NoSpecialCharacterException if password does not contain any special characters.
	 * @throws InvalidSequenceException if the password repeats a letter more than twice in sequence.
	 * @throws LengthException if the password has less than 6 characters.
	 */
	public static boolean isValidPassword(String password) throws NoDigitException, NoLowerAlphaException, NoUpperAlphaException, NoSpecialCharacterException, InvalidSequenceException, LengthException {
		
		if(isValidLength(password)) {
			if(hasUpperAlpha(password) & hasLowerAlpha(password) & hasDigit(password) 
					& hasSpecialChar(password) 
					& noSameCharInSequence(password))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		
		for(int i=0; i<passwords.size(); i++) {
			try {
				if(isValidPassword(passwords.get(i)))
					continue;
			} catch(Exception e) {
				invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			}
		}
		return invalidPasswords;
	}
	
	
	/**
	 * Checks to see if the password is:
	 * 1-valid
	 * 2-invalid
	 * if the password is valid checks to see if the password is at least 9 characters long.
	 * @param password the password entered by user
	 * @return returns false if the password is valid and has 9 or more characters
	 * @throws WeakPasswordException if the password is valid but has less than 9 characters
	 * @throws NoDigitException if the password does not contain any numbers.
	 * @throws NoLowerAlphaException if password does not contain any lower case letters.
	 * @throws NoUpperAlphaException if password does not contain any upper chase letters.
	 * @throws NoSpecialCharacterException if password does not contain any special characters.
	 * @throws InvalidSequenceException if the password repeats a letter more than twice in sequence.
	 * @throws LengthException if the password has less than 6 characters.
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException, NoDigitException, NoLowerAlphaException, NoUpperAlphaException, NoSpecialCharacterException, InvalidSequenceException, LengthException {
		
		if(isValidPassword(password)) {
			if(hasBetweenSixAndNineChars(password))
				throw new WeakPasswordException();
			else
				return false;
		}
		else
			return false;
	}
}
