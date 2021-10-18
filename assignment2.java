import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.DataFormatException;

public class assignment2new {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        while(true) {
            WelcomeMenu();
            int welcome = sc.nextInt();
            if(welcome==1) {
                String Id=choosInstructorID();
                while (true) {
                    System.out.println(Id);
                    InstructorMenu();
                    int choose = sc.nextInt();
                    if(choose==1){
                        System.out.println("1. Add Lecture Slides");
                        System.out.println("2. Add Lecture Video");
                        int choice= sc.nextInt();
                        if(choice==1) {
                            Slides s = new Slides();
                            s.add(Id);
                        }else{
                            Video v = new Video();
                            v.add(Id);
                        }
                    } else if (choose == 2) {
                        System.out.println("1. Add Assignment");
                        System.out.println("2. Add Quiz");
                        int choice= sc.nextInt();
                        if(choice==1) {
                            Assignment a = new Assignment();
                            a.add(Id);
                        }else{
                             quiz q= new quiz();
                            q.add(Id);
                        }

                    }else if (choose == 3){
                        Slides s=new Slides();
                        s.show();
                        Video v = new Video();
                        v.show();

                    }else if (choose == 4){
                        Assignment a= new Assignment();
                        a.show();
                        quiz q=new quiz();
                        q.show();
                    }else if (choose == 5){
                        System.out.println("5");
                    }else if (choose == 6){
                        System.out.println("6");
                    }else if (choose == 7){
                        System.out.println("7");
                    }else if (choose == 8){
                        System.out.println("8");
                    }else if (choose == 9){
                        break;
                    }
                }
            }else if(welcome==2){
                String ID=chooseStudentID();
                while(true) {
                    System.out.println(ID);
                    StudentMenu();
                    int choose= sc.nextInt();
                    if (choose==1){
                        System.out.println("1");
                    } else if (choose == 2) {
                        System.out.println("2");
                    }else if (choose == 3){
                        System.out.println("3");
                    }else if (choose == 4){
                        System.out.println("4");
                    }else if (choose == 5){
                        System.out.println("5");
                    }else if (choose == 6){
                        System.out.println("6");
                    }else if (choose == 7){
                        break;
                    }
                }
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

    public static String choosInstructorID(){
        int count=2;
        Scanner sc= new Scanner(System.in);
        System.out.println("Instructors:");
        for(int i=0;i<count;i++){
            System.out.println(i+" - "+"I"+i);
        }
        System.out.println("Choose id:");
        int choose=sc.nextInt();
        String ch="";
        for(int i =0;i<count;i++){
            if(choose==i){
                ch="Welcome "+"I"+i;
            }
        }
        return ch;
    }

    public static String  chooseStudentID(){
        int count=3;
        Scanner sc= new Scanner(System.in);
        System.out.println("Students:");
        for(int i=0;i<count;i++){
            System.out.println(i+" - "+"S"+i);
        }
        System.out.println("Choose id:");
        int choose=sc.nextInt();
        String ch="";
        for(int i =0;i<count;i++){
            if(choose==i){
                ch="Welcome "+"S"+i;
            }
        }
        return ch;
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
//-----------------------------------------------------Student--------------------------------------------------------//
    class student implements show_menu{

        public void submit_Assesments(){

        }

        @Override
        public void wellcome_menu() {
            System.out.println("Welcome to Backpack\n" +
                    "1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");
        }

        @Override
        public void Show_menu() {
            System.out.println("1. View lecture materials\n" +
                    "2. View assessments\n" +
                    "3. Submit assessment\n" +
                    "4. View grades\n" +
                    "5. View comments\n" +
                    "6. Add comments\n" +
                    "7. Logout");
        }

        @Override
        public void Set_id() {
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
    }

//------------------------------------------------------Instructor----------------------------------------------------//
    class instructor extends Student implements show_menu{

        public void submit_assignment(){

        }
        @Override
        public void wellcome_menu() {
            System.out.println("Welcome to Backpack\n" +
                    "1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");
        }

        @Override
        public void Show_menu() {
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

        @Override
        public void Set_id() {
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

    }

    //-------------------------------------------------Video----------------------------------------------------------//
    class Video implements Lecture_material{
        Scanner sc=new Scanner(System.in);
        String Ttile;
        String file_name;
        String Date;
        String instructorID;

       public Video(){

       }
       public Video(String Ttile,String file_name,String Date,String instructorID){
           this.Ttile=Ttile;
           this.file_name=file_name;
           this.Date=Date;
           this.instructorID=instructorID;
       }
        private static ArrayList<Video> V=new ArrayList<>();

        public String getTtile() {
            return Ttile;
        }

        public String getFile_name() {
            return file_name;
        }

        public String getDate() {
            return Date;
        }

        public String getInstructorID() {
            return instructorID;
        }

        public static ArrayList<Video> getV() {
            return V;
        }

        @Override
        public void add(String Id) {
            String instructorId ="";
            if(Id.equals("Welcome I0")){
                instructorId="I0";
            }else if(Id.equals("Welcome I1")){
                instructorId="I1";
            }
            System.out.println("Enter topic of video:");
            String topic=sc.next();
            System.out.println("Enter filename of video:");
            String filename=sc.next();
            int len=filename.length();
            if(!filename.substring(len-4, len).equals("mp4")){
                System.out.println("invalid input");
            }
            Date dateobject = new Date();
            SimpleDateFormat date = new SimpleDateFormat("E,dd MM yyyy HH:mm:ss z");
            String Date=date.format(dateobject);
             Video v=new Video(topic,filename,Date,instructorId);
             V.add(v);
        }
        @Override
        public void show() {
            for(int i=0;i<V.size();i++){
                System.out.println("Title of video: "+getV().get(i).getTtile());
                System.out.println("Video file: "+getV().get(i).getFile_name());
                System.out.println("Date of upload: "+getV().get(i).getDate());
                System.out.println("Uploaded by: "+getV().get(i).getInstructorID());
            }
        }
    }


//-----------------------------------------------------Slides---------------------------------------------------------//
    class Slides implements Lecture_material{
    Scanner sc=new Scanner(System.in);

    String content[];
    int no_of_slides;
    String Title;
    String instructorID;
    String Date;

    public Slides(){

    }

    public Slides(String content[],int no_of_slides,String Title,String instructorID,String Date){
        this.no_of_slides=no_of_slides;
        this.instructorID=instructorID;
        this.Date=Date;
        this.Title=Title;
        this.content=content;
    }

    public String[] getContent() {
        return content;
    }

    public int getNo_of_slides() {
        return no_of_slides;
    }

    public String getTitle() {
        return Title;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public String getDate() {
        return Date;
    }

    public static ArrayList<Slides> getS() {
        return S;
    }

    private static ArrayList<Slides> S = new ArrayList<>();

    @Override
        public void add(String Id) {
            String instructorId = "";
            if(Id.equals("Welcome I0")){
                instructorId="I0";
            }else if(Id.equals("Welcome I1")){
                instructorId="I1";
            }
            System.out.println("Enter topic of slides:");
            String topic = sc.next();
            System.out.println("Enter number of slides:");
            int no_of_slides = sc.nextInt();
            System.out.println("Enter content of slides");
            String  content[]=new String[no_of_slides];
            for (int i = 0; i < no_of_slides; i++) {
                System.out.println("Content of slide " + i+1 + ":");
                content[i]= sc.next();
            }
             Date dateobject = new Date();
            SimpleDateFormat date = new SimpleDateFormat("E,dd MM yyyy HH:mm:ss z");
            String Date=date.format(dateobject);
            Slides s=new Slides(content,no_of_slides,topic,instructorId,Date);
            S.add(s);
        }
        @Override
        public void show() {
            for(int i=0;i<getS().size();i++){
                System.out.println("Title : "+getS().get(i).getTitle());
                for(int j=0;j<getS().get(i).getContent().length;j++){
                    System.out.println("Slide "+(j+1)+getS().get(i).getContent()[j]);
                }
                System.out.println("Number of slides: "+getS().get(i).getNo_of_slides());
                System.out.println("Date of upload: "+getS().get(i).getDate());
                System.out.println("Uploaded by: "+getS().get(i).getInstructorID());
            }
        }
    }


    //------------------------------------------------Assignment------------------------------------------------------//
    class Assignment implements Assisments{
        Scanner sc =new Scanner(System.in);
        String problem_statement;
        String Date;
        String instructorID;
        int maxmarks;

        public Assignment(){
        }
        public Assignment( String problem_statement,String Date,String instructorID,int maxmarks){
            this.Date=Date;
            this.instructorID=instructorID;
            this.maxmarks=maxmarks;
            this.problem_statement=problem_statement;
        }
        private static ArrayList<Assignment> A=new ArrayList<>();
        public String getProblem_statement() {
            return problem_statement;
        }

        public String getDate() {
            return Date;
        }

        public String getInstructorID() {
            return instructorID;
        }

        public int getMaxmarks() {
            return maxmarks;
        }

        public static ArrayList<Assignment> getA() {
            return A;
        }

        @Override
        public void add(String Id) {
            String instructorId = "";
            if(Id.equals("Welcome I0")){
                instructorId="I0";
            }else if(Id.equals("Welcome I1")){
                instructorId="I1";
            }
            System.out.println("Enter problem statement:");
            String problem_statement=sc.next();
            System.out.println("Enter max marks:");
            int max_marks=sc.nextInt();
            Date dateobject = new Date();
            SimpleDateFormat date = new SimpleDateFormat("E,dd MM yyyy HH:mm:ss z");
            String Date=date.format(dateobject);
            Assignment a=new Assignment(problem_statement,Date,instructorId,max_marks);
            A.add(a);
        }


        @Override
        public void show() {
          for(int i=0;i<getA().size();i++){
                System.out.println("ID: "+i+" Assignment :"+getA().get(i).getProblem_statement()+" Max Marks "+getA().get(i).getMaxmarks());
            }
            System.out.println("-------------------------------------------------------------------------");

        }
    }

    //---------------------------------------------------Quiz---------------------------------------------------------//
    class quiz implements Assisments{
        Scanner sc=new Scanner(System.in);
        String instructorId;
        String Date;
        String quiz_ques;

        public quiz(){

        }
        public quiz(String instructorId,String Date,String quiz_ques){
            this.Date=Date;
            this.instructorId=instructorId;
            this.quiz_ques=quiz_ques;
        }

        private static ArrayList<quiz> Q=new ArrayList<>();

        public String getInstructorId() {
            return instructorId;
        }

        public String getDate() {
            return Date;
        }

        public String getQuiz_ques() {
            return quiz_ques;
        }

        public static ArrayList<quiz> getQ() {
            return Q;
        }

        @Override
        public void add(String Id) {
            String instructorId = "";
            if(Id.equals("Welcome I0")){
                instructorId="I0";
            }else if(Id.equals("Welcome I1")){
                instructorId="I1";
            }
            System.out.println("Enter quiz question:");
            String quiz_ques=sc.next();
            Date dateobject = new Date();
            SimpleDateFormat date = new SimpleDateFormat("E,dd MM yyyy HH:mm:ss z");
            String Date=date.format(dateobject);
            quiz q=new quiz(instructorId,Date,quiz_ques);
            Q.add(q);
        }

        @Override
        public void show() {
            for(int i=0;i<getQ().size();i++){
                System.out.println("ID: " +i+" Question: "+getQ().get(i).quiz_ques);
            }
            System.out.println("---------------------------------------------------------------------------");

        }
    }


    //------------------------------------------------interface-------------------------------------------------------//
    interface  show_menu{
        public void wellcome_menu();
        public void Show_menu();
        public void Set_id();

    }
    interface Lecture_material{
        public void add(String Id);
        public void show();
    }
    interface Assisments{
        public void add(String Id);
        public void show();
    }



