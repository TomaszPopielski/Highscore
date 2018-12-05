import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class List1 {

    HighScore[] list;
    int size;

    public List1() {
        this.size = 0;
        this.list = new HighScore[size];
        //list[0] = new HighScore("Tomasz", 1, 2000);
            /*list[1] = new HighScore("Łukasz", 3, 3000);
            list[2] = new HighScore("Michał", 3, 5000);
            list[3] = new HighScore("Tomasz", 2, 2000);
            list[4] = new HighScore("Martyna", 2, 6000);
            list[5] = new HighScore("Martyna", 1, 6000);
            list[6] = new HighScore("Martyna", 3, 6000);
            list[7] = new HighScore("Martyna", 4, 6000);
        */
    }

    public void intputRecord() {
        Scanner input = new Scanner(System.in);
        System.out.println("Wprowadź imię: ");
        String name = input.next();
        System.out.println("Wprowadz poziom: ");
        int level = input.nextInt();
        System.out.println("Wprowadź wynik: ");
        int score = input.nextInt();
        addToList(name, level, score);

    }

    public void addToList(String name, int level, int score) {


        HighScore[] temp = list;
        size++;
        list = new HighScore[size];
        for (int i = 0; i < temp.length; i++) {
            list[i] = temp[i];
        }
        list[size - 1] = new HighScore(name, level, score);
        allSort();
    }


    public void printList() {
        //if ()
        for (int i = 0; i < list.length; i++) {
            list[i].printScore();
        }
    }

    public void print10List() {
        int toPrint = 5;
        if (size < 5) {
            toPrint = size;
        }
        for (int i = 0; i < toPrint; i++) {
            list[i].printScore();
        }
    }

    public void changePlaceces(HighScore[] list, int sorted, int other) {//it can be done without list, but i will not change it now
        HighScore tempSorted = list[sorted];
        HighScore tempOther = list[other];
        list[sorted] = tempOther;
        list[other] = tempSorted;

    }

    public int maxLevel() {
        int maxLevel = 0;
        for (int i = 0; i < list.length; i++) {
            if (maxLevel < list[i].level) maxLevel = list[i].level;
        }
        return maxLevel;
    }

    public void allSort() {
        int max = 0;
        int level = maxLevel();
        int input = 0;
        int index = 0;
        for (int i = level; i > 0; i--) { //it iterates all levels
            for (int k = 0; k < list.length; k++) { // it iterates all elements in array to be sure all element were covered i think it is somehow reduntad
                for (int j = input; j < list.length; j++) { //it fins the max in one level
                    if (i == list[j].level & max < list[j].score) { // it finds where is the max and is it higher than previous
                        max = list[j].score;
                        index = j;
                    }
                }
                if (max > 0) { // it is used only if new max was founded in the same level
                    changePlaceces(list, index, input);
                    input++;
                }
                max = 0; //resets max for new search of max in this same level
            }
        }
    }

    public void saveScore() throws Exception {
        File saveOutput = new File("saveScore.txt");
        PrintWriter writer = new PrintWriter(saveOutput);
        for (int i = 0; i < list.length; i++) {
            writer.println(list[i].playerName + " " + list[i].level + " " + list[i].score);
        }
        writer.close();
    }

    public void loadScore() throws Exception{
        File loadInput = new File("saveScore.txt");
        Scanner input = new Scanner(loadInput);
        while (input.hasNextLine()) {
            String player = input.nextLine();
            Scanner record = new Scanner(player);
            String playerName = record.next();
            int level = record.nextInt();
            int score = record.nextInt();
            addToList(playerName, level, score);
        }
        input.close();
    }
}


