import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static Stack<Tower> stack = new Stack<>();
    static int[] arr;
    static int n;

    static class Tower {
        private int idx;
        private int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty()){
                if(stack.peek().height >= arr[i]){
                    sb.append((stack.peek().idx + 1) + " ");
                    break;
                }

                stack.pop();
            }

            if(stack.isEmpty()){
                sb.append("0 ");
            }

            stack.push(new Tower(i, arr[i]));
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
