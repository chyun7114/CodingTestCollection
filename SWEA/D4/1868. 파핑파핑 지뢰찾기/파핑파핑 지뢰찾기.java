import java.util.*;
import java.io.*;

public class Solution {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int n;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};
    private static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
    private static int answer;

    private static void solveProblem() throws IOException {
        int t = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= t; testCase++) {
            n = Integer.parseInt(br.readLine());

            map = new char[n][n];
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                String st = br.readLine().trim();
                for (int j = 0; j < n; j++) {
                    map[i][j] = st.charAt(j);
                }
            }

            answer = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 가장 최소로 눌러야하므로 0을 제일 먼저 눌러서 주변 8칸을 오픈한다
                    // 연쇄적으로 오픈을 구현하기 위해서 BFS를 활용하여 0 -> 0이 되는 경우 다음 칸을 오픈 하도록 한다.
                    if (!visited[i][j] && map[i][j] != '*' && checkBombCount(i, j) == 0) {
                        answer += 1;
                        bfs(i, j);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '.') {
                        map[i][j] = (char)(checkBombCount(i, j) + '0');
                        visited[i][j] = true;
                        answer += 1;
                    }
                }
            }

            System.out.println(String.format("#%d %d", testCase, answer));
        }
    }

    private static int checkBombCount(int x, int y) {
        int count = 0;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] == '*') {
                    count += 1;
                }
            }
        }

        return count;
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int curX = curPos[0];
            int curY = curPos[1];

            int bombCount = checkBombCount(curX, curY);
            map[curX][curY] = (char) (bombCount + '0');

            if (bombCount > 0) {
                continue;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && map[nx][ny] != '*') {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}