import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Pilih Mode:");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs CPU");
        int mode = sc.nextInt();
        sc.nextLine();

        System.out.println("Pilih ukuran papan:");
        System.out.println("1. 3x3");
        System.out.println("2. 4x4");
        System.out.println("3. 5x5");
        int uk = sc.nextInt();
        int size = (uk == 2) ? 4 : (uk == 3) ? 5 : 3;

        Board board = new Board(size);

        Player p1, p2;

        System.out.print("Nama Player 1: ");
        sc.nextLine();
        String n1 = sc.nextLine();
        p1 = new HumanPlayer(n1, 'X');

        int level = 1;

        if (mode == 1) {
            System.out.print("Nama Player 2: ");
            String n2 = sc.nextLine();
            p2 = new HumanPlayer(n2, 'O');
        } else {
            p2 = new ComputerPlayer("CPU", 'O');

            System.out.print("Level CPU (1–3): ");
            level = sc.nextInt();
        }

        Game game = new Game();

        while (true) {
            game.start(p1, p2, board, level);

            System.out.println("\nSkor Sementara:");
            System.out.println(p1.getName() + " : " + p1.getScore());
            System.out.println(p2.getName() + " : " + p2.getScore());

            System.out.print("Main lagi? (y/n): ");
            if (!sc.next().equalsIgnoreCase("y")) break;
        }

        System.out.println("\nSkor sudah disimpan ke score.txt");
        System.out.println("Terima kasih!");
        sc.close();
    }
}
