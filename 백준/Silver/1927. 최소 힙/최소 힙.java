import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수
    static PriorityQueue<Integer> pq;
    static int n;

    private static void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int temp = Integer.parseInt(st.nextToken());

            if(temp == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                pq.offer(temp);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(sb.toString());
    }
}