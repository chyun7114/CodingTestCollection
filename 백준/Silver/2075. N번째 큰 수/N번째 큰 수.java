import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(st.nextToken());
            pq.offer(temp);
        }

        // pq의 사이즈를 n으로 유지하면서 큐에 내용을 추가하자
        // 즉 큰놈은 집어넣고, 작은놈은 삭제하면서 내용을추가한다
        for(int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if(pq.peek() < temp){
                    pq.poll();
                    pq.offer(temp);
                }
            }
        }

        System.out.println(pq.poll());
    }
}