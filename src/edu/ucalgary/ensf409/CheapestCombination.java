package edu.ucalgary.ensf409;
import java.util.*;

public class CheapestCombination {

    public ArrayList<Furniture> furnitureCombination;              // an ArrayList of Furniture objects that make up a combination
    public int totalPrice = 0;                                     // total price of the furnitureList combination

    /**
     * Constructor
     * contains the furnitureCombination as a parameter
     * finds total price of the all items in the combination
     * @param furnitureList list of furniture objects that will make the furnitureCombination
     */
    public CheapestCombination(ArrayList<Furniture> furnitureList) {
        this.furnitureCombination = furnitureList;
        for (int i = 0; i < furnitureList.size(); i++){
            totalPrice += furnitureList.get(i).getPriceInt();
        }
    }

    //getter
    public ArrayList<Furniture> getFurnitureCombination(){
    	return this.furnitureCombination;
    }
    

    //getter - sends String of userIDs for use by the UI and Database classes
    public String [] getIDs(){
    	String [] returnStringArray = new String [furnitureCombination.size()];
    	for(int i = 0; i<furnitureCombination.size();i++){
    	returnStringArray[i] = furnitureCombination.get(i).getiD();
    	}
      	return returnStringArray;
    }

	/**
	 * @return the totalPrice
	 */
	public int getTotalPrice(){
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
    
    
}
//end of class declaration