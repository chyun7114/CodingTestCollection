import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;

    // 지워도 되는 변수들
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        StringBuilder s = new StringBuilder(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder t = new StringBuilder(st.nextToken());

        int result = 0;
        // 문자열 마지막이 A이면 A를 그냥 제거함
        // 문자열 마지막이 B이면 B를 제거후 문자열을 뒤집는다.
        while(s.length() < t.length()){
            if(t.charAt(t.length() - 1) == 'A'){
                t.deleteCharAt(t.length() - 1);
            }
            else if(t.charAt(t.length() - 1) == 'B'){
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }

        if(s.toString().equals(t.toString())){
            result = 1;
        }

        System.out.println(result);
    }


}