package alumni_system;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class EditResumeGUI implements ActionListener {
	
	private Grad grad;
	
	private DefaultListModel<String> courseNameModel =	new DefaultListModel<String>();
	protected JList<String> courseNameList =				new JList<String>(courseNameModel);
	private JScrollPane courseListScroller =			new JScrollPane(getCourseNameList());
	
	private String selectedCourseName = new String();
	private SharedListSelectionHandler selectionListener = new SharedListSelectionHandler(this);
	private ListSelectionModel selectionModel;
	
	private JButton addingButton = 						new JButton("add course");	
	
	public EditResumeGUI() {
		initComponents();
	}

	protected void initComponents() {
		
		getCourseNameList().setBounds(320, 140, 165, 25);
		getCourseNameList().setLayoutOrientation(JList.VERTICAL);
		getCourseNameList().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		getCourseNameList().setVisibleRowCount(2);
		
		courseListScroller.setBounds(320, 140, 165, 50);
		courseListScroller.setPreferredSize(new Dimension(250, 80));
		
		selectionModel = getCourseNameList().getSelectionModel();
		selectionModel.addListSelectionListener(selectionListener);
		
		addingButton.setBounds(490, 140, 120, 25);
		addingButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("EditResumeGUI::actionPerformed");
//		grad.addCourse(courseName);
	}
	
	public void setGrad(Grad grad) {
		this.grad = grad;
	}
	public void setCourseListModel(ArrayList<Course> courseList) {
		
		try {
			for (Course course : courseList) {
				this.courseNameModel.addElement(course.getCourseName());
			}			
		}
		catch (Exception e) {
		}
	}
	public JScrollPane getCourseListScroller() {
		return courseListScroller;
	}
	public JButton getAddingButton() {
		return addingButton;
	}

	public JList<String> getCourseNameList() {
		return courseNameList;
	}
	public void setSelectedCourseName(String courseName) {
		selectedCourseName = courseName;
	}
}
