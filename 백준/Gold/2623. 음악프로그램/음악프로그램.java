import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int n, m;
    static ArrayList<HashSet<Integer>> graph;
    static int[] count;

    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        count = new int[n + 1];
        Arrays.fill(count, 0);

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            if (size == 0) {
                continue;
            }

            int firstSinger = Integer.parseInt(st.nextToken());
            for (int j = 1; j < size; j++) {
                int currentSinger = Integer.parseInt(st.nextToken());
                if (!graph.get(firstSinger).contains(currentSinger)) {
                    graph.get(firstSinger).add(currentSinger);
                    count[currentSinger]++;
                }
                firstSinger = currentSinger;
            }
        }

        Queue<Integer> result = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.offer(cur);
            for (int next : graph.get(cur)) {
                count[next]--;
                if (count[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (result.size() != n) {
            sb.append("0\n");
        } else {
            while (!result.isEmpty()) {
                sb.append(result.poll());
                sb.append("\n");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
