package alumni_system;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SharedListSelectionHandler implements ListSelectionListener {
	
	EditResumeGUI editResume;
	JList<String> list;
	ListSelectionModel selectionModel;
	String selectedValue = new String();

	SharedListSelectionHandler(EditResumeGUI editResume) {
		this.editResume = editResume;
		this.list = editResume.getCourseNameList();
		this.selectionModel = this.list.getSelectionModel();
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
        if (!selectionModel.isSelectionEmpty() && !e.getValueIsAdjusting()) {
            selectedValue = list.getSelectedValue();
        }
	}
	
	public String getSelectedValue() {
		return selectedValue;
	}

}
