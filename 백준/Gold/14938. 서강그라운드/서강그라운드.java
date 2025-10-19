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
    static int m;
    static int r;

    static List<Node>[] graph;
    static boolean[] visited;
    static int[] distances;
    static int[] items;

    static class Node implements Comparable<Node> {
        int end;
        int distance;

        public Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        items = new int[n + 1];
        distances = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, distance));
            graph[end].add(new Node(start, distance));
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dijkstra(i));
        }

        bw.write(String.valueOf(ans));
        bw.flush();

        br.close();
        bw.close();
    }

    static int dijkstra(int start) {
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        distances[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(!visited[node.end]) {
                visited[node.end] = true;

                for (Node next : graph[node.end]) {
                    if (!visited[next.end] && distances[next.end] > distances[node.end] + next.distance) {
                       distances[next.end] = distances[node.end] + next.distance;
                       pq.add(new Node(next.end, distances[next.end]));
                    }
                }
            }
        }

        int res = 0;

        for (int i = 1; i <= n; i++) {
            if (distances[i] <= m) {
               res += items[i];
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
