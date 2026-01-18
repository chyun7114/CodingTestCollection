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

    static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;

        int min = Integer.MAX_VALUE;

        int[] res = new int[2];

        while(start < end) {
            int sum = arr[start] + arr[end];

            if(min > Math.abs(sum)) {
                min = Math.abs(sum);

                res[0] = arr[start];
                res[1] = arr[end];

                if(sum == 0) {
                    break;
                }

            }

            if(sum < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(res[0] + " " + res[1]);
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
