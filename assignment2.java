import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.*;

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
                        System.out.println();
                        Video v = new Video();
                        v.show();

                    }else if (choose == 4){
                        int count=0;
                        Assignment a= new Assignment();
                        a.show(count);
                        System.out.println();
                        quiz q=new quiz();
                        q.show(count);
                    }else if (choose == 5){
                        System.out.println("List of Assignemnts.");

                        Assignment a= new Assignment();
                        quiz q=new quiz();
                        int c = a.show(0);
                        c = q.show(c);

                        System.out.print("Enter ID.");

                        int ch = sc.nextInt();

                        if(ch < Assignment.getA().size()) {
                            a.grade(ch,  Integer.parseInt(Id.substring(Id.length()-1)));
                        }
                        else{
                            a.grade(ch - Assignment.getA().size(), Integer.parseInt(Id.substring(Id.length()-1)));
                        }


                    }else if (choose == 6){
                        instructor.close_assessment();
                    }else if (choose == 7){
                        comments c=new comments();
                        c.show();
                    }else if (choose == 8){
                        comments c=new comments();
                        c.add(Id.substring(Id.length()-2,Id.length()));
                    }else if (choose == 9){
                        break;
                    }else{
                        System.out.println("Wrong Input");
                    }
                }
            }else if(welcome==2){
                String ID=chooseStudentID();
                while(true) {
                    System.out.println(ID);
                    StudentMenu();
                    int choose= sc.nextInt();
                    if (choose==1){
                        Slides s=new Slides();
                        s.show();
                        System.out.println();
                        Video v = new Video();
                        v.show();
                    } else if (choose == 2) {
                        int count=0;
                        Assignment a= new Assignment();
                        a.show(count);
                        System.out.println();
                        quiz q=new quiz();
                        q.show(count);
                    }else if (choose == 3){
                        student s=new student();
                        s.submit(Integer.parseInt(ID.substring(ID.length()-1,ID.length())));
                    }else if (choose == 4){
                        System.out.println("4");
                    }else if (choose == 5){
                        comments c=new comments();
                        c.show();
                    }else if (choose == 6){
                        comments c=new comments();
                        c.add(ID.substring(ID.length()-2,ID.length()));
                    }else if (choose == 7){
                        break;
                    }else{
                        System.out.println("Wrong input");
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
    class student {
    Scanner sc=new Scanner(System.in);

    public void submit(int Id){
        ArrayList<Integer> Assignment_record = new ArrayList<>();
        ArrayList<Integer> Quiz_record = new ArrayList<>();

        System.out.println("Pending assessments");
        int counter = 0;

        Assignment A = new Assignment();
        quiz q = new quiz();
        for( int i = 0; i<Assignment.getA().size(); i++){
            if(Assignment.getA().get(i).getStatus().equals("Open")) {
                System.out.println("ID: " + counter + " Assignment: " + Assignment.getA().get(i).getProblem_statement());
                Assignment_record.add(counter);
                counter++;
            }
        }
        for( int i = 0; i<quiz.getQ().size(); i++){
            if(quiz.getQ().get(i).getStatus().equals("Open")) {
                System.out.println("ID: " + counter + " Question: " + quiz.getQ().get(i).getQuiz_ques());
                Quiz_record.add(counter);
                counter++;
            }


        }

        System.out.print("Enter ID of assessment: ");
        int assessmentChoice = sc.nextInt();

        if(assessmentChoice < Assignment_record.size()){
            System.out.print("Enter filename of assessment: ");
            String file_Assessment = sc.next();
            int len=file_Assessment.length();
            if(!file_Assessment.substring(len-4, len).equals(".zip")){
                System.out.println("invalid input");
            }
            Assignment.getA_rec().get(Assignment_record.get(assessmentChoice))[Id] = file_Assessment;
        }
        else{
            System.out.print(quiz.getQ().get(assessmentChoice - Assignment_record.size()).quiz_ques);
            String quiz_answer = sc.nextLine();
            quiz.getQ_rec().get(Quiz_record.get(assessmentChoice - Assignment_record.size()))[Id] = quiz_answer;
        }

    
    }

}

//------------------------------------------------------Instructor----------------------------------------------------//
    class instructor {
    Scanner sc = new Scanner(System.in);


    public static void close_assessment() {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> close_assignment = new ArrayList<>();
        ArrayList<Integer> close_quiz = new ArrayList<>();

        System.out.println("List of open assessments.");


        int count = 0;

        for (int i = 0; i < Assignment.getA().size(); i++) {
            if (Assignment.getA().get(i).status.equals("Open")) {
                System.out.println("ID: " + count + " Assignment: " + Assignment.getA().get(i).getProblem_statement() + " Max Marks: " + Assignment.getA().get(i).getMaxmarks());
                close_assignment.add(count);
                count++;
            }
        }

        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < quiz.getQ().size(); i++) {
            if (quiz.getQ().get(i).status.equals("Open")) {
                System.out.println("ID: " + count + " Question: " + quiz.getQ().get(i).getQuiz_ques());
                close_quiz.add(count);
                count++;
            }
        }
        System.out.println("-------------------------------------------------------------------------");
        if (close_assignment.size() + close_quiz.size() == 0) {
            System.out.println("No open assignments left ");
            return;
        }

        System.out.print("Enter if of assignemnt you want to close: ");

        int assignment_Id = sc.nextInt();

        if (assignment_Id < close_assignment.size()) {
            Assignment.getA().get(close_assignment.get(assignment_Id)).status = "Close";
        } else {
            quiz.getQ().get(close_quiz.get(assignment_Id - close_assignment.size())).status= "Close";
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
            if(!filename.substring(len-4, len).equals(".mp4")){
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

//----------------------------------------------------Assignment------------------------------------------------------//
    class Assignment implements Assisments{
        Scanner sc =new Scanner(System.in);
        String problem_statement;
        String Date;
        String instructorID;
        String status;
        int maxmarks;

        public Assignment(){
        }
        public Assignment( String problem_statement,String Date,String instructorID,int maxmarks,String status){
            this.Date=Date;
            this.instructorID=instructorID;
            this.maxmarks=maxmarks;
            this.problem_statement=problem_statement;
            this.status=status;
        }
        private static ArrayList<Assignment> A=new ArrayList<>();
        private static ArrayList<String[]> A_rec=new ArrayList<>();

    public static ArrayList<int[]> getA_marks() {
        return A_marks;
    }

    private static ArrayList<int []> A_marks=new ArrayList<>();

        public static ArrayList<String[]> getA_rec() {
            return A_rec;
        }

        public String getProblem_statement() {
            return problem_statement;
        }

        public String getDate() {
            return Date;
        }

        public String getStatus() {
            return status;
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
            System.out.print("Enter problem statement:");
            String problem_statement=sc.nextLine();
//            sc.next();
            System.out.print("Enter max marks:");
            int max_marks=sc.nextInt();
            Date dateobject = new Date();
            SimpleDateFormat date = new SimpleDateFormat("E,dd MM yyyy HH:mm:ss z");
            String Date=date.format(dateobject);
            String status="Open";
            Assignment a=new Assignment(problem_statement,Date,instructorId,max_marks,status);
            A.add(a);
            String temp[]={null,null,null};
            A_rec.add(temp);
        }


        @Override
        public int show(int count) {
            for (int i=0; i < getA().size(); i++) {
                System.out.println("ID: " + count + " Assignment :" + getA().get(i).getProblem_statement() + " Max Marks " + getA().get(i).getMaxmarks());
                count++;
            }
            System.out.println("-------------------------------------------------------------------------");
            return count;
        }

        @Override
        public void grade(int indx,int instructor_id) {
            int count  = 0;
            System.out.println("Choose ID from these ungraded submissions.");
            for (int i = 0 ; i < 3 ; i ++) {
                if(A_rec.get(indx)[i] != null) {
                    System.out.println(i + ".S" + i);
                }
            }
            if (count == 0 ) {
                System.out.println("No ungraded submission.");
            }
            int c = sc.nextInt();
            System.out.println("Sumission: " + A_rec.get(indx)[c]);
            System.out.println("Max Marks: " + A_rec.get(indx)[1]);
            System.out.print("Marks Scored: ");
            int marks = sc.nextInt();
            A_marks.get(indx) [c] = marks;
        }
    }

//-------------------------------------------------------Quiz---------------------------------------------------------//
    class quiz implements Assisments{
        Scanner sc=new Scanner(System.in);
        String instructorId;
        String Date;
        String quiz_ques;
        String status;
        int maxmarks;

        public quiz(){

        }

        public String getStatus() {
            return status;
        }

        public int getMaxmarks() {
            return maxmarks;
        }

        public quiz(String instructorId, String Date, String quiz_ques, String status, int maxmarks){
            this.Date=Date;
            this.instructorId=instructorId;
            this.quiz_ques=quiz_ques;
            this.status=status;
            this.maxmarks=maxmarks;
        }

        private static ArrayList<quiz> Q=new ArrayList<>();
        private static ArrayList<String[]> Q_rec=new ArrayList<>();
        private static ArrayList<int []> Q_marks=new ArrayList<>();

    public static ArrayList<int[]> getQ_marks() {
        return Q_marks;
    }

    public static ArrayList<String[]> getQ_rec() {
            return Q_rec;
        }

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
            String quiz_ques=sc.nextLine();
            Date dateobject = new Date();
            SimpleDateFormat date = new SimpleDateFormat("E,dd MM yyyy HH:mm:ss z");
            String Date=date.format(dateobject);
            String status="Open";
            int maxmarks=1;
            quiz q=new quiz(instructorId,Date,quiz_ques,status,maxmarks);
            Q.add(q);
            String temp[]={null,null,null};
            Q_rec.add(temp);
        }

        @Override
        public int show(int count) {
            for(int i=0 ;i<getQ().size();i++){
                System.out.println("ID: " +count+" Question: "+getQ().get(i).quiz_ques);
                count++;
            }
            System.out.println("---------------------------------------------------------------------------");
            return count;
        }

        @Override
        public void grade(int indx,int instructor_id) {
            int count  = 0;
            System.out.println("Choose ID from these ungraded submissions.");
            for (int i = 0 ; i < 3 ; i ++) {
                if(Q_rec.get(indx)[i] != null) {
                    System.out.println(i + ".S" + i);
                }
            }
            if (count == 0 ) {
                System.out.println("No ungraded submission.");
            }
            int c = sc.nextInt();
            System.out.println("Sumission: " + Q_rec.get(indx)[c]);
            System.out.println("Max Marks: 1" + Q_rec.get(indx)[1]);
            System.out.print("Marks Scored: ");
            int marks = sc.nextInt();
            Q_marks.get(indx)[c] = marks;

        }
    }

//----------------------------------------------------comments--------------------------------------------------------//
class comments implements Lecture_material{

    private String comment;
    private String time;
    private String user;

    public comments() {

    }

    public comments(String comment, String time, String  user) {
        this.comment = comment;
        this.time = time;
        this.user = user;
    }

    static ArrayList <comments> comment_list = new ArrayList<>();

    public String getComment() {
        return comment;
    }

    public String getTime() {
        return time;
    }

    public String getUser() {
        return user;
    }

    public static ArrayList<comments> getComment_list() {
        return comment_list;
    }

    Date dateobject = new Date();
    SimpleDateFormat date = new SimpleDateFormat("E,dd MM yyyy HH:mm:ss z");

    @Override
    public void add(String addedby) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter comment: ");
        String comment = sc.nextLine();
        String user = addedby;
        SimpleDateFormat date = new SimpleDateFormat("E,dd MM yyyy HH:mm:ss z");
        String time=date.format(dateobject);

        comments comment_obj = new comments(comment , time , user);
        getComment_list().add(comment_obj);
    }

    @Override
    public void show() {
        for (int i = 0 ; i < getComment_list().size() ; i++) {
            System.out.println(getComment_list().get(i).getComment() + " - " + getComment_list().get(i).getUser());
            System.out.println(getComment_list().get(i).getTime());
        }
    }
}

//----------------------------------------------------interface-------------------------------------------------------//

    interface Lecture_material{
        public void add(String Id);
        public void show();
    }
    interface Assisments{
        public void add(String Id);
        public int show(int count);
        public void grade(int index,int instructor_id);
    }



