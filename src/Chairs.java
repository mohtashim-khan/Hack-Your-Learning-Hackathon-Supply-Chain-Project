import java.sql.*;

public class Chairs extends Furniture {
	private String id;
	private String type;
	private String arms;
	private String seat;
	private String cushion;
	private String price;
	private String menuID;
	
	private String [] chairInfo; //Ex. chairInfo ["C1320" ,	"Kneeling" , "Y" , "N" , "N" , "N" , "50" , "002"]
	
	
	private Connection dbConnect;
    private ResultSet results;

	
	//0 arg constructor
	//need to pull data from SQL database and populate chairInfo array
	public Chairs(){
		chairInfo = new String [7];
		initializeConnection();
		selectChairs();	
		id = chairInfo[0];
		type = chairInfo[1];
		arms = chairInfo[2];
		seat = chairInfo[3];
		cushion =chairInfo[4];
		price = chairInfo[5];
		menuID = chairInfo[6];
	}
// create database class
	public void initializeConnection() {
		try {
			  dbConnect = DriverManager.getConnection("write DBURL here", "USERNAME", "PASSWORD");
		}
		catch(SQLException err){
            err.printStackTrace();
		}
	}
	public void calculatePrice () {
		
	}
	public void selectChairs() {
		try {
			Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM CHAIR");
            
            while(results.next()) { //iterate thru all rows of the table
            	chairInfo [0] = results.getString("ID");
            	chairInfo [1] = results.getString("Type");
            	chairInfo [2] = results.getString("Legs");
            	chairInfo [3] = results.getString("Arms");
            	chairInfo [4] = results.getString("Seat");
            	chairInfo [5] = results.getString("Cushion");
            	chairInfo [6] = results.getString("Price");
            	chairInfo [7] = results.getString("menuID");
            }
            
            myStmt.close();
		}
		
		catch(SQLException err){
            err.printStackTrace();
		}
	}
	
 // leave for now. Might get rid later.
	
	public String getArms() {
		return this.arms;
	}
	public String getSeat() {
		return this.seat;
	}
	public String getCushion() {
		return this.cushion;
	}
	
	public String [] getChairInfo() {
		return this.chairInfo;
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
	
	public void setChairInfo(String [] chairInfo) {
		this.chairInfo = chairInfo;
	}

}
