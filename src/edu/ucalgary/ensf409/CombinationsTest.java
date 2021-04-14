package edu.ucalgary.ensf409;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.*;

public class CombinationsTest {
    @Test
    public void testConstructors(){
        Lamp lamp1 = new Lamp("test1","Study", "Y", "N", "2", "abcd");
        Lamp lamp2 = new Lamp("test2","Study", "N", "Y", "2", "defg");
        ArrayList<Furniture> lampList = new ArrayList<>();
        lampList.add((Furniture)lamp1);
        lampList.add((Furniture)lamp2);
        CheapestCombination actual = new CheapestCombination(lampList);
        System.out.println(actual.furnitureCombination);
        assertEquals(lampList, actual.furnitureCombination);
    }
}
//to compile: javac -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/system-rules-1.19.0.jar src/edu/ucalgary/ensf409/CombinationsTest.java
//to run: java -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/system-rules-1.19.0.jar org.junit.runner.JUnitCore src/edu.ucalgary.ensf409.CombinationsTest