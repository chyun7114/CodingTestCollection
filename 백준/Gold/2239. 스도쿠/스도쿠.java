import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int[][] board;
    static boolean[][][] check;
    static boolean end = false;

    static void solveProblem() throws IOException {
        board = new int[9][9];
        check = new boolean[9][9][10];

        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = s.charAt(j) - '0';
                if (board[i][j] != 0) {
                    check[0][i][board[i][j]] = true;
                    check[1][j][board[i][j]] = true;
                    check[2][(i / 3) * 3 + (j / 3)][board[i][j]] = true;
                }
            }
        }

        dfs(0, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int x, int y) {
        if (x == 8 && y == 8) {
            for (int i = 1; i <= 9; i++) {
                if (!check[0][8][i]) {
                    board[8][8] = i;
                    break;
                }
            }
            end = true;
            return;
        }

        if (board[y][x] != 0) {
            if (x + 1 == 9) {
                dfs(0, y + 1);
            } else {
                dfs(x + 1, y);
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                if (!check[0][y][i] && !check[1][x][i] && !check[2][(y / 3) * 3 + (x / 3)][i]) {
                    board[y][x] = i;
                    check[0][y][i] = true;
                    check[1][x][i] = true;
                    check[2][(y / 3) * 3 + (x / 3)][i] = true;

                    if (x + 1 == 9) {
                        dfs(0, y + 1);
                    } else {
                        dfs(x + 1, y);
                    }

                    if (end) {
                        return;
                    }

                    board[y][x] = 0;
                    check[0][y][i] = false;
                    check[1][x][i] = false;
                    check[2][(y / 3) * 3 + (x / 3)][i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
