public class Board {
    private char[][] grid;
    private int size;

    public Board(int size) {
        this.size = size;
        grid = new char[size][size];
        reset();
    }

    public void reset() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = ' ';
    }

    // ANIMASI PRINT (pelan)
    public void print() {
        System.out.print("   ");
        for (int j = 0; j < size; j++) System.out.print(j + " ");
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j]);
                if (j < size - 1) System.out.print("|");
            }
            System.out.println();

            if (i < size - 1) {
                System.out.print("   ");
                for (int j = 0; j < size; j++) {
                    System.out.print("--");
                }
                System.out.println("-");
            }

            try { Thread.sleep(150); } catch (Exception e) {}
        }
        System.out.println();
    }

    public boolean place(int r, int c, char s) {
        if (r < 0 || r >= size || c < 0 || c >= size) return false;
        if (grid[r][c] != ' ') return false;
        grid[r][c] = s;
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (grid[i][j] == ' ') return false;
        return true;
    }

    // WIN CONDITION: 3 berturut-turut (untuk semua ukuran)
    public boolean checkWin(char s) {
        return checkLines(s) || checkCols(s) || checkDiag(s);
    }

    private boolean checkLines(char s) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j <= size - 3; j++)
                if (grid[i][j] == s && grid[i][j+1] == s && grid[i][j+2] == s)
                    return true;
        return false;
    }

    private boolean checkCols(char s) {
        for (int j = 0; j < size; j++)
            for (int i = 0; i <= size - 3; i++)
                if (grid[i][j] == s && grid[i+1][j] == s && grid[i+2][j] == s)
                    return true;
        return false;
    }

    private boolean checkDiag(char s) {
        // diagonal utama
        for (int i = 0; i <= size - 3; i++)
            for (int j = 0; j <= size - 3; j++)
                if (grid[i][j] == s && grid[i+1][j+1] == s && grid[i+2][j+2] == s)
                    return true;
        // diagonal anti
        for (int i = 0; i <= size - 3; i++)
            for (int j = 2; j < size; j++)
                if (grid[i][j] == s && grid[i+1][j-1] == s && grid[i+2][j-2] == s)
                    return true;
        return false;
    }

    public int getSize() {
        return size;
    }

    public char[][] getCells() {
        return grid;
    }
}
