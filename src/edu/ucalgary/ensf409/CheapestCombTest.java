package edu.ucalgary.ensf409;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class CheapestCombTest {

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

	@Test
	void getterTest() {
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

	/*
	 * @Test void () { Lamp lamp1 = new Lamp("test1", "Study", "Y", "N", "2",
	 * "abcd"); Lamp lamp2 = new Lamp("test2", "Study", "N", "Y", "2", "defg");
	 * ArrayList<Furniture> lampList = new ArrayList<>(); lampList.add((Furniture)
	 * lamp1); lampList.add((Furniture) lamp2); CheapestCombination actual = new
	 * CheapestCombination(lampList);
	 * 
	 * assertEquals(lampList, actual.furnitureCombination); }
	 */

}