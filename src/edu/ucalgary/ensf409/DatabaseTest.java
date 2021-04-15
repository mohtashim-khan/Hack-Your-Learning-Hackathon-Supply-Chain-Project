/**@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *DatabaseTest class: handles all unit testing for the Database class
 */


//package declaration
 package edu.ucalgary.ensf409;

//import statements
import static org.junit.Assert.*;
import java.sql.*;
import org.junit.Test;


public class DatabaseTest {

	/**
	 * Test method for {@link edu.ucalgary.ensf409.Database#Database(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 * makes sure that the database is constructed properly
	 */
	@Test
	public void testDatabase() {
		String expected = "Mohtashim";
		Database test = new Database("jdbc:mysql://localhost/inventory", expected, "assignment9", "mesh", "chair");
		assertEquals(expected,test.getUSERNAME());
	}

	/**
	 * Test method for {@link edu.ucalgary.ensf409.Database#initConnection()}.
	 * tests if the program can initialize connection to the database
	 */
	@Test
	public void testInitConnection() {
		
		Connection check;
		Database test = new Database("jdbc:mysql://localhost/inventory", "Mohtashim", "assignment9", "mesh", "chair");
		test.initConnection();
		check = test.getDbConnect();
		
		try {
			assertTrue("Connection is open", check.isValid(0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Test method for {@link edu.ucalgary.ensf409.Database#testgetData()}.
	 * tests the getData and selectFromDB method to ensure that the correct object array is output
	 */
	@Test
	public void testgetData() {
		Object [] dataArray;
		String expectedType = "Mesh";
		
		Database test = new Database("jdbc:mysql://localhost/inventory", "Mohtashim", "assignment9", "mesh", "chair");
		test.initConnection();
		dataArray = test.getData();
		assertEquals(expectedType, ((Chair) dataArray[0]).getType());
		
	}
	
	/**
	 * Test method for {@link edu.ucalgary.ensf409.Database#testgetData()}.
	 * tests the deleteDBEntry method to ensure that the entry is deleted from the database with the provided id
	 */
	@Test
	public void testdeleteDBentry()
	{
		Object [] initialArray;
		Object [] deletedEntryArray;
		Database test = new Database("jdbc:mysql://localhost/inventory", "Mohtashim", "assignment9", "mesh", "chair");
		test.initConnection();
		
		  try {
		  
		  String query ="INSERT INTO chair ( ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID) VALUES ('test','Mesh','Y','N','Y','Y','100','005')"; 
		  PreparedStatement myStmt = test.sendQuery(query); 
		  myStmt.executeUpdate();
		  myStmt.close();
		  
		  } catch (SQLException ex) { 
			  ex.printStackTrace();
			  }
		 
		initialArray = test.getData();
		test.deleteDBEntry("test");
		deletedEntryArray = test.getData();
		assertNotEquals(((Chair) deletedEntryArray[deletedEntryArray.length-1]).getiD(),((Chair) initialArray[initialArray.length-1]).getiD());
		
		
	}
	
	

}
