public class Game {
    public void start(Player p1, Player p2, Board board, int level) {
        board.reset();

        while (true) {
            board.print();

            // TURN PLAYER 1
            int[] m1 = p1.move(new java.util.Scanner(System.in), board, level);
            while (!board.place(m1[0], m1[1], p1.getSymbol())) {
                System.out.println("Tidak valid!");
                m1 = p1.move(new java.util.Scanner(System.in), board, level);
            }
            if (board.checkWin(p1.getSymbol())) {
                board.print();
                System.out.println(p1.getName() + " MENANG!");
                p1.addScore();
                break;
            }
            if (board.isFull()) {
                board.print();
                System.out.println("SERIII");
                break;
            }

            // TURN PLAYER 2
            int[] m2 = p2.move(new java.util.Scanner(System.in), board, level);
            board.place(m2[0], m2[1], p2.getSymbol());

            if (board.checkWin(p2.getSymbol())) {
                board.print();
                System.out.println(p2.getName() + " MENANG!");
                p2.addScore();
                break;
            }
            if (board.isFull()) {
                board.print();
                System.out.println("SERIII");
                break;
            }
        }

        ScoreManager.saveScore(p1, p2);
    }
}
