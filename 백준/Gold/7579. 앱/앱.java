import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int n, m;
    static int[] memory;
    static int[] cost;
    static int[][] dp;

    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        int ans = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        memory = new int[n];
        cost = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][10001];

        for(int i = 0; i < n; i++) {
            int curCost = cost[i];
            int curMem = memory[i];

            for(int j = 0; j < 10001; j++){
                if(i == 0) {
                    if(j >= curCost) {
                        dp[i][j] = curMem;
                    }
                }else {
                    if(j >= curCost) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - curCost] + curMem);
                    }else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }

                if(dp[i][j] >= m) {
                    ans = Math.min(j, ans);
                }
            }
        }

        System.out.println(ans);
    }


    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
