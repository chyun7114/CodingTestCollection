import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수
    static int t;
    static int n;
    static String[] arr;

    private static void solution() throws IOException {
        t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            n = Integer.parseInt(br.readLine());

            arr = new String[n];

            for(int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            Arrays.sort(arr, Comparator.naturalOrder());

            boolean flag = true;

            for(int i = 1; i < n; i++) {
                if(arr[i].startsWith(arr[i - 1])) {
                    flag = false;
                    break;
                }
            }

            System.out.println(flag ? "YES" : "NO");
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}