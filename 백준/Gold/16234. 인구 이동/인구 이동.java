import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수
    static int n;
    static int l;
    static int r;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Node> list;

    private static void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }

    private static int move() {
        int result = 0;

        while (true) {
            boolean isMove = false;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            changePopulation(sum, list);
                            isMove = true;
                        }
                    }
                }
            }

            if (!isMove) {
                return result;
            }
            result++;
        }
    }

    private static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        list = new ArrayList<>();

        queue.offer(new Node(x, y));
        list.add(new Node(x, y));
        visited[x][y] = true;

        int sum = arr[x][y];

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int curX = curNode.x;
            int curY = curNode.y;

            for (int i = 0; i < dx.length; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(arr[curX][curY] - arr[nx][ny]);
                    if (l <= diff && diff <= r) {
                        queue.offer(new Node(nx, ny));
                        list.add(new Node(nx, ny));
                        sum += arr[nx][ny];
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return sum;
    }

    private static void changePopulation(int sum, List<Node> list) {
        int population = sum / list.size();

        for (Node node : list) {
            arr[node.x][node.y] = population;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}