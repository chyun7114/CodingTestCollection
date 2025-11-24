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
    static int[] arr;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < operator.length; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);

        sb.append(max).append("\n").append(min);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int num, int depth) {
        if (depth == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);

            return;
        }

        for(int i = 0; i < operator.length; i++) {
            if(operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(num + arr[depth], depth + 1);
                        break;
                    case 1:
                        dfs(num - arr[depth], depth + 1);
                        break;
                    case 2:
                        dfs(num * arr[depth], depth + 1);
                        break;
                    case 3:
                        dfs(num / arr[depth], depth + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
