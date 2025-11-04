import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int[][] map;
    static int r;
    static int c;
    static int t;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<Integer> cleaner = new ArrayList<>();

    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == -1) {
                    cleaner.add(i);
                }
                map[i][j] = temp;
            }
        }

        while (t > 0) {
            dustDiffusion();
            operateAirPurifier();
            t--;
        }

        System.out.println(count());
    }

    static void dustDiffusion() {
        int[][] tmp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int dust = map[i][j];

                if (dust <= 0) {
                    continue;
                }

                int diffusedDust = dust / 5;
                int count = 0;

                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == -1) {
                        continue;
                    }

                    tmp[nx][ny] += diffusedDust;
                    count++;
                }
                tmp[i][j] += map[i][j] - (diffusedDust * count);
            }
        }

        for (int i = 0; i < 2; i++) {
            int x = cleaner.get(i);
            tmp[x][0] = -1;
        }

        map = tmp;
    }

    static void operateAirPurifier() {
        int topPos = cleaner.get(0);
        int downPos = cleaner.get(1);

        // 위쪽 (반시계)
        for (int i = topPos - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < topPos; i++) {
            map[i][c - 1] = map[i + 1][c - 1];
        }
        for (int i = c - 1; i > 1; i--) {
            map[topPos][i] = map[topPos][i - 1];
        }
        map[topPos][1] = 0;

        // 아래쪽 (시계)
        for (int i = downPos + 1; i < r - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            map[r - 1][i] = map[r - 1][i + 1];
        }
        for (int i = r - 1; i > downPos; i--) {
            map[i][c - 1] = map[i - 1][c - 1];
        }
        for (int i = c - 1; i > 1; i--) {
            map[downPos][i] = map[downPos][i - 1];
        }
        map[downPos][1] = 0;
    }

    static int count() {
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != -1) {
                    sum += map[i][j];
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
