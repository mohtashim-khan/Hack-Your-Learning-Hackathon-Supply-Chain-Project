# University Of Calgary Supply Chain Managment Java Application!


## Instructions for running and using our program:

Step 1:

Run the OrderGUI.java class and that will launch the GUI.

Step 2:

Enter the details into the GUI.

Step 3:

You will see the output order on your screen, and an order form .txt will also be generated.

## How the program is structured:

**The program has been divided into 3 key parts:**


### 1. Front-End:


> `OrderGUI.java` is the file that contains the code for the GUI that users see when they run the program!


### 2. Cheapest Combination Algorithm:

**CheapestCombination.java**

> Represents a single combination class that is then implemented by the main `CalculateCombinations.java` program 
> to populate winning combinations.


**CalculateCombinations.java**

>`ArrayList<CheapestCombination> allCombinations` stores all combinations that satisfy the order item and quantity.
>However, this list then gets passed into `method bestCombination()` to return a single best combination!
>
>To actually find the `ArrayList allCombinations`, we use a recursive search algorithm `method bestLampCombination(){` and a driver `method findLampCombinations(){` that searches for all possible combinations and adds fullfilled combinations to the `ArrayList allCombinations` array!
>


### 3. Back-End:

>
> The `Database.java` class contains all the fetching and updating of the database that is required for the proper 
> functionality of the program.
>
