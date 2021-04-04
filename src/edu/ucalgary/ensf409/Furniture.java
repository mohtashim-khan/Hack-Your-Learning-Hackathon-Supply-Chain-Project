package edu.ucalgary.ensf409;

abstract class Furniture 
{
	private String iD;
	private String type;
	private int price;
	private String manuID;
	
	
	
	public Furniture(String iD, String type, int price, String manuID) {
		
		this.iD = iD;
		this.type = type;
		this.price = price;
		this.manuID = manuID;
	}


	public String getiD() {
		return iD;
	}
	

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getManuID() {
		return manuID;
	}

	public void setManuID(String manuID) {
		this.manuID = manuID;
	}
	
	
	
	
	

}
