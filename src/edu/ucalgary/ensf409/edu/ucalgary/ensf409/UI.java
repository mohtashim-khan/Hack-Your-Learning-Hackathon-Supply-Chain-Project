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

public class UI {
	//Class variables
	private String type; // mesh
	private String item; // chair
	private String quanity; // 1
	private String totalPrice; // This will be the total price of the order
	
	/*Constructor
	 *Takes in String from user input and stores in class variables.
	 *Calls processOrder() to go through the calculation process.
	 */
	public UI(String fromCmdPrompt) {
		String [] temp = fromCmdPrompt.split(" ",3 );
		type = temp [0];
		item = temp [1].substring(0,temp[1].length()-1);
		quanity = temp [2];
		System.out.println("Processing your order... \n");
		processOrder();
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
	
	/*processOrder
	 *Gives information of order details to dataBase SQL class.
	 *Once information has been processed in back-end, an output of the order
	 *results will be printed for the user.
	 */
	public void processOrder() {
		StringBuilder bigString = new StringBuilder();
		
    	bigString.append("Furniture Order Form \n\n");
    	bigString.append("Faculty Name: \n");
    	bigString.append("Cantact: \n");
    	bigString.append("Date: \n\n");
    	bigString.append("Original Request: " + type + " " + item + "," + quanity + "\n\n");
    	
    	bigString.append("Items Ordered \n");
    	bigString.append("ID: " + "chairCode1"+ "\n"); // need furniture code class to store codes
    	bigString.append("ID: " + "chairCode2"+ "\n"); // need furniture code class to store codes
    	
    	bigString.append("Total Price: $150"); // price is hard-coded for now (example).
    	System.out.println(bigString.toString());
    }
		
	public static void main(String[] args) {
			Scanner sc= new Scanner(System.in);  //System.in is a standard input stream  
			System.out.print("Please enter your order request: \n");  
			String str= sc.nextLine();   //reads string upto line
			UI newOrder = new UI(str);	//creates new UI object, with order request from user.
	}
}
