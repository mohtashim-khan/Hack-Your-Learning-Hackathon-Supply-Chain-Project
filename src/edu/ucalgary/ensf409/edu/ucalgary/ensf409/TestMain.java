package edu.ucalgary.ensf409;
import java.util.*;

public class TestMain {

	public static void main(String[] args) {
		ArrayList<Lamp> lampArr = new ArrayList<Lamp>();
        for(int i = 0; i < lampTwoD.length; i++){
            Lamp createdLamp = new Lamp(lampTwoD[i][0], Integer.parseInt(lampTwoD[i][4]), lampTwoD[i][5], lampTwoD[i][1],
                                        toBinaryVal(lampTwoD[i][2]), toBinaryVal(lampTwoD[i][3]));
            lampArr.add(createdLamp);
            //System.out.println("i = " + i + ", Price is " + createdLamp.getPRICE());
        }

        CalculateCombinations lampCombs = new CalculateCombinations();
        lampCombs.findAllCombinationsLamp(lampArr, 1);
        lampCombs.bestCombination().print();
	
	}

	public static int toBinaryVal(String cYorN){
		int ret = 2;
		if(cYorN.equals("Y")){
			ret = 1;
		}
		else if(cYorN.equals("N")){
			ret = 0;
		}
		return ret;
	}

	private static String [][] lampTwoD = {{"L132",	"Desk",	"Y",	"N",	"18",	"005"},
                                           {"L980",	"Study",	"N",	"Y",	"2",	"004"},
                                           {"L487",	"Swing Arm",	"Y",	"N",	"27",	"002"},
                                           {"L564",	"Desk",	"Y",	"Y",	"20",	"004"},
                                           {"L342",	"Desk",	"N",	"Y",	"2",	"002"},
                                           {"L982",	"Study",	"Y",	"N",	"8",	"002"},
                                           {"L879",	"Swing Arm",	"N",	"Y",	"3",	"005"},
                                           {"L208",	"Desk",	"N",	"Y",	"2",	"005"},
                                           {"L223",	"Study",	"N",	"Y",	"2",	"005"},
                                           {"L928",	"Study",	"Y",	"Y",	"10",	"002"},
                                           {"L013",	"Desk",	"Y",	"N",	"18",	"004"},
                                           {"L053",	"Swing Arm",	"Y",	"N",	"27",	"002"},
                                           {"L112",	"Desk",	"Y",	"N",	"18",	"005"},
                                           {"L649",	"Desk",	"Y",	"N",	"18",	"004"},
                                           {"L096",	"Swing Arm",	"N",	"Y",	"3",	"002"}};
}
