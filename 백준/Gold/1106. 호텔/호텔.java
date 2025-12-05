import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수
    static int c;
    static int n;


    private static void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c + 101];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            for (int j = people; j < c + 101; j++) {
                dp[j] = Math.min(dp[j], dp[j - people] + cost);
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = c; i < c + 101; i++) {
            result = Math.min(dp[i], result);
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}