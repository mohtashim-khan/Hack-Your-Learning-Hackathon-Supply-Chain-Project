package edu.ucalgary.ensf409;
import java.util.*;

public class CheapestCombination {

    public ArrayList<Furniture> combination;                // an ArrayList of Furniture objects that make up a valid combination
    public int totalPrice = 0;                              // total price the this combination

    /**
     * Constructor. Setting the datamember combination to the ArrayList in argument
     * @param comb a valid Furniture objects combination.
     */
    public CheapestCombination(ArrayList<Furniture> comb) {
        this.combination = comb;
        for (Furniture furniture : comb){
            totalPrice += furniture.getPriceInt();
        }
    }

    public void print() {
        for (Furniture furniture : combination) {
            System.out.println(furniture.getiD());
        }
        System.out.println("Total Price: $" + totalPrice);
    }

    public String getFormat() {
		StringBuilder ret = new StringBuilder();
		for (Furniture furniture : combination) {
            ret.append("ID: " + furniture.getiD() + '\n');
        }
		ret.append("Total Price: " + totalPrice);
		return ret.toString();
	}
    
    public ArrayList<Furniture> getCombination()
    {
    	return this.combination;
    	
    }
    
    public String [] getIDs()
    {
    	String [] returnStringArray = new String [combination.size()];
    	for(int i = 0; i<combination.size();i++)
    	{
    	returnStringArray[i] = combination.get(i).getiD();
    	}
    	
    	return returnStringArray;
    }

	/**
	 * @return the totalPrice
	 */
	public int getTotalPrice() {
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