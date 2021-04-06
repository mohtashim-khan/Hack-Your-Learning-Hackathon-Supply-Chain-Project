package edu.ucalgary.ensf409;

public class Filing extends Furniture{

	
	
	
	private String rails;
	private String drawers;
	private String cabinet;
	
	
	
	public Filing(String iD, String type, String rails, String drawers, String cabinet, String price, String manuID) {
		
		super(iD, type, price, manuID);
		this.rails = rails;
		this.drawers = drawers;
		this.cabinet = cabinet;

	}
	
	public String getRails() {
		return this.rails;
	}
	public String getDrawers() {
		return this.drawers;
	}
	public String getCabinet() {
		return this.cabinet;
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
	
	
	
}
