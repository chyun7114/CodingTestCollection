import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 풀이용 변수
    static Queue<Integer> truckList;
    static int n;   // 다리를 건너려는 트럭의 수
    static int w;   // 다리의 길이
    static int l;   // 다리의 최대 하중

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        truckList = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            truckList.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int nowWeight = 0;  // 현재 다리위에 있는 트럭의 무게
        Queue<Integer> nowInBridge = new LinkedList<>(); // 현재 다리위에 있는 트럭 정보
        for(int i = 0; i < w; i++){
            nowInBridge.add(0);
        }
        // 풀이 시작
        // 트럭이 모든 다리를 건널 때까지 루프를 돈다
        while(!nowInBridge.isEmpty()){
            time++;
            nowWeight -= nowInBridge.poll();

            if(!truckList.isEmpty()){
                // 만약 다음 트럭이 다리 위에 올라 갈 수 있다고 하자.
                // 그러면 지금 올라가는 트럭의 무게와 현재 다리 하중을 더한것이 최대하중보다 작거나 같아야함
                if(truckList.peek() + nowWeight <= l){
                    nowWeight += truckList.peek();
                    nowInBridge.add(truckList.poll());
                }
                // 만약 그렇지 않다면
                // 트럭이 못 올라간것이니 그저 다리 무게에 0을 더해준다.
                // 이러면 단위 시간 1마다 트럭이 이동하는 것을 구현이 가능함
                else{
                    nowInBridge.add(0);
                }
            }
        }

        System.out.println(time);
    }

}