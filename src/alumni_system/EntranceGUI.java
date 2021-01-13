package alumni_system;

public class EntranceGUI {
	
	/**
	 * An AlumniSystem frame and a panel
	 */
	private AlumniSystemGUI gui = new AlumniSystemGUI();
	
	/**
	 * GUI components for login of a registered grad
	 */
	private LoginGUI login;
	
	/**
	 * GUI components for signing up of a new grad
	 */
	private SignupGUI signup;
	
	/////////////////////////////////////////////////////////
	
	public EntranceGUI(AlumniSystem alSys) {
		this.login = new LoginGUI(alSys, this);
		this.signup = new SignupGUI(alSys);
		
		addComponents();
	}

	protected void addComponents() {
		
		// TO DO: use polymorphism do add from a
		// list of components using a loop
		
		gui.panel.add(login.getTitleLabel());
		gui.panel.add(login.getUserLabel());
		gui.panel.add(login.getUserField());
		gui.panel.add(login.getPasswordLabel());
		gui.panel.add(login.getPasswordField());
		gui.panel.add(login.getLoginButton());
		
		gui.panel.add(signup.getTitleLabel());
		gui.panel.add(signup.getFirstNameLabel());
		gui.panel.add(signup.getFirstNameField());
		gui.panel.add(signup.getLastNameLabel());
		gui.panel.add(signup.getLastNameField());
		gui.panel.add(signup.getSignupButton());
	}
	
	public void start() {
		gui.start();
	}
	public void stop() {
		gui.stop();
	}

}