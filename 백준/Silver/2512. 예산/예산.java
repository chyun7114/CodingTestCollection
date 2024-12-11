import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 시작
        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] payroll = new int[n];
        for(int i = 0; i < n; i++) {
            payroll[i] = Integer.parseInt(tmp[i]);
        }

        int allPayroll = Integer.parseInt(br.readLine());
        // 종료

        if(Arrays.stream(payroll).sum() < allPayroll) {
            System.out.println(Arrays.stream(payroll).max().getAsInt());
        } else {
            int answer = computePayroll(payroll, allPayroll);
            System.out.println(answer);
        }
    }

    public static int computePayroll(int[] payArr, int allPayroll) {
        int start = 1;
        int end = Arrays.stream(payArr).max().getAsInt();

        while(start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            for(int i = 0; i < payArr.length; i++) {
                sum += Math.min(payArr[i], mid);
            }
            if(sum > allPayroll) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return end;
    }
}