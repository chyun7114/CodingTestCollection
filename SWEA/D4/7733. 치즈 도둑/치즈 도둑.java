import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int n;
    static int[][] arr;
    static boolean[][] visited;

    static int maxTaste;

    static void solveProblem() throws IOException {

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];

            maxTaste = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    maxTaste = Math.max(maxTaste, arr[i][j]);
                }
            }

            int max = 1; // 아무것도 안 녹은 경우

            for (int day = 1; day <= maxTaste; day++) {
                visited = new boolean[n][n];
                int count = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (!visited[i][j] && arr[i][j] > day) {
                            bfs(i, j, day);
                            count++;
                        }
                    }
                }

                max = Math.max(max, count);
            }

            sb.append("#").append(testCase).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int i, int j, int day) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (!visited[nx][ny] && arr[nx][ny] > day) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
