
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Sepand Jahrominejad
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;

	@Before
	public void setUp() throws Exception {
		String[] invalidPassEx = {"1DontgeEtt", "th3e_Poinnnt", "0Th!2", "jun!Ttesstt"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(invalidPassEx));
		
	}
		

	@After
	public void tearDown() throws Exception {
		passwords = null;
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("1Dms"));
			assertTrue("Didn't throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Passed",true);
		}
		 
		catch(Exception e)
		{
			assertTrue("Unexpected Exception",false);
		}
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Mm123s$@093"));
			assertTrue("Passed",true);
		}
		catch(LengthException e)
		{
			assertTrue("Threw a lengthExcepetion",false);
		}
		 
		catch(Exception e)
		{
			assertTrue("Unexpected Exception",false);
		}
		
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("spads1&2345"));
			 
			assertTrue("Didn't throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Passed",true);
		}
		catch(Exception e)
		{
			assertTrue("Unexpected Exception",false);
		}
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("SpadS12345$"));
			 
			assertTrue("Passed",true);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Threw a NoUpperAlphaExcepetion",false);
		}
		catch(Exception e)
		{
			assertTrue("Unexpected Exception",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("159WEOFD%"));
 
			assertTrue("Didn't throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Passed",true);
		}
		catch(Exception e)
		{
			assertTrue("Unexpected Exception",false);
		}
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("159WEOfdD%"));
 
			assertTrue("Passed",true);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Threw NoLowerAlphaException",false);
		}
		catch(Exception e)
		{
			assertTrue("Unexpected Exception",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			 
			assertTrue(PasswordCheckerUtility.isWeakPassword("3456Bb$"));
			assertTrue("Didn't throw WeakPasswordException",false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Passed",true);
		}
		catch(Exception e)
		{
			assertTrue("Unexpected Exception",false);
		}
		
		try{
			 
			boolean yoPassIsWeak = PasswordCheckerUtility.isWeakPassword("3456Bb$sewee");
			assertTrue("Passed",true);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Threw WeakPasswordException",false);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Unexpected Exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("5643%#SAssEEEEE"));
		 	assertTrue("Didn't throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Passed",true);
		}
		catch(Exception e)
		{
			assertTrue("Unexpected Exception",false);
		}
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("5643%#AsEE"));
		 	assertTrue("Passed",true);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Threw an InvalidSequenceException",false);
		}
		catch(Exception e)
		{
			assertTrue("Unexpected Exception",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertTrue(PasswordCheckerUtility.hasDigit("asdewQw$%"));
			assertTrue("Didn't throw NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Passed",true);
		}
		catch(Exception e)
		{
			assertTrue("Unexpected Exception",false);
		}
		
		try{
			assertTrue(PasswordCheckerUtility.hasDigit("asdew1234Qw$%"));
			assertTrue("Passed",true);
		}
		catch(NoDigitException e)
		{
			assertTrue("threw NoDigitException",false);
		}
		catch(Exception e)
		{
			assertTrue("Unexpected Exception",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("asdASD123$#@aswER"));
			assertTrue("Passed", true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Uneexpected Exception", false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		Scanner scan = new Scanner(results.get(0));
		assertEquals(scan.next(), "1DontgeEtt");
		String nextResults = scan.nextLine().toUpperCase();
		assertTrue(nextResults.contains("SPECIAL"));
		
		scan = new Scanner(results.get(1));
		assertEquals(scan.next(), "th3e_Poinnnt");
		nextResults = scan.nextLine().toUpperCase();
		assertTrue(nextResults.contains("SEQUENCE"));
		
		scan = new Scanner(results.get(2));
		assertEquals(scan.next(), "0Th!2");
		nextResults = scan.nextLine().toUpperCase();
		assertTrue(nextResults.contains("LONG"));
		
		scan = new Scanner(results.get(3));
		assertEquals(scan.next(), "jun!Ttesstt");
		nextResults = scan.nextLine().toUpperCase();
		assertTrue(nextResults.contains("DIGIT"));
		
	}
	
}
