import java.util.*;
import java.io.*;

public class Solution {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int n;
    static int m;
    static int k;

    static PriorityQueue<Integer> waiting;
    static int bread;

    static void solveProblem() throws IOException {

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            waiting = new PriorityQueue<>();


            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                waiting.offer(Integer.parseInt(st.nextToken()));
            }

            bread = 0;
            int curTime = 0;
            String result = "Possible";

            while(!waiting.isEmpty()) {
                int next = waiting.peek();

                bread += (next / m) * k - (curTime / m) * k;

                curTime = next;

                if (bread < 1) {
                    result = "Impossible";
                    break;
                }

                waiting.poll();
                bread--;
            }
            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
