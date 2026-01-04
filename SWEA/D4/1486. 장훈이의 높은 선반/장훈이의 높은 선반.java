import java.util.*;
import java.io.*;

public class Solution {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int t;
    private static int n;
    private static int b;
    private static int[] arr;
    private static boolean[] isSelected;
    private static int answer;

    private static void solveProblem() throws IOException {
        t = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= t; testCase++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            arr = new int[n];
            isSelected = new boolean[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            answer = Integer.MAX_VALUE;

            subSum(0, 0);
            System.out.println(String.format("#%d %d", testCase, answer));
        }
    }

    private static void subSum(int cnt, int sum) {
        if (sum >= b) {
            answer = Math.min(answer, sum - b);
        }

        if (cnt == n) {
            return;
        }

        isSelected[cnt] = true;
        subSum(cnt + 1, sum + arr[cnt]);
        isSelected[cnt] = false;
        subSum(cnt + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}