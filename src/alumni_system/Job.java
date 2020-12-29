package alumni_system;

import java.util.ArrayList;

public class Job {
	private String jobName = new String();
	private ArrayList<Course> courseList = new ArrayList<Course>();
	
	public Job(String name) {
		this.jobName = name;
	}
	
	/**
	 * Creates and adds a Course object to the courseRqmnts list
	 * @param courseName - a name for a Course object
	 */
	public void addCourse(String courseName) {
		courseList.add(new Course(courseName));
	}
	
	/**
	 * Adds a Course object to the courseRqmnts list
	 * @param course - a Course object reference
	 */
	public void addCourse(Course course) {
		courseList.add(course);
	}
	
	/**
	 * Gets the course completion requirements for this Job
	 * @return a copy of the courseRqmnts list
	 */
	public ArrayList<Course> getRqmnts() {
		return new ArrayList<Course>(courseList);
	}
	
	public String getJobName() {
		return new String(jobName);
	}
	
	@Override
	public String toString() {
		String str = new String();
		
		str += ("Job Title=" + jobName);
		str += (",\nRequirements=");
		for (int i = 0; i < this.courseList.size(); i++) {
			str += (this.courseList.get(i)).getCourseName();
			str += ", ";
		}
				
		return str;
	}
}