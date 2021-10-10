package Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class assignment1 {
	Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		assignment1 obj =new assignment1 ();
		obj.home_display();
	}
	
	//these are the main storage in array list 
	static ArrayList<Vaccine> Vaccine_List = new ArrayList<>();
    static ArrayList <Hospital> Hospital_List = new ArrayList<>();
    static ArrayList<Citizen> Citizen_List =new ArrayList<>();
    static ArrayList<Vacine_Slots> Slots=new ArrayList<>();
    
    public void home_display() {
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
				Methods.Add_Vaccine();
			}else if(input==2) {
				Methods.Register_Hospital();
			}else if(input==3) {
				Methods.Register_Citizen();
			}else if(input==4) {
				
			}else if(input==5) {
				
			}else if(input==6) {
				
			}else if(input==7) {
				
			}else if (input == 8) {
				break;
			}
		}
	}
}
	class Vaccine {

	    String Vaccine_Name; int Number_doses; int Doses_Gap;
	    public Vaccine(String Name, int Doses, int Gap) {
	    	Vaccine_Name = Name; Number_doses = Doses; Doses_Gap = Gap;
	    }
	    public static void Show_Vaccine(String Name, int Doses, int Gap) {
	    	System.out.println("Vaccine Name: "+Name+",Number of Doses: "+Doses+",Gap Between Doses: "+Gap);
	    }
	}
	class Hospital{
		String Hospital_Name; int Pincode; String UniqueId;
		public Hospital(String hospital_name,int Pin,String uid) {
			Hospital_Name=hospital_name; Pincode=Pin; UniqueId=uid;
		}
		 public static void Show_Hospital(String hospital, int Pin,int uid) {
		    	System.out.println("Hospital Name: "+hospital+", PinCode: "+Pin+", Unique ID:: "+uid);
	    }	
	}
	class Citizen{
		String Citizen_Name; int Age; String UniqieId;
		public Citizen(String name,int age,String uid) {
			Citizen_Name = name; Age = age; UniqieId =uid; 
		}
		public void Show_Citizen(String name,int age,int uid) {
			System.out.println("Citizen Name: "+name+", Age: "+age+", Unique ID: "+uid);
		}
	}
	class Vacine_Slots{
		int Hospital_ID;int Sltos_no; int Day_no; int Quanatiy; Vaccine Vac;
		public Vacine_Slots(int hospid,int slot,int day,int qty,Vaccine vaxi) {
			Hospital_ID = hospid;Sltos_no=slot; Day_no=day; Quanatiy=qty; Vac=vaxi;
		}
		
		
		
	}
	class Methods{
		
		 public static void Add_Vaccine() {
		    	
		    	Scanner sc = new Scanner(System.in);
		    	System.out.println("Vaccine Name: ");
		    	String Vaccine_Name = sc.next();
		    	System.out.println("Number of Doses: ");
		    	int Number_doses= sc.nextInt();
		    	System.out.println("Gap between Doses: ");
		    	int Doses_Gap = sc.nextInt();
		    	Vaccine Vaccine_Obj = new Vaccine(Vaccine_Name,Number_doses,Doses_Gap);
		    	assignment1.Vaccine_List.add(Vaccine_Obj);
		    	Vaccine.Show_Vaccine(Vaccine_Name,Number_doses,Doses_Gap);
		 }
		 public static void Register_Hospital() {
			 	Scanner sc = new Scanner(System.in);
			 	System.out.println("Hospital Name: ");
			 	String Hospital_Name = sc.next();
			 	System.out.println("PinCode: ");
			 	int Pincode=sc.nextInt();
			 	String c="000000";
			 	int uid=Integer.parseInt(c);
			 	uid++;
			 	String new_id = Integer.toString(uid);
			 	while(new_id.length()!=6) "0".concat(new_id);
			 	
			 	Hospital hospital_obj=new Hospital(Hospital_Name,Pincode,new_id);
			 	assignment1.Hospital_List.add(hospital_obj);
			 	Hospital.Show_Hospital(Hospital_Name, Pincode, uid);
		 }
		 public static void Register_Citizen(){
			 	Scanner sc = new Scanner(System.in);
			 	System.out.println("Citizen Name: ");
			 	String Citizen_Name = sc.next();
			 	System.out.println("Age: ");
			 	int age=sc.nextInt();
			 	System.out.println("Unique ID:");
			 	String uid =sc.next();
			 	if(age<18) {
			 		System.out.println("Only above 18 are allowed");return;
			 		//if not then terminatae this
			 	}
			 	int len_uid=uid.length();
			 	if(len_uid != 12) {
			 		System.out.println("Invalid Unique Id");return;
			 		//if not then terminatae this 
			 	}
			 	//covering the case if citizen is already registered 
			 	int sz=assignment1.Citizen_List.size();
			 	for (int i=0 ;i<sz;i++) {
			 		if (assignment1.Citizen_List.get(i).UniqieId.equals(uid)) {
		                System.out.println("You are already registered.");
		                return;
		            }
		        }
			 	Citizen citizen_obj=new Citizen(Citizen_Name,age,uid);
			 	assignment1.Citizen_List.add(citizen_obj);	 	
		 }
		 public static void Add_slot(){
			 Scanner sc = new Scanner(System.in);
			 System.out.println("Enter Hospital ID: ");
			 int Hospital_ID=sc.nextInt();
			 System.out.println("Enter number of Slots to be added: ");
			 int Slots=sc.nextInt();
			 System.out.println("Enter Day Number: ");
			 int day=sc.nextInt();
			 System.out.println("Enter Quantity: ");
			 int qty=sc.nextInt();
			 System.out.println("Select Vaccine ");
			 int sz=assignment1.Vaccine_List.size();
			 for (int i = 0; i < sz; i++) {
				 	System.out.print(i +" "+assignment1.Vaccine_List.get(i).Vaccine_Name+ " ");
		        }
			 int set=sc.nextInt();
			 Vaccine vax =assignment1.Vaccine_List.get(set); 
			 Vacine_Slots slot_obj=new Vacine_Slots(Hospital_ID,Slots,day,qty,vax);
			 int size=assignment1.Hospital_List.size();
			 for(int i=0;i<size;i++) {
				 if(assignment1.Hospital_List.get(i).UniqueId.equals(Hospital_ID)){
					
		            }

		        }
		    }
		 }
	

	
	
		
	

