/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *Desk is a basic class that stores all the string variables from the
 *SQL database provided by the course instructors.
 *
 */
//Package declaration
package edu.ucalgary.ensf409;

public class Desk extends Furniture {
	
	//Class variables
	private String legs;
	private String top;
	private String drawer;

	//Constructor
	public Desk(String iD, String type, String price, String manuID, String legs, String top, String drawer) {
		super(iD, type, price, manuID);
		this.legs = legs;
		this.top = top;
		this.drawer = drawer;
	}
	
	//Getter
	public String getLegs() {
		return this.legs;
	}
	
	//Getter
	public String getTop() {
		return this.top;
	}
	
	//Getter
	public String getDrawer() {
		return this.drawer;
	}
	
	//Setter
	public void setlegs(String legs) {
		this.legs = legs;
	}
	
	//Setter
	public void setTop(String top) {
		this.top = top;
	}
	
	//Setter
	public void setDrawer(String drawer) {
		this.drawer = drawer;
	}
}	
//End class definition