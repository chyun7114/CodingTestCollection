import java.awt.print.Pageable;
import java.io.*;
import java.time.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수
    static int countTree;
    static int needTree;
    static long[] trees;
    static long answer;
    private static void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        countTree = Integer.parseInt(st.nextToken());
        needTree = Integer.parseInt(st.nextToken());

        trees = new long[countTree];
        st = new StringTokenizer(br.readLine());

        long left = 0;
        long right = 0;

        for (int i = 0; i < countTree; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(right < trees[i]) {
                right = trees[i];
            }
        }

        while(left <= right){
            long mid = (left + right) / 2;
            long cut = 0;

            for(long tree : trees){
                if(tree > mid){
                    cut += tree - mid;
                }
            }

            if(cut >= needTree){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(answer);
    }
}