import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int n;
    static int[][] arr;
    static boolean[] check;

    static int min = Integer.MAX_VALUE;

    static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        check = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1);
        System.out.println(min);
    }

    static void dfs(int depth, int start) {
        if (depth == n / 2) {
            min = Math.min(min, getResult());
            return;
        }

        for (int i = start; i <= n; i++) {
            check[i] = true;
            dfs(depth + 1, i + 1);
            check[i] = false;
        }
    }

    static int getResult() {
        int start = 0;
        int link = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;

                if (check[i] && check[j]) {
                    start += arr[i][j];
                }

                if(!check[i] && !check[j]) {
                    link += arr[i][j];
                }
            }
        }

        return Math.abs(start - link);
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
