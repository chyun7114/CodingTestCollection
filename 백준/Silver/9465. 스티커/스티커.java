import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int t, n;

    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            for (int i = 0; i < 2; i++) {
                String[] inputs = br.readLine().split(" ");
                for (int j = 1; j <= n; j++) {
                    stickers[i][j] = Integer.parseInt(inputs[j - 1]);
                }
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            if (n >= 2) {
                for (int j = 2; j <= n; j++) {
                    dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
                    dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
                }
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }


    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
