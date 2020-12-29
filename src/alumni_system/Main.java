package alumni_system;

import java.util.Scanner;

public class Main {
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		gradTest();
//		alumniTest();
//		courseTest();
		jobTest();
//		guiTest();
		
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
		alSys.registerNewGrad("Tzipi", "Shakshouka");

		Course course1 = new Course("Java Basics");
		Job job1 = new Job("Junior Java developer");
		job1.addCourse(course1);
		
		Job job2 = new Job("Fire Juggler");
		
		alSys.postJob(job1);
		alSys.postJob(job2);
		
		loginUI(alSys);
		
	}

	static void guiTest() {
		new GUI();
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

