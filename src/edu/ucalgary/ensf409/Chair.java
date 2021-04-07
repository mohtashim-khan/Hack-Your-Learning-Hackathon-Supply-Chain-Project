/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *Chair is a basic class that stores all the string variables from the
 *SQL database provided by the course instructors.
 *
 */

//Package declaration
package edu.ucalgary.ensf409;

public class Chair extends Furniture {
	
	//Class variables
	private String arms;
	private String seat;
	private String cushion;
	
	//Constructor
	public Chair(String iD, String type, String price, String manuID, String arms, String seat, String cushion) {
		super(iD, type, price, manuID);
		// TODO Auto-generated constructor stub
		this.arms = arms;
		this.seat = seat;
		this.cushion = cushion;
	}
	
	//Getter
	public String getArms() {
		return this.arms;
	}
	
	//Getter
	public String getSeat() {
		return this.seat;
	}
	
	//Getter
	public String getCushion() {
		return this.cushion;
	}
	
	//Setter
	public void setArms(String arms) {
		this.arms = arms;
	}
	
	//Setter
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	//Setter
	public void setCushion(String cushion) {
		this.cushion = cushion;
	}
}
//End class definition