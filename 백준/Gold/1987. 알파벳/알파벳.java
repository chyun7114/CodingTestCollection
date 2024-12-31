import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;

    // 지워도 되는 변수들
    static int n,m;
    static int[][] map;
    static boolean[] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[26];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for(int j = 0; j < m; j++){
                map[i][j] = temp.charAt(j) - 'A';
            }
        }

        dfs(0,0, 1);
        System.out.println(result);
    }

    static void dfs(int x, int y, int count){
        visited[map[x][y]] = true;
        result = Math.max(result, count);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if(!visited[map[nx][ny]]) {
                    dfs(nx, ny, count + 1);
                    // 백트래킹;;;
                    // 이전 값들 무효화 해야함;;;
                    visited[map[nx][ny]] = false;
                }
            }
        }
    }
}