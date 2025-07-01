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
    static Stack<Integer> stack;

    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        stack = new Stack<>();
        n = Integer.parseInt(br.readLine());
        int start = 0;

        while(n-- > 0){
            int value = Integer.parseInt(br.readLine());

            if(value > start){
                for(int i = start + 1; i <= value; i++){
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                start = value;
            }else if(stack.peek() != value){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
