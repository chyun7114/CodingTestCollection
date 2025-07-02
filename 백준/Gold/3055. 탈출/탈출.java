import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수
    static int r, c;
    static char[][] map;
    static Queue<int[]> waterQueue;
    static Queue<int[]> kaktusQueue;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static final char WATER = '*';
    static final char KAKTUS = 'S';
    static final char FINAL = 'D';
    static final char STONE = 'X';
    static final char EMPTY_SPACE = '.';

    private static void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        waterQueue = new LinkedList<>();
        kaktusQueue = new LinkedList<>();

        for(int i = 0; i < r; i++) {
            String line = br.readLine();
            for(int j = 0; j < c; j++) {
                char cur = line.charAt(j);
                if(cur == WATER) {
                    // 물의 위치
                    waterQueue.add(new int[]{i, j});
                }else if(cur == KAKTUS) {
                    // 고슴도치 시작점
                    kaktusQueue.add(new int[]{i, j, 0});
                }
                map[i][j] = cur;
            }
        }

        bfs();
        System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS" : answer);
    }

    private static void bfs() throws IOException {
        while(!kaktusQueue.isEmpty()) {
            // 물을 퍼뜨리자
            int waterLen = waterQueue.size();
            for(int i = 0; i < waterLen; i++){
                int[] temp = waterQueue.poll();
                int x = temp[0];
                int y = temp[1];

                for(int j = 0; j < 4; j++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] == EMPTY_SPACE) {
                        // 빈 공간으로 물이 퍼진다.
                        map[nx][ny] = WATER;
                        waterQueue.add(new int[]{nx, ny});
                    }
                }
            }

            // 고슴도치가 움직인다.
            int kaktusLen = kaktusQueue.size();
            for(int i = 0; i < kaktusLen; i++){
                int[] temp = kaktusQueue.poll();
                int x = temp[0];
                int y = temp[1];
                int time = temp[2];

                for(int j = 0; j < 4; j++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(nx >= 0 && ny >= 0 && nx < r && ny < c) {
                        if(map[nx][ny] == FINAL) {
                            answer = Math.min(answer, time + 1);
                            return;
                        }else if(map[nx][ny] == EMPTY_SPACE) {
                            map[nx][ny] = KAKTUS;
                            kaktusQueue.add(new int[]{nx, ny, time + 1});
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(sb.toString());
    }
}