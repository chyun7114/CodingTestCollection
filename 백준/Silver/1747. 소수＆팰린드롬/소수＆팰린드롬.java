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

    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());

        if(n == 1){
            System.out.println(2);
            System.exit(0);
        }

        while(true){
            if(isPalindrome(n) && isPrime(n)) {
                System.out.println(n);
                break;
            }

            n++;
        }
    }

    private static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPalindrome(int n) {
        String word = String.valueOf(n);

        for(int i = 0; i < word.length() / 2; i++) {
            if(word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
