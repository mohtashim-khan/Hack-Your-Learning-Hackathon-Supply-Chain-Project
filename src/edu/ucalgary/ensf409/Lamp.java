package edu.ucalgary.ensf409;

public class Lamp {
	

	private String iD;
	private String type;
	private String base;
	private String bulb;
	private String price;
	private String manuID;
	
	public Lamp(String iD, String type, String base, String bulb, String price, String manuID) {
		
		//super(iD, type, rails, drawers, cabinet, price, manuID);
		// TODO Auto-generated constructor stub
		this.iD = iD;
		this.type = type;
		this.base = base;
		this.bulb = bulb;
		this.price = price;
		this.manuID = manuID;

	}

	public String getID() {
		return this.iD;
	}
	public String getType() {
		return this.type;
	}
	public String getBase() {
		return this.base;
	}
	public String getBulb() {
		return this.bulb;
	}
	public String getPrice() {
		return this.price;
	}
	public String getmanuID() {
		return this.manuID;
	}
// Setters - 
	public void setID(String iD) {
		this.iD = iD;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public void setBulb(String bulb) {
		this.bulb = bulb;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setManuID(String manuID) {
		this.manuID = manuID;
	}


}
