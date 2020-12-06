package alumni_system;

import java.util.ArrayList;
import java.util.Random;

import alumni_system.Grad.JobHuntStat;

public class Grad {
	
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
	
	private String id;
	private String password = new String(generateOtp());
	private ArrayList<Course> resume = new ArrayList<Course>();
	private String linkedinPage;
	private JobHuntStat status = JobHuntStat.IDLE;
	
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
	
	// edit methods /////////////////////////////////////////////////
	
	// adds a new course to Grad's resume
	protected void addCourse(Course course) {
			resume.add(course);
	}
	protected void addCourse(String courseName) {
		resume.add(new Course(courseName));
	}
	
	// setters
	protected void setPassword(String password) {
		this.password = password;
	}
	protected void setLinkedinPage(String path) {
		this.linkedinPage = path;
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
	
	// getter methods ///////////////////////////////////////////////
	
	// returns true if <id> is same as object's
	protected boolean match(String id) {
		return id.equals(this.id);
	}
	
	/**
	 * @param password - private password to access Grad data
	 * @return true if <password> is correct
	 */
	protected boolean correctPassword(String password) {
		return password.equals(this.password);
	}
	
	// returns a copy of the object's ID
	protected String getId() {
		return new String(this.id);
	}
	
	// returns true if all <courses> items are in resume
	protected boolean inResume(ArrayList<Course> courses) {
		return resume.containsAll(courses);
	}
	
	// returns true if Grad is to receive job offers
	protected boolean openForJobs() {
		return	JobHuntStat.OPEN == this.status |
				JobHuntStat.HUNTING == this.status;
	}
	
	// test methods /////////////////////////////////////////////////
	
	@Override
	public String toString() {
		String str = new String("id=" + id + 
								",\npassword=" + password + 
								",\nlinkedinPage=" + linkedinPage + 
								",\ncourses=");
		for (int i = 0; i < this.resume.size(); i++) {
			str += (this.resume.get(i)).getCourseName();
			str += ", ";
		}
		str += ("\nstatus=" + status);
		
		return str;
	}

	// returns true if <other> has the same type and ID as self
	public boolean equals(Object other) {
		boolean similar = other instanceof Grad;
		if (similar) {
			similar = id.equals(((Grad)other).getId());
		}
		
		return similar;
	}
	
}
