import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int k;
    static int[] s, numbers;
    // 문제 풀이용 함수
    static void solveProblem() throws IOException {

        while(true) {
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            if(k == 0){
                break;
            }

            s = new int[k];
            numbers = new int[6];

            for(int i = 0; i < k; i++){
                s[i] = Integer.parseInt(st.nextToken());
            }

            lotto(0,0);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void lotto(int count, int start) throws IOException {
        if(count == 6) {
            for(int i = 0; i < 6; i++){
                sb.append(numbers[i] + " ");
            }

            sb.append("\n");
            return;
        }

        for(int i = start; i < k; i++){
            numbers[count] = s[i];
            lotto(count + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
