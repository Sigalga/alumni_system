package alumni_system;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import java.net.URI;

public class DashboardGUI {
	
	private Grad grad;
	
	private AlumniSystemGUI gui =	new AlumniSystemGUI();
	private JLabel titleLabel =		new JLabel("Welcome");
	
	private JLabel idLabel =			new JLabel();
	
	private JLabel linkedinTitleLabel =	new JLabel("linkedin page: ");
	private JLabel linkedinLink =		new JLabel();
	
	private JLabel statusTitleLabel = 	new JLabel("job hunt status: ");
	private JLabel statusLabel =		new JLabel();
	
	private JLabel coursesTitleLabel =			new JLabel("Courses: ");
	private DefaultListModel<Course> resume =	new DefaultListModel<Course>();
	private JList<Course> courseList =			new JList<Course>(resume);
	private JScrollPane courseListScroller =	new JScrollPane(courseList);
	
	private EditLinkedinGUI editLinkedin =	new EditLinkedinGUI();
	private EditStatusGUI editStatus = 		new EditStatusGUI();

	/////////////////////////////////////////////////////////
	
	public DashboardGUI(Grad grad) {
		this.grad = grad;
		
		initComponents();
		addComponents();
	}

	protected void initComponents() {
		
		titleLabel.setBounds(10, 20, 140, 25);
		
		idLabel.setBounds(10, 50, 140, 25);
		
		linkedinTitleLabel.setBounds(10, 80, 140, 25);
		linkedinLink.setBounds(150, 80, 165, 25);
		linkedinLink.setForeground(Color.BLUE.darker());
		linkedinLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		statusTitleLabel.setBounds(10, 110, 140, 25);
		statusLabel.setBounds(150, 110, 165, 25);
		
		coursesTitleLabel.setBounds(10, 140, 140, 25);
		
		try {
			for (Course course : grad.getResume()) {
				resume.addElement(course);
			}			
		}
		catch (Exception e) {
		}
		
		courseList.setLayoutOrientation(JList.VERTICAL);
		courseList.setVisibleRowCount(2);
		courseListScroller.setPreferredSize(new Dimension(250, 80));
		
	}
	
	protected void addComponents() {
		
		gui.panel.add(titleLabel);
		
		gui.panel.add(idLabel);
		
		gui.panel.add(linkedinTitleLabel);
		gui.panel.add(linkedinLink);
		
		gui.panel.add(statusTitleLabel);
		gui.panel.add(statusLabel);
		
		gui.panel.add(coursesTitleLabel);
		gui.panel.add(courseList);
		gui.panel.add(courseListScroller);
		
		gui.panel.add(editLinkedin.getLinkedinField());
		gui.panel.add(editLinkedin.getEditButton());
		
		gui.panel.add(editStatus.getIdleOption());
		gui.panel.add(editStatus.getOpenOption());
		gui.panel.add(editStatus.getHuntingOption());
	}
	
	public void start() {

		idLabel.setText(grad.getId());
		startLinkedinLink();
		statusLabel.setText(grad.getStatus());
		editLinkedin.setGrad(grad);
		editStatus.setGrad(grad);
		
		gui.start();
	}
	
	private void startLinkedinLink() {
		
		linkedinLink.setText(grad.getLinkedinPage());
		linkedinLink.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseClicked(MouseEvent e) {
				try {
					URI uri = new URI(grad.getLinkedinPage());
			        Desktop.getDesktop().browse(uri);   
			    }
				catch (IOException | URISyntaxException e1) {
			        e1.printStackTrace();
			    }
		    }
		});
	}
	
	
}