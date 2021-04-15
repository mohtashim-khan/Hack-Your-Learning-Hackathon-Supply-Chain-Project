/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 * CalcCombTest is a testing class that tests the major methods and constructors of the CalculateCombinations class
 */

//package declaration
package edu.ucalgary.ensf409;

//imports
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class CalcCombTest {

	/**
	 * Tests the constructor of CalculateCombinations()
	 * Will only pass the test if test is not null after being constructed
	 */
	@Test
	public void CalcConstructorTest() { 
		CalculateCombinations test = new CalculateCombinations();
		assertNotNull(test); 
	}


	/**
	 * Tests the three getter methods of CalculateCombinations
	 * getBestCombIDs - if the string array is the same as expected, test pass
	 * getTotalPrice - if the int is same as expected, test pass
	 * getAllCombinations - if the allCombinations is not empty, test pass
	 */
	@Test
	public void allGettersTest(){
		//constructs test object
		CalculateCombinations test = new CalculateCombinations();

		//filing objects to be used for testing
		Filing filing1 = new Filing("test1", "Standing", "Y", "N", "N", "5", "abcd");
		Filing filing2 = new Filing("test2", "Standing", "N", "Y", "Y", "25", "defg");
		Filing filing3 = new Filing("test3", "Standing", "Y", "N", "Y", "20", "hijk");
		Filing filing4 = new Filing("test4", "Standing", "N", "Y", "N", "10", "lmno");
		
		//setting up the findFiling method
		Filing[] filingvar = { filing1, filing2, filing3, filing4 };
		int quantTest = 2;

		test.findFilingCombinations(filingvar, quantTest);
		
		//getting test values
		String[] testIDs = test.getBestCombIDs();
		int testPrice = test.getTotalPrice();
		ArrayList<CheapestCombination> testArr = test.getAllCombinations();
		Boolean testBool = testArr.isEmpty();
				
		//expected values
		String[] expectedIDs = {"test1","test2","test3","test4"};
		int expectedPrice = 60;
		
		//tests
		assertFalse(testBool); // if Array is empty - testBool is true - , then allCombinations doesnt exist and the test will faill
		assertEquals(Arrays.toString(expectedIDs), Arrays.toString(testIDs)); //testing getBestCombIDs
		assertEquals(expectedPrice, testPrice);								  //testing getTotalPrice
	}

	/**
	 * If the allCombinations ArrayList is empty after bestCombinations is called without running any recursive method, the test will pass, otherwise fail
	 */
	@Test
	public void bestCombinationMethodTest(){
		CalculateCombinations test = new CalculateCombinations();
		test.bestCombination();
		boolean testBool = test.getAllCombinations().isEmpty();
		
		assertTrue(testBool);
	}


	/**
	 * This test checks if the driver class for finding all combinations of filing objects works properly. two methods are tested:
	 * findFilingCombinations() - the recursion driver method
	 * bestFilingCombination()  - method that populates the CheapestCombination ArrayList with the correct filing combinations
	 */
	@Test
	public void RecursionFilingTest() {

		Filing filing1 = new Filing("test1", "Standing", "Y", "N", "N", "5", "abcd");
		Filing filing2 = new Filing("test2", "Standing", "N", "Y", "Y", "25", "defg");
		Filing filing3 = new Filing("test3", "Standing", "Y", "N", "Y", "20", "hijk");
		Filing filing4 = new Filing("test4", "Standing", "N", "Y", "N", "10", "lmno");

		Filing[] filingvar = { filing1, filing2, filing3, filing4 };
		String[] expectedusedIDs = { "test1", "test2", };
		int quantTest = 1;

		CalculateCombinations actual = new CalculateCombinations();
		actual.findFilingCombinations(filingvar, quantTest);

		String[] usedIDs = actual.getBestCombIDs();
		int totalPrice = actual.getTotalPrice();
		int expectedPrice = 30;

		assertEquals(expectedPrice, totalPrice);
		assertEquals(Arrays.toString(expectedusedIDs), Arrays.toString(usedIDs));
	}


	/**
	 * This test checks if the driver class for finding all combinations of lamp objects works properly. two methods are tested:
	 * findLampCombinations() - the recursion driver method
	 * bestLampCombination()  - method that populates the CheapestCombination ArrayList with the correct lamp combinations
	 */
	@Test
	public void RecursionLampTest() {

		Lamp lamp1 = new Lamp("test1", "Study", "Y", "N", "2", "abcd");
		Lamp lamp2 = new Lamp("test2", "Study", "N", "Y", "2", "defg");
		Lamp lamp3 = new Lamp("test3", "Study", "Y", "Y", "4", "hijk");
		Lamp lamp4 = new Lamp("test4", "Study", "N", "Y", "2", "lmno");

		Lamp[] lampvar = { lamp1, lamp2, lamp3, lamp4 };
		String[] expectedusedIDs = { "test1", "test2", "test3" };
		int quantTest = 2;

		CalculateCombinations actual = new CalculateCombinations();
		actual.findLampCombinations(lampvar, quantTest);

		String[] usedIDs = actual.getBestCombIDs();
		int totalPrice = actual.getTotalPrice();
		int expectedPrice = 8;

		assertEquals(expectedPrice, totalPrice);
		assertEquals(Arrays.toString(expectedusedIDs), Arrays.toString(usedIDs));
	}

	/**
	 * This test checks if the driver class for finding all combinations of chair objects works properly. two methods are tested:
	 * findChairCombinations() - the recursion driver method
	 * bestChairCombination()  - method that populates the CheapestCombination ArrayList with the correct chair combinations
	 */
	@Test
	public void RecursionChairTest() {

		Chair chair1 = new Chair("test1", "Standing", "2", "abcd", "Y", "N", "N", "N");
		Chair chair2 = new Chair("test2", "Standing", "18", "defg", "N", "Y", "Y", "Y");
		Chair chair3 = new Chair("test3", "Standing", "8", "hijk", "Y", "N", "Y", "N");
		Chair chair4 = new Chair("test4", "Standing", "12", "lmno", "N", "Y", "N", "Y");
		Chair chair5 = new Chair("test5", "Standing", "20", "pqrs", "Y", "Y", "Y", "Y");

		Chair[] chairvar = { chair1, chair2, chair3, chair4, chair5 };
		String[] expectedusedIDs = { "test1", "test2", "test3", "test4", "test5" };
		int quantTest = 3;

		CalculateCombinations actual = new CalculateCombinations();
		actual.findChairCombinations(chairvar, quantTest);

		String[] usedIDs = actual.getBestCombIDs();
		int totalPrice = actual.getTotalPrice();
		int expectedPrice = 60;

		assertEquals(expectedPrice, totalPrice);
		assertEquals(Arrays.toString(expectedusedIDs), Arrays.toString(usedIDs));
	}
	
	/**
	 * This test checks if the driver class for finding all combinations of desk objects works properly. two methods are tested:
	 * findDeskCombinations() - the recursion driver method
	 * bestDeskCombination()  - method that populates the CheapestCombination ArrayList with the correct filing combinations
	 */
	@Test
	public void RecursionDeskTest() {

		Desk desk1 = new Desk("test1", "Standing","5", "abcd", "Y", "N", "N");
		Desk desk2 = new Desk("test2", "Standing","25", "defg", "N", "Y", "Y");
		Desk desk3 = new Desk("test3", "Standing", "20", "hijk","Y", "N", "Y");
		Desk desk4 = new Desk("test4", "Standing", "10", "lmno", "N", "Y", "N");

		Desk[] deskvar = { desk1, desk2, desk3, desk4 };
		String[] expectedusedIDs = { "test1", "test2", };
		int quantTest = 1;

		CalculateCombinations actual = new CalculateCombinations();
		actual.findDeskCombinations(deskvar, quantTest);

		String[] usedIDs = actual.getBestCombIDs();
		int totalPrice = actual.getTotalPrice();
		int expectedPrice = 30;

		assertEquals(expectedPrice, totalPrice);
		assertEquals(Arrays.toString(expectedusedIDs), Arrays.toString(usedIDs));
	}

}

//to compile: 	javac -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/system-rules-1.19.0.jar edu/ucalgary/ensf409/CalcCombTest.java
//to run: 		java -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/system-rules-1.19.0.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.CalcCombTest