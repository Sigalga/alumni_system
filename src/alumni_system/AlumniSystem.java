package alumni_system;

import java.util.ArrayList;
import java.util.Scanner;

import alumni_system.Grad.JobHuntStat;

public class AlumniSystem {
	private ArrayList<Grad> registered = new ArrayList<Grad>();
	private ArrayList<Grad> gradList = new ArrayList<Grad>();
	private ArrayList<Course> courseList = new ArrayList<Course>();
	
	AlumniSystem() {
		initCourseList();
	}
	
	private void initCourseList() {
		courseList.add(new Course("Java Basics"));
		courseList.add(new Course("Android"));
		courseList.add(new Course("Basics Python"));
		courseList.add(new Course("Data Analysis"));
		courseList.add(new Course("Python for Programmers"));
		courseList.add(new Course("Web"));
		courseList.add(new Course("React"));
	}
	
	public void registerNewGrad(String firstName, String lastName) {
		
		// make a Grad object
		Grad newGrad = new Grad(firstName, lastName);
		
		// add to list
		registered.add(newGrad);
	}
	
	public boolean shecodesLogin(String id, String password) {
		
		// first login of a registered user
		for (Grad grad : registered ) {	
			if (grad.match(id)) {
				if (authentic(grad, password)) {
					changePassword(grad);
					login(grad);
					return true;
				}
				else {
					return false;
				}
			}
		}
		
		// login of a registered user
		for (Grad grad : gradList ) {	
			if (grad.match(id)) {
				if (authentic(grad, password)) {
					login(grad);
					return true;
				}
			}	
		}
		
		// an unregistered user
		System.out.println("Wrong username");
		return false;
	}
	
	private boolean authentic(Grad grad, String password) {
		
		boolean authentic = grad.correctPassword(password);
		
		if (authentic) {
			System.out.println("Connecting");
		}
		else {
			System.out.println("Wrong password");
		}
		
		return authentic;
	}

	private void login(Grad grad) {
		viewProfile(grad);
		editProfile(grad);
	}
	
	private void viewProfile(Grad grad) {
		System.out.println(grad.toString());
	}
	
	private void editProfile(Grad grad) {
		
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
			changePassword(grad);
			break;
			
		case (2):
			System.out.println("Enter a LinkedIn path:");
			grad.setLinkedinPage(in.nextLine());
			break;
			
		case (3):
			changeStatus(grad);
			break;
		
		case(4):
			changeCourses(grad);
			break;
		}
	}
	
	private void changePassword(Grad grad) {
		
		System.out.println("Please enter a new password");
		Scanner in = new Scanner(System.in);
		grad.setPassword(in.nextLine());
	}

	private void changeStatus(Grad grad) {
		
		System.out.println("Choose a status:");
		for (JobHuntStat stat : JobHuntStat.values()) {
			System.out.println(stat.getStatCode() + " - " + stat);
		}
		
		Scanner in = new Scanner(System.in);
		int statCode = in.nextInt();
		grad.setStatus(statCode);
	}

	private void changeCourses(Grad grad) {
		System.out.println("Choose courses to add by typing their numbers, or '0' to finish:");
		printCourseList();
		
		Course course;
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		while (0 != choice) {
			try {
				course = courseList.get(choice);
				grad.addCourse(course);					
				System.out.println(course.getCourseName() + " added");
			} catch (IndexOutOfBoundsException ex) {
				System.out.println("course code does not exist");
			}
			
			choice = in.nextInt();
		}
	}
	
	private void printCourseList() {
		for (Course course : courseList) {
			System.out.println(course.getCourseCode() + " " +
								course.getCourseName());
		}
	}
	
	////////
	
	private boolean shouldOfferJob(Grad grad, Job job) {
		return true;
	}
	
}