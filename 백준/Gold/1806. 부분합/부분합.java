import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수
    static int n;
    static int s;

    private static void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        while (start <= end && start <= n) {
            if(sum >= s) {
                result = Math.min(result, end - start);
                sum -= arr[start++];
            } else if(end == n) {
                break;
            } else {
                sum += arr[end++];
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}