package alumni_system;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SharedListSelectionHandler implements ListSelectionListener {
	
	EditResumeGUI editResume;
	JList<String> list;

	SharedListSelectionHandler(EditResumeGUI editResume) {
		this.list = editResume.getCourseNameList();
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
	    if (e.getValueIsAdjusting() == false) {
	        if (list.getSelectedIndex() != -1) {
	        	System.out.println(list.getSelectedValue());
	        	editResume.setSelectedCourseName(list.getSelectedValue());
	        }
	    }
	}

}