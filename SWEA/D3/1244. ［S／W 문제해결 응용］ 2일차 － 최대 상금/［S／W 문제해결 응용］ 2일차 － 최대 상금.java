import java.util.*;
import java.io.*;

public class Solution {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int t;
    static int n;
    static int[] arr;
    static int max;

    static void solveProblem() throws IOException {
        t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            n = Integer.parseInt(st.nextToken());

            arr = new int[temp.length()];

            for (int i = 0; i < temp.length(); i++) {
                arr[i] = temp.charAt(i) - '0';
            }

            if (n > arr.length) {
                n = arr.length;
            }

            dfs(0, 0);

            sb.append("#").append(testCase).append(" ").append(max).append("\n");

            max = 0;
        }

        System.out.println(sb.toString());
    }

    static void dfs(int depth, int count) {
        if (count == n) {
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                result += (int) (Math.pow(10, i) * arr[arr.length - i - 1]);
            }
            max = Math.max(result, max);
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(i, j);
                dfs(i, count + 1);
                swap(i, j);
            }
        }
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
