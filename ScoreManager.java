import java.io.FileWriter;

public class ScoreManager {
    public static void saveScore(Player p1, Player p2) {
        try {
            FileWriter fw = new FileWriter("score.txt");
            fw.write(p1.getName() + ": " + p1.getScore() + "\n");
            fw.write(p2.getName() + ": " + p2.getScore() + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Gagal menyimpan skor.");
        }
    }
}
