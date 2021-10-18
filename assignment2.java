 import java.util.ArrayList;
import java.util.Scanner;
public class assignment2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        while(true) {
            WelcomeMenu();
            int welcome = sc.nextInt();
            if(welcome==1){
                choosInstructorID();
                InstructorMenu();
                break;
            }else if(welcome==2){
                chooseStudentID();
                StudentMenu();
                break;
            }else if(welcome==3){
                break;
            }
        }
    }
    public static void WelcomeMenu(){
        System.out.println("Welcome to Backpack\n" +
                "1. Enter as instructor\n" +
                "2. Enter as student\n" +
                "3. Exit");
    }
    public static void choosInstructorID(){
        int count=2;
        Scanner sc= new Scanner(System.in);
        System.out.println("Instructors:");
        for(int i=0;i<count;i++){
            System.out.println(i+" - "+"I"+i);
        }
        System.out.println("Choose id:");
        int choose=sc.nextInt();
        for(int i =0;i<count;i++){
            if(choose==i){
                System.out.println("Welcome "+"I"+i);
            }
        }
    }
    public static void chooseStudentID(){
        int count=3;
        Scanner sc= new Scanner(System.in);
        System.out.println("Students:");
        for(int i=0;i<count;i++){
            System.out.println(i+" - "+"S"+i);
        }
        System.out.println("Choose id:");
        int choose=sc.nextInt();
        for(int i =0;i<count;i++){
            if(choose==i){
                System.out.println("Welcome "+"S"+i);
            }
        }
    }

    public static void InstructorMenu(){
        System.out.println("1. Add class material\n" +
                "2. Add assessments\n" +
                "3. View lecture materials\n" +
                "4. View assessments\n" +
                "5. Grade assessments\n" +
                "6. Close assessment\n" +
                "7. View comments\n" +
                "8. Add comments\n" +
                "9. Logout");
    }
    public static void StudentMenu(){
        System.out.println("1. View lecture materials\n" +
                "2. View assessments\n" +
                "3. Submit assessment\n" +
                "4. View grades\n" +
                "5. View comments\n" +
                "6. Add comments\n" +
                "7. Logout");
    }
}
class Instructor implements similar{
    Scanner sc = new Scanner(System.in);
   // private  static ArrayList<String[]> slides_info=new ArrayList<>();
   //private static ArrayList<String[]> slides_content=new ArrayList<>();
   // private static ArrayList<String[]> video_info=new ArrayList<>();
   private static ArrayList<String[]> quiz_info=new ArrayList<>();
    private static ArrayList<String[]> assignment_info=new ArrayList<>();

    public void add_slide(int Id) {
        String instructorId = "";
        if(Id==0){
            instructorId="I0";
        }else if(Id==1){
            instructorId="I1";
        }
        System.out.println("Enter topic of slides:");
        String topic = sc.next();
        System.out.println("Enter number of slides:");
        int no_of_slides = sc.nextInt();
        System.out.println("Enter content of slides");
        String  content[]=new String[no_of_slides];
        for (int i = 0; i < no_of_slides; i++) {
            System.out.println("Content of slide " + i + ":");
             content[i]= sc.next();
        }
        String date="";
        Study_material S = new Study_material(content,no_of_slides,topic,instructorId,date);
    }
    public void add_video(int Id){
        String instructorId = "";
        if(Id==0){
            instructorId="I0";
        }else if(Id==1){
            instructorId="I1";
        }
        System.out.println("Enter topic of video:");
        String topic=sc.next();
        System.out.println("Enter filename of video:");
        String filename=sc.next();
        int len=filename.length();
        if(filename.substring(len-4, len).equals("mp4")){
            System.out.println("invalid input");
        }
        String date="";
      Study_material V=new Study_material(topic,filename,date,instructorId);
    }
    public void add_assignment(int Id){
        String instructorId = "";
        if(Id==0){
            instructorId="I0";
        }else if(Id==1){
            instructorId="I1";
        }
        System.out.println("Enter problem statement:");
        String problem_statement=sc.next();
        System.out.println("Enter max marks:");
        int max_marks=sc.nextInt();
        String date="";
        String arr[]={instructorId,problem_statement,Integer.toString(max_marks),date};
        assignment_info.add(arr);
    }
    public void add_quiz(int Id){
        String instructorId = "";
        if(Id==0){
            instructorId="I0";
        }else if(Id==1){
            instructorId="I1";
        }
        System.out.println("Enter quiz question:");
        String quiz_ques=sc.next();
        String date="";
        String arr[]={instructorId,quiz_ques,date};
        quiz_info.add(arr);
    }

    @Override
    public void View_Lecture_material() {

    }

    @Override
    public void Add_comments() {

    }

    @Override
    public void View_Assignment() {

    }

    @Override
    public void View_comments() {

    }

    @Override
    public void Logout() {
    }
}
class Student implements similar{
    Scanner sc = new Scanner(System.in) ;

    @Override
    public void View_Lecture_material() {

    }

    @Override
    public void Add_comments() {

    }

    @Override
    public void View_Assignment() {

    }

    @Override
    public void View_comments() {

    }

    @Override
    public void Logout() {

    }
}
class Study_material{ // defining array list as data members of the class study material storing the records of the uploaded video as well as slides
//    private static ArrayList<String> Lecture_video=new ArrayList<>();
//    private static ArrayList<String[]> Lecture_slides=new ArrayList<>();
//    private static ArrayList<String[]> Instructor_V_info=new ArrayList<>();
//    private static  ArrayList<String[]>Instructor_S_info=new ArrayList<>();
    private  static ArrayList<String[]> slides_info=new ArrayList<>();
    private static ArrayList<String[]> slides_content=new ArrayList<>();
    private static ArrayList<String[]> video_info=new ArrayList<>();
    //polymorphism is used according to the video input and slides input
    public Study_material(String Ttile,String file_name,String date,String instructorID){
        String temp[]={Ttile,file_name,date,instructorID};
        video_info.add(temp);
    }

    public Study_material(String content[],int no_of_slides,String Title,String instructorID,String date){
        String temp[]={ Title,instructorID,date,Integer.toString(no_of_slides)};
        slides_info.add(temp);
        slides_content.add(content);
    }
}

interface similar{
    public void  View_Lecture_material();
    public void Add_comments();
    public void  View_Assignment();
    public void  View_comments();
    public  void Logout();

}
