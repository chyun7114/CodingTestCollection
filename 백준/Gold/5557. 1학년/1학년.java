import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n][21];

        dp[0][arr[0]] = 1;

        int plus;
        int minus;
        for(int i=1; i<n-1; i++){
            for(int j=0; j<=20; j++){
                if(dp[i-1][j]!=0){
                    plus = j+arr[i];
                    minus = j-arr[i];
                    if(plus>=0 && plus<=20){
                        dp[i][plus]+=dp[i-1][j];
                    }
                    if(minus>=0 && minus<=20){
                        dp[i][minus]+=dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[n - 2][arr[n - 1]]);
    }
}