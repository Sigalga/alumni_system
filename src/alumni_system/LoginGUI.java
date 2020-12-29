package alumni_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI implements ActionListener {

	private JLabel userLabel = 				new JLabel("user name ");
	private JTextField userField =			new JTextField(20);
	private String userStr =				new String();
	
	private JLabel passwordLabel =			new JLabel("password ");
	private JPasswordField passwordField =	new JPasswordField(20);
	private String passwordStr =			new String();	
	
	LoginGUI() {
		
		userLabel.setBounds(10, 50, 80, 25);
		userField.setBounds(100, 50, 165, 25);
		
		passwordLabel.setBounds(10, 80, 80, 25);
		passwordField.setBounds(100, 80, 165, 25);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		userStr = userField.getText();
		passwordStr = passwordField.getText();
		
		System.out.println(userStr);
		System.out.println(passwordStr);
		
	}
	
	public JLabel getUserLabel() {
		return userLabel;
	}
	
	public JLabel getPasswordLabel() {
		return passwordLabel;
	}
	
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getUserField() {
		return userField;
	}
	
	public String getUserStr() {
		return userStr;
	}
	
	public String getPasswordStr() {
		return passwordStr;
	}
	
}


