import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int l, c;
    static char[] chars, codes;

    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        chars = new char[c];
        codes = new char[l];

        String inputLine = br.readLine();
        if (inputLine == null) {
            return; // 입력이 없을 경우 예외 방지
        }
        st = new StringTokenizer(inputLine);

        for(int i = 0; i < c; i++){
            if (!st.hasMoreTokens()) return; // 토큰이 부족하면 예외 방지
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);
        makeCode(0, 0);
    }

    public static void makeCode(int x, int index){
        if(index == l){
            if(checkCode()){
                System.out.println(new String(codes)); // char[]을 문자열로 변환하여 출력
            }
            return;
        }

        for(int i = x; i < c; i++){
            codes[index] = chars[i];
            makeCode(i + 1, index + 1);
        }
    }

    public static boolean checkCode(){
        int m = 0, j = 0;
        for(char x : codes){
            if ("aeiou".indexOf(x) >= 0) {
                m++;
            } else {
                j++;
            }
        }
        return m >= 1 && j >= 2;
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
