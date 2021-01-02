package alumni_system;

import javax.swing.JLabel;

public class DashboardGUI extends AlumniSystemGUI {
	
	private Grad grad;
	private JLabel titleLabel =		new JLabel("Welcome");
	private JLabel profileLabel =	new JLabel();
	
	/////////////////////////////////////////////////////////
	
	public DashboardGUI(Grad grad) {
		this.grad = grad;
		
		super.initGUI();
	}
	
	@Override
	protected void initPanel() {
		
		panel.setLayout(null);
		
		titleLabel.setBounds(10, 20, 165, 25);
		profileLabel.setBounds(10, 50, 165, 25);
		
		profileLabel.setText(grad.getId());
		
		panel.add(titleLabel);
		panel.add(profileLabel);
		
	}
	

	
}
