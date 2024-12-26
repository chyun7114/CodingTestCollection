import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    // 풀이용 변수
    static int n;
    static Integer[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new Integer[n + 1];
        dp = new Integer[n + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        dp[1] = arr[1];
        if(n > 1){
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(recur(n));
    }

    static Integer recur(int n){
        if(dp[n] == null){
            dp[n] = Math.max(recur(n - 3) + arr[n - 1] + arr[n],recur(n - 2) + arr[n]);
        }
        return dp[n];
    }

}