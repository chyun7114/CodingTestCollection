import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수
    static int n, m;
    static Queue<Node> queue;
    static boolean[][] visited;
    static boolean isStarted;
    static int startX, startY;
    static int[][] graph;
    static int[][] distance;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int point = Integer.parseInt(st.nextToken());
                graph[i][j] = point;
                if(point == 2){
                    isStarted = true;
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    sb.append(-1 + " ");
                }else{
                    sb.append(distance[i][j] + " ");
                }
            }
            sb.append("\n");
        }
    }

    private static void bfs(int startX, int startY){
        queue = new LinkedList<>();
        visited[startX][startY] = true;
        distance[startX][startY] = 0;
        queue.add(new Node(startX, startY));
        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 4; i++){
                int newX = node.x + dx[i];
                int newY = node.y + dy[i];

                if(newX < 0 || newX >= n || newY < 0 || newY >= m){
                    continue;
                }

                if(!visited[newX][newY] && graph[newX][newY] == 1){
                    queue.add(new Node(newX, newY));
                    visited[newX][newY] = true;
                    distance[newX][newY] = distance[node.x][node.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(sb.toString());
    }
}