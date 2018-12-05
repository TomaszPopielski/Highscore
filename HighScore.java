public class HighScore {

    String playerName;
    int level;
    int score;

    public HighScore(String playerName, int level, int score){
        this.playerName = playerName;
        this.level = level;
        this.score = score;
    }

    public HighScore(){
        this.playerName = "Tomasz";
        this.level = 1;
        this.score = 0;

    }

    public void printScore(){

        System.out.print(playerName);
        for (int i=0; i<(15-playerName.length());i++) {
            System.out.print("-");
        }

        System.out.println(level + "------------" + score);
    }
}
