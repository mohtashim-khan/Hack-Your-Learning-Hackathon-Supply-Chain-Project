/**
 *@author	Group 73 (Mackenzie,Mohtashim, Ritwik, Usman) <a>
 *href="mailto:mohtashim.khan@ucalgary.ca">mohtashim.khan@ucalgary.ca</a>
 *Project Manager: Mohtashim Khan
 *@version 1.0
 *@since 1.0
 *
 *OrderGUI is a basic class that is part of the front-end of our program.
 *This Class produces an interactive window that displays 6 text boxes for the user.
 *The User will be instructed to enter the following information:
 *
 *DBURL
 *Username
 *Password
 *Furniture type
 *Furniture item
 *Furniture quantity
 *
 *There will be a series of basic tests to ensure the user has enter the information correctly.
 *Majority of error statements will be generic and will inform the user that
 *their input is "INVALID ARGUMENTS" or "their ORDER COULD NOT BE PROCESSED"
 *Regardless of the situation, the program will display the output to the user in 3 forms:
 *Text through output window, console, and .txt format
 *
 */

//Package declaration
package edu.ucalgary.ensf409;

//Import Statements
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class OrderGUI extends JFrame implements ActionListener, MouseListener{
	
	//list of all furniture type descriptions from SQL database
		public static String [] itemsList = {"kneeling","task","mesh","executive", 
											"ergonomic","standing", "adjustable",
											"traditional","desk","study","swing arm",
											"small","medium","large"};
	
	// Class variables
	private String DBURLDef;
    private String usernameDef;
    private String passwordDef;
	
    private String typeDef;
    private String itemDef;
    private String quantityDef;
    
    private JLabel instructions;
    private JLabel DBURLLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    
    private JLabel typeLabel;
    private JLabel itemLabel;
    private JLabel quantityLabel;
    
    private JTextField DBURLInput;
    private JTextField usernameInput;
    private JTextField passwordInput;
    
    private JTextField typeInput;
    private JTextField itemInput;
    private JTextField quantityInput;
    
    /**
	 * Constructor for OrderGUI class. This simple constructor that creates the 
	 * interactive window called: Create an Order Request.
	 * Window size is 800 x 600
	 */
    public OrderGUI(){
        super("Create an Order Request");
        setupGUI();
        setSize(750,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
    }
    
    /**
	 * This method "processOrder" sets up the layout of the interactive window.
	 * There will be a total of 6 labels and 6 text boxes from which the user can
	 * enter their DBURL, username, password, furniture type, furniture item,
	 * and quantity. There will also be example text to help guide the user to 
	 * know what type of inputs to type in. If the user wishes to overwrite the example 
	 * text, they just need to perform 1 single mouse click.
	 */
    public void setupGUI(){
        
    	//Instructions header
        instructions = new JLabel("Please enter your DBURL, Username, and Password to access the SQL furniture database");
        
        //User's SQL info
        //Constructs a new TextField initialized with thespecified text and columns.
        //A default model is created.
        DBURLLabel = new JLabel("DBURL:");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        
        //Order request info
        //Constructs a new TextField initialized with thespecified text and columns.
        //A default model is created.
        typeLabel = new JLabel("Type:");
        itemLabel = new JLabel("Item:");
        quantityLabel = new JLabel("Quantity:");
        
        
        //Sample test in text boxes
        //Constructs a new TextField initialized with thespecified text and columns.
        //A default model is created.
        DBURLInput = new JTextField("jdbc:mysql://localhost/inventory", 20);
        usernameInput = new JTextField("Mohtashim", 15);
        passwordInput = new JTextField("assignment9", 15);
        
        typeInput = new JTextField("e.g. mesh,study,task,etc ", 15);    
        itemInput = new JTextField("e.g. chair,desk,lamp, filing ", 15);    
        quantityInput = new JTextField("e.g. 1,2,3 etc ", 15);    
        
        //Adds the specified mouse listener to receive mouse events fromthis component.
        //If listener l is null,no exception is thrown and no action is performed. 
        DBURLInput.addMouseListener(this);
        usernameInput.addMouseListener(this);
        passwordInput.addMouseListener(this);
        
        typeInput.addMouseListener(this);
        itemInput.addMouseListener(this);
        quantityInput.addMouseListener(this);
        
        
        //Creates a button with text.
        //Parameters:text the text of the button.
        JButton submitInfo = new JButton("Submit Order");
        
        //Adds an ActionListener to the button.
        submitInfo.addActionListener(this);
        
        
        //Creates a new JPanel with a double bufferand a flow layout.
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
        
        headerPanel.add(instructions);
        
        clientPanel.add(DBURLLabel);
        clientPanel.add(DBURLInput);
        clientPanel.add(usernameLabel);
        clientPanel.add(usernameInput);
        clientPanel.add(passwordLabel);
        clientPanel.add(passwordInput);
       
        clientPanel.add(typeLabel);
        clientPanel.add(typeInput);      
        clientPanel.add(itemLabel);
        clientPanel.add(itemInput); 
        clientPanel.add(quantityLabel);
        clientPanel.add(quantityInput);

        submitPanel.add(submitInfo);
        
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
    	
    	//stores user input in class variables
    	DBURLDef = DBURLInput.getText();
        usernameDef = usernameInput.getText();
        passwordDef = passwordInput.getText();
        itemDef = itemInput.getText().toLowerCase();
        typeDef = typeInput.getText().toLowerCase();
        quantityDef = quantityInput.getText();
        
        //Begin processing of order request here by making 
        //a call to orderProcessing.
        if(validateInput()){
            String orderToBeFilled = orderProcessing();
            JOptionPane.showMessageDialog(this, orderToBeFilled);
        }
    }
    
    //Invoked when the mouse button has been clicked (pressedand released) on a component.
    public void mouseClicked(MouseEvent event){
        
    	//when user clicks in textbox, example entry goes away
        if(event.getSource().equals(DBURLInput))
            DBURLInput.setText("");

        if(event.getSource().equals(usernameInput))
            usernameInput.setText("");

        if(event.getSource().equals(passwordInput))
            passwordInput.setText("");

        if(event.getSource().equals(typeInput))
            typeInput.setText("");
        
        if(event.getSource().equals(itemInput))
            itemInput.setText("");
        
        if(event.getSource().equals(quantityInput))
            quantityInput.setText("");
                
    }
    
    //Invoked when the mouse enters a component.
    public void mouseEntered(MouseEvent event){
        
    }

    public void mouseExited(MouseEvent event){
        
    }

    public void mousePressed(MouseEvent event){
        
    }

    public void mouseReleased(MouseEvent event){
        
    }
    
    /**
	 * This method "orderProcessing" will create a new UI object called newOrder.
	 * typeDef, itemDef,quantityDef, DBURLDef, usernameDef, passwordDef will be passed 
	 * into newOrder's constructor. 
	 * 
	 * (Simple explanation)
	 * This will begin the 2nd part of the front-end program where the order request will be process. 
	 * newOrder will make the necessary calls to the Database and CalculateCombinations Class. 
	 * Depending on the user's request, the function will find the cheapest combination. 
	 * Whatever items used will be removed from the SQL database and the results of the 
	 * order will be displayed for the user.
	 */
    private String orderProcessing(){
    	
    	UI newOrder = new UI(typeDef, itemDef,quantityDef, DBURLDef, usernameDef, passwordDef);
		
    	//Try catch blocks to detect invalid inputs from user or
    	//if order could not be fulfilled.
    	try
    	{
    		newOrder.processOrder();
    	}catch(DatabaseProcessException e)
    	{
    		return "INVALID ARGUMENTS";
    	}
		newOrder.calculateOrder();
		newOrder.displayOrder();
		try {
			newOrder.deleteUsedIDs();
		}
		catch(DatabaseDeleteException e)
		{
			return "ORDER COULD NOT BE PROCESSED";
			
		}
		return newOrder.formatOrderRequest();

    }    
    
    /**
   	 * This method "validateINput" checks if the user entered the correct inputs.
   	 * 
   	 * (Simple explanation)
   	 * In the event the user does not enter the correct form of inputs,
   	 * an error message will be generated when the submit order button is pressed.
   	 */
    //put exceptions heres to to prompt user to enter correct inputs
    // NEED TO FIX
    private boolean validateInput(){
    	
        boolean allInputValid = true;
        
        //DBURLDef check
        if(DBURLDef.length() < 0||!(DBURLDef.substring(0,11).equals("jdbc:mysql:"))||DBURLDef.contains(" ")){
        	allInputValid = false;
        	JOptionPane.showMessageDialog(this, DBURLDef + " is an invalid DBURL input.");
        }
        
        //usernameDef check
        if(usernameDef.length() < 0||usernameDef.length() > 30){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, usernameDef + " is an invalid username input.");
        }
        
        //passwordDef check
        if(passwordDef.length() < 1){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, passwordDef + " is an invalid password input.");
        }
        
        //typeDef check
        int scanner =0; //if scanner does not change to 1, then we know the type requested by user input does not exist.
        for(int i=0;i<itemsList.length;i++) {
        	 if(typeDef.equals(itemsList[i])){
        		 scanner=1; 		 
        	 }
        }
        
        if(scanner==0){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, typeDef + " is an invalid furniture type input.");
        }
        
        //itemDef check
        if(!(itemDef.equals("chair") || itemDef.equals("desk") || itemDef.equals("filing") || itemDef.equals("lamp"))){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, itemDef + " is an invalid furniture item input.");
        }
        
        // NEED 1 MORE CHECK FOR VALID INT CONVERSION 
        
        if(quantityDef.length()<0||quantityDef.contains(" ")){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, quantityDef + " is an invalid quantity input.");
        }
        
        return allInputValid;  
    }
    
    //Start of program
    public static void main(String[] args) {
    	
    	/**
    	 * EventQueue is a platform-independent class that queues events, both from the underlying 
    	 * peer classes and from trusted application classes. It encapsulates asynchronous event 
    	 * dispatch machinery which extracts events from the queue and dispatches them by calling 
    	 * dispatchEvent(AWTEvent) method on this EventQueue with the event to be dispatched as an argument.
    	 * The particular behavior of this machinery is implementation-dependent. The only requirements 
    	 * are that events which were actually enqueued to this queue (note that events being posted 
    	 * to the EventQueue can be coalesced)are dispatched.
    	 */
        EventQueue.invokeLater(() -> {
            new OrderGUI().setVisible(true);        
        });
    }
        
}

