package edu.ucalgary.ensf409;

public class Chair extends Furniture {
	private String arms;
	private String seat;
	private String cushion;

	public void selectChairs() {
		
	}
	
 // leave for now. Might get rid later.
	
	public Chair(String iD, String type, int price, String manuID, String arms, String seat, String cushion) {
		super(iD, type, price, manuID);
		// TODO Auto-generated constructor stub
		this.arms = arms;
		this.seat = seat;
		this.cushion = cushion;
	}

	public String getArms() {
		return this.arms;
	}
	public String getSeat() {
		return this.seat;
	}
	public String getCushion() {
		return this.cushion;
	}
	

	public void setArms(String arms) {
		this.arms = arms;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public void setCushion(String cushion) {
		this.cushion = cushion;
	}
	

}
