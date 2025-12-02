import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int s;
    static boolean[][] visited = new boolean[2001][2001];

    static void solveProblem() throws IOException {
        s = Integer.parseInt(br.readLine());
        bfs();
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        // 화면 이모티콘 수, 클립보드, 시간
        queue.add(new int[]{1, 0, 0});
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            int screen = temp[0];
            int clip = temp[1];
            int time = temp[2];

            if (screen == s) {
                System.out.println(time);
                return;
            }

            // 복사
            if (!visited[screen][screen]) {
                visited[screen][screen] = true;
                queue.add(new int[]{screen, screen, time + 1});
            }

            // 붙여 넣기
            if (clip > 0 && screen + clip <= 2000 && !visited[screen + clip][clip]) {
                visited[screen + clip][clip] = true;
                queue.add(new int[]{screen + clip, clip, time + 1});
            }

            // 삭제
            if (screen > 0 && !visited[screen - 1][clip]) {
                queue.add(new int[]{screen - 1, clip, time + 1});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
