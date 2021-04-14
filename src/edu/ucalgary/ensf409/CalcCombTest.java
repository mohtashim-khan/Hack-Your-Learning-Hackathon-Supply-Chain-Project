package edu.ucalgary.ensf409;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CalcCombTest {

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
		System.out.println(totalPrice);
		int expectedPrice = 8;

		assertEquals(expectedPrice, totalPrice);
		assertEquals(Arrays.toString(expectedusedIDs), Arrays.toString(usedIDs));

	}

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
		System.out.println(Arrays.toString(usedIDs));
		int totalPrice = actual.getTotalPrice();
		System.out.println(totalPrice);
		int expectedPrice = 60;

		assertEquals(expectedPrice, totalPrice);
		assertEquals(Arrays.toString(expectedusedIDs), Arrays.toString(usedIDs));

	}
	
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
