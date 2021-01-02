package alumni_system;

public class EntranceGUI extends AlumniSystemGUI {
	
	protected AlumniSystem alSys = new AlumniSystem();
	
	private LoginGUI login = new LoginGUI(alSys);
	private SignupGUI signup = new SignupGUI(alSys);
	
	/////////////////////////////////////////////////////////
	
	public EntranceGUI() {
		super.initGUI();
		super.start();
	}

	
	@Override
	protected void initPanel() {

		panel.setLayout(null);
		
		login.getTitleLabel();
//		panel.add(login.getTitleLabel());
//		panel.add(login.getUserLabel());
//		panel.add(login.getUserField());
//		panel.add(login.getPasswordLabel());
//		panel.add(login.getPasswordField());
//		panel.add(login.getLoginButton());
//		
//		panel.add(signup.getTitleLabel());
//		panel.add(signup.getFirstNameLabel());
//		panel.add(signup.getFirstNameField());
//		panel.add(signup.getLastNameLabel());
//		panel.add(signup.getLastNameField());
//		panel.add(signup.getSignupButton());
	}

}