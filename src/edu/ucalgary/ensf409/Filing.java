package edu.ucalgary.ensf409;

public class Filing {

	
	
	private String iD;
	private String type;
	private String rails;
	private String drawers;
	private String cabinet;
	private String price;
	private String manuID;
	
	
	public Filing(String iD, String type, String rails, String drawers, String cabinet, String price, String manuID) {
		
		//super(iD, type, rails, drawers, cabinet, price, manuID);
		// TODO Auto-generated constructor stub
		this.iD = iD;
		this.type = type;
		this.rails = rails;
		this.drawers = drawers;
		this.cabinet = cabinet;
		this.price = price;
		this.manuID = manuID;

	}
	
	public String getID() {
		return this.iD;
	}
	public String getType() {
		return this.type;
	}
	public String getRails() {
		return this.rails;
	}
	public String getDrawers() {
		return this.rails;
	}
	public String getCabinet() {
		return this.rails;
	}
	public String getPrice() {
		return this.rails;
	}
	public String ManuID() {
		return this.rails;
	}
	
	
	
	
	
	public void setID(String iD) {
		this.iD = iD;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setRails(String rails) {
		this.rails = rails;
	}
	public void setDrawers(String drawers) {
		this.drawers = drawers;
	}
	public void setCabinet(String cabinet) {
		this.cabinet = cabinet;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setManuID(String manuID) {
		this.manuID = manuID;
	}
	
	
	
}
