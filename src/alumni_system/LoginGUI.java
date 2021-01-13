package alumni_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI implements ActionListener {
	
	private AlumniSystem alSys;
	private EntranceGUI entranceGui;
	
	// GUI Components ///////////////////////////////////////
	
	private JLabel titleLabel =		new JLabel("Enter the system:");
	
	private JLabel userLabel = 		new JLabel("user name ");
	private JTextField userField =	new JTextField(15);
	private String userStr =		new String();
	
	private JLabel passwordLabel =	new JLabel("password ");
	private JPasswordField passwordField =
									new JPasswordField(15);
	private String passwordStr =	new String();	
	
	private JButton loginButton =	new JButton("Login");
	
	/////////////////////////////////////////////////////////
	
	public LoginGUI(AlumniSystem alSys, EntranceGUI entranceGui) {
		this.alSys = alSys;
		this.entranceGui = entranceGui;
		
		initComponents();
	}
	
	private void initComponents() {
		
		titleLabel.setBounds(10, 20, 165, 25);
		
		userLabel.setBounds(10, 50, 80, 25);
		userField.setBounds(100, 50, 165, 25);
		
		passwordLabel.setBounds(10, 80, 80, 25);
		passwordField.setBounds(100, 80, 165, 25);
		
		loginButton.setBounds(10, 110, 255, 25);
		loginButton.addActionListener(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		userStr = userField.getText();
		passwordStr = passwordField.getText();
		
		System.out.println("gui login: " + userStr + " " + passwordStr);
		
		boolean loggedIn = alSys.shecodesLogin(userStr, passwordStr);
		if (loggedIn) {
			entranceGui.stop();			
		}
	}
	
	public JLabel getTitleLabel() {
		return titleLabel;
	}
	public JLabel getUserLabel() {
		return userLabel;
	}
	public JTextField getUserField() {
		return userField;
	}
	public String getUserStr() {
		return userStr;
	}
	public JLabel getPasswordLabel() {
		return passwordLabel;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public String getPasswordStr() {
		return passwordStr;
	}
	public JButton getLoginButton() {
		return loginButton;
	}
}


