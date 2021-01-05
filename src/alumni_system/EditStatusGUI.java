package alumni_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import alumni_system.Grad.JobHuntStat;

public class EditStatusGUI implements ActionListener {
	
	private Grad grad;
	
	HashMap<String, JobHuntStat> actions = new HashMap<String, JobHuntStat>();
	
	JRadioButton idleOption = new JRadioButton("Idle");
	JRadioButton openOption = new JRadioButton("Open");
	JRadioButton huntingOption = new JRadioButton("Hunting");
	ButtonGroup options = new ButtonGroup();
    
	/////////////////////////////////////////////////////////
	
	public EditStatusGUI(Grad grad) {
		this.grad = grad;
		initComponents();
	}
	public EditStatusGUI() {
		initComponents();
	}
	
	private void initComponents() {
		
		actions.put("Idle", JobHuntStat.IDLE);
		actions.put("Open", JobHuntStat.OPEN);
		actions.put("Hunting", JobHuntStat.HUNTING);
		
		idleOption.setBounds(320, 110, 80, 25);
	    idleOption.setMnemonic(KeyEvent.VK_B);
	    idleOption.addActionListener(this);

	    openOption.setBounds(405, 110, 80, 25);
	    openOption.setMnemonic(KeyEvent.VK_B);
	    openOption.addActionListener(this);
	    
	    huntingOption.setBounds(490, 110, 110, 25);
	    huntingOption.setMnemonic(KeyEvent.VK_B);
	    huntingOption.addActionListener(this);
	    
	    options.add(idleOption);
	    options.add(openOption);
	    options.add(huntingOption);

	}
	
	@Override
	public void actionPerformed(ActionEvent option) {
		
		String command = option.getActionCommand();
		JobHuntStat status = actions.get(command);
		grad.setStatus(status);
		
		System.out.println("EditStatusGUI::actionPerformed: "
				+  grad.getStatus());
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
	}
	public JRadioButton getIdleOption() {
		return idleOption;
	}
	public void setIdleOption(JRadioButton idleOption) {
		this.idleOption = idleOption;
	}
	public JRadioButton getOpenOption() {
		return openOption;
	}
	public void setOpenOption(JRadioButton openOption) {
		this.openOption = openOption;
	}
	public JRadioButton getHuntingOption() {
		return huntingOption;
	}
	public void setHuntingOption(JRadioButton huntingOption) {
		this.huntingOption = huntingOption;
	}
	public ButtonGroup getOptions() {
		return options;
	}
	public void setOptions(ButtonGroup options) {
		this.options = options;
	}
	
	
}
