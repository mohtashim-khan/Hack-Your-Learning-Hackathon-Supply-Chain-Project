/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *UI is a basic class that gets user input (order request) from the terminal and stores thats information
 *to be used to create an order request. The summary of the order will be displayed to the user in the form of
 *a txt.fie and also on the terminal/console.
 *
 */

//Package declaration
package edu.ucalgary.ensf409;

import java.util.*;
import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.FileWriter;

public class UI {
	
	// Class variables
	private String type; 
	private String item; 
	private String quantity;
	private int totalPrice; // This will be the total price of the order

	private Object[] sqlDataStorage; // generic object array, will be filled with all necessary line items from data tables

	private String[] usedIDs; // String of the IDs used to make the new item for the user, will need to remove
							  // these IDs from the Database

	public final String DBURL;
	public final String username;
	public final String password;
	
	/**
	 * Constructor for UI class, simple constructor that takes in six Args for type, quantity, Dburl, username, and password and assigns them values.
	 */
	public UI(String type, String item, String quantity, String dBURL, String username, String password) {
		this.type = type.replace(" ", "");
		this.item = item.replace(" ", "");
		this.quantity = quantity.replace(" ", "");
		DBURL = dBURL.replace(" ", "");
		this.username = username.replace(" ", "");
		this.password = password.replace(" ", "");
	}

	// Getter
	public String getType() {
		return this.type;
	}

	// Getter
	public String getItem() {
		return this.item;
	}

	// Getter
	public String getQuantity() {
		return this.quantity;
	}

	// Getter
	public String getDBURLType() {
		return this.DBURL;
	}

	// Getter
	public String getUsername() {
		return this.username;
	}

	// Getter
	public String getPassword() {
		return this.password;
	}

	// Setter
	public void setType(String type) {
		this.type = type;
	}

	// Setter
	public void setItem(String item) {
		this.item = item;
	}

	// Setter
	public void setQuantity(String quanity) {
		this.quantity = quanity;
	}

	// Getter
	public String[] getUsedIDs() {
		return usedIDs;
	}

	// Setter
	public void setUsedIDs(String[] usedIDs) {
		this.usedIDs = usedIDs;
	}


	/**
	 * @return the rst (int to str conversion for quantity)
	 */
	private int strToInt() {
		int rst = Integer.parseInt(quantity);
		return rst;
	}
	
	/**
	 * This method "processOrder" will create a new Database object and passes in 
	 * DBURL, username, password,type, and item.
	 * 
	 * (Simple explanation)
	 * This function will retrieve the user requested item table with line items 
	 * that match the user's request from the SQL database and stores it in an
	 * Object [] called sqlDataStorage.
	 */
	public void processOrder() throws DatabaseProcessException {
		try {
			Database myOrder = new Database(DBURL, username, password, type, item); 
			myOrder.initConnection();
			sqlDataStorage = myOrder.getData(); // ex. all mesh chair line items from table stored in array list
			myOrder.closeProcess();
		} catch (Exception e) {
			throw new DatabaseProcessException("PROBLEM WITH DATABASE PROCESS");
		}
	}

	/**
	 * This method "deleteUsedIDs" will send the IDs to the SQL database of the furniture items
	 * used to fulfill the order.
	 * 
	 * (Simple explanation)
	 * Any items used will be removed from the database.
	 */
	public void deleteUsedIDs() throws DatabaseDeleteException {
		try {
			Database myOrder = new Database(DBURL, username, password, type, item);
			myOrder.initConnection();
			for (int i = 0; i < usedIDs.length; i++) {
				myOrder.deleteDBEntry(usedIDs[i]);
			}
			myOrder.closeDelete();
		} catch (Exception e) {
			throw new DatabaseDeleteException("PROBLEM WITH DATABASE DELETE");
		}
	}

	/**
	 * This method "calculateOrder" gives the object [] of SQL line items to cheapestCombinations
	 * used to fulfill the order.
	 * 
	 * (Simple explanation)
	 * Once the calculation process has been completed, all furniture ID codes deemed to be the
	 * cheapest combinations will be stored in the String [] usedIDs
	 */
	public void calculateOrder() {
		CalculateCombinations findResults = new CalculateCombinations();// pass in Object []
		int quanityNum = strToInt();
		
		// use if statements to generate all combos for furniture items
		if (item.equals("chair")) {
			findResults.findChairCombinations(sqlDataStorage, quanityNum);
		}

		if (item.equals("desk")) {
			findResults.findDeskCombinations(sqlDataStorage, quanityNum);

		}
		if (item.equals("filing")) {
			findResults.findFilingCombinations(sqlDataStorage, quanityNum);

		}
		if (item.equals("lamp")) {
			findResults.findLampCombinations(sqlDataStorage, quanityNum);
		}
		usedIDs = findResults.getBestCombIDs();
		totalPrice = findResults.getTotalPrice();

	}

	/**
	 * This method "displayOder" displays the results of the order in a .txt format
	 * 
	 * (Simple explanation)
	 * Within this function, there will be a call to formatOrderRequest where that function
	 * will properly format the results of the user's order in a well-formatted manner.
	 * Once the formatted string has been return, to displayOrder, a new .txt will be 
	 * created and the formatted string will be written in the file.
	 */
	public void displayOrder() {
		String toBePrinted = formatOrderRequest(); // receives bigString (formatted output of order request)
		createFile();
		try {
			FileWriter myWriter = new FileWriter("Order_Request_Results.txt");
			myWriter.write(toBePrinted);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	/**
	 * This method "createFile" is a standard way to create a .txt file
	 * 
	 * (Simple explanation)
	 * if the user wishes to enter multiple orders, the contents in the file
	 * will be overwritten and the new results from the order request will be displayed.
	 */
	private void createFile() {
		try {
			File myObj = new File("Order_Request_Results.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("Order_Request_Results File has been Overwritten. A new Order has been created.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	/**
	 * This method "formatOrderRequest" is called from "displayOrder."
	 * 
	 * (Simple explanation)
	 * This function uses the StringBuilder class to format the results of the order in 
	 * a nice and well-formatted manner.
	 * In the event the order could not be fulfilled, a message will appear notifying the 
	 * user that the "ORDER COULD NOT BE FULFILLED."
	 */
	public String formatOrderRequest() {
		StringBuilder bigString = new StringBuilder();
		System.out.println("Processing your order... \n");

		bigString.append("Furniture Order Form \n\n");
		bigString.append("Faculty Name: \n");
		bigString.append("Contact: \n");
		bigString.append("Date: \n\n");
		bigString.append("Original Request: " + type + " " + item + "," + quantity + "\n\n");

		bigString.append("Items Ordered :\n");
		if (usedIDs == null) {
			bigString.append("ORDER COULD NOT BE FULFILLED");
		} else {
			for (int i = 0; i < usedIDs.length; i++) {
				bigString.append("ID: " + usedIDs[i] + "\n"); // need furniture code class to store codes
			}
			bigString.append("Total Price: $" + totalPrice); // price is hard-coded for now (example).
		}
		System.out.println(bigString.toString());
		return bigString.toString();
	}
	
	/**
	 * This method "main" is the start of the order request program
	 * 
	 * (Simple explanation)
	 * The program prompts the user to first enter their order request in the form of:
	 * type item, quantity.
	 * Afterwards, the program will prompt the user to enter their SQL infoamtion in
	 * the form of: DBURL, username, and password.
	 * All of the users input will be passed into the constructor of the UI class.
	 * Main makes a new UI object called newOrder.
	 * newOrder will make several function calls (processOrder, calculateOrder,
	 * displayOrder, and deleteUsedIds) to run through the entire operation of the program.
	 */
	
}
