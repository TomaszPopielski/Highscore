import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws Exception {

        List1 list = new List1();
        list.loadScore();
        int players = 2;

        while (players>0) {
            list.intputRecord();
            players--;
        }

        System.out.println();
        list.print10List();
        list.saveScore();




    }
}
