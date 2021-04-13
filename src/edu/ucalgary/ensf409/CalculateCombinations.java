/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *CalculateCombinations is a class that finds all combinations and 
 *outputs the cheapest one
 * Ritwik - Backtracking Daddy
 * Usman - the godly legend who understood everything no cap
 */


// The best combination is the cheapest Combination
// The cheapest Combination in the code BELOW represents one combination (not necessarily cheapest)

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
        return bestComb;
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
	 * @param localList 
	 * @param lampList - The array of all Lamps in the current Data Base
	 * 
	 * (For Dummies)
	 * localist is a temp list used to add and remove individual lamps, thus creating a "Potential" comb.
	 * Now if the locallist was a successful comb, it will add those "lamps" from the local list into comb list so that we do not 
	 * loose track of a winner
	 *
	 * Now that we have a winner, we better add it to the daddy list which is allCombinations!
	 * 
	 * (Deeper Explanation)
	 * We perform a backtracking recursive call that checks for potential winner combinations and loops through all possible 
	 * combinations to test that!
	 * 
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
		}

        // This loop is an iteration of recursion 
        for (int i = index; i < lampList.size(); i++){
            // check if the current Lamp is repeated or not
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


	
	
	 
	public void findAllCombinationsChair (ArrayList<Chair> arr, int quantity) {
        Vector<Chair> A = new Vector<>(arr);
        Vector<Chair> local = new Vector<>();

        uniqueCombinationChair(0, 0, 0, 0, 0, quantity, local, A);
    }


	public void uniqueCombinationChair(int l, int sum1, int sum2, int sum3, int sum4, int quantity, Vector<Chair> local, Vector<Chair> A) {
        if (sum1 >= quantity && sum2 >= quantity && sum3 >= quantity && sum4 >= quantity) {
            ArrayList<Furniture> comb = new ArrayList<>();
            for (Chair chair : local) {
                comb.add((Furniture) chair);
            }
            this.result.add(new CheapestCombination(comb));         // adding the newly created Furniture Object to the result data member
            return;
        }

        // add another Chair from A to local to check.
        for (int i = l; i < A.size(); i++){
            // check if the current Chair is repeated or not
            if (i > l && A.get(i) == A.get(i-1)){
                continue; // skip this increment
            }

            // adding the next Chair into local
            local.add(A.get(i));

            // recursive call
            uniqueCombinationChair(i+1, sum1 + A.get(i).getLegs(), sum2 + A.get(i).getArms(),
                    sum3 + A.get(i).getSeat(), sum4 + A.get(i).getCushion(), quantity, local, A);

            // Remove element from the combination
            local.remove(local.size() - 1);
        }
    }


	public void findAllCombinationsDesk (ArrayList<Desk> arr, int quantity) {
        Vector<Desk> A = new Vector<>(arr);
        Vector<Desk> local = new Vector<>();

        uniqueCombinationDesk(0, 0, 0, 0, quantity, local, A);
    }


	public void uniqueCombinationDesk(int l, int sum1, int sum2, int sum3, int quantity, Vector<Desk> local, Vector<Desk> a) {
        if (sum1 >= quantity && sum2 >= quantity && sum3 >= quantity) {
            ArrayList<Furniture> comb = new ArrayList<>();
            for (Desk desk : local) {
                comb.add((Furniture) desk);
            }
            this.result.add(new CheapestCombination(comb));         // adding the newly created Furniture Object to the result data member
            return;
        }

        // add another Desk from A to local to check.
        for (int i = l; i < a.size(); i++){
            // check if the current Desk is repeated or not
            if (i > l && a.get(i) == a.get(i-1)){
                continue; // skip this increment
            }

            // adding the next Desk into local
            local.add(a.get(i));

            // recursive call
            uniqueCombinationDesk(i+1, sum1 + a.get(i).getLegs(), sum2 + a.get(i).getTop(),
                    sum3 + a.get(i).getDrawer(), quantity, local, a);

            // Remove element from the combination
            local.remove(local.size() - 1);
        }
    }


	public void findAllCombinationsFiling (ArrayList<Filing> arr, int quantity) {
        Vector<Filing> A = new Vector<>(arr);
        Vector<Filing> local = new Vector<>();

        uniqueCombinationFiling(0, 0, 0, 0, quantity, local, A);
    }


	public void uniqueCombinationFiling(int l, int sum1, int sum2, int sum3, int quantity, Vector<Filing> local, Vector<Filing> a) {
        if (sum1 >= quantity && sum2 >= quantity && sum3 >= quantity) {
            ArrayList<Furniture> comb = new ArrayList<>();
            for (Filing filing : local) {
                comb.add((Furniture) filing);
            }
            this.result.add(new CheapestCombination(comb));         // adding the newly created Furniture Object to the result data member
            return;
        }

        // add another Desk from A to local to check.
        for (int i = l; i < a.size(); i++){
            // check if the current Desk is repeated or not
            if (i > l && a.get(i) == a.get(i-1)){
                continue; // skip this increment
            }

            // adding the next Desk into local
            local.add(a.get(i));

            // recursive call
            uniqueCombinationFiling(i+1, sum1 + a.get(i).getRails(), sum2 + a.get(i).getDrawers(),
                    sum3 + a.get(i).getCabinet(), quantity, local, a);

            // Remove element from the combination
            local.remove(local.size() - 1);
        }
    }

	//getter
	public ArrayList<CheapestCombination> getAllCombinations() {
        return allCombinations;
    }
	
	// This is a getter for the Cheapest Combination 
	public String [] getBestCombIDs()
	{
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
	
	public int getTotalPrice()
	{
		return this.totalPrice;
		
	}
}

