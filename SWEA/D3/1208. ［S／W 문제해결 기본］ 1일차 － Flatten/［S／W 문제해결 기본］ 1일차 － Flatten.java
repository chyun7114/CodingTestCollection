import java.util.*;
import java.io.*;

public class Solution {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;

    static void solveProblem() throws IOException {
        for (int testCase = 1; testCase <= 10; testCase++) {
            int dump = Integer.parseInt(br.readLine());
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

            String[] arr = br.readLine().split(" ");
            for(String s : arr) {
                minHeap.offer(Integer.parseInt(s));
                maxHeap.offer(Integer.parseInt(s));
            }

            for(int i = 0; i < dump; i++) {
                int min = minHeap.poll();
                int max = maxHeap.poll();

                min += 1;
                max -= 1;

                minHeap.offer(min);
                maxHeap.offer(max);
            }

            int result = maxHeap.peek() - minHeap.peek();

            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
