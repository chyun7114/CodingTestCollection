import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;

    // 지워도 되는 변수들
    static int[][] paint;
    static int[][] DP;
    static int red = 0;
    static int green = 1;
    static int blue = 2;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        paint = new int[n][3];
        DP = new int[n][3];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                paint[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DP[0][red] = paint[0][red];
        DP[0][green] = paint[0][green];
        DP[0][blue] = paint[0][blue];


        System.out.println(Math.min(getDPTable(n - 1, red),Math.min(getDPTable(n - 1, green), getDPTable(n - 1, blue))));
    }

    static int getDPTable(int n, int color){
        if(DP[n][color] == 0) {

            if(color == red){
                DP[n][red] = paint[n][red] + Math.min(getDPTable(n - 1, green), getDPTable(n - 1,blue));
            }
            else if(color == blue){
                DP[n][blue] = paint[n][blue] + Math.min(getDPTable(n - 1, red), getDPTable(n - 1, green));
            }
            else {
                DP[n][green] = paint[n][green] + Math.min(getDPTable(n - 1, red), getDPTable(n - 1, blue));
            }
        }

        return DP[n][color];
    }
}