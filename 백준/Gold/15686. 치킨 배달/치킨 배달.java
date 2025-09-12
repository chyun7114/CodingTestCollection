import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static int[][] map;
    static ArrayList<Point> chicken;
    static ArrayList<Point> home;
    static boolean[] open;
    static int ans;

    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        chicken = new ArrayList<>();
        home = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    home.add(new Point(i, j));
                }else if (map[i][j] == 2){
                    chicken.add(new Point(i, j));
                }
            }
        }

        open = new boolean[chicken.size()];

        ans = Integer.MAX_VALUE;
        dfs(0,0);
        System.out.println(ans);
    }

    private static void dfs(int start, int cnt){
        if(cnt == m){
            int res = 0;

            for(int i = 0; i < home.size(); i++){
                int temp = Integer.MAX_VALUE;

                // 치킨거리를 구하기
                for(int j = 0; j < chicken.size(); j++){
                    if(open[j]){
                        int distance = getChickenDistance(home.get(i), chicken.get(j));
                        temp = Math.min(temp, distance);
                    }
                }

                res += temp;
            }

            ans = Math.min(ans, res);
            return;
        }

        for(int i = start; i < chicken.size(); i++) {
            // 백트래킹 -> 열어보고 아니면 닫아버려
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }

    private static int getChickenDistance(Point home, Point chicken) {
        return Math.abs(chicken.x - home.x) + Math.abs(chicken.y - home.y);
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
