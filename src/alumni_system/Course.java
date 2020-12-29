package alumni_system;

public class Course {

	private static int instanceCounter = 0;
	private int courseCode = 0;
	private String courseName;
	
	public Course(String courseName) {
		this.courseName = courseName;
		
		instanceCounter++;
		courseCode = instanceCounter;
	}
	
	public Course(Course other) {
		this.courseName = other.getCourseName();
		this.courseCode = other.getCourseCode();
	}
	
	/**
	 * @return a numeric unique course code
	 */
	public int getCourseCode() {
		return courseCode;
	}
	
	/**
	 * @return a copy of the course name
	 */
	public String getCourseName() {
		return new String(courseName);
	}
	
	public boolean equals(Course other) {
		return this.courseCode == other.getCourseCode();
	}

}