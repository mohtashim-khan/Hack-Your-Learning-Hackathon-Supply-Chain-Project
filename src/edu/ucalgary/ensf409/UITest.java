/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *UITest will perform basic tests for all methods and functionality of the UI Class.
 */

//Package declaration
package edu.ucalgary.ensf409;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.TreeMap;

import org.junit.Test;

public class UITest {

	@Test
	// Constructor created with 4 arguments
	// Concats getter methods (getType, getItem, getQuanity, getTotalPrice,
	// getDBURL, getUsername, getPassword)
	// to test again expected String
	public void testConstructor4() {
		UI testObj = new UI("study", "lamp", "1", "DBURLTest", "usernameTest", "passwordTest");
		String expResult = testObj.getType() + testObj.getItem() + testObj.getQuantity() + testObj.getDBURLType()
				+ testObj.getUsername() + testObj.getPassword();

		assertEquals("studylamp1DBURLTestusernameTestpasswordTest", expResult);

	}

	@Test
	public void testProcessOrder() {
		// Add test entries to database to calculate the order
		Database test = new Database("jdbc:mysql://localhost/inventory", "Mohtashim", "assignment9", "test", "chair");
		test.initConnection();

		// Insert two test entries into database
		try {

			String query1 = "INSERT INTO chair ( ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID) VALUES ('test','test','Y','N','Y','Y','100','005')";
			String query2 = "INSERT INTO chair ( ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID) VALUES ('test1','test','N','Y','N','N','100','005')";
			PreparedStatement myStmt = test.sendQuery(query1);
			PreparedStatement myStmt1 = test.sendQuery(query2);
			myStmt.executeUpdate();
			myStmt1.executeUpdate();
			myStmt.close();
			myStmt1.close();
			//system.out.println("testProcessOrder: added test and test1!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		// Instantiate UI, Process order
		UI testObj = new UI("test", "chair", "1", "jdbc:mysql://localhost/inventory", "Mohtashim", "assignment9");
		try {
			testObj.processOrder();
		} catch (DatabaseProcessException e) {
			e.printStackTrace();
		}

		// Get SQLStorage

		Object[] results = test.getData();

		// Fill in the expected Object array with the respective Chair objects.
		Object[] expected = new Object[2];
		Chair expected_0 = new Chair("test", "chair", "100", "005", "Y", "N", "Y", "Y");
		Chair expected_1 = new Chair("test1", "chair", "100", "005", "N", "Y", "N", "N");
		expected[0] = (Object) expected_0;
		expected[1] = (Object) expected_1;

		// Delete test entries
		test.deleteDBEntry("test");
		test.deleteDBEntry("test1");

		// Close Database
		test.closeDelete();

		// assert if the two object array IDs are equivalent
		boolean comparision = true;
		for(int i= 0; i<results.length; i++)
		{
			String resultID = ((Chair) results[i]).getiD();
			String expectedID = ((Chair) expected[i]).getiD();
			if(!resultID.equals(expectedID)) 
			{
				comparision = false;
			}
		}
		
		assertTrue("The expected Object IDs:" + ((Chair) expected[0]).getiD() +" "+ ((Chair) expected[1]).getiD() + " is not the same as the resulting Object IDs: "
				+ ((Chair) results[0]).getiD() +" "+ ((Chair) results[1]).getiD()+ ", error with process Order!", comparision);

	}

	@Test
	public void testCalculateOrder() {
		// Add test entries to database to calculate the order
		Database test = new Database("jdbc:mysql://localhost/inventory", "Mohtashim", "assignment9", "test", "chair");
		test.initConnection();

		// Insert two test entries into database
		try {

			String query1 = "INSERT INTO chair ( ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID) VALUES ('test','test','Y','N','Y','Y','100','005')";
			String query2 = "INSERT INTO chair ( ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID) VALUES ('test1','test','N','Y','N','N','100','005')";
			PreparedStatement myStmt = test.sendQuery(query1);
			PreparedStatement myStmt1 = test.sendQuery(query2);
			myStmt.executeUpdate();
			myStmt1.executeUpdate();
			myStmt.close();
			myStmt1.close();
			//system.out.println("testCalculateOrder: test1 and test added!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		// Instantiate UI
		UI testObj = new UI("test", "chair", "1", "jdbc:mysql://localhost/inventory", "Mohtashim", "assignment9");
		try {
			testObj.processOrder();
		} catch (DatabaseProcessException e) {
			e.printStackTrace();
		}

		// Calculate what IDs should be used
		testObj.calculateOrder();

		// Get used IDs and the expected result
		String[] result = testObj.getUsedIDs();
		String[] expected = { "test", "test1" };

		// Check if the result array is the same as the expected array, only expect the
		// test IDs to be returned.
		assertEquals("expected and result arrays are not the same!", Arrays.toString(expected),
				Arrays.toString(result));

		// Delete test entries
		test.deleteDBEntry("test");
		test.deleteDBEntry("test1");

		// Close Database
		test.closeDelete();
	}

	@Test
	public void testDisplayOrder() {

		// Add test entries to database to calculate the order
		Database test = new Database("jdbc:mysql://localhost/inventory", "Mohtashim", "assignment9", "test", "chair");
		test.initConnection();

		// Insert two test entries into database
		try {

			String query1 = "INSERT INTO chair ( ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID) VALUES ('test','test','Y','N','Y','Y','100','005')";
			String query2 = "INSERT INTO chair ( ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID) VALUES ('test1','test','N','Y','N','N','100','005')";
			PreparedStatement myStmt = test.sendQuery(query1);
			PreparedStatement myStmt1 = test.sendQuery(query2);
			myStmt.executeUpdate();
			myStmt1.executeUpdate();
			myStmt.close();
			myStmt1.close();
			//system.out.println("testDisplayOrder: test1 and test added!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		// Instantiate UI
		UI testObj = new UI("test", "chair", "1", "jdbc:mysql://localhost/inventory", "Mohtashim", "assignment9");
		try {
			testObj.processOrder();
		} catch (DatabaseProcessException e) {
			e.printStackTrace();
		}
		// Calculate the order and display the output
		testObj.calculateOrder();

		// Check if displayOrder was successful, also check the output files and command
		// line print.
		assertTrue(testObj.displayOrder());

		// delete test entries and close database
		test.deleteDBEntry("test");
		test.deleteDBEntry("test1");
		test.closeDelete();

	}

	@Test
	public void testDeleteUsedIDs() {
		// Add test entries to database to calculate the order
		Database test = new Database("jdbc:mysql://localhost/inventory", "Mohtashim", "assignment9", "test", "chair");
		test.initConnection();

		// Insert two test entries into database
		try {

			String query1 = "INSERT INTO chair ( ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID) VALUES ('test','test','Y','N','Y','Y','100','005')";
			String query2 = "INSERT INTO chair ( ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID) VALUES ('test1','test','N','Y','N','N','100','005')";
			PreparedStatement myStmt = test.sendQuery(query1);
			PreparedStatement myStmt1 = test.sendQuery(query2);
			myStmt.executeUpdate();
			myStmt1.executeUpdate();
			myStmt.close();
			myStmt1.close();
			//system.out.println("testDeleteUsedIDs: test1 and test added!");

		} catch (SQLException ex) {
			//system.out.println("testDeleteUsedIDs: test1 and test already added!");
		}

		// Insert another two test entries into database
		try {

			String query1 = "INSERT INTO chair ( ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID) VALUES ('test2','test','Y','N','Y','Y','100','005')";
			String query2 = "INSERT INTO chair ( ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID) VALUES ('test3','test','N','Y','N','N','100','005')";
			PreparedStatement myStmt = test.sendQuery(query1);
			PreparedStatement myStmt1 = test.sendQuery(query2);
			myStmt.executeUpdate();
			myStmt1.executeUpdate();
			myStmt.close();
			myStmt1.close();
			//system.out.println("testDeleteUsedIDs: test2 and test3 added!");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		// instantiate test UI
		UI testObj = new UI("test", "chair", "1", "jdbc:mysql://localhost/inventory", "Mohtashim", "assignment9");
		try {
			testObj.processOrder();
		} catch (DatabaseProcessException e) {
			e.printStackTrace();
		}

		// calculate order
		testObj.calculateOrder();

		// get the initial IDs that were used before deletion
		String[] beforeDeletion = testObj.getUsedIDs();

		// delete the Used IDs
		try {
			// deletes test,and test1 IDs
			testObj.deleteUsedIDs();
		} catch (DatabaseDeleteException e) {
			e.printStackTrace();
		}

		// calculate the order again
		testObj.calculateOrder();
		String[] afterDeletion = testObj.getUsedIDs();

		assertNotEquals("The string arrays are identical, IDs were not deleted!", beforeDeletion, afterDeletion);

		// delete the two test entries
		test.deleteDBEntry("test2");
		test.deleteDBEntry("test3");

		// close database
		test.closeDelete();

	}

}
