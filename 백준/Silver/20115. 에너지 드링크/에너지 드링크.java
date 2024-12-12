import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] temps = br.readLine().split(" ");
        double[] drinks = new double[n];

        for(int i = 0; i < n; i++){
            drinks[i] = Double.parseDouble(temps[i]);
        }

        Arrays.sort(drinks);
        double answer = drinks[drinks.length - 1];
        for(int i = 0; i < n - 1; i++){
            answer += drinks[i] / 2;
        }

        System.out.println(answer);
    }
}