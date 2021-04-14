
package edu.ucalgary.ensf409;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class OrderGUI extends JFrame implements ActionListener, MouseListener{

	private String DBURLDef;
    private String usernameDef;
    private String passwordDef;
	
    private String typeDef;
    private String itemDef;
    private String quantityDef;
    private int quantityInt;
    
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
    
    public OrderGUI(){
        super("Create an Order Request");
        setupGUI();
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
    }
    public void setupGUI(){
        
    	//user SQL info
        instructions = new JLabel("Please enter your DBURL, Username, and Password to access the SQL furniture database");
        
        DBURLLabel = new JLabel("DBURL:");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        
       //Order request info
        typeLabel = new JLabel("Type:");
        itemLabel = new JLabel("Item:");
        quantityLabel = new JLabel("Quanity:");
        
        
        //sample test in text boxes
        
        DBURLInput = new JTextField("jdbc:mysql://localhost/inventory", 15);
        usernameInput = new JTextField("Mohtashim", 15);
        passwordInput = new JTextField("assignment9", 15);
        
        typeInput = new JTextField("e.g. mesh,study,task,etc ", 15);    
        itemInput = new JTextField("e.g. chair,desk,lamp, filing ", 15);    
        quantityInput = new JTextField("e.g. 1,2,3 etc ", 15);    
        
        DBURLInput.addMouseListener(this);
        usernameInput.addMouseListener(this);
        passwordInput.addMouseListener(this);
        
        typeInput.addMouseListener(this);
        itemInput.addMouseListener(this);
        quantityInput.addMouseListener(this);
        
        JButton submitInfo = new JButton("Submit Order");
        
        submitInfo.addActionListener(this);
        
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
        itemDef = itemInput.getText();
        typeDef = typeInput.getText();
        quantityDef = quantityInput.getText();
        
       //if(validateInput()){
            String orderToBeFilled = orderProcessing();
            JOptionPane.showMessageDialog(this, orderToBeFilled);
       //}
    }
    
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
    
    public void mouseEntered(MouseEvent event){
        
    }

    public void mouseExited(MouseEvent event){
        
    }

    public void mousePressed(MouseEvent event){
        
    }

    public void mouseReleased(MouseEvent event){
        
    }
    
    //format this function to produce order request (bigstring)
    private String orderProcessing(){
    	
    	UI newOrder = new UI(typeDef, itemDef,quantityDef, DBURLDef, usernameDef, passwordDef);
		
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
    
    //put exceptions heres to to prompt user to enter correct inputs
    // NEED TO FIX
    private boolean validateInput(){
        boolean allInputValid = true;
        
        //DBURL check
        if(DBURLDef.length() > 26){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, DBURLDef + " is an invalid DBURL input.");
        }
        
        //username check
        if(usernameDef.length() > 26){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, usernameDef + " is an invalid username input.");
        }
        
        //password check
        if(passwordDef.length() < 1){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, passwordDef + " is an invalid password input.");
        }
        
        //type check
        if(typeDef.length() < 4){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, typeDef + " is an invalid furniture type input.");
        }
        
        //item check
        if((itemDef.equals("chair") || itemDef.equals("desk") || itemDef.equals("filing") || itemDef.equals("lamp"))){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, itemDef + " is an invalid furniture item input.");
        }
        
        //quantity check
        if(quantityInt<0 || quantityInt>100){
            allInputValid = false;
            JOptionPane.showMessageDialog(this, quantityInt + " is an invalid furniture quantity input.");
        }     
        return allInputValid;  
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            new OrderGUI().setVisible(true);        
        });
    }
        
}

