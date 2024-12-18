import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    // 풀이용 변수
    static int t;               // 테스트 케이스 개수
    static String func;         // 함수 문자열
    static int n;               // 배열 원소의 개수
    static String[] arrString;    // [1,2,3]
    static ArrayDeque<Integer> deque;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            func = br.readLine();
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            commandAC(func, deque);
        }
    }

    public static void commandAC(String func, ArrayDeque<Integer> deque) {
        boolean isRight = false;

        for(int i = 0; i < func.length(); i++) {
            char cmd = func.charAt(i);

            // 직접 배열을 뒤집으면 시간초과가 난다...
            // 그러므로 방향만 뒤집어준다.

            if(cmd == 'R'){
                isRight = !isRight;
                continue;
            }

            // D가 오는 경우
            // 일단 방향부터 탐구
            if(isRight){
                if(deque.pollLast() == null){
                    System.out.println("error");
                    return;
                }
            }else{
                if(deque.pollFirst() == null){
                    System.out.println("error");
                    return;
                }
            }
        }
        // 오른쪽 출력
        if(isRight){
            System.out.print("[");
            while(!deque.isEmpty()){
                System.out.print(deque.pollLast());
                if(!deque.isEmpty()){
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }else{
            System.out.print("[");
            while(!deque.isEmpty()){
                System.out.print(deque.pollFirst());
                if(!deque.isEmpty()){
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }
}