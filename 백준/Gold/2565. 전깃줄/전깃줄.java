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
    static int[][] wire;
    static Integer[] dp;

    static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());

        wire = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, (o1, o2) -> o1[0] - o2[0]);

        dp = new Integer[n];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, lis(i));
        }

        System.out.println(n - max);
    }

    static int lis(int num) {

        if (dp[num] == null) {

            dp[num] = 1;

            for(int i = num + 1; i < n; i++) {
                if (wire[num][1] < wire[i][1]) {
                    dp[num] = Math.max(dp[num], lis(i) + 1);
                }
            }
        }

        return dp[num];
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
