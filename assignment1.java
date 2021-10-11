import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignmentap {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Citizen> citizen = new ArrayList<>();
    static ArrayList<Vaccine> vaccine = new ArrayList<>();
    static ArrayList<Hospital> hospital = new ArrayList<>();
    static ArrayList<Add_Slot> slots = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            Display();
            int input = sc.nextInt();

            if (input == 1) {
                Add_Vaccine();
            } else if (input == 2) {
                Register_hospital();
            } else if (input == 3) {
                Register_Citizen();
            } else if (input == 4) {
                add_slot();
            } else if (input == 5) {
                book_slot();
            } else if (input == 6) {
                System.out.println("Enter hospital Id: ");
                String s = sc.next();
                checkVaccine(s);
            } else if (input == 7) {
                System.out.println("Hello World");
            } else if (input == 8) {
                break;
            }

        }
    }
    public static void checkvac(String hospital_id){
        for(int i=0;i<Assignmentap.hospital.size();i++){
            if(Assignmentap.hospital.get(i).uniqueId.equals(hospital_id)){
                System.out.println("Day :");
            }
        }
    }
    public static void checkVaccine(String ID){
        for(Add_Slot a: Assignmentap.slots){
            if(a.hospId.equals(ID)){
                System.out.println("Day: " + a.day_no + " Vaccine: " + a.vaccine_name + " Available" + "Qty: " +  a.Quantity);
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
    }

    public static void Register_hospital() {
        String uniqueId;
        System.out.println("Hospital Name: ");
        String Hospital_Name = sc.next();
        System.out.println("PinCode: ");
        int Pincode = sc.nextInt();
        if(Hospital.ifRegistered(Hospital_Name, Pincode)){
            System.out.println("Already Registered");
            return;
        }

        if (Assignmentap.hospital.size() == 0) {
            uniqueId = "000000";
        } else {
            uniqueId = convert(Assignmentap.hospital.get(Assignmentap.hospital.size() - 1).uniqueId);
        }
        Hospital hospital_obj = new Hospital(Hospital_Name, Pincode, uniqueId);
        hospital.add(hospital_obj);
        hospital_obj.Show_Hospital();
    }

    public static String convert(String s) {
        int n = Integer.parseInt(s);
        n++;
        String temp = Integer.toString(n);
        while (temp.length() < 6) {
            temp = "0" + temp;
        }
        return temp;
    }

    public static void Add_Vaccine() {
        int Doses_Gap;
        System.out.println("Vaccine Name: ");
        String Vaccine_Name = sc.next();
        System.out.println("Number of Doses: ");
        int Number_doses = sc.nextInt();
        if (Number_doses == 1) {
            Doses_Gap = 0;
        } else {
            System.out.println("Gap between Doses: ");
            Doses_Gap = sc.nextInt();
        }
        Vaccine Vaccine_Obj = new Vaccine(Vaccine_Name, Number_doses, Doses_Gap);
        vaccine.add(Vaccine_Obj);

        Vaccine_Obj.Show_Vaccine();
    }

    public static void Register_Citizen() {
        System.out.println("Citizen Name: ");
        String Citizen_Name = sc.next();
        System.out.println("Age: ");
        int age = sc.nextInt();
        System.out.println("unique ID:");
        String uid = sc.next();
        if (age < 18) {
            System.out.println("Only above 18 are allowed");
            return;
            // if not then terminatae this
        }
        int len_uid = uid.length();
        if (len_uid != 12) {
            System.out.println("Invalid unique Id");
            return;
            // covering length case
        }
        if (!checkRegistered(uid)) {
            return;
        }
        Citizen citizen_obj = new Citizen(Citizen_Name, age, uid);
        citizen.add(citizen_obj);

//        Citizen.Show_Citizen();
    }

    public static boolean checkRegistered(String str) {
        for (int i = 0; i < Assignmentap.citizen.size(); i++) {
            if (Assignmentap.citizen.get(i).uniqueId.equals(str)) {
                System.out.println("You are already registered");
                return false;
            }
        }
        return true;
    }
    // public static void Add_slot() {
    // System.out.println("Enter Hospital ID: ");
    // String Hospital_ID = sc.next();
    //
    // System.out.println("Enter number of Slots to be added: ");
    // int Slots = sc.nextInt();
    //
    // System.out.println("Enter Day Number: ");
    // int day = sc.nextInt();
    //
    // System.out.println("Enter Quantity: ");
    // int qty = sc.nextInt();
    //
    // System.out.println("Select Vaccine ");
    // Vaccine_available(Hospital_ID);
    //
    // int choose = sc.nextInt();
    //
    // add_slot slot_obj=new add_slot(Hospital_ID,
    // Slots,day,qty,vaccine_name);vaccine_name
    // }

    // public void decrease_QTY() {
    // if (this.Quanatiy > 0) {
    // this.Quanatiy--;
    // }

//    public static void Vaccine_available(String Hospital_ID) {
//        for (int i = 0; i < Assignmentap.vaccine.size(); i++) {
//            System.out.println(i + ". " + Assignmentap.vaccine.get(i));
//        }
//    }

    public static void add_slot() {
        String vaccine_name;
        String hospId;
        int slot_no;
        int day_no;
        int quantity;
        String hosp_name = "";

        System.out.println("Enter hospital Id: ");
        hospId = sc.next();

        System.out.println("Enter number of slots to add: ");
        slot_no = sc.nextInt();

        for (int i=0; i<slot_no; i++){
            System.out.println("Enter day number: ");
            day_no = sc.nextInt();

            System.out.println("Enter Quantity; ");
            quantity = sc.nextInt();

            System.out.println("select vaccine: ");
            int c = 0;
            for (Vaccine v : Assignmentap.vaccine) {
                System.out.println(c + ". " + Assignmentap.vaccine.get(c).Vaccine_Name);
                c++;
            }

            int choice = sc.nextInt();
            vaccine_name = Assignmentap.vaccine.get(choice).Vaccine_Name;

            for (Hospital h : Assignmentap.hospital) {
                if (h.uniqueId.equals(hospId))
                    hosp_name = h.Hospital_Name;
            }
            Add_Slot a = new Add_Slot(vaccine_name, hospId, slot_no, day_no, hosp_name, quantity);
            Assignmentap.slots.add(a);
        }

    }


    public static void book_slot() {
        System.out.println("Enter patient unique ID: ");
        String unique_ID = sc.next();

        System.out.println("1. Search by area");
        System.out.println("2. Search by Vaccine");
        System.out.println("3. Exit");
        System.out.println("Enter option: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Enter pincode: ");
            int Pin_code = sc.nextInt();
            Book_slot.findpin(Pin_code);
            for(Hospital h: Assignmentap.hospital) {
                if(h.Pincode==Pin_code) System.out.println(h.uniqueId + " " + h.Hospital_Name);
            }
        }
        else if (choice==2) {
            String s = sc.next();
            Book_slot.findname(s);

            for(Add_Slot a: Assignmentap.slots) {
                if(a.hosp_name.equals(s)) System.out.println(a.hospId + " " + a.hosp_name);
            }
        }
        else return;

        System.out.println("Enter hospital id: ");
        String hospital_ID = sc.next();

        ArrayList<String[]> arr = new ArrayList<>();
        int k=0;
        for(Add_Slot a : Assignmentap.slots){
            if(a.hospId.equals(hospital_ID)) {
//                String s = a.slot_no + "->" + "Day: " + a.day_no+ " Available" + " Qty:" + a.Quantity + " Vaccine:" + a.vaccine_name;
                System.out.println(k + "->" + "Day: " + a.day_no + " Available" + " Qty:" + a.Quantity + " Vaccine:" + a.vaccine_name);
                String[] str = new String[3];
                str[0] = Integer.toString(a.slot_no); str[1] = Integer.toString(a.day_no); str[2] = a.vaccine_name;
                k++;
            }
        }
        System.out.println("Choose slot: ");
        int slot_num = sc.nextInt();

        if(slot_num>=arr.size() && slot_num<0) return;

        String s = Book_slot.search_by_name(unique_ID);
        System.out.println(s + " is vaccinated with " + arr.get(slot_num)[2]);

    }

}

class Vaccine {
    static Scanner sc = new Scanner(System.in);

    String Vaccine_Name;
    int Number_doses;
    int Doses_Gap;

    public Vaccine(String Name, int Doses, int Gap) {
        this.Vaccine_Name = Name;
        this.Number_doses = Doses;
        this.Doses_Gap = Gap;
    }

    public void Show_Vaccine() {
        System.out.println(" Vaccine Name: " + Vaccine_Name + " , Number of Doses: " + Number_doses
                + " , Gap Between Doses: " + Doses_Gap);
    }

    public boolean ifAdded(String s, int doses, int gap) {
        boolean result = false;
        for (Vaccine val : Assignmentap.vaccine) {
            if (val.Vaccine_Name.equals(s) && val.Number_doses == doses && val.Doses_Gap == gap) {
                result = true;
                break;
            }
        }
        return result;
    }
}

class Hospital {
    static Scanner sc = new Scanner(System.in);
    String Hospital_Name;
    int Pincode;
    String uniqueId;

    public Hospital(String hospital_name, int Pin, String uid) {
        Hospital_Name = hospital_name;
        Pincode = Pin;
        uniqueId = uid;
    }

    public void Show_Hospital() {
        System.out.println(" Hospital Name: " + Hospital_Name + " , PinCode: " + Pincode + " , unique ID: " + uniqueId);
    }

    public static boolean ifRegistered(String name, int pin) {
        for (int i = 0; i < Assignmentap.hospital.size(); i++) {
            if (Assignmentap.hospital.get(i).Hospital_Name.equals(name) && Assignmentap.hospital.get(i).Pincode == pin) {
                return true;
            }
        }
        return false;
    }

}

class Citizen {
    static Scanner sc = new Scanner(System.in);

    String Citizen_Name;
    int Age;
    String uniqueId;
    int status;

    public Citizen(String name, int age, String uid) {
        Citizen_Name = name;
        Age = age;
        uniqueId = uid;
        status = 0;

        System.out.print("Citizen Name: "+ name + ", Age:" + age + ", Unique Id: " + uid);
    }


    public static int[] getVaccineDetailsByName(String name) {
        int[] arr = new int[2];
        for (int i = 0; i < Assignmentap.vaccine.size(); i++) {
            if (Assignmentap.vaccine.get(i).Vaccine_Name.equals(name)) {
                arr[0] = Assignmentap.vaccine.get(i).Number_doses;
                arr[1] = Assignmentap.vaccine.get(i).Doses_Gap;
            }
        }
        return new int[2];
    }
    // public static void checkStatus(String Id){
    // for(int i=0; i<Citizen__.citizen.size(); i++){
    // if(Citizen__.citizen.get(i).ID.equals(Id)){
    // int[] arr =
    // Vaccine_.getVaccineDetails(Citizen_.citizen.get(i).vaccineNamePersonGet);
    // if(Citizen__.citizen.get(i).status==0) System.out.println("Citizen
    // REGISTERED");
    // else if(Citizen__.citizen.get(i).status<arr[1]){
    // System.out.println("PARTIALLY VACCINATED");
    // System.out.println("Vaccine Given: " +
    // Citizen__.citizen.get(i).vaccineNamePersonGet);
    // System.out.println("Number of Doses given: " +
    // Citizen__.citizen.get(i).status);
    // System.out.println("Next Dose due date: " +
    // arr[0]+Citizen__.citizen.get(i).dateOnWhichPersonGetVaccine);
    // }
    // else if(Citizen__.citizen.get(i).status==arr[1]) System.out.println("FULL
    // VACCINATED");
    // }
    // }
    // }

}

class Add_Slot {
    String vaccine_name;
    String hospId;
    int slot_no;
    int day_no;
    int Quantity;
    String hosp_name;

    public Add_Slot(String vaccine_name, String hospId, int slot_no, int day_no, String hosp_name, int Quantity) {
        this.day_no = day_no;
        this.vaccine_name = vaccine_name;
        this.hospId = hospId;
        this.slot_no = slot_no;
        this.hosp_name = hosp_name;
        this.Quantity = Quantity;


        System.out.println("Slots added by hospital " + hospId + " for Day " + day_no + ", Available Quantity: " + Quantity + " of Vaccine " + vaccine_name);
    }

}

//class add_slot {
//    static Scanner sc = new Scanner(System.in);
//    String Hospital_ID;
//    int Sltos_no;
//    int Day_no;
//    int Quanatiy;
//    String Vaccine_Name;
//    int gap;
//
//    public add_slot(String hospid, int slot, int day, int qty, String vaccine_name) {
//        Hospital_ID = hospid;
//        Sltos_no = slot;
//        Day_no = day;
//        Quanatiy = qty;
//        Vaccine_Name = vaccine_name;
//    }

//    public void Show_slot() {
//        System.out.println("Slot added by Hospital " + Hospital_ID + "for Day: " + Day_no + ", Available Quantity: "
//                + Quanatiy + "of Vaccine " + Vaccine_Name);
//    }
//}

class Book_slot {
    Scanner sc = new Scanner(System.in);

    String uniqueId; int search;

    public static String search_by_name(String s){
        for(Citizen c: Assignmentap.citizen){
            if(c.uniqueId.equals(s)) return c.Citizen_Name;
        }
        return "";
    }

    public static void findpin(int Pin_code){
        //System.out.print("Enter pincode: ");
        for (int i = 0; i < Assignmentap.hospital.size(); i++) {
            if (Assignmentap.hospital.get(i).Pincode == Pin_code) {
                System.out.println(Assignmentap.hospital.get(i).uniqueId + " " + Assignmentap.hospital.get(i).Hospital_Name);
            }
        }
    }

    public static void findname(String s){
        System.out.println("Enter vaccine name: ");
        for(int i=0; i<Assignmentap.slots.size(); i++){
            if(Assignmentap.slots.get(i).hosp_name.equals(s)) System.out.println(Assignmentap.slots.get(i).hospId + " " + Assignmentap.slots.get(i).hosp_name);
        }
    }
}
