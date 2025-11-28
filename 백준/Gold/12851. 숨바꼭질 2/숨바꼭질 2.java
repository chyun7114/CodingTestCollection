import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int n;
    static int k;

    static int[] time = new int[1000001];
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;

    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println((n - k) + "\n1");
            return;
        }

        bfs();
        System.out.println(minTime);
        System.out.println(count);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(n);
        time[n] = 1;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(minTime < time[cur]) return;

            for(int i = 0; i < 3; i++) {
                int next;

                if(i == 0) next = cur + 1;
                else if (i == 1) next = cur - 1;
                else next = cur * 2;

                if(next < 1 || next > 1000000) continue;

                if(next == k) {
                    minTime = time[cur];
                    count++;
                }

                if(time[next] == 0 || time[next] == time[cur] + 1) {
                    queue.offer(next);
                    time[next] = time[cur] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
