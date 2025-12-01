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
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for(int coin : coins) {
            for(int i = coin; i <= k; i++) {
                // coin으로 금액을 만들수 있는 경우 + 1
                dp[i] = dp[i - coin] + dp[i];
            }
        }

        System.out.println(dp[k]);
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
