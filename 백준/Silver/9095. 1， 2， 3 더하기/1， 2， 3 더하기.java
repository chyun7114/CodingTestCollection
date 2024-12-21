import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        int[] dp = new int[11];
        int[] arr = new int[t];
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] =  Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < 11; i++)
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

        for(int num : arr){
            System.out.println(dp[num]);
        }
    }
}