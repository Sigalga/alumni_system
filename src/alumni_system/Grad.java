package alumni_system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Grad implements Serializable{
	
	public enum JobHuntStat {
		IDLE(1),
		OPEN(2),
		HUNTING(3);
		
		private final int statCode;

	    private JobHuntStat(int statCode) {
	        this.statCode = statCode;
	    }
	    
	    public int getStatCode() {
	        return this.statCode;
	    }
	    public int getStat(int statCode) {
	        return this.statCode;
	    }
	}
	
	// members //////////////////////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String password =			new String(generateOtp());
	private String linkedinPage =		new String();
	private JobHuntStat status =		JobHuntStat.IDLE;
	private ArrayList<Course> resume =	new ArrayList<Course>();
	private ArrayList<Job> jobOffers =	new ArrayList<Job>();
	
	// init methods /////////////////////////////////////////////////
	
	/**
	 * Creates an object with auto-generated ID and OTP
	 * @param firstName - grad's first name
	 * @param lastName - grad's last name
	 */
	protected Grad(String firstName, String lastName) {
		this.id = generateId(firstName, lastName);
		
		System.out.println("created:");
		System.out.println(this.id);
		System.out.println(this.password);
	}
	
	/**
	 * Creates an ID string based on grad's name
	 * @param firstName - grad's first name
	 * @param lastName - grad's last name
	 * @return the string: "<firsName>.<lastName>.she-codes"
	 */
	private String generateId(String firstName, String  lastName) {
		String newId = new String(firstName + "." + lastName + ".she-codes");
		return newId;
	}
	
	/**
	 * Generates a random OTP (one time password)
	 * @return an array of 8 randomized alphanumeric chars
	 */
	private char[] generateOtp() {
		char[] otp = new char[8];
		Random rnd = new Random();
		
		for (int i = 0; i < 8; i++ ) {	
			
			int group = rnd.nextInt(3) + 1;
			switch (group) {
				case 1:
					otp[i] = (char)(rnd.nextInt(10) + 48);
					break;
				case 2:
					otp[i] = (char)(rnd.nextInt(10) + 65);
					break;
				case 3:
					otp[i] = (char)(rnd.nextInt(26) + 97);
					break;		
			}
		}
		
		return otp;
	}
	
	// edit/set/get methods /////////////////////////////////////////////////
	
	/**
	 * Adds/removes course to/from Grad's resume
	 */
	protected void addCourse(Course course) {
			resume.add(course);
	}
	protected void addCourse(String courseName) {
		resume.add(new Course(courseName));
	}
	protected void removeCourse(String courseName) {
		
		Course course = findInResume(courseName);
		
		if (null != course) {
			resume.remove(course);
		}
	}
	
	/**
	 * Adds a new Job to Grad's jobOffers
	 * @param job - a job offer object
	 */
	protected void addJob(Job job) {
		jobOffers.add(job);
	}

	protected String getId() {
		return new String(this.id);
	}
	protected String getLinkedinPage() {
//		String path = new String();
//		if (null != this.linkedinPage) {
//			path = this.linkedinPage;
//		}
//		return path;
		
		return new String(this.linkedinPage);
	}
	protected String getStatus() {
		String statusStr = new String();
		statusStr += this.status;
		return statusStr;
	}
	protected ArrayList<Course> getResume() {
		
		 ArrayList<Course> resume = new ArrayList<Course>();
		 resume = this.resume;
		 return resume;
	}
	
	protected void setPassword(String password) {
		this.password = password;
	}
	protected void setLinkedinPage(String path) {
		this.linkedinPage = path;
	}
	protected void setLinkedinPage(char[] path) {
		this.linkedinPage = new String(path);
	}
	protected void setStatus(JobHuntStat status) {
		this.status = status;
	}
	protected void setStatus(int statCode) {
		for (JobHuntStat stat : JobHuntStat.values()) {
			if (statCode == stat.getStatCode()) {
				this.status = stat;
			}
		}
	}
	
	// bool methods ///////////////////////////////////////////////
	
	// PERHAPS TURN INTO EQUALS(OTHERGRAD) OVERLOADING
	/**
	 * Compares another Grad's id with this Grad's id
	 * @param id - a Grad's unique username
	 * @return true if <id> is same as object's
	 */
	protected boolean match(String id) {
		return id.equals(this.id);
	}
	
	/**
	 * Validates password for this Grad
	 * @param password - private password to access Grad data
	 * @return true if <password> is correct
	 */
	protected boolean correctPassword(String password) {
		return password.equals(this.password);
	}
	
	/**
	 * Checks if all courses are in this Grad's resume
	 * @param courses - a container of course objects
	 * @return true if all <courses> items are in resume
	 */
	protected boolean isInResume(ArrayList<Course> courses) {
		return resume.containsAll(courses);
	}
	
	/**
	 * Checks a course name to see if resume contains a course with an equal name
	 * @param courseName = a string to be compared against the name field of a course object
	 * @return true if courseName matches a course in resume, false if not.
	 */
	protected boolean isInResume(String courseName) {
		for (Course course : resume) {
			if (course.equalName(courseName)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Checks a course name to see if resume contains a course with an equal name
	 * @param courseName = a string to be compared against the name field of a course object
	 * @return a reference to the matching Course object, otherwise null
	 */
	protected Course findInResume(String courseName) {
		for (Course course : resume) {
			if (course.equalName(courseName)) {
				return course;
			}
		}
		
		return null;
	}
	
	/**
	 * Checks Grad's availability to receive job offers 
	 * @return true if Grad is to receive job offers
	 */
	public boolean isOpenForJobs() {
		return	JobHuntStat.OPEN == this.status |
				JobHuntStat.HUNTING == this.status;
	}

	// pre-login operations ////////////////////////////////////////
	
	/**
	 * Checks if password is correct for this Grad
	 * @param password - a suggested pass phrase
	 * @return true if <password> is matching this Grad's password
	 */
	protected boolean authentic(String password) {
		
		boolean authentic = correctPassword(password);
		
		if (authentic) {
			System.out.println("Connecting");
		}
		else {
			System.out.println("Wrong password");
		}
		
		return authentic;
	}

	// test methods ////////////////////////////////////////////////
	
	@Override
	public String toString() {
		String str = new String();
		
		str += ("id=" + (null != id ? id : "null"));
		
		str += (",\npassword=" + password);
		
		str += (",\nlinkedinPage=" + linkedinPage); 
		
		str += (",\ncourses=");
		for (int i = 0; i < this.resume.size(); i++) {
			str += (this.resume.get(i)).getCourseName();
			str += ", ";
		}
		
		str += ("\nstatus=" + status);
		
		str += ("\njobOffers=");
		for (int i = 0; i < this.jobOffers.size(); i++) {
			str += ((this.jobOffers.get(i)).getJobName());
			str += ", ";
		}
		
		return str;
	}

	/**
	 * returns true if <other> has the same type and ID as self
	 */
	public boolean equals(Object other) {
		boolean similar = other instanceof Grad;
		if (similar) {
			similar = id.equals(((Grad)other).getId());
		}
		
		return similar;
	}

//	@Override
//	public String toString() {
//		return "Grad [in=" + in + ", alSys=" + alSys + ", chPassGui=" + chPassGui + ", dashboardGui=" + dashboardGui
//				+ ", id=" + id + ", password=" + password + ", linkedinPage=" + linkedinPage + ", status=" + status
//				+ ", resume=" + resume + ", jobOffers=" + jobOffers + "]";
//	}

	

	

}
