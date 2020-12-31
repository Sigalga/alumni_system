package alumni_system;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AlumniSystemGUI {
	
	private AlumniSystem alSys = new AlumniSystem();

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();

	private LoginGUI login = new LoginGUI(alSys);
	private SignupGUI signup = new SignupGUI(alSys);
	
	/////////////////////////////////////////////////////////
	
	public AlumniSystemGUI() {
		initGUI();
	}
	
	private void initGUI() {
		initPanel();
		initFrame();
	}
	
	private void initPanel() {

		panel.setLayout(null);
		
		panel.add(login.getTitleLabel());
		panel.add(login.getUserLabel());
		panel.add(login.getUserField());
		panel.add(login.getPasswordLabel());
		panel.add(login.getPasswordField());
		panel.add(login.getLoginButton());
		
		panel.add(signup.getTitleLabel());
		panel.add(signup.getFirstNameLabel());
		panel.add(signup.getFirstNameField());
		panel.add(signup.getLastNameLabel());
		panel.add(signup.getLastNameField());
		panel.add(signup.getSignupButton());
	}
	
	private void initFrame() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setTitle("Alumni System");
		frame.setVisible(true);
		
		frame.add(panel);
	}

}

