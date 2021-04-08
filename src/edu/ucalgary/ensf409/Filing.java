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

public class Filing extends Furniture{
	
	//Class variables
	private String rails;
	private String drawers;
	private String cabinet;
	
	//Constructor
	public Filing(String iD, String type, String rails, String drawers, String cabinet, String price, String manuID) {
		
		super(iD, type, price, manuID);
		this.rails = rails;
		this.drawers = drawers;
		this.cabinet = cabinet;

	}
	
	//Getter
	public String getRails() {
		return this.rails;
	}
	
	//Getter
	public String getDrawers() {
		return this.drawers;
	}
	
	//Getter
	public String getCabinet() {
		return this.cabinet;
	}
	
	//Setter
	public void setRails(String rails) {
		this.rails = rails;
	}
	
	//Setter
	public void setDrawers(String drawers) {
		this.drawers = drawers;
	}
	
	//Setter
	public void setCabinet(String cabinet) {
		this.cabinet = cabinet;
	}
}
//End class definition