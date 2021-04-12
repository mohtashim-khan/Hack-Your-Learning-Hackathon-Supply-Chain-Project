/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *Furniture is a basic class that provides a template for the other furniture objects
 *(chair, Desks, Filings, Lamp).
 *These furniture items are based from the SQL database provided by the course instructors.
 *
 */

//Package declaration
package edu.ucalgary.ensf409;

abstract class Furniture {
	
	//Class variables
	private String iD;
	private String type;
	private String price;
	private String manuID;
	
	//Constructor
	public Furniture(String iD, String type, String price, String manuID) {
		this.iD = iD;
		this.type = type;
		this.price = price;
		this.manuID = manuID;
	}
	
	//Important method for getting int values for Y/N things from furniture databases
	public int getIntFromYorN(String a){
		if(a.equals("Y")){
			return 1;
		}
		else{
			return 0;
		}
	}

	//Getter
	public String getiD() {
		return iD;
	}
	
	//Getter
	public String getManuID() {
		return manuID;
	}
	
	//Getter
	public String getPrice() {
		return price;
	}

	//Get Price as Int value
	public int getPriceInt(){
		return Integer.parseInt(this.price);
	}
	
	//Getter
	public String getType() {
		return type;
	}
	
	//Function converts String to Double
	public double pricetoDouble() {
		return Double.valueOf(price);
	}
	
	//Setter
	public void setiD(String iD) {
		this.iD = iD;
	}
	
	//Setter
	public void setType(String type) {
		this.type = type;
	}
	
	//Setter
	public void setPrice(String price) {
		this.price = price;
	}
	
	//Setter
	public void setManuID(String manuID) {
		this.manuID = manuID;
	}
}
//End class definition
