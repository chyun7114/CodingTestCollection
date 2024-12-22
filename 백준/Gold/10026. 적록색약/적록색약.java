import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;

    // 지워도 되는 변수들
    static Character[][] map;
    static boolean[][] visited;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new Character[n][n];
        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        visited = new boolean[n][n];
        int normalCount = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                    normalCount++;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 'G'){
                    map[i][j] = 'R';
                }
            }
        }

        visited = new boolean[n][n];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(normalCount + " " + count);
    }

    static void bfs(int x, int y){
        visited[x][y] = true;
        char nowColor = map[x][y];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                    continue;
                }

                if(nowColor == map[nx][ny] && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

    }

}