import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    // 풀이용 변수
    static PriorityQueue<Integer> pq;
    static int n;

    static void solveProblem() throws IOException {
        pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());

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

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}