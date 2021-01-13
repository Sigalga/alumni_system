package alumni_system;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AlumniSystem {
	private ArrayList<Course> courseList =		new ArrayList<Course>();
	private ArrayList<Grad> registeredGrads =	new ArrayList<Grad>();
	private ArrayList<Grad> activeGrads =		new ArrayList<Grad>();
	
	private DashboardGUI dashboardGui =			new DashboardGUI(courseList);
	private ChangePasswordGUI chPassGui =		new ChangePasswordGUI(this);
	
//	//> Arraylist to file serialization
	FileOutputStream fOut;
    ObjectOutputStream oOut;
    FileInputStream fIn;
    ObjectInputStream oIn;
	
	AlumniSystem() {
		initCourseList();
		
		//>
		initFileStream();
	}
	
	//>
	private void initFileStream() {	
		try {
			fOut = new FileOutputStream("registeredGrads.ser");
		    oOut = new ObjectOutputStream(fOut);
		    fIn = new FileInputStream("registeredGrads.ser");
            oIn = new ObjectInputStream(fIn);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch(IOException e) {
			System.out.println("Error initializing stream");
		}
		
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
	
	//>
	/**
	 * Creates a new Grad object with an auto-generated ID and OTP,
	 * and adds it to the system's database 
	 * @param firstName - grad's first name, used for identification
	 * @param lastName - grad's last name, used for identification
	 */
	public void registerNewGrad(String firstName, String lastName) {
		
		System.out.println("\n////////////registerNewGrad::read");
		readListFromFile(registeredGrads);
		
		// make a Grad object
		Grad newGrad = new Grad(firstName, lastName);
		
		// add to list
		registeredGrads.add(newGrad);
		
		//>
		System.out.println("////////////registerNewGrad::write");
		writeListToFile(registeredGrads);
 
	}
	
	//> add to file
	private void writeListToFile(ArrayList<Grad> gradList) {
		try {
			System.out.println("write list: " + gradList.toString());
			oOut.writeObject(gradList);
			oOut.flush();
//			oOut.close();
//			fOut.close();
		}
		catch (IOException e) {
			System.out.println("Error writing object to file");
		}
	}
	
	//> read from file
	@SuppressWarnings("unchecked")
	private void readListFromFile(ArrayList<Grad> gradList) {
		try {
			gradList = (ArrayList<Grad>) oIn.readObject();
			System.out.println("read list: " + gradList.toString());
//			oIn.close();
//			fIn.close();
		}
		catch (IOException e) {
			System.out.println("Error reading object from file");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void registerNewGrad(Grad newGrad) {	
		registeredGrads.add(newGrad);
	}
	
	/**
	 * Identifies a Grad and authentifies the user, then grants them
	 * r/w access for the Grad fields.
	 * @param id - unique Grad username
	 * @param password - secret Grad password
	 * @return true if login is successful
	 */
	public boolean shecodesLogin(String id, String password) {
		readListFromFile(registeredGrads);
		
		// first login of a registered user
		for (Grad grad : registeredGrads) {	
			if (grad.match(id)) {
				if (grad.authentic(password)) {
					chPassGui.start(grad);
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
					showDashboard(grad);
					return true;
				}
			}	
		}
		
		// an unregistered user
		System.out.println("Wrong username");
		return false;
	}
	
	/**
	 * Executes requiered operations for first time login of a registered user
	 * @param grad - a Grad object which exists in <registered> list
	 */
	protected void firstLogin(Grad grad) {
		activate(grad);
		showDashboard(grad);
	}
	
	/**
	 * Enlists a registered Grad as an active user
	 * @param grad - a Grad object which exists in <registered> list
	 */
	private void activate(Grad grad) {
		System.out.println("first login");
		activeGrads.add(grad);
		registeredGrads.remove(grad);
		
	}
	
	/**
	 * Starts the Dashboard GUI to display and modify a <grad>
	 * @param grad - an Grad registered into this AlumniSystem object
	 */
	private void showDashboard(Grad grad) {
		System.out.println("AlumniSystem::showDashboard");
		dashboardGui.start(grad);
	}
	
	// Course List operations  //////////////////////////////////////
	
	protected Course getCourse(int choice) {
		return new Course(courseList.get(choice));
	}
	protected ArrayList<Course> getCourseList() {
		return new ArrayList<Course>(this.courseList);
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
		return	grad.isOpenForJobs() &
				grad.isInResume(job.getRqmnts());
	}
}