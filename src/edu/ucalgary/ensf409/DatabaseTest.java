/**
 * 
 */
package edu.ucalgary.ensf409;

import static org.junit.Assert.*;

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
		
		Database test = new Database("jdbc:mysql://localhost/inventory", "Mohtashim", "assignment9", "mesh", "chair");
		test.initConnection();
	}

	/**
	 * Test method for {@link edu.ucalgary.ensf409.Database#selectfromDB()}.
	 */
	@Test
	public void testSelectfromDB() {
		fail("Not yet implemented");
	}

}
