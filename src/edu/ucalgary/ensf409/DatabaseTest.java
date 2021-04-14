/**
 * 
 */
package edu.ucalgary.ensf409;

import static org.junit.Assert.*;

import java.sql.*;

import org.junit.Test;

/**
 * @author moto_
 *
 */
public class DatabaseTest {

	/**
	 * Test method for {@link edu.ucalgary.ensf409.Database#Database(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDatabase() {
		String expected = "Mohtashim";
		Database test = new Database("jdbc:mysql://localhost/inventory", expected, "assignment9", "mesh", "chair");
		assertEquals(expected,test.getUSERNAME());
	}

	/**
	 * Test method for {@link edu.ucalgary.ensf409.Database#initConnection()}.
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
		assertNotEquals("Both arrays are identical, the entry was not deleted!",((Chair) deletedEntryArray[deletedEntryArray.length-1]).getiD(),((Chair) initialArray[initialArray.length-1]).getiD());
		
		
	}
	
	

}
