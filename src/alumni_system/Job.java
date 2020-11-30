package alumni_system;

import java.util.ArrayList;

public class Job {
	private ArrayList<Course> requirements = new ArrayList<Course>();
	
	public void addCourse(String courseName) {
		requirements.add(new Course(courseName));
	}
 
}