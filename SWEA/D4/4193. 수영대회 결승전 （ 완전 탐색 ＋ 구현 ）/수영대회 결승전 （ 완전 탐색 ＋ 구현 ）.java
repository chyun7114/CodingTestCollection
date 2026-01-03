import java.util.*;
import java.io.*;

public class Solution {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int t;
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static int answer;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static Node start;
    private static Node destination;

    private static class Node {
        int x;
        int y;
        int depth;

        Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    private static void solveProblem() throws IOException {
        t = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= t; testCase++) {
            n = Integer.parseInt(br.readLine().trim());

            map = new int[n][n];
            visited = new boolean[n][n];
            answer = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            st = new StringTokenizer(br.readLine());
            destination = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            boolean success = bfs();

            System.out.print(String.format("#%d ", testCase));
            if (!success) {
                System.out.println("-1");
            } else {
                System.out.println(answer);
            }
        }
    }

    private static boolean bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start.x, start.y, start.depth));
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if(curNode.x == destination.x && curNode.y == destination.y) {
                answer = Math.min(answer, curNode.depth);
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                // 장애물이거나 방문한곳은 다시 못감
                if (map[nx][ny] == 1 || visited[nx][ny]) {
                    continue;
                }

                // 소용돌이는 3초 주기로 이동 가능
                if (map[nx][ny] == 2) {
                    if (curNode.depth % 3 == 2) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny, curNode.depth + 1));
                    } else {
                        // 소용돌이가 있으면 그 자리에서 기다리기
                        visited[curNode.x][curNode.y] = true;
                        queue.add(new Node(curNode.x, curNode.y, curNode.depth + 1));
                    }
                } else {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, curNode.depth + 1));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}