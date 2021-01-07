package alumni_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class EditLinkedinGUI implements ActionListener {
	
	private Grad grad;
	
	private JTextField linkedinField = new JTextField();
	private JButton editButton = new JButton("update");	
	
	public EditLinkedinGUI(Grad grad) {
		this.grad = grad;
		initComponents();
	}
	public EditLinkedinGUI() {
		initComponents();
	}
	
	private void initComponents() {
		linkedinField.setBounds(320, 80, 165, 25);
		editButton.setBounds(490, 80, 120, 25);
		editButton.addActionListener(this);
	}
	
	public void start(Grad grad) {
		setGrad(grad);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		grad.setLinkedinPage(linkedinField.getText());
		
		System.out.println("EditProfileGUI::actionPerformed: "
			+ grad.getLinkedinPage());
		
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
	}
	public JTextField getLinkedinField() {
		return linkedinField;
	}
	public JButton getEditButton() {
		return editButton;
	}

}
