package alumni_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SignupGUI implements ActionListener {
	
	private AlumniSystem alSys;
	
	private JLabel titleLabel =			new JLabel("New user? Sign up:");
	
	private JLabel firstNameLabel = 	new JLabel("first name ");
	private JTextField firstNameField =	new JTextField(15);
	private String firstNameStr =		new String();
	
	private JLabel lastNameLabel = 		new JLabel("last name ");
	private JTextField lastNameField =	new JTextField(15);
	private String lastNameStr =		new String();
	
	private JButton signupButton =		new JButton("Sign up");
	
	/////////////////////////////////////////////////////////
	
	public SignupGUI(AlumniSystem alSys) {
		this.alSys = alSys;
		
		titleLabel.setBounds(290, 20, 165, 25);
		
		firstNameLabel.setBounds(290, 50, 80, 25);
		firstNameField.setBounds(380, 50, 165, 25);
		
		lastNameLabel.setBounds(290, 80, 80, 25);
		lastNameField.setBounds(380, 80, 165, 25);
		
		signupButton.setBounds(290, 110, 255, 25);
		signupButton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		firstNameStr = firstNameField.getText();
		lastNameStr = lastNameField.getText();
		
		System.out.println("gui signup: " + firstNameStr + " " + lastNameStr);
		
		alSys.registerNewGrad(firstNameStr, lastNameStr);
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}
	public JLabel getFirstNameLabel() {
		return firstNameLabel;
	}
	public JTextField getFirstNameField() {
		return firstNameField;
	}
	public String getFirstNameStr() {
		return firstNameStr;
	}
	public JLabel getLastNameLabel() {
		return lastNameLabel;
	}
	public JTextField getLastNameField() {
		return lastNameField;
	}
	public String getLastNameStr() {
		return lastNameStr;
	}
	public JButton getSignupButton() {
		return signupButton;
	}

}

