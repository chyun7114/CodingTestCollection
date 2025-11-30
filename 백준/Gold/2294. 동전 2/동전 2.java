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
    static int k;
    static int[] coins;

    static int[] dp = new int[10001];

    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];

        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for(int coin : coins) {
            for(int i = coin; i <= k; i++) {
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }

        System.out.println(dp[k] == 100_001 ? -1 : dp[k]);
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
