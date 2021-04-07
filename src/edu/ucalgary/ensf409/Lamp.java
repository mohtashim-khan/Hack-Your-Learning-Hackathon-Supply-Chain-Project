/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *Filing is a basic class that stores all the string variables from the
 *SQL database provided by the course instructors.
 *
 */

//Package declaration
package edu.ucalgary.ensf409;

public class Lamp extends Furniture {
	
	//Class variables
	private String base;
	private String bulb;
	
	//Constructor
	public Lamp(String iD, String type, String base, String bulb, String price, String manuID) {
		
		super(iD, type, price, manuID);
		this.base = base;
		this.bulb = bulb;

	}
	
	//Getter
	public String getBase() {
		return this.base;
	}
	//Getter
	public String getBulb() {
		return this.bulb;
	}
	
	//Setter	
	public void setBase(String base) {
		this.base = base;
	}
	//Setter
	public void setBulb(String bulb) {
		this.bulb = bulb;
	}
}
//End class definition
