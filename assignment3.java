import java.util.Random;
import java.util.Scanner;

public class demo1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the player name and hit enter: ");
        String s = sc.nextLine();
        player.setName(s);
        System.out.println("The game setup is ready.");

        while (true) {
            System.out.println("Hit Enter to roll dice.");
            sc.nextLine();
            dice d = new dice();
            int dicenumber = d.getNumber();

            System.out.println("Dice gave " + dicenumber);
            if (dicenumber == 1){
                System.out.println("Player position Floor-0");
                System.out.println(player.getName() + " has reached an Empty Floor");
                System.out.println("Total points 1");
                player.setPos(0);
                player.setPoints(player.getPoints()+1);
                break;
            }
            System.out.println("Game cannot start until you get 1");
        }

        while (true) {
            System.out.println("Hit enter to roll dice");
            sc.nextLine();
            dice d = new dice();
            int dicenumber = d.getNumber();
            System.out.println("Dice gave " + dicenumber);
            int c = player.getPos() + dicenumber;
            if(c > 13){
                System.out.println("player cannot move");
            }
            else if (c==0 || c==1 ||  c == 3  ||  c == 4 || c == 6 || c == 7 || c == 9 || c == 10 || c == 12) {
                System.out.println("Player position Floor-" + c);
                System.out.println(player.getName() + " has reached an Empty Floor");
                player.setPos(player.getPos()+1);
                player.setPoints(player.getPoints()+1);
                System.out.println("Total Points " +  player.getPoints());
            }
            else if (c == 2) { // elevator
                System.out.println("Player position Floor-" + c);
                System.out.println(player.getName() + " has reached an Elevator Floor");
                Elivator_ladder.points();
                System.out.println("Total points " + player.getPoints());
                Elivator_ladder.floor();

                player.setPoints(player.getPoints() + 1);
                System.out.println(player.getName() + " has reached an Empty Floor");
                System.out.println("Player position " + player.getPos());
                System.out.println("Total points " + player.getPoints());
            }
            else if (c == 5) { // snake
                System.out.println("Player position Floor-" + c);
                System.out.println(player.getName()+ " has reached a Snake Floor");
                normal_snake.point();
                System.out.println("Total points " + player.getPoints());
                normal_snake.floor();

//                player.setPoints(1);
                System.out.println(player.getName() + " has reached an Empty Floor");
                System.out.println("Player position " + player.getPos());
                System.out.println("Total points " + player.getPoints());
            }
            else if (c == 8) { // ladder
                System.out.println("Player position Floor-" + c);
                System.out.println(player.getName() + " has reached a Ladder Floor");
                normal_ladder.points();
                System.out.println("Total points " + player.getPoints());
                normal_ladder.floor();

                player.setPoints(player.getPoints()+1);
                System.out.println(player.getName() + " has reached an Empty Floor");
                System.out.println("Player position " + player.getPos());
                System.out.println("Total points " + player.getPoints());
            }
            else if (c == 11) { // cobra
                System.out.println("Player position Floor-" + c);
                System.out.println(player.getName() + " has reached a King Cobra Floor");
                King_cobra.point();
                System.out.println("Total points " + player.getPoints());
                King_cobra.floor();

//                player.setPoints(1);
                System.out.println(player.getName() + " has reached an Empty Floor");
                System.out.println("Player position " + player.getPos());
                System.out.println("Total points " + player.getPoints());
            }
            else if (c == 13) {
                System.out.println("Player position Floor-13");
                System.out.println(player.getName() + " has reached an Empty Floor");
                player.setPoints(player.getPoints() + 1);
                System.out.println("Total points " + player.getPoints());
                System.out.println("Game Over");
                System.out.println(player.getName() + " accumulated " + player.getPoints() + " points");
                break;
            }
        }
    }
}


class player{
    private static int points;
    private static String name;
    private static int pos;

    public static void setPoints(int points) { player.points = points; }

    public static void setName(String name) { player.name = name; }

    public static void setPos(int pos) { player.pos = pos; }

    public static int getPoints() { return player.points; }

    public static String getName() { return player.name; }

    public static int getPos() { return player.pos; }
}


class dice{
    private int diceFace;

    public void setDiceFace(int val){
        diceFace = val;
    }

    public int getDiceFace(){
        return diceFace;
    }

    public int getNumber(){
        Random r = new Random();
        int n = r.nextInt(2) + 1;
        setDiceFace(n);
        return getDiceFace();
    }
}



class floor {

    public static void points(int p){
        player.setPoints(player.getPoints()+p);
    }
    public static void floor_position(int dice){
        player.setPoints(player.getPos()+dice);
    }
}

class upGoing extends floor{
    public static void points(){
        player.setPoints(0);
    }
    public static void floor(){
        player.setPos(0);
    }
}


class downGoing extends floor{
    public static void point(){
        player.setPoints(0);
    }
    public static void floor(){
        player.setPos(0);
    }
}


class normal_ladder extends upGoing{
    upGoing up = new upGoing();

    public static void points() {
        player.setPoints(player.getPoints()+2);
    }

    public static void floor() {
        player.setPos(12);
    }
}


class Elivator_ladder extends upGoing{

    upGoing up = new upGoing();

    public static void points() {
        player.setPoints(player.getPoints()+4);
    }

    public static void floor() {
        player.setPos(10);
    }

}


class normal_snake extends downGoing{

    downGoing down =new downGoing();

    public static void point() {
        player.setPoints(player.getPoints()-2);
    }

    public static void floor() {
        player.setPos(1);
    }
}

class King_cobra extends downGoing{

    downGoing down =new downGoing();

    public static void point() {
        player.setPoints(player.getPoints()-4);
    }

    public static void floor() {
        player.setPos(3);
    }
}
