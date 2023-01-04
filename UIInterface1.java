package database1;

import java.sql.SQLException;
import java.util.Scanner;

import database.DatabaseInterface;

public class UIInterface1 {
	public static void start() 
			throws ClassNotFoundException, SQLException {
		
		Scanner scan = new Scanner(System.in);
		
		DatabaseInterface1.DbConnect();
		
		System.out.println("***** Student Management *****");
		while(true) {
			System.out.println("Select the operation to perform:");
			System.out.println("1. Show All Students Information");
			System.out.println("2. Find Student by id");
			System.out.println("3. Add another Student");
			System.out.println("4. Update Student Details");
			System.out.println("5. Remove Student");
			System.out.println("0. Quit");
			System.out.print("Enter Your Choice: ");
			
			int choice = scan.nextInt();
			
			if(choice == 0) {
				System.out.println("\n\n***** THANK YOU ***** \n\n");
				break;
			}
			else {
				int id,rn;
				
				String sname;
				
				String city;
				
				switch(choice) {
				case 1: System.out.println(DatabaseInterface1.getAll());
						break;
				case 2: System.out.print("Provide the ID of the student: ");
						id = scan.nextInt();
						System.out.println(DatabaseInterface1.getById(id));
						break;
				case 3: System.out.print("Enter ID: ");
						id = scan.nextInt();
						
						System.out.print("Enter Student Name: ");
						sname = scan.next();
						
						System.out.print("Enter Roll no.: ");
						rn = scan.nextInt();
						
						System.out.print("Enter City: ");
						city = scan.next();
						
						
						System.out.println(DatabaseInterface1.add(id, sname, rn, city));
						break;
				case 4: System.out.print("Provide the ID of the student to be updated: ");
						id = scan.nextInt();
						System.out.println("Choose the detail to be updated:");
						System.out.println("1. Student Name");
						System.out.println("2. rollno ");
						System.out.println("3. city");
						
						
						System.out.print("Enter Your Choice: ");
						int upChoice = scan.nextInt();
						switch(upChoice) {
							case 1: System.out.print("Enter New Student Name: ");
							sname = scan.next();
							System.out.println(DatabaseInterface1.updateName(id, sname));
							break;
							
									
							case 2: System.out.print("Enter roll no: ");
							rn = scan.nextInt();
							System.out.println(DatabaseInterface1.updateroll(id, rn));
							break;
							
							case 3: System.out.print("Enter city: ");
							city = scan.next();
							System.out.println(DatabaseInterface1.updatecity(id, city));
					break;
							default: System.out.println("\n\n *** WRONG CHOICE *** \n\n");
						}
						break;
				case 5: System.out.print("Provide the ID of the patient to be deleted: ");
						id = scan.nextInt();
						System.out.println(DatabaseInterface1.delete(id));
						break;
				
				default: System.out.println("\n\n *** WRONG CHOICE *** \n\n");
				}
			}			
		}
		DatabaseInterface1.DbDisconnect();
	}
}
