import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements ActionListener{
	
	private static boolean login = false;
	private static boolean register = false;
	
	private JLabel customer_ID;
	private JLabel pin_number;
	private JLabel incorrect;
	
	private static JTextField customer_ID_Field;
	private static JTextField pin_number_Field;
	
	private JButton loginButton;
	private JButton registerButton;
	private JButton exitButton;	
	
	public LoginPanel(){
		
//		setLayout(new GridLayout(4,2));
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
		
		customer_ID = new JLabel("Customer ID");
		pin_number = new JLabel("PIN Number");	
		incorrect = new JLabel("");

		
		customer_ID_Field = new JTextField(15);
		pin_number_Field = new JTextField(15);

		
		loginButton = new JButton("Login");
		registerButton = new JButton("Register");

		exitButton = new JButton("Exit");
		
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
		exitButton.addActionListener(this);
		

		
		//add the buttons to the panel
		constraints.gridx = 0;
		constraints.gridy = 3;
		add(customer_ID_Field, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		add(customer_ID, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		add(pin_number_Field, constraints);

		constraints.gridx = 1;
		constraints.gridy = 2;
		add(pin_number, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		add(loginButton, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		add(registerButton, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 1;
		add(exitButton, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(incorrect, constraints);

		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		if (buttonPressed.equals(loginButton)){
			System.out.println("LOGGING IN");
			login = true;
		}
		
		else if (buttonPressed.equals(registerButton)){
			System.out.println("REGISTERING NEW CUSTOMER");		
			register = true;
		}
		
		else if (buttonPressed.equals(exitButton)){
			System.exit(0);			
		} 

		
		
	}
	
	public static boolean getLogin(){
		
		return login;
	}
	
	public static void setLoginFalse(){
		
		login = false;
	}
	
	public static boolean getRegister(){
		
		return register;
	}
	
	public static void setRegisterFalse(){
		register = false;
	}
	
	public static String getID(){
		return customer_ID_Field.getText();
	}

	public static String getPIN(){
		return pin_number_Field.getText();
	}
	
	public void setIncorrect(){
		incorrect.setText("INCORRECT ID OR PASSWORD");
	}
	
	public void setAccountNumber(String ID){
		incorrect.setText("**CUSTOMER CREATED**\n CUSTOMER NUMBER: " + ID);
	}
	
	public void setClear(){
		incorrect.setText("");
		customer_ID_Field.setText("");
		pin_number_Field.setText("");
	}

	

}