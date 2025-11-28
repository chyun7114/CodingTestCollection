import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int n;
    static long m;

    static int[][] arr;

    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % 1_000;
            }
        }

        int[][] result = pow(arr, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int[][] pow(int[][] arr, long m) {
        if (m == 1) {
            return arr;
        }

        int[][] ret = pow(arr, m / 2);

        ret = multiply(ret, ret);

        if (m % 2 == 1) {
            ret = multiply(ret, arr);
        }

        return ret;
    }

    static int[][] multiply(int[][] o1, int[][] o2) {
        int[][] ret = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= 1_000;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
