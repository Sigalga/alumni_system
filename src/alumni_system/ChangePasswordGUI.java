package alumni_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ChangePasswordGUI implements ActionListener {
	
	private Grad grad;

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	
	private JLabel passwordLabel =	new JLabel("new password ");
	private JPasswordField passwordField = new JPasswordField(15);
	private JButton loginButton =	new JButton("Change password");
	
	/////////////////////////////////////////////////////////
	
	public ChangePasswordGUI(Grad grad) {
		this.grad = grad;
		initGUI();
	}
	
	protected void initGUI() {
		initPanel();
		initFrame();
	}
	
	protected void initPanel() {
		
		panel.setLayout(null);
		
		passwordLabel.setBounds(10, 20, 140, 25);
		passwordField.setBounds(150, 20, 165, 25);
		loginButton.setBounds(10, 50, 305, 25);
		loginButton.addActionListener(this);
		
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(loginButton);

	}
	
	protected void initFrame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 90);
		frame.setTitle("Change Password");
		frame.setVisible(false);
		
		frame.add(panel);
	}
	
	protected void start() {
		frame.setVisible(true);
	}
	protected void stop() {
		frame.setVisible(false);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		grad.setPassword(passwordField.getText());
		System.out.println("new password was set");
		
		stop();
		grad.firstLogin();
	}
	
}