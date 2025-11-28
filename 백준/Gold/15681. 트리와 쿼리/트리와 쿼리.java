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
    static int r;
    static int q;

    static List<Integer>[] graph;
    static List<Integer>[] tree;
    static int[] parent;
    static int[] size;

    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        tree = new ArrayList[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
            parent[i] = -1;
            size[i] = 0;
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }


        makeTree(r, -1);
        countSubTree(r);

        for(int i = 0; i < q; i++) {
            System.out.println(size[Integer.parseInt(br.readLine())]);
        }
    }

    static void makeTree(int curNode, int p) {
        for(int node : graph[curNode]) {
            if(node != p) {
                tree[curNode].add(node);
                parent[node] = curNode;
                makeTree(node, curNode);
            }
        }
    }

    static void countSubTree(int curnode) {
        size[curnode] = 1;

        for(int node : tree[curnode]) {
            countSubTree(node);
            size[curnode] += size[node];
        }
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
