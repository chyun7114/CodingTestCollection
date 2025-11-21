import java.util.*;
import java.io.*;

public class Solution {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static class Node implements Comparable<Node> {
        int start;
        int end;
        int distance;

        Node(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n) {
            if (this.distance > n.distance) {
                return 1;
            } else if (this.distance < n.distance) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;
    static boolean[][] visited;
    static int min;
    static int[][] ans;
    static int n;

    static void solveProblem() throws IOException {

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            min = Integer.MAX_VALUE;
            visited = new boolean[n][n];

            ans = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(ans[i], Integer.MAX_VALUE);
            }

            ans[0][0] = 0;

            bfs(0, 0);

            sb.append("#").append(testCase).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void bfs(int x, int y) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.offer(new Node(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int a = node.start;
            int b = node.end;
            int dis = node.distance;

            if (a == n - 1 && b == n - 1) {
                min = Math.min(min, dis);
            }

            if (min <= dis) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    int nDistance = dis + map[nx][ny];

                    if (!visited[nx][ny] || nDistance < ans[nx][ny]) {
                        visited[nx][ny] = true;
                        ans[nx][ny] = nDistance;
                        queue.offer(new Node(nx, ny, dis + map[nx][ny]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
