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
            totalPrice += furniture.getPRICE();
        }
    }

    public void print() {
        for (Furniture furniture : combination) {
            System.out.println(furniture.getID());
        }
        System.out.println("Total Price: $" + totalPrice);
    }

    public String getFormat() {
		StringBuffer format = new StringBuffer();
		for (Furniture furniture : combination) {
            format.append("ID: " + furniture.getID());
			format.append('\n');
        }
		format.append("Total Price: " + totalPrice);
		
		return format.toString();
	}

}



class Combination {

    /**
     * Builds a String for the formatted output to the order-form.txt file
     * @return String consists of all Furniture objects' IDs and total price in the correct format.
     */
    public String getFormat() {
		StringBuffer format = new StringBuffer();
		for (Furniture furniture : combination) {
            format.append("ID: " + furniture.getID());
			format.append('\n');
        }
		format.append("Total Price: " + totalPrice);
		
		return format.toString();
	}
	
}
