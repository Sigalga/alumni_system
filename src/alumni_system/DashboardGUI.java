package alumni_system;

import javax.swing.JLabel;

public class DashboardGUI {
	
	private AlumniSystemGUI gui =	new AlumniSystemGUI();
	private JLabel titleLabel =		new JLabel("Welcome");
	private JLabel profileLabel =	new JLabel();
	private Grad grad;
	
	/////////////////////////////////////////////////////////
	
	public DashboardGUI(Grad grad) {
		this.grad = grad;
		
		initComponents();
		addComponents();
	}

	protected void initComponents() {
		
		titleLabel.setBounds(10, 20, 165, 25);
		profileLabel.setBounds(10, 50, 165, 25);
		
	}
	
	protected void addComponents() {
		
		gui.panel.add(titleLabel);
		gui.panel.add(profileLabel);
	}
	
	public void start() {

		profileLabel.setText(grad.getId());
		gui.start();
	}
	
}
