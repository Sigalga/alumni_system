package alumni_system;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	
	private JLabel titleLabel = new JLabel("Choose What to do");
	
	private JButton signupButton = new JButton("Sign up");
	private JButton loginButton = new JButton("Login");
	
	private LoginGUI login = new LoginGUI();
	private SignupGUI signup = new SignupGUI();
	
	public GUI() {
		initGUI();
	}
	
	private void initGUI() {
		
		titleLabel.setBounds(50, 20, 165, 25);
	
		loginButton.setBounds(10, 110, 80, 25);
		loginButton.addActionListener(login);
		
		signupButton.setBounds(10, 140, 80, 25);
		signupButton.addActionListener(signup);
		
		initPanel();
		initFrame();
	}
	
	private void initPanel() {

		panel.setLayout(null);
		
		panel.add(titleLabel);
		panel.add(login.getUserLabel());
		panel.add(login.getUserField());
		panel.add(login.getPasswordLabel());
		panel.add(login.getPasswordField());
		panel.add(loginButton);
		
		panel.add(signupButton);
	}
	
	private void initFrame() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setTitle("Alumni System");
		frame.setVisible(true); // makes the window visible
		
//		frame.pack(); // makes the window match the size of its components
//		frame.add(panel, BorderLayout.CENTER);
		
		frame.add(panel);
	}

}

