import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨

    static void solveProblem() throws IOException {
        String s = br.readLine();
        String bomb = br.readLine();

        int bombLength = bomb.length();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if (sb.length() >= bombLength) {
                boolean match = true;

                for (int j = 0; j < bombLength; j++) {
                    if (sb.charAt(sb.length() - bombLength + j) != bomb.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    sb.delete(sb.length() - bombLength, sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
