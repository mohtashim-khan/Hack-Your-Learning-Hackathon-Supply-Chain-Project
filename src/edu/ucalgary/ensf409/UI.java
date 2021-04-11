/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *UI is a basic class that gets user input (order request) from the terminal and stores thats information
 *to be used to create an order request. The summer of the order will be displayed to the user in the form of
 *a txt.fie.
 *
 */

//Package declaration
package edu.ucalgary.ensf409;


import java.util.*;  
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;  

public class UI {
	//Class variables
	private String type; // mesh
	private String item; // chair
	private String quanity; // 1
	private String totalPrice; // This will be the total price of the order
	
	private Object [] sqlDataStorage; // generic object array, will be filled with all necessary line items from data tables
	private Object [] completedOrder; // filled with contents from cheapestCombinations
	
	private ArrayList<Chair> chairStorage;         // added for now. Need to decide if we're using arrayLists or Object []
	private ArrayList<Desk> deskStorage;  			// added for now. Need to decide if we're using arrayLists or Object []
	private ArrayList<Filing> filingStorage; 	 // added for now. Need to decide if we're using arrayLists or Object []
	private ArrayList<Lamp> lampStorage;		// added for now. Need to decide if we're using arrayLists or Object []
	
	public final String DBURL;
	public final String username;
	public final String password;
	
	
	
	// Create DBURL, username, and password class variables, need to send to Moto.
	
	
	/*Constructor
	 *Takes in Strings from user input and stores in class variables.
	 */
	public UI(String first, String second, String third, String forth) {
		String [] temp = first.split(" ",3 );
		type = temp [0];
		item = temp [1].substring(0,temp[1].length()-1);
		quanity = temp [2];
	
		DBURL = second;
		username = third;
		password = forth;
	}
	
	//Getter
	public String getType() {
		return this.type;
	}
	
	//Getter
	public String getItem() {
		return this.item;
	}
	//Getter
	public String getQuanity() {
		return this.quanity;
	}
	
	//Getter
	public String getDBURLType() {
		return this.DBURL;
	}
		
	//Getter
	public String getUsername() {
		return this.username;
	}
	//Getter
	public String getPassword() {
		return this.password;
	}
	
	//Setter
	public void setType(String type) {
		this.type = type;
	}
	//Setter
	public void setItem(String item) {
		this.item = item;
	}
	//Setter
	public void setQuanity(String quanity) {
		this.quanity = quanity;
	}
	
	//str to int conversion
	public int strToInt() {
		int rst =Integer.parseInt(quanity);
		return rst;
	}
	
	//Setters have not been implemented for DBURL, username, and password
	
	/*processOrder
	 *Gives information of order details to dataBase SQL class.
	 */
	public void processOrder() {
		Database myOrder = new Database (DBURL, username, password, type, item); //
		sqlDataStorage = myOrder.getData(); // ex. all mesh chair line items from table stored in array list
    }
	
	/*calculateOrder
	 *Gives object [] of SQL line item to cheapestCombinations Class.
	 *Receives new Object [] of cheapest items to fulfill order request.
	 *Stores in class variable.
	 */
	public void calculateOrder() {
		CalculateCombinations findResults = new CalculateCombinations();//pass in Object []
		int quanityNum = strToInt();
		//use if statements to generate all combos for furniture items
		if(item =="chair") {
			findResults.findAllCombinationsChair(chairStorage, quanityNum);
		}
		
		if(item == "desk") {
			findResults.findAllCombinationsDesk(deskStorage, quanityNum);
			
		}
		if(item == "filing") {
			findResults.findAllCombinationsFiling(filingStorage, quanityNum);
			
		}
		if(item == "lamp") {
			findResults.findAllCombinationsLamp(lampStorage, quanityNum);			
		}
	}
	
	/*displayOrder
	 *Results of user's order request will be presented in the form of a file.txt.
	 */
	public void displayOrder() {
		String toBePrinted = formatOrderRequest(); //receives bigString (formatted output of order request)
		createFile();
		try {
		      FileWriter myWriter = new FileWriter("Order_Request_Results.txt");
		      myWriter.write(toBePrinted);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } 
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	/*createFile
	 *Creates a file.txt named "Order_Request_Results.txt"
	 *This file will be filled with information from the order request.
	 */
	public void createFile() {
		    try {
		      File myObj = new File("Order_Request_Results.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } 
		      else {
		        System.out.println("File already exists.");
		      }
		    } 
		    catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  }

	/*formatOrderRequest
	 *formats results from cheapestCombinations Class then
	 *send the string to displayOrder.
	 */
	public String formatOrderRequest() {
		StringBuilder bigString = new StringBuilder();
		System.out.println("Processing your order... \n");
		
    	bigString.append("Furniture Order Form \n\n");
    	bigString.append("Faculty Name: \n");
    	bigString.append("Cantact: \n");
    	bigString.append("Date: \n\n");
    	bigString.append("Original Request: " + type + " " + item + "," + quanity + "\n\n");
    	
    	bigString.append("Items Ordered \n");
    	bigString.append("ID: " + "chairCode1"+ "\n"); // need furniture code class to store codes
    	bigString.append("ID: " + "chairCode2"+ "\n"); // need furniture code class to store codes
    	
    	bigString.append("Total Price: $150"); // price is hard-coded for now (example).
    	return bigString.toString();
	}
		
	public static void main(String[] args) {
		
			//prompts user to enter their order request in the form of type item, quantity 
			Scanner sc= new Scanner(System.in);  
			try {
				System.out.print("Please enter your order request (type item, quanity): \n");  
				String storage1= sc.nextLine();
			
				//prompts user again to enter DBURL, username, and password
				System.out.print("Please enter DBURL: \n");  
				String storage2 = sc.nextLine();
			
				System.out.print("Please enter username: \n");  
				String storage3 = sc.nextLine();
			
				System.out.print("Please enter password: \n");  
				String storage4 = sc.nextLine();
			
				//create new UI object and pass in all user input
				UI newOrder = new UI(storage1, storage2, storage3, storage4);
		
				newOrder.processOrder(); 
				newOrder.calculateOrder();
				newOrder.displayOrder();
			}
	    	finally {
	    		sc.close();
	    	}		
	}
}
