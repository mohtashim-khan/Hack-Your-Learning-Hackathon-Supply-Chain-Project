package edu.ucalgary.ensf409;

public class Lamp extends Furniture {
	


	private String base;
	private String bulb;
	
	public Lamp(String iD, String type, String base, String bulb, String price, String manuID) {
		
		super(iD, type, price, manuID);
		this.base = base;
		this.bulb = bulb;

	}

	public String getBase() {
		return this.base;
	}
	public String getBulb() {
		return this.bulb;
	}
// Setters - 
	
	public void setBase(String base) {
		this.base = base;
	}
	public void setBulb(String bulb) {
		this.bulb = bulb;
	}
	


}
