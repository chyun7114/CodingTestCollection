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
    static int[] arr;
    static int answer;

    private static void solution() throws IOException {
        t = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase < t; testCase++) {
            n = Integer.parseInt(br.readLine());

            arr = new int[n + 1];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int rank = Integer.parseInt(st.nextToken());
                arr[rank] = Integer.parseInt(st.nextToken());
            }

            answer = 1;
            int rating = arr[1];

            for(int i = 2; i <= n; i++) {
                if(rating > arr[i]) {
                    answer++;
                    rating = arr[i];
                }
            }

            sb.append(answer).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(sb.toString());
    }
}