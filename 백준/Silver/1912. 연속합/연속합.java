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
    static int[] arr;
    static Integer[] dp;
    static int max = Integer.MIN_VALUE;

    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new Integer[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];

        subSum(n - 1);

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int subSum(int n) {
        if(dp[n] == null) {
            dp[n] =  Math.max(subSum(n - 1) + arr[n], arr[n]);

            max = Math.max(max, dp[n]);
        }

        return dp[n];
    }


    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
