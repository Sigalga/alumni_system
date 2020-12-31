package alumni_system;

import java.util.Scanner;

public class Main {
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		gradTest();
//		alumniTest();
//		courseTest();
//		jobTest();
		guiTest();
		
		in.close();
	}
	
	static void gradTest() {
		AlumniSystem alSys = new AlumniSystem();
		
		Grad lulu = new Grad("Lulu", "Benlulu", alSys);
		System.out.println(lulu.toString());
		
		lulu.setLinkedinPage("linkedin.com/lulu");
		lulu.setStatus(Grad.JobHuntStat.OPEN);
		lulu.addCourse(new Course("Java basics"));
		lulu.addCourse("Java advanced");
		lulu.setPassword("lu12345");
		
		System.out.println(lulu.toString());
		
		Grad lulu2 = new Grad("Lulu", "Benlulu", alSys);
		Grad lala = new Grad("Lala", "Abulala", alSys);
		
		System.out.println(lulu.equals(lulu2));
		System.out.println(lulu.equals(lala));
	}
	
	static void alumniTest() {
		AlumniSystem alSys = new AlumniSystem();
		alSys.registerNewGrad("Tzipi", "Shakshouka");
		alSys.registerNewGrad("Geula", "Knafe");
		alSys.registerNewGrad("Rita", "Pita");
		alSys.registerNewGrad("Bilha", "Mashawsha");
		
		loginUI(alSys);
	}

	static void courseTest() {
		
		Course[] courseList = {
				new Course("Java Basics"),
				new Course("Android"),
				new Course("Basics Python"),
				new Course("Data Analysis"),
				new Course("Python for Programmers"),
				new Course("Web"),
				new Course("React") };
		
		for (int i = 0; i < courseList.length; i++ ) {
			System.out.println(courseList[i].getCourseCode() + " " +
								courseList[i].getCourseName());
		}
	}

	static void jobTest() {
		AlumniSystem alSys = new AlumniSystem();
		
		Course courseJava = new Course("Java Basics");
		Course courseWeb = new Course("Web");
		
		// Zehava took Java
		Grad gradZehava = new Grad("Zehava", "Baklava", alSys);
		gradZehava.addCourse(courseJava);
		gradZehava.setStatus(Grad.JobHuntStat.OPEN);
		gradZehava.viewProfile();
		
		// Debb took Java & Web
		Grad gradDebb = new Grad("Debb", "Sahleb", alSys);
		gradDebb.addCourse(courseJava);
		gradDebb.addCourse(courseWeb);
		gradDebb.setStatus(Grad.JobHuntStat.OPEN);
		gradDebb.viewProfile();
		
		// Both open up for jobs, register and login to system
		alSys.registerNewGrad(gradZehava);
		alSys.registerNewGrad(gradDebb);
		alSys.shecodesLogin(gradZehava);
		alSys.shecodesLogin(gradDebb);
		
		// Javaist and Webist positions are posted in system
		Job jobJavaist = new Job("Junior Java developer");
		jobJavaist.addCourse(courseJava);
		alSys.postJob(jobJavaist);
		
		Job jobWebist = new Job("Java Web developer");
		jobWebist.addCourse(courseJava);
		jobWebist.addCourse(courseWeb);
		alSys.postJob(jobWebist);
		
		// Zehava stops receiving job offers
		gradZehava.setStatus(Grad.JobHuntStat.IDLE);
		
		// Juggler position is posted in system (no requirements)
		Job jobJuggler = new Job("Fire Juggler");
		alSys.postJob(jobJuggler);
		
		// Zehava is only offered Javaist
		gradZehava.viewProfile();
		// Debb is offered Javaist, Webist and Fire Juggler
		gradDebb.viewProfile();
		
	}

	static void guiTest() {
		new AlumniSystemGUI();
//		AlumniSystem alSys = new AlumniSystem();
	}
	
	static void loginUI(AlumniSystem alSys) {
		
		boolean loggedIn;
		String id, password;
		
		do {
			System.out.println("Enter username:");
			id = in.nextLine();
			System.out.println("Enter password: ");
			password = in.nextLine();
			loggedIn = alSys.shecodesLogin(id, password);
			
		} while (!loggedIn);

	}
}

