import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 지워도 되는 변수
    static class Node{
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static int n, m;
    static PriorityQueue<Node> pq;
    static int[] parent;
    static int result = 0;
    // 문제 풀이 함수
    static void solveProblem() throws IOException {
        pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            parent[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end, cost));
        }

        MST();

        System.out.println(result);
    }

    static void MST(){
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(find(node.start) != find(node.end)){
                result += node.cost;
                union(node.start, node.end);
            }

        }
    }

    // 현재 정점의 부모를 찾는 함수
    static int find(int v){
        if(parent[v] == v)
            return v;
        return parent[v] = find(parent[v]);
    }

    static void union(int v1, int v2){
        v1 = find(v1);
        v2 = find(v2);

        if(v1 < v2){
            parent[v2] = v1;
        }else{
            parent[v1] = v2;
        }
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
