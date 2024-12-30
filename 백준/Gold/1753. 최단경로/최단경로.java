import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;

    // 지워도 되는 변수들
    static final int INF = 100000000;
    static int v, e, k;
    static List<Node>[] graph;
    static int[] dist;
    static class Node implements Comparable<Node>{
        int end;
        int cost;

        public Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        graph = new List[v + 1];
        dist = new int[v + 1];
        Arrays.fill(dist, INF);

        for(int i = 1; i <= v; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }

        dijkstra(k);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= v; i++){
            if(dist[i] == INF)
                sb.append("INF\n");
            else
                sb.append(dist[i]).append("\n");
        }


        System.out.print(sb);
    }

    static void dijkstra(int start){
        // 다익스트라 알고리즘을 수행한다.
        // 다익스트라 알고리즘 = BFS + DP + 그리디라고 생각한다.
        
        // 우선순위 큐를 쓰는 이유 -> 더 가까운 거리를 먼저 확인하기 위해서
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[v + 1];

        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            // BFS 와 동일하게 동작
            Node curNode = queue.poll();
            int cur = curNode.end;

            if(check[cur])  continue;
            check[cur] = true;

            // 연결된 정점들을 모두 확인
            for(Node node : graph[cur]){
                if(dist[node.end] > dist[cur] + node.cost){
                    // 더 최단거리라면 -> 값을 업데이트하자
                    dist[node.end] = dist[cur] + node.cost;

                    // 그 후 큐에 추가 -> 방문처리
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}