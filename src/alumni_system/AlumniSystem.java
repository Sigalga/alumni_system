package alumni_system;

import java.util.ArrayList;

public class AlumniSystem {
	private ArrayList<Course> courseList =		new ArrayList<Course>();
	private ArrayList<Grad> registeredGrads =	new ArrayList<Grad>();
	private ArrayList<Grad> activeGrads =		new ArrayList<Grad>();
	
	AlumniSystem() {
		initCourseList();
	}
	
	/**
	 * Adds default courses to the courseList
	 */
	private void initCourseList() {
		courseList.add(new Course("Java Basics"));
		courseList.add(new Course("Android"));
		courseList.add(new Course("Basics Python"));
		courseList.add(new Course("Data Analysis"));
		courseList.add(new Course("Python for Programmers"));
		courseList.add(new Course("Web"));
		courseList.add(new Course("React"));
	}
	
	// pre-login operations ////////////////////////////////////////
	
	public void registerNewGrad(String firstName, String lastName) {
		
		// make a Grad object
		Grad newGrad = new Grad(firstName, lastName, this);
		
		// add to list
		registeredGrads.add(newGrad);
	}
	protected void registerNewGrad(Grad newGrad) {	
		registeredGrads.add(newGrad);
	}
	
	/**
	 * Gives user an access to a Grad's data based on Grad identification and authentication
	 * @param id - unique Grad username
	 * @param password - secret Grad password
	 * @return true if login is successful
	 */
	public boolean shecodesLogin(String id, String password) {
		
		// first login of a registered user
		for (Grad grad : registeredGrads) {	
			if (grad.match(id)) {
				if (grad.authentic(password)) {
					grad.changePassword();
					return true;
				}
				else {
					return false;
				}
			}
		}
		
		// login of a registered user
		for (Grad grad : activeGrads ) {	
			if (grad.match(id)) {
				if (grad.authentic(password)) {
					grad.showDashboard();
					return true;
				}
			}	
		}
		
		// an unregistered user
		System.out.println("Wrong username");
		return false;
	}
	
	/**
	 * Allows a registered Grad to enlist as an active user after its first login
	 * @param grad - a Grad object which exists in <registered> list
	 */
	protected void activate(Grad grad) {
		System.out.println("first login");
		activeGrads.add(grad);
		registeredGrads.remove(grad);
		
	}
	
	// Course List operations  //////////////////////////////////////
	
	protected Course getCourse(int choice) {
		return new Course(courseList.get(choice));
	}
	
	protected void printCourseList() {
		for (Course course : courseList) {
			System.out.println(course.getCourseCode() + " " +
								course.getCourseName());
		}
	}
	
	// Job operations ///////////////////////////////////////////////
	
	/**
	 * Sends job to all relevant grads
	 * @param job - a Job object
	 */
	public void postJob(Job job) {
		for (Grad grad : activeGrads) {
			if (shouldOfferJob(grad, job)) {
				grad.addJob(job);
			}
		}
	}
	
	/**
	 * Checks if a job can be relevant for a grad
	 * @param grad - a Grad object
	 * @param job - a Job object
	 * @return true if job is relevant to grad
	 */
	private boolean shouldOfferJob(Grad grad, Job job) {
		return	grad.openForJobs() &
				grad.inResume(job.getRqmnts());
	}
}