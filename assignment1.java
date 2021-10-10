package Assignment;

import java.util.Scanner;

public class assignment1 {
	public static void home_display() {
		
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			
			System.out.println("CoWin Portal initialized....");
			System.out.println("---------------------------------");
			System.out.println("1. Add Vaccine");
			System.out.println("2. Register Hospital");
			System.out.println("3. Register Citizen");
			System.out.println("4. Add Slot for Vaccination");
			System.out.println("5. Book Slot for Vaccination");
			System.out.println("6. List all slots for a hospital");
			System.out.println("7. Check Vaccination Status");
			System.out.println("8. Exit");
			System.out.println("---------------------------------");
			int input = sc.nextInt();
			if(input==1) {
				
			}else if(input==2) {
				
			}else if(input==3) {
				
			}else if(input==4) {
				
			}else if(input==5) {
				
			}else if(input==6) {
				
			}else if(input==7) {
				
			}else if (input == 8) {
				break;
			}
		}
	}
		
	
	public static void main(String[] args) {
		
		assignment1 obj =new assignment1 ();
		obj.home_display();
		 
		
	}
}
