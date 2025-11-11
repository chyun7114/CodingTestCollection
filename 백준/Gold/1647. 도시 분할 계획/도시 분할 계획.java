import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static class Node implements Comparable<Node> {
        int start, end, value;

        //A_idx, b_idx : 연결된 집 정보, value : 유지비
        public Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        //유지비 기준 오름차순
        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    static int n;
    static int m;
    static int[] parent;
    static ArrayList<Node> graph;

    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph.add(new Node(start, end, value));
        }

        Collections.sort(graph);

        int sum = 0;
        int max = -1;

        for(Node node : graph) {
            if(find(node.start) != find(node.end)) {
                union(node.start, node.end);
                sum += node.value;
                max = Math.max(max, node.value);
            }
        }

        sum -= max;
        bw.write(String.valueOf(sum));
        bw.flush();
        br.close();
        bw.close();
    }

    static int find(int a) {
        if(parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa <= pb)
            parent[pb] = parent[pa];
        else
            parent[pa] = parent[pb];
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}