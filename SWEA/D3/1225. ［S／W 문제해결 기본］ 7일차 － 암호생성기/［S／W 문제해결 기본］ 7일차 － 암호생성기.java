import java.util.*;
import java.io.*;

public class Solution {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static Deque<Integer> deque;

    static void solveProblem() throws IOException {
        for (int testCase = 0; testCase < 10; testCase++) {
            int t = Integer.parseInt(br.readLine());
            deque = new ArrayDeque<>();
            String[] arr = br.readLine().split(" ");

            for (String temp : arr) {
                deque.add(Integer.parseInt(temp));
            }

            int i = 1;

            while (true) {
                if (i > 5) {
                    i = 1;
                }

                int current = deque.pollFirst();
                current -= i;
                if (current <= 0) {
                    deque.addLast(0);
                    break;
                } else {
                    deque.addLast(current);
                }
                i += 1;
            }

            sb.append("#").append(t).append(" ");
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
