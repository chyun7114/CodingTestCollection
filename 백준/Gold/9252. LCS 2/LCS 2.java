import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨

    static void solveProblem() throws IOException {
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = s1.length();
        int j = s2.length();

        Stack<Character> st = new Stack<>();

        while(i > 0 && j > 0) {
            if(i == 0 || j ==0)break;

            if(dp[i][j] == dp[i-1][j]) {
                i--;
            }else if(dp[i][j] == dp[i][j-1]) {
                j--;
            }else {
                st.push(s1.charAt(i-1));
                i--;
                j--;
            }
        }

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        System.out.println(dp[s1.length()][s2.length()]);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
