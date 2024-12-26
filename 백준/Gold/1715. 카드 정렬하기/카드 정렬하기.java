import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    // 풀이용 변수
    static int n;
    static int result;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Integer.parseInt(st.nextToken()));
        }

        result = 0;

        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            result = result + a + b;
            pq.add(a + b);
        }

        System.out.println(result);

    }

}