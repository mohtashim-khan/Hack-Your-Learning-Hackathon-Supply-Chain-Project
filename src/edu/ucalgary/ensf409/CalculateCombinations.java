/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *CalculateCombinations is a class that finds all combinations and 
 *outputs the cheapest one
 */


// The best combination is the cheapest Combination
// CheapestCombination in the code BELOW represents one combination (not necessarily cheapest)
// the bestCombination method looks through the ArrayList of CheapestCombinations to find the bestCombination

package edu.ucalgary.ensf409;
import java.util.*;
import java.sql.*;

public class CalculateCombinations {

	//This Array List contains all the combinations
	private ArrayList<CheapestCombination> allCombinations;
	private int totalPrice = 0;

	
	//Constructor
	public CalculateCombinations() {
        allCombinations = new ArrayList<>();
    }

    //getter
	public ArrayList<CheapestCombination> getAllCombinations() {
        return allCombinations;
    }
	
    //getter
    public int getTotalPrice(){
		return this.totalPrice;
	}

	// This is a getter for the ID's of the Cheapest Combination
	public String [] getBestCombIDs(){
		CheapestCombination outBestComb = bestCombination();
		String [] returnStringArray;
		try {
			totalPrice = outBestComb.getTotalPrice();
			returnStringArray = outBestComb.getIDs();
		}
		catch(NullPointerException e)
		{
			totalPrice = 0;
			returnStringArray = null;
		}
		return returnStringArray;
	}

    //finds the Cheapest Combinations from allCombinations
	public CheapestCombination bestCombination(){
        if (this.allCombinations.isEmpty()){
            return null;
        }

        CheapestCombination bestComb = null;
        
		// This traverses all combinations from the allCombination array and finds the combination with the cheapest totalPrice 
        
		for (int i = 0; i < this.allCombinations.size(); i++){
            if (bestComb == null){
                bestComb = this.allCombinations.get(i);
            }
            if(this.allCombinations.get(i).totalPrice < bestComb.totalPrice){
                bestComb = this.allCombinations.get(i);
            }
        }
        return bestComb; // returns the cheapest combination
    }
    

	// Generic methods - public void find <T> - USMAN 
    // This find<item>Combinations method is the driver class for recursion 
	public void findLampCombinations(Object[] lampObjectList, int quantity){
        // Type cast the returned Object[] to the required Array List type
		ArrayList<Lamp> lampList = new ArrayList<>();
        for(int i = 0; i < lampObjectList.length; i++){
            lampList.add((Lamp) lampObjectList[i]);                               
        }

		//This locallist will contain all combinations that fullfill the order!
        ArrayList<Lamp> localList = new ArrayList<>();                        
		
		//starts the recursion - Bang!
        bestLampCombination(0, 0, 0, quantity, localList, lampList);
    }

	/**
	 * This method "populates" all the combinations that fulfill the requested # of orders aka "Best Combination"
	 * @param index - Recursion increment 
	 * @param baseLocInt - Subitem must reach the order quantity
	 * @param bulbLocInt - Subitem must reach the order quantity
	 * @param quantity - Number of orders to be placed 
	 * @param localList - explained below
	 * @param lampList - The array of all Lamps in the current Data Base
	 * 
	 * (Simple explanation)
	 * localist is a temp list used to add and remove individual lamps, thus creating a "Potential" combination.
	 * Now if the locallist was a successful combination, it will add those "lamps" from the local list into winnerComb list so that we do not 
	 * loose track of a winner
	 *
	 * Now that we have a winner, we add it to the allCombinations list which can be used to find the bestCombination later!
	 * 
	 * (Deeper Explanation)
	 * We perform a backtracking recursive call that checks for potential winner combinations and loops through all possible 
	 * combinations to test that!
	 */
	public void bestLampCombination(int index, int baseLocInt, int bulbLocInt, int quantity, ArrayList<Lamp> localList, ArrayList<Lamp> lampList){
        // Base Case for recursion - Checks if quantities are met, if met then add to daddy List 
		if (baseLocInt >= quantity && bulbLocInt >= quantity){  
			// This is a type cast because we need to construct a CheapestCombination class!!
			ArrayList<Furniture> winnerComb = new ArrayList<>();
			for(int i=0; i < localList.size(); i++){
				winnerComb.add((Furniture) localList.get(i));
			}
			this.allCombinations.add(new CheapestCombination(winnerComb));
            return;
		}

        // This loop is an iteration of recursion 
        for (int i = index; i < lampList.size(); i++){
            // check if lamp is being repeated in lampList
            if (i > index && lampList.get(i) == lampList.get(i-1)){
                continue; // skip this increment
            }

            // adding the next lamp into the temp array "localList"
            localList.add(lampList.get(i));

            // recursive call
            int baseArg = baseLocInt + lampList.get(i).getBaseInt();
            int bulbArg = bulbLocInt + lampList.get(i).getBulbInt();
            int newIndex = i+1;
            bestLampCombination(newIndex, baseArg, bulbArg, quantity, localList, lampList);

            // Remove the last Lamp from the "localList" - AKA Backtracking 
            localList.remove(localList.size() - 1);
        }
    }

	
	// This find<item>Combinations method is the driver class for recursion 
	public void findChairCombinations (Object[] chairObjectList, int quantity) {
         // Type cast the returned Object[] to the required Array List type
		ArrayList<Chair> chairList = new ArrayList<>();
        for(int i = 0; i < chairObjectList.length; i++){
            chairList.add((Chair) chairObjectList[i]);                               
        }

		//This locallist will contain all combinations that fullfill the order!
        ArrayList<Chair> localList = new ArrayList<>();

        //starts the recursion
        bestChairCombination(0, 0, 0, 0, 0, quantity, localList, chairList);
    }


    /**
	 * This method "populates" all the combinations that fulfill the requested # of orders aka "Best Combination"
	 * @param index - Recursion increment 
	 * @param legsLocInt - Subitem must reach the order quantity
	 * @param armsLocInt - Subitem must reach the order quantity
     * @param seatLocInt - Subitem must reach the order quantity
     * @param cushionLocInt - Subitem must reach the order quantity
	 * @param quantity - Number of orders to be placed 
	 * @param localList - explained below
	 * @param chairList - The array of all Chairs in the current Data Base
	 * 
	 * (Simple explanation)
	 * localist is a temp list used to add and remove individual chairs, thus creating a "Potential" combination.
	 * Now if the locallist was a successful combination, it will add those "chairs" from the local list into winnerComb list so that we do not 
	 * loose track of a winner
	 *
	 * Now that we have a winner, we add it to the allCombinations list which can be used to find the bestCombination later!
	 * 
	 * (Deeper Explanation)
	 * We perform a backtracking recursive call that checks for potential winner combinations and loops through all possible 
	 * combinations to test that!
	 */
	public void bestChairCombination(int index, int legsLocInt, int armsLocInt, int seatLocInt, int cushionLocInt, int quantity, ArrayList<Chair> localList, ArrayList<Chair> chairList) {
        // Base Case for recursion - Checks if quantities are met, if met then add to daddy List
        if (legsLocInt >= quantity && armsLocInt >= quantity && seatLocInt >= quantity && cushionLocInt >= quantity) {
            // This is a type cast because we need to construct a CheapestCombination class!!
            ArrayList<Furniture> winnerComb = new ArrayList<>();
            for (int i = 0; i < localList.size(); i++) {
                winnerComb.add((Furniture) localList.get(i));
            }
            this.allCombinations.add(new CheapestCombination(winnerComb));
            return;
        }

        // This loop is an iteration of recursion
        for (int i = index; i < chairList.size(); i++){
            // check if the current Chair is repeated or not
            if (i > index && chairList.get(i) == chairList.get(i-1)){
                continue; // skip this increment
            }

            // adding the next chair into the temp array "localList"
            localList.add(chairList.get(i));

            // recursive call
            int newIndex = i + 1;
            int legsArg = legsLocInt + chairList.get(i).getLegsInt();
            int armsArg = armsLocInt + chairList.get(i).getArmsInt();
            int seatArg = seatLocInt + chairList.get(i).getSeatInt();
            int cushionArg = cushionLocInt + chairList.get(i).getCushionInt();
            bestChairCombination(newIndex, legsArg, armsArg, seatArg, cushionArg, quantity, localList, chairList);

            // Remove the last Lamp from the "localList" - AKA Backtracking
            localList.remove(localList.size() - 1);
        }
    }


    // This find<item>Combinations method is the driver class for recursion
	public void findDeskCombinations(Object[] deskObjList, int quantity) {
        // Type cast the returned Object[] to the required Array List type
        ArrayList<Desk> deskList = new ArrayList<>();
        for(int i = 0; i < deskObjList.length; i++){
            deskList.add((Desk) deskObjList[i]);
        }

        //This locallist will contain all combinations that fullfill the order!
        ArrayList<Desk> localList = new ArrayList<>();

        //starts the recursion
        bestDeskCombination(0, 0, 0, 0, quantity, localList, deskList);
    }


    /**
	 * This method "populates" all the combinations that fulfill the requested # of orders aka "Best Combination"
	 * @param index - Recursion increment 
	 * @param legsLocInt - Subitem must reach the order quantity
	 * @param topLocInt - Subitem must reach the order quantity
     * @param drawerLocInt - Subitem must reach the order quantity
	 * @param quantity - Number of orders to be placed 
	 * @param localList - explained below
	 * @param deskList - The array of all Desks in the current Data Base
	 * 
	 * (Simple explanation)
	 * localist is a temp list used to add and remove individual desks, thus creating a "Potential" combination.
	 * Now if the locallist was a successful combination, it will add those "desks" from the local list into winnerComb list so that we do not 
	 * loose track of a winner
	 *
	 * Now that we have a winner, we add it to the allCombinations list which can be used to find the bestCombination later!
	 * 
	 * (Deeper Explanation)
	 * We perform a backtracking recursive call that checks for potential winner combinations and loops through all possible 
	 * combinations to test that!
	 */
	public void bestDeskCombination(int index, int legsLocInt, int topLocInt, int drawerLocInt, int quantity, ArrayList<Desk> localList, ArrayList<Desk> deskList) {
        // Base Case for recursion - Checks if quantities are met, if met then add to daddy List
        if (legsLocInt >= quantity && topLocInt >= quantity && drawerLocInt >= quantity) {
            // This is a type cast because we need to construct a CheapestCombination class!!
            ArrayList<Furniture> winnerComb = new ArrayList<>();
            for (int i = 0; i < localList.size(); i++) {
                winnerComb.add((Furniture) localList.get(i));
            }
            this.allCombinations.add(new CheapestCombination(winnerComb));         
            return;
        }

        // This loop is an iteration of recursion
        for (int i = index; i < deskList.size(); i++){
            // check if the current Desk is repeated or not
            if (i > index && deskList.get(i) == deskList.get(i-1)){
                continue; // skip this increment
            }

            // adding the next desk into the temp array "localList"
            localList.add(deskList.get(i));

            // recursive call
            int legsArg = legsLocInt + deskList.get(i).getLegsInt();
            int topArg = topLocInt + deskList.get(i).getTopInt();
            int drawerArg = drawerLocInt + deskList.get(i).getDrawerInt();
            bestDeskCombination(i+1, legsArg,topArg, drawerArg, quantity, localList, deskList);

            // Remove the last Lamp from the "localList" - AKA Backtracking
            localList.remove(localList.size() - 1);
        }
    }


    // This find<item>Combinations method is the driver class for recursion
	public void findFilingCombinations(Object[] filingObjList, int quantity) {
        // Type cast the returned Object[] to the required Array List type
        ArrayList<Filing> filingList = new ArrayList<>();
        for(int i = 0; i < filingObjList.length; i++){
            filingList.add((Filing) filingObjList[i]);
        }

        //This locallist will contain all combinations that fullfill the order!
        ArrayList<Filing> localList = new ArrayList<>();

        //starts the recursion
        bestFilingCombination(0, 0, 0, 0, quantity, localList, filingList);
    }


    /**
	 * This method "populates" all the combinations that fulfill the requested # of orders aka "Best Combination"
	 * @param index - Recursion increment 
	 * @param railsLocInt - Subitem must reach the order quantity
	 * @param drawersLocInt - Subitem must reach the order quantity
     * @param cabinetLocInt - Subitem must reach the order quantity
	 * @param quantity - Number of orders to be placed 
	 * @param localList - explained below
	 * @param filingList - The array of all filing in the current Data Base
	 * 
	 * (Simple explanation)
	 * localist is a temp list used to add and remove individual filings, thus creating a "Potential" combination.
	 * Now if the locallist was a successful combination, it will add those "filings" from the local list into winnerComb list so that we do not 
	 * loose track of a winner
	 *
	 * Now that we have a winner, we add it to the allCombinations list which can be used to find the bestCombination later!
	 * 
	 * (Deeper Explanation)
	 * We perform a backtracking recursive call that checks for potential winner combinations and loops through all possible 
	 * combinations to test that!
	 */
	public void bestFilingCombination(int index, int railsLocInt, int drawersLocInt, int cabinetLocInt, int quantity, ArrayList<Filing> localList, ArrayList<Filing> filingList){
        // Base Case for recursion - Checks if quantities are met, if met then add to daddy List
        if (railsLocInt >= quantity && drawersLocInt >= quantity && cabinetLocInt >= quantity){
            // This is a type cast because we need to construct a CheapestCombination class!!
            ArrayList<Furniture> winnerComb = new ArrayList<>();
            for (int i = 0; i < localList.size(); i++) {
                winnerComb.add((Furniture) localList.get(i));
            }
            this.allCombinations.add(new CheapestCombination(winnerComb));         
            return;
        }

        // This loop is an iteration of recursion
        for (int i = index; i < filingList.size(); i++){
            // check if the current Desk is repeated or not
            if (i > index && filingList.get(i) == filingList.get(i-1)){
                continue; // skip this increment
            }

            // adding the next filing into the temp array "localList"
            localList.add(filingList.get(i));

            // recursive call
            int newIndex = i+1;
            int railsArg = railsLocInt + filingList.get(i).getRailsInt();
            int drawersArg = drawersLocInt + filingList.get(i).getDrawersInt();
            int cabinetArg = cabinetLocInt + filingList.get(i).getCabinetInt();
            bestFilingCombination(newIndex, railsArg, drawersArg, cabinetArg, quantity, localList, filingList);

            // Remove the last Lamp from the "localList" - AKA Backtracking
            localList.remove(localList.size() - 1);
        }
    }	
}

