public class ComputerPlayer extends Player {

    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int[] move(java.util.Scanner sc, Board board, int level) {
        // delay biar terasa gantian turn, tidak instan
        try { Thread.sleep(800); } catch (Exception e) {}

        char[][] g = board.getCells();
        int size = board.getSize();
        char me = getSymbol();
        char enemy = (me == 'X') ? 'O' : 'X';

        // ============================
        // LEVEL 3 – CPU MASTER
        // ============================
        if (level == 3) {
            // 1. Menang kalau bisa
            int[] win = findWinningMove(board, me);
            if (win != null) return announce(win);

            // 2. Blok lawan
            int[] block = findWinningMove(board, enemy);
            if (block != null) return announce(block);

            // 3. Ambil center (kalau ukuran ganjil)
            if (size % 2 == 1) {
                int mid = size / 2;
                if (g[mid][mid] == ' ') return announce(new int[]{mid, mid});
            }

            // 4. Ambil corner
            int[][] corners = {
                {0, 0},
                {0, size - 1},
                {size - 1, 0},
                {size - 1, size - 1}
            };
            for (int[] c : corners) {
                if (inBoard(c[0], c[1], size) && g[c[0]][c[1]] == ' ') {
                    return announce(c);
                }
            }

            // 5. Ambil side (tepi, bukan pojok)
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    boolean edge = (i == 0 || i == size - 1 || j == 0 || j == size - 1);
                    boolean corner = (i == 0 || i == size - 1) && (j == 0 || j == size - 1);
                    if (edge && !corner && g[i][j] == ' ') {
                        return announce(new int[]{i, j});
                    }
                }
            }

            // 6. fallback random
            return announce(randomMove(g, size));
        }

        // ============================
        // LEVEL 2 – CPU MEDIUM
        // ============================
        if (level == 2) {
            // 1. Blok lawan kalau hampir menang
            int[] block = findWinningMove(board, enemy);
            if (block != null) return announce(block);

            // 2. Ambil center (kalau ganjil)
            if (size % 2 == 1) {
                int mid = size / 2;
                if (g[mid][mid] == ' ') return announce(new int[]{mid, mid});
            }

            // 3. Ambil corner
            int[][] corners = {
                {0, 0},
                {0, size - 1},
                {size - 1, 0},
                {size - 1, size - 1}
            };
            for (int[] c : corners) {
                if (inBoard(c[0], c[1], size) && g[c[0]][c[1]] == ' ') {
                    return announce(c);
                }
            }

            // 4. fallback random
            return announce(randomMove(g, size));
        }

        // ============================
        // LEVEL 1 – CPU RANDOM
        // ============================
        return announce(randomMove(g, size));
    }

    // ============================
    // HELPER METHODS
    // ============================

    private boolean inBoard(int r, int c, int size) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }

    private int[] randomMove(char[][] g, int size) {
        // kumpulkan semua sel kosong dulu
        int[][] empty = new int[size * size][2];
        int count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (g[i][j] == ' ') {
                    empty[count][0] = i;
                    empty[count][1] = j;
                    count++;
                }
            }
        }

        // asumsi selalu masih ada kosong saat dipanggil
        int idx = (int) (Math.random() * count);
        return new int[]{empty[idx][0], empty[idx][1]};
    }

    // Cari langkah yang membuat s menang (dipakai untuk menang & blok)
    private int[] findWinningMove(Board board, char s) {
        char[][] g = board.getCells();
        int size = board.getSize();

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (g[r][c] == ' ') {
                    g[r][c] = s;
                    boolean win = board.checkWin(s);
                    g[r][c] = ' ';
                    if (win) return new int[]{r, c};
                }
            }
        }
        return null;
    }

    // cetak pilihan CPU + return
    private int[] announce(int[] move) {
        System.out.println(getName() + " memilih: " + move[0] + " " + move[1]);
        return move;
    }
}
