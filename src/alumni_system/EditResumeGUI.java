package alumni_system;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class EditResumeGUI implements ActionListener {
	
	private Grad grad;
	
	private DefaultListModel<String> courseNameModel =	new DefaultListModel<String>();
	protected JList<String> courseNameList =			new JList<String>(courseNameModel);
	private JScrollPane courseListScroller =			new JScrollPane(courseNameList);
	
	private SharedListSelectionHandler selectionListener =	new SharedListSelectionHandler(this);
	private ListSelectionModel selectionModel =				courseNameList.getSelectionModel();
	
	private JButton addingButton = new JButton("add course");	
	
	public EditResumeGUI() {
		initComponents();
	}

	protected void initComponents() {
		
		courseNameList.setBounds(320, 140, 165, 25);
		courseNameList.setLayoutOrientation(JList.VERTICAL);
		courseNameList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		courseNameList.setVisibleRowCount(2);
		
		courseListScroller.setBounds(320, 140, 165, 50);
		courseListScroller.setPreferredSize(new Dimension(250, 80));
		
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectionModel.addListSelectionListener(selectionListener);
		
		addingButton.setBounds(490, 140, 120, 25);
		addingButton.addActionListener(this);

	}
	
	public void start(Grad grad, ArrayList<Course> courseList) {
		setGrad(grad);
		setCourseNameModel(courseList);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String selectedCourseName = selectionListener.getSelectedValue();
//		System.out.println("EditResumeGUI::actionPerformed" + selectedCourseName );
		
		if (!selectedCourseName.isEmpty() && !grad.nameInResume(selectedCourseName)) {
			grad.addCourse(selectionListener.getSelectedValue());			
		}
//	    System.out.println(grad.toString());
	}
	
	public void setGrad(Grad grad) {
		this.grad = grad;
	}
	public Grad getGrad() {
		return grad;
	}
	public void setCourseNameModel(ArrayList<Course> courseList) {
		
		try {
			for (Course course : courseList) {
				this.courseNameModel.addElement(course.getCourseName());
			}			
		}
		catch (Exception e) {
			System.out.println("EditResumeGUI::setCourseNameModel");
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
	public ListSelectionModel getListSelectionModel() {
		return selectionModel;
	}
	public void setSelectedCourseName(String courseName) {
		selectedCourseName = courseName;
	}
}
