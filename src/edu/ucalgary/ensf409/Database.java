/**@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *Database class: handles all Database related stuff and instantiates the necessary Objects.
 */
package edu.ucalgary.ensf409;
import java.sql.*;
import java.util.ArrayList;

public class Database 
{
	public final String DBURL;
	public final String USERNAME;
	public final String PASSWORD;
	private Connection dbConnect;
	private ResultSet results;
	private String selectedTable;
	private String selectedType;
	private ArrayList<Chair> chairList = new ArrayList<Chair>();
	private ArrayList<Desk> deskList = new ArrayList<Desk>();
	private ArrayList<Lamp> lampList = new ArrayList<Lamp>();
	private ArrayList<Filing> filingList = new ArrayList <Filing>();
	
    /**
     * @param dBURL
     * @param username
     * @param password
     * @param selectedType
     * @param selectedTable
     * @throws IllegalArgumentException
     * Database's constructor, receives the URL, the Username, and the password to the database. Stores the required table and type requested.
     * throws IllegalArguement exception if the selectedTable is not a part of the furniture classes
     * 
     */
    public Database(String dBURL, String username, String password, String selectedType, String selectedTable) throws IllegalArgumentException {
    	
    	DBURL = dBURL;
    	USERNAME = username;
    	PASSWORD = password;
    	this.selectedType = selectedType.toLowerCase();
    	this.selectedTable = selectedTable.toLowerCase();
    	
    	if(!(selectedTable.equals("chair") || selectedTable.equals("desk") || selectedTable.equals("filing") || selectedTable.equals("lamp")))
    	{
    		throw new IllegalArgumentException("selectedTable is not valid");
    	}
    	
    	
    	
	}
    
    
    /**
     * initConnection() Initializes connection with the database based on provided DBURL, Username, and password
     * 
     */
    public void initConnection()
    {
        
        try{
            dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    /**
     * @return Object []
     * @throws NullPointerException
     * 
     * getData() calls selectFromDB() where 
     */
    public Object [] getData() throws NullPointerException
    {
    	selectFromDB();
    	if(selectedTable.equals("chair"))
    	{
    	return chairList.toArray();
    	}
    	
    	else if(selectedTable.equals("desk"))
    	{
    	return deskList.toArray();
    	}
   
    	else if(selectedTable.equals("lamp"))
    	{
    	return lampList.toArray();
    	}
    	
    	else if(selectedTable.equals("filing"))
    	{
    	return filingList.toArray();
    	}
    	
    	else
    	{
    		throw new NullPointerException("data is empty from getData()");
    	}
    	
    
    }
    
	
    
    
    //Extracts the required information from the database and populates the appropriate class ArrayList with the 
    // required values.
    public void selectFromDB()
    {
    	try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM "+selectedTable+" WHERE `type` = '"+selectedType+"'");

            switch(selectedTable)
            {
            case "chair":
            	while(results.next())
            	{
            		String id = results.getString("id");
            		String type = results.getString("type");
            		String price = results.getString("price");
            		String manuID = results.getString("manuID");
            		String legs = results.getString("legs");
            		String arms = results.getString("arms");
            		String seat = results.getString("seat");
            		String cushion = results.getString("cushion");
            		chairList.add(new Chair(id,type,price,manuID,legs,arms,seat,cushion));
            	}
            case "lamp":
            	while(results.next())
            	{
            		String id = results.getString("id");
            		String type = results.getString("type");
            		String price = results.getString("price");
            		String manuID = results.getString("manuID");
            		String base = results.getString("base");
            		String bulb = results.getString("bulb");
            		lampList.add(new Lamp(id,type,base, bulb,price,manuID));
            	}
            case "filing":
            	while(results.next())
            	{
            		String id = results.getString("id");
            		String type = results.getString("type");
            		String price = results.getString("price");
            		String manuID = results.getString("manuID");
            		String rails = results.getString("rails");
            		String drawers = results.getString("drawers");
            		String cabinet = results.getString("cabinet");
            		filingList.add(new Filing(id,type,rails, drawers, cabinet, price,manuID));
            	}
            case "desk":
            	while(results.next())
            	{
            		String id = results.getString("id");
            		String type = results.getString("type");
            		String price = results.getString("price");
            		String manuID = results.getString("manuID");
            		String legs = results.getString("legs");
            		String top = results.getString("top");
            		String drawer = results.getString("drawer");
            		deskList.add(new Desk(id,type,price,manuID,legs,top,drawer));
            	}
            
            }
            
            
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    	
    	
    	
    	
    }
    
    //Deletes Database entry in the selected table based on provided iD
    public void deleteDBEntry(String id)
    {
    	try {
            String query = "DELETE FROM "+selectedTable+" WHERE id = '"+id.replace(" ", "")+"'";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.executeUpdate();
            myStmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    	
    }
    
    public PreparedStatement sendQuery(String query) throws SQLException
    {
    	return dbConnect.prepareStatement(query);
    }
    
    
    
    
    public void closeProcess() {
        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void closeDelete()
    {
    	try {
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


	/**
	 * @return the dBURL
	 */
	public String getDBURL() {
		return DBURL;
	}


	/**
	 * @return the uSERNAME
	 */
	public String getUSERNAME() {
		return USERNAME;
	}


	/**
	 * @return the pASSWORD
	 */
	public String getPASSWORD() {
		return PASSWORD;
	}


	/**
	 * @return the dbConnect
	 */
	public Connection getDbConnect() {
		return dbConnect;
	}


	/**
	 * @return the results
	 */
	public ResultSet getResults() {
		return results;
	}


	/**
	 * @return the selectedTable
	 */
	public String getSelectedTable() {
		return selectedTable;
	}


	/**
	 * @return the selectedType
	 */
	public String getSelectedType() {
		return selectedType;
	}


	/**
	 * @return the chairList
	 */
	public ArrayList<Chair> getChairList() {
		return chairList;
	}


	/**
	 * @return the deskList
	 */
	public ArrayList<Desk> getDeskList() {
		return deskList;
	}


	/**
	 * @return the lampList
	 */
	public ArrayList<Lamp> getLampList() {
		return lampList;
	}


	/**
	 * @return the filingList
	 */
	public ArrayList<Filing> getFilingList() {
		return filingList;
	}

	
	

}
