import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;

    // 지워도 되는 변수들
    static int n;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt((new StringTokenizer(br.readLine())).nextToken());
        }

        dp[1] = arr[1];
        // 배열이 1개일수도 있어...
        if (n > 1) {
            dp[2] = arr[1] + arr[2];
        }

        for(int i = 3; i <= n; i++){
            dp[i] = Math.max(Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]), dp[i - 1]);
        }


        System.out.print(dp[n]);

    }
}