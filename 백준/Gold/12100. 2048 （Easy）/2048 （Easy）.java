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
    static int n;
    static int ans = 0;
    static boolean[][] check;

    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int count) {
        if(count == 5) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    ans = Math.max(ans, map[i][j]);
                }
            }
            return;
        }

        int[][] originalArr = new int[n][n];

        // 백트래킹을 위한 복사
        for(int i = 0; i < n; i++) {
            originalArr[i] = map[i].clone();
        }

         for(int i = 0; i < 4; i++) {
             // 이동
             move(map, i);
             dfs(count + 1);
             // 백트래킹
             for(int j = 0; j < n; j++) {
                 map[j] = originalArr[j].clone();
             }
         }
    }

    private static void move(int[][] map, int d) {
        check = new boolean[n][n];

        if(d == 0) { // 위
            for(int j = 0; j < n; j++) { // 열 기준
                for(int i = 1; i < n; i++) { // 두 번째 행부터 위로 이동
                    if(map[i][j] != 0) {
                        int r = i, c = j;
                        while(r > 0 && map[r-1][c] == 0) {
                            map[r-1][c] = map[r][c];
                            map[r][c] = 0;
                            r--;
                        }
                        if(r > 0 && map[r-1][c] == map[r][c] && !check[r-1][c]) {
                            map[r-1][c] *= 2;
                            map[r][c] = 0;
                            check[r-1][c] = true;
                        }
                    }
                }
            }
        } else if(d == 1) { // 아래
            for(int j = 0; j < n; j++) { // 열 기준
                for(int i = n-2; i >= 0; i--) { // 끝에서 두 번째 행부터 아래로 이동
                    if(map[i][j] != 0) {
                        int r = i, c = j;
                        while(r < n-1 && map[r+1][c] == 0) {
                            map[r+1][c] = map[r][c];
                            map[r][c] = 0;
                            r++;
                        }
                        if(r < n-1 && map[r+1][c] == map[r][c] && !check[r+1][c]) {
                            map[r+1][c] *= 2;
                            map[r][c] = 0;
                            check[r+1][c] = true;
                        }
                    }
                }
            }
        } else if(d == 2) { // 왼쪽
            for(int i = 0; i < n; i++) { // 행 기준
                for(int j = 1; j < n; j++) { // 두 번째 열부터 왼쪽으로 이동
                    if(map[i][j] != 0) {
                        int r = i, c = j;
                        while(c > 0 && map[r][c-1] == 0) {
                            map[r][c-1] = map[r][c];
                            map[r][c] = 0;
                            c--;
                        }
                        if(c > 0 && map[r][c-1] == map[r][c] && !check[r][c-1]) {
                            map[r][c-1] *= 2;
                            map[r][c] = 0;
                            check[r][c-1] = true;
                        }
                    }
                }
            }
        } else if(d == 3) { // 오른쪽
            for(int i = 0; i < n; i++) { // 행 기준
                for(int j = n-2; j >= 0; j--) { // 끝에서 두 번째 열부터 오른쪽으로 이동
                    if(map[i][j] != 0) {
                        int r = i, c = j;
                        while(c < n-1 && map[r][c+1] == 0) {
                            map[r][c+1] = map[r][c];
                            map[r][c] = 0;
                            c++;
                        }
                        if(c < n-1 && map[r][c+1] == map[r][c] && !check[r][c+1]) {
                            map[r][c+1] *= 2;
                            map[r][c] = 0;
                            check[r][c+1] = true;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
