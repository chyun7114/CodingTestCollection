import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    // 알고리즘 풀이용 static 변수
    static int[][] map;
    static boolean[][] visited;
    static int[][] countArr;
    static int pictureArea;
    static int maxPictureArea = 0;
    static int pictureCount = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 그래프
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 풀이 시작

        // 모든 정점에 대해서 방문할 예정
        // 만약 방문하는 정점이 1인 경우에 dfs or bfs 탐색 시작
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // 먼저 그림의 개수를 구할 수 있는지 확인
                if(map[i][j] == 1 && !visited[i][j]) {
                    // dfs 시작전
                    pictureArea = 0;

                    // dfs
                    // dfs(i, j);

                    // bfs
                    bfs(i, j);
                    // 탐색 종료 후 그림 개수 1증가
                    pictureCount++;

                    // 가장 넓이가 큰 영역 반환
                    if(maxPictureArea < pictureArea){
                        maxPictureArea = pictureArea;
                    }
                }
            }
        }

        System.out.println(pictureCount);
        System.out.println(maxPictureArea);
    }

    private static void dfs(int x, int y){
        // 방문 여부 체크
        visited[x][y] = true;

        // 색칠 될 때마다 넓이를 1씩 올린다.
        pictureArea++;

        for(int i = 0; i < dx.length; i++){
            // 상하좌우 체크
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 만약 값이 입력 영역을 넘어간 경우
            if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
                continue;

            // 색이 칠해져 있고 아직 방문하지 않은 경우
            if(map[nx][ny] == 1 && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
    }

    private static void bfs(int x, int y){
        visited[x][y] = true;
        pictureArea++;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i = 0; i < dx.length; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
                    continue;

                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    pictureArea++;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
