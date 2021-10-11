import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignmentap {

    static ArrayList<Citizen> citizen = new ArrayList<>();
    static ArrayList<Vaccine> vaccine = new ArrayList<>();
    static ArrayList<Hospital> hospital = new ArrayList<>();
    static ArrayList<Create_slot> slots = new ArrayList<>();

    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
            while(true) {
                Display();
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

    public static void Display() {
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
    }}
    class Vaccine{
        static Scanner sc = new Scanner(System.in);

        String Vaccine_Name;
        int Number_doses;
        int Doses_Gap;

        public Vaccine(String Name, int Doses, int Gap) {
            Vaccine_Name = Name;
            Number_doses = Doses;
            Doses_Gap = Gap;
        }
        public void Show_Vaccine() {
            System.out.println(" Vaccine Name: "+Vaccine_Name+" , Number of Doses: "+Number_doses+" , Gap Between Doses: "+Doses_Gap);
        }
        public void Add_Vaccine() {
            int Doses_Gap;
            System.out.println("Vaccine Name: ");
            String Vaccine_Name = sc.next();
            System.out.println("Number of Doses: ");
            int Number_doses= sc.nextInt();
            if(Number_doses == 1) {
                Doses_Gap=0;
            }else{
                System.out.println("Gap between Doses: ");
                Doses_Gap = sc.nextInt();

                Vaccine Vaccine_Obj = new Vaccine(Vaccine_Name,Number_doses,Doses_Gap);
            }

            Show_Vaccine();
        }


    }
    class Hospital{
        static Scanner sc = new Scanner(System.in);

        String Hospital_Name;
        int Pincode;
        String UniqueId;

        public Hospital(String hospital_name,int Pin,String uid) {
            Hospital_Name=hospital_name;
            Pincode=Pin;
            UniqueId=uid;
        }
        public void Show_Hospital() {
            System.out.println(" Hospital Name: "+Hospital_Name+" , PinCode: "+Pincode+" , Unique ID: "+UniqueId);
        }

        public void Register_hospital() {
            System.out.println("Hospital Name: ");
            String Hospital_Name = sc.next();
            System.out.println("PinCode: ");
            int Pincode = sc.nextInt();
            if(Assignmentap.hospital.size()==0) {
                UniqueId = "000000";
            }else{
                UniqueId=convert(Assignmentap.hospital.get(Assignmentap.hospital.size()-1).UniqueId);
            }
            Hospital hospital_obj= new Hospital(Hospital_Name,Pincode,UniqueId);
            Show_Hospital();

        }
        public String convert(String s){
            while(s.length()<6) {
                s = "0" + s;
            }
            return s;
        }

        public void List_Hospital_slots(String s){
            for(int i=0;i<Assignmentap.slots.size();i++){
                if(Assignmentap.slots.get(i).Hospital_ID == s){
                    System.out.println("Day: "+Assignmentap.slots.get(i).Day_no+" Vaccine: "+Assignmentap.slots.get(i).Vaccine_Name+" Qty: "+Assignmentap.slots.get(i).Quanatiy);
                }
            }
        }
    }
    class Citizen {
        static Scanner sc = new Scanner(System.in);

        static String Citizen_Name;
        static int Age;
        static String UniqieId;

        public Citizen(String name, int age, String uid) {
            Citizen_Name = name;
            Age = age;
            UniqieId = uid;
        }

        public static void Show_Citizen() {
            System.out.println(" Citizen Name: " + Citizen_Name + " , Age: " + Age + ", Unique ID: " + UniqieId);
        }

        public static void Register_Citizen() {
            System.out.println("Citizen Name: ");
            String Citizen_Name = sc.next();
            System.out.println("Age: ");
            int age = sc.nextInt();
            System.out.println("Unique ID:");
            String uid = sc.next();
            if (age < 18) {
                System.out.println("Only above 18 are allowed");
                return;
                //if not then terminatae this
            }
            int len_uid = uid.length();
            if (len_uid != 12) {
                System.out.println("Invalid Unique Id");
                return;
                //covering length case
            }
            if(checkRegistered(uid)== false){
                return;
            }
            Citizen citizen_obj=new Citizen(Citizen_Name,age,uid);

            Citizen.Show_Citizen();
        }

        public static boolean checkRegistered(String str){
            for(int i=0;i<Assignmentap.citizen.size();i++){
                if(Assignmentap.citizen.get(i).UniqieId == str){
                    System.out.println("You are already registered");
                    return false;
                }
            }
            return true;
        }
    }



    class Create_slot {
        static Scanner sc = new Scanner(System.in);
        String Hospital_ID;
        int Sltos_no;
        int Day_no;
        int Quanatiy;
        String Vaccine_Name;

        public Create_slot(String hospid, int slot, int day, int qty, String vaccine_name) {
            Hospital_ID = hospid;
            Sltos_no = slot;
            Day_no = day;
            Quanatiy = qty;
            Vaccine_Name = vaccine_name;
        }

        public void Vaccine_available(String Hospital_ID) {
            for (int i = 0; i < Assignmentap.vaccine.size(); i++) {
                System.out.println(i + ". " + Assignmentap.vaccine.get(i));
            }
        }

        public void Show_slot() {
            System.out.println("Slot added by Hospital " + Hospital_ID + "for Day: " + Day_no + ", Available Quantity: " + Quanatiy + "of Vaccine " + Vaccine_Name);
        }

        public void Add_slot() {
            System.out.println("Enter Hospital ID: ");
            String Hospital_ID = sc.next();
            System.out.println("Enter number of Slots to be added: ");
            int Slots = sc.nextInt();
            System.out.println("Enter Day Number: ");
            int day = sc.nextInt();
            System.out.println("Enter Quantity: ");
            int qty = sc.nextInt();
            System.out.println("Select Vaccine ");
            Vaccine_available(Hospital_ID);
            int choose = sc.nextInt();
            Vaccine_Name = Assignmentap.vaccine.get(choose).Vaccine_Name;

            Show_slot();
        }

        class Book_slot {

        }

        class Check_status {

        }
    }


