
package edu.ucalgary.ensf409;
import java.util.*;
import java.sql.*;

public class CalculateCombinations {
	private ArrayList<CheapestCombination> allCombinations;
	private int totalPrice=0;

	//constructor
	public CalculateCombinations() {
        allCombinations = new ArrayList<>();
    }

    //finds the Cheapest Combinations from allCombinations
	public CheapestCombination bestCombination(){
        if (this.allCombinations.isEmpty()){
            return null;
        }

        CheapestCombination bestComb = null;
        
        for (CheapestCombination current : this.allCombinations){
            if (bestComb == null){
                bestComb = current;
            }
            if(current.totalPrice < bestComb.totalPrice){
                bestComb = current;
            }
        }
        return bestComb;
    }


	public void findLampCombinations(Object[] lampObjectList, int quantity){
        ArrayList<Lamp> lampList = new ArrayList<>();
        for(int i = 0; i < lampObjectList.length; i++){
            lampList.add((Lamp) lampObjectList[i]);                               //this list will contain the the lamp objects
        }
        ArrayList<Lamp> localList = new ArrayList<>();                            //this list will contain all Lamp Combinations
        bestLampCombination(0, 0, 0, quantity, localList, lampList);
    }

	
	public void bestLampCombination(int index, int baseLocInt, int bulbLocInt, int quantity, ArrayList<Lamp> localList, ArrayList<Lamp> lampList){
        if (baseLocInt >= quantity && bulbLocInt >= quantity){                   //if bases and bulbs found are at least the quantity
            ArrayList<Furniture> comb = new ArrayList<>();
            for (Lamp lamp : localList) {
                comb.add((Furniture) lamp);
            }
            this.allCombinations.add(new CheapestCombination(comb));            //adding the newly created Furniture Object to the result data member
            return;
        }

        // add Lamp from lampList to localList to check.
        for (int i = index; i < lampList.size(); i++){
            // check if the current Lamp is repeated or not
            if (i > index && lampList.get(i) == lampList.get(i-1)){
                continue; // skip this increment
            }

            // adding the next Lamp into local
            localList.add(lampList.get(i));

            // recursive call
            int baseArg = baseLocInt + lampList.get(i).getBaseInt();
            int bulbArg = bulbLocInt + lampList.get(i).getBulbInt();
            int newIndex = i+1;
            bestLampCombination(newIndex, baseArg, bulbArg, quantity, localList, lampList);

            // Remove element from the combination
            localList.remove(localList.size() - 1);
        }
    }
	/*
	 * 
	 * public void findAllCombinationsChair (ArrayList<Chair> arr, int quantity) {
	 * Vector<Chair> A = new Vector<>(arr); Vector<Chair> local = new Vector<>();
	 * 
	 * uniqueCombinationChair(0, 0, 0, 0, 0, quantity, local, A); }
	 * 
	 * 
	 * public void uniqueCombinationChair(int l, int sum1, int sum2, int sum3, int
	 * sum4, int quantity, Vector<Chair> local, Vector<Chair> A) { if (sum1 >=
	 * quantity && sum2 >= quantity && sum3 >= quantity && sum4 >= quantity) {
	 * ArrayList<Furniture> comb = new ArrayList<>(); for (Chair chair : local) {
	 * comb.add((Furniture) chair); } this.allCombinations.add(new
	 * CheapestCombination(comb)); // adding the newly created Furniture Object to
	 * the result data member return; }
	 * 
	 * // add another Chair from A to local to check. for (int i = l; i < A.size();
	 * i++){ // check if the current Chair is repeated or not if (i > l && A.get(i)
	 * == A.get(i-1)){ continue; // skip this increment }
	 * 
	 * // adding the next Chair into local local.add(A.get(i));
	 * 
	 * // recursive call uniqueCombinationChair(i+1, sum1 + A.get(i).getLegs(), sum2
	 * + A.get(i).getArms(), sum3 + A.get(i).getSeat(), sum4 +
	 * A.get(i).getCushion(), quantity, local, A);
	 * 
	 * // Remove element from the combination local.remove(local.size() - 1); } }
	 * 
	 * 
	 * public void findAllCombinationsDesk (ArrayList<Desk> arr, int quantity) {
	 * Vector<Desk> A = new Vector<>(arr); Vector<Desk> local = new Vector<>();
	 * 
	 * uniqueCombinationDesk(0, 0, 0, 0, quantity, local, A); }
	 * 
	 * 
	 * public void uniqueCombinationDesk(int l, int sum1, int sum2, int sum3, int
	 * quantity, Vector<Desk> local, Vector<Desk> a) { if (sum1 >= quantity && sum2
	 * >= quantity && sum3 >= quantity) { ArrayList<Furniture> comb = new
	 * ArrayList<>(); for (Desk desk : local) { comb.add((Furniture) desk); }
	 * this.allCombinations.add(new CheapestCombination(comb)); // adding the newly
	 * created Furniture Object to the result data member return; }
	 * 
	 * // add another Desk from A to local to check. for (int i = l; i < a.size();
	 * i++){ // check if the current Desk is repeated or not if (i > l && a.get(i)
	 * == a.get(i-1)){ continue; // skip this increment }
 	 * 
	 * // adding the next Desk into local local.add(a.get(i));
	 * 
	 * // recursive call uniqueCombinationDesk(i+1, sum1 + a.get(i).getLegs(), sum2
	 * + a.get(i).getTop(), sum3 + a.get(i).getDrawer(), quantity, local, a);
	 * 
	 * // Remove element from the combination local.remove(local.size() - 1); } }
	 * 
	 * 
	 * public void findAllCombinationsFiling (ArrayList<Filing> arr, int quantity) {
	 * Vector<Filing> A = new Vector<>(arr); Vector<Filing> local = new Vector<>();
	 * 
	 * uniqueCombinationFiling(0, 0, 0, 0, quantity, local, A); }
	 * 
	 * 
	 * public void uniqueCombinationFiling(int l, int sum1, int sum2, int sum3, int
	 * quantity, Vector<Filing> local, Vector<Filing> a) { if (sum1 >= quantity &&
	 * sum2 >= quantity && sum3 >= quantity) { ArrayList<Furniture> comb = new
	 * ArrayList<>(); for (Filing filing : local) { comb.add((Furniture) filing); }
	 * this.allCombinations.add(new CheapestCombination(comb)); // adding the newly
	 * created Furniture Object to the result data member return; }
	 * 
	 * // add another Desk from A to local to check. for (int i = l; i < a.size();
	 * i++){ // check if the current Desk is repeated or not if (i > l && a.get(i)
	 * == a.get(i-1)){ continue; // skip this increment }
	 * 
	 * // adding the next Desk into local local.add(a.get(i));
	 * 
	 * // recursive call uniqueCombinationFiling(i+1, sum1 + a.get(i).getRails(),
	 * sum2 + a.get(i).getDrawers(), sum3 + a.get(i).getCabinet(), quantity, local,
	 * a);
	 * 
	 * // Remove element from the combination local.remove(local.size() - 1); } }
	 */

	//getter
	public ArrayList<CheapestCombination> getAllCombinations() {
        return allCombinations;
    }
	
	public String [] getusedIDs()
	{
		CheapestCombination bestComb = bestCombination();
		String [] returnStringArray;
		try {
			totalPrice = bestComb.getTotalPrice();
			returnStringArray = bestComb.getIDs();
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

