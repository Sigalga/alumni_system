package alumni_system;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
	private ArrayList<Job> jobOffers = new ArrayList<Job>();
	private AlumniSystem alsys;
	
	// init methods /////////////////////////////////////////////////
	
	/**
	 * Creates an object with auto-generated ID and OTP
	 * @param firstName - grad's first name
	 * @param lastName - grad's last name
	 */
	protected Grad(String firstName, String lastName, AlumniSystem alsys) {
		this.id = generateId(firstName, lastName);
		this.alsys = alsys;
		
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
	
	/**
	 * Adds a new course to Grad's resume
	 */
	protected void addCourse(Course course) {
			resume.add(course);
	}
	protected void addCourse(String courseName) {
		resume.add(new Course(courseName));
	}

	/**
	 * Adds a new Job to Grad's jobOffers
	 * @param job - a job offer object
	 */
	protected void addJob(Job job) {
		jobOffers.add(job);
	}

	/**
	 * Removes a Job from Grad's jobOffers
	 * @param job - a job offer object
	 */
	protected void refuseJob(Job job) {
		jobOffers.remove(job);
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
	 * Gets this Grad's unique username
	 * @return a copy of this Grad's id
	 */
	protected String getId() {
		return new String(this.id);
	}
	
	/**
	 * Checks if all courses are in this Grad's resume
	 * @param courses - a container of course objects
	 * @return true if all <courses> items are in resume
	 */
	protected boolean inResume(ArrayList<Course> courses) {
		return resume.containsAll(courses);
	}
	
	/**
	 * Checks Grad's availability to receive job offers 
	 * @return true if Grad is to receive job offers
	 */
	public boolean openForJobs() {
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
	
	// post-login operations ////////////////////////////////////////
	
	/**
	 * TEMPORARY FUNCTIONALITY - Grad data read/write operations
	 * @param grad
	 */
	public void login() {
		viewProfile();
		editProfile();
	}
	
	/**
	 * Prints a Grad's data to terminal
	 * @param grad - a Grad object reference
	 */
	protected void viewProfile() {
		System.out.println(toString());
	}
	
	/**
	 * Prints a menu of edit options, receives and redirects choice
	 * @param grad - a Grad object reference
	 */
	protected void editProfile() {
		
		// print menu
		System.out.println("select a field to edit:\n" +
				"1 - change password\n" +
				"2 - set LinkedIn page\n" +
				"3 - set job hunting status\n" +
				"4 - add a completed course\n"
				);
		
		// receive menu choice
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		
		// operate according to choice
		switch (choice) {
		case (1):
			changePassword();
			break;
			
		case (2):
			System.out.println("Enter a LinkedIn path:");
			setLinkedinPage(in.nextLine());
			break;
			
		case (3):
			changeStatus();
			break;
		
		case(4):
			changeCourses();
			break;
		}
		
		in.close();
	}
	protected void changePassword() {
		
		System.out.println("Please enter a new password");
		Scanner in = new Scanner(System.in);
		setPassword(in.nextLine());
//		in.close();
	}
	protected void changeStatus() {
		
		System.out.println("Choose a status:");
		for (JobHuntStat stat : JobHuntStat.values()) {
			System.out.println(stat.getStatCode() + " - " + stat);
		}
		
		Scanner in = new Scanner(System.in);
		int statCode = in.nextInt();
		setStatus(statCode);
		in.close();
	}
	protected void changeCourses() {
		
		System.out.println("Choose courses to add by typing their numbers, or '0' to finish:");
		alsys.printCourseList();

		Course course;
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		while (0 != choice) {
			try {
				course = alsys.getCourse(choice);
				addCourse(course);					
				System.out.println(course.getCourseName() + " added");
			} catch (IndexOutOfBoundsException ex) {
				System.out.println("course code does not exist");
			}
			
			choice = in.nextInt();
		}
		
		in.close();
	}

	// test methods /////////////////////////////////////////////////
	
	@Override
	public String toString() {
		String str = new String();
		
		str += ("id=" + id);
		
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
	

}
