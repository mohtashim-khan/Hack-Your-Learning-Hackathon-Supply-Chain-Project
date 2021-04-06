package edu.ucalgary.ensf409;

public class Desk extends Furniture {

	private String legs;
	private String top;
	private String drawer;

	public void selectDesks() {
	}
	
 // leave for now. Might get rid later.
	
	public Desk(String iD, String type, int price, String manuID, String legs, String top, String drawer) {
		super(iD, type, price, manuID);
		// TODO Auto-generated constructor stub
		this.legs = legs;
		this.top = top;
		this.drawer = drawer;
	}

	public String getLegs() {
		return this.legs;
	}
	public String getTop() {
		return this.top;
	}
	public String getDrawer() {
		return this.drawer;
	}
	

	public void setlegs(String legs) {
		this.legs = legs;
	}
	public void setTop(String top) {
		this.top = top;
	}
	public void setDrawer(String drawer) {
		this.drawer = drawer;
	}
}	
