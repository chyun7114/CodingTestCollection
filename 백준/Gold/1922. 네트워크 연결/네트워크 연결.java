import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static PriorityQueue<Node> pq;
    static int n, m;

    private static class Node implements Comparable<Node> {
        private int end;
        private int cost;

        public Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        prim(1, n);
    }

    private static void prim(int start, int n) {
        visited = new boolean[n + 1];
        pq = new PriorityQueue<>();
        int total = 0;

        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            int end = node.end;
            int cost = node.cost;

            if(visited[end]) continue;

            visited[end] = true;
            total += cost;

            for(Node temp : graph[end]){
                if(!visited[temp.end])
                    pq.offer(temp);
            }
        }


        System.out.println(total);
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
