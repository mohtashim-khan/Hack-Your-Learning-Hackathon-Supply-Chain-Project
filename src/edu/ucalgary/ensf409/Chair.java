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
	private String legs;
	private String arms;
	private String seat;
	private String cushion;
	
	//Constructor
	public Chair(String iD, String type, String price, String manuID, String arms, String seat, String cushion) {
		super(iD, type, price, manuID);
		// TODO Auto-generated constructor stub
		this.legs = legs;
		this.arms = arms;
		this.seat = seat;
		this.cushion = cushion;
	}

	//Getter
	public String getLegs() {
		return this.legs;
	}

	//returns 1 if legs == "Y" 0 otherwise
	public int getLegsInt() {
		return getIntFromYorN(this.legs);
	}

	//Getter
	public String getArms() {
		return this.arms;
	}
		
	//returns 1 if arms == "Y" 0 otherwise
	public int getArmsInt() {
		return getIntFromYorN(this.arms);
	}
	
	//Getter
	public String getSeat() {
		return this.seat;
	}
	
	//returns 1 if seat == "Y" 0 otherwise
	public int getSeatInt() {
		return getIntFromYorN(this.seat);
	}
	
	//Getter
	public String getCushion() {
		return this.cushion;
	}
		
	//returns 1 if cushion == "Y" 0 otherwise
	public int getCushionInt() {
		return getIntFromYorN(this.cushion);
	}

	//Setter
	public void setLegs(String legs) {
		this.legs = legs;
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