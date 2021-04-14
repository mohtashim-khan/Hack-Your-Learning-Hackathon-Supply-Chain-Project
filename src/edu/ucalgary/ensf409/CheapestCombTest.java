/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 * CheapestCombTest is a testing class that tests the major methods and constructors of the CheapestCombination class
 *
 */

//package declaration
package edu.ucalgary.ensf409;

//import statements
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class CheapestCombTest {

	/**
	 * This tests the contructor of CheapestCombination and ensures that the ArrayList we were expecting the CheapestCombination object to be is 
	 * the same ArrayList made by the constructor. 
	 */
	@Test
	public void constructorTest() {
		Lamp lamp1 = new Lamp("test1", "Study", "Y", "N", "2", "abcd");
		Lamp lamp2 = new Lamp("test2", "Study", "N", "Y", "2", "defg");
		ArrayList<Furniture> lampList = new ArrayList<>();
		lampList.add((Furniture) lamp1);
		lampList.add((Furniture) lamp2);
		CheapestCombination actual = new CheapestCombination(lampList);

		assertEquals(lampList, actual.furnitureCombination);
	}


	/**
	 * This tests 3 different getters for CheapestCombinations - getTotalPrice(), getIDs(), getFurnitureCombination()
	 * getTotalPrice() ensures that the price of the combination is the sum of the furniture objects in the combination
	 * getIDs() returns a String[] array of the furniture objects in the furniture combination
	 * getFurnitureCombination() returns a furniture ArrayList which should be the same as the input object list
	 */
	@Test
	public void getterTest() {
		Lamp lamp1 = new Lamp("test1", "Study", "Y", "N", "2", "abcd");
		Lamp lamp2 = new Lamp("test2", "Study", "N", "Y", "2", "defg");

		ArrayList<Furniture> lampList = new ArrayList<>();
		lampList.add((Furniture) lamp1);
		lampList.add((Furniture) lamp2);
		CheapestCombination actual = new CheapestCombination(lampList);

		int priceTest = actual.getTotalPrice();
		String[] idTest = actual.getIDs();
		ArrayList<Furniture> arrTest = actual.getFurnitureCombination();

		int expPriceTest = 4;
		String[] expIdTest = { "test1", "test2" };
		ArrayList<Furniture> expArrTest = lampList;

		assertEquals(expPriceTest, priceTest);
		assertEquals(Arrays.toString(expIdTest), Arrays.toString(idTest));
		assertEquals(Arrays.deepToString(expArrTest.toArray()), Arrays.deepToString(arrTest.toArray()));
	}
}

//to compile: 	javac -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/system-rules-1.19.0.jar edu/ucalgary/ensf409/CheapestCombTest.java
//to run: 		java -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/system-rules-1.19.0.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.CheapestCombTest