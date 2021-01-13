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

public class EditResumeGUI {

	private Grad grad;
	
	/**
	 * A list model which contains the name fields of Course objects
	 */
	private DefaultListModel<String> courseNameModel =	new DefaultListModel<String>();
	
	/**
	 * A GUI component to display the course names contained in courseNameModel
	 */
	protected JList<String> courseNameList =			new JList<String>(courseNameModel);
	
	/**
	 * A listener to selections made by the GUI user in courseNameList.
	 * Selection may be obtained from the listener using a Getter.
	 */
	private SharedListSelectionHandler selectionListener =	new SharedListSelectionHandler(this);
	
	/**
	 * A Scroller pane to scroll through courseNameList, should be added to main pane
	 */
	private JScrollPane courseListScroller =			new JScrollPane(courseNameList);
	
	/**
	 * 
	 */
	private JButton addingButton = new JButton("add course");
	private JButton removingButton = new JButton("remove course");	
	
	public EditResumeGUI() {
		initComponents();
	}

	protected void initComponents() {
		
		courseNameList.setBounds(320, 140, 165, 25);
		courseNameList.setLayoutOrientation(JList.VERTICAL);
		courseNameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		courseNameList.setVisibleRowCount(2);
		
		ListSelectionModel selectionModel = courseNameList.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectionModel.addListSelectionListener(selectionListener);

		courseListScroller.setBounds(320, 140, 165, 50);
		courseListScroller.setPreferredSize(new Dimension(250, 80));
		
		addingButton.setBounds(490, 140, 120, 25);
		addingButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String selectedCourseName = selectionListener.getSelectedValue();
				System.out.println("EditResumeGUI::addingButton: " + selectedCourseName );
				
				// Selected value must be obtained from the listener and not directly from list
				if (!selectedCourseName.isEmpty() && !grad.isInResume(selectedCourseName)) {	
					grad.addCourse(selectionListener.getSelectedValue());
				}
				System.out.println(grad.toString());
			}
			
		});
		
		removingButton.setBounds(490, 170, 120, 25);
		removingButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String selectedCourseName = selectionListener.getSelectedValue();
				System.out.println("EditResumeGUI::removingButton: " + selectedCourseName );
				
				// Selected value must be obtained from the listener and not directly from list
				if (!selectedCourseName.isEmpty() && grad.isInResume(selectedCourseName)) {	
					grad.removeCourse(selectionListener.getSelectedValue());
				}
				System.out.println(grad.toString());
			}
			
		});
	}
	
	public void start(Grad grad, ArrayList<Course> courseList) {
		setGrad(grad);
		setCourseNameModel(courseList);
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
	public JButton getRemovingButton() {
		return removingButton;
	}
	public JList<String> getCourseNameList() {
		return courseNameList;
	}
}
