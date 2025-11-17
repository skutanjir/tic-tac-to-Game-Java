public abstract class Player {
    private String name;
    private char symbol;
    protected int score = 0;

    public Player(String n, char s) {
        name = n;
        symbol = s;
    }

    public String getName() { return name; }
    public char getSymbol() { return symbol; }
    public int getScore() { return score; }
    public void addScore() { score++; }

    public abstract int[] move(java.util.Scanner sc, Board board, int level);
}
