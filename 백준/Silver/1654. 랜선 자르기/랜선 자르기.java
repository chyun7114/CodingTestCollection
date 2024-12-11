import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        int k = Integer.parseInt(tmp[0]);
        int n = Integer.parseInt(tmp[1]);

        int[] lines = new int[k];
        long max = 0;

        for(int i = 0; i < k; i++){
            lines[i] = Integer.parseInt(br.readLine());
            if(max < lines[i]){
                max = lines[i];
            }
        }

        max++;

        long min = 0;
        long mid = 0;

        while(min < max){
            mid = (min + max) / 2;

            long count = 0;

            for (int line : lines) {
                count += (line / mid);
            }

            if(count < n){
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}