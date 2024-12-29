import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;

    // 지워도 되는 변수들
    final static long mod = 1000000000;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long[][] dp = new long[101][10];

        dp[1][0] = 0;

        // 먼저 1자리수인경우 수 채우기
        for(int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < 10; j++){
                if(j == 0)
                    dp[i][j] = dp[i - 1][j + 1] % mod;
                else if (j == 9)
                    dp[i][j] = dp[i - 1][j - 1] % mod;
                else
                    dp[i][j] = (dp[i - 1][j + 1] + dp[i - 1][j - 1]) % mod;
            }
        }

        long result = 0;

        for(int j = 0; j < 10; j++){
            result += dp[n][j];
        }

        System.out.print(result % mod);
    }
}