import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;
    static int[] resultArr;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        // 1번 컴퓨터 부터 그래프 저장 하기
        graph = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }

        // 정답 값 저장 리스트
        resultArr = new int[n + 1];

        // 각 컴퓨터 탐색 진행
        // 각 컴퓨터 마다 count 반환
        for(int i = 1; i < n + 1; i++) {
            // 방문 여부는 다시 생성
            visited = new boolean[n + 1];
            dfs(i);
        }

        // 최대 크기 구하기
        int max = 0;
        for(int i = 1; i < n + 1; i++){
            if(max < resultArr[i]){
                max = resultArr[i];;
            }
        }

        for(int i = 1; i < n + 1; i++){
            if(max == resultArr[i])
                System.out.print(i + " ");
        }
    }

    public static void dfs(int start){
        visited[start] = true;
        for(int next : graph[start]){
            if(visited[next])
                continue;

            resultArr[next]++;
            dfs(next);
        }
    }
}