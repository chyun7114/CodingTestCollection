import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int n, c;
    static int[] home;

    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        home = new int[n];

        for(int i = 0; i < n; i++){
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int low = 1;
        int high = home[n - 1] - home[0] + 1;

        // 이분 탐색으로 인접한 공유기 사이 거리가 최대가 되도록 찾는다.
        while(low < high){
            int mid = (low + high) / 2;

            if(install(mid) >= c) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        System.out.println(low - 1);
    }

    private static int install(int distance) {
        int count = 1;
        int lastLocate = home[0];

        for(int i = 1; i < home.length; i++) {
            int locate = home[i];

            // 설치가 가능한 경우
            if(locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
