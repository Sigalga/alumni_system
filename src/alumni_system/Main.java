package alumni_system;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
//		gradTest();
//		alumniTest();
		courseTest();
	}
	
	static void gradTest() {
		
		Grad lulu = new Grad("Lulu", "Benlulu");
		System.out.println(lulu.toString());
		
		lulu.setLinkedinPage("linkedin.com/lulu");
		lulu.setStatus(Grad.JobHuntStat.OPEN);
		lulu.addCourse(new Course("Java basics"));
		lulu.addCourse("Java advanced");
		lulu.setPassword("lu12345");
		
		System.out.println(lulu.toString());
		
		Grad lulu2 = new Grad("Lulu", "Benlulu");
		Grad lala = new Grad("Lala", "Abulala");
		
		System.out.println(lulu.equals(lulu2));
		System.out.println(lulu.equals(lala));
	}
	
	static void alumniTest() {
		AlumniSystem alSys = new AlumniSystem();
		alSys.registerNewGrad("Tzipi", "Shakshouka");
		alSys.registerNewGrad("Geula", "Knafe");
		alSys.registerNewGrad("Rita", "Pita");
		alSys.registerNewGrad("Bilha", "Mashawsha");
		
		Scanner in = new Scanner(System.in);
		
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
}

