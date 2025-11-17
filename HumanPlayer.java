public class HumanPlayer extends Player {
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int[] move(java.util.Scanner sc, Board board, int level) {
        System.out.print(getName() + " (r c): ");
        return new int[]{sc.nextInt(), sc.nextInt()};
    }
}
