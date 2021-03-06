package alumni_system;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AlumniSystemGUI {
	
	protected JPanel panel = new JPanel();
	protected JFrame frame = new JFrame();

	/////////////////////////////////////////////////////////
	
	public AlumniSystemGUI() {
		initPanel();
		initFrame();
	}

	protected void initPanel() {
		panel.setLayout(null);
	}
	
	protected void initFrame() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setTitle("Alumni System");
		frame.setVisible(false);
		
		frame.add(panel);
	}
	
	protected void start() {
		frame.setVisible(true);
	}
	protected void stop() {
		frame.setVisible(false);
	}

}
