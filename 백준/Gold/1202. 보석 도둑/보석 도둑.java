import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int n, k;
    private static Gem[] gems;
    private static int[] bags;
    private static long answer = 0;

    private static class Gem{
        int weight;
        int cost;

        public Gem(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }
    }

    private static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        gems = new Gem[n];
        bags = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            gems[i] = new Gem(weight, cost);
        }

        Arrays.sort(gems, new Comparator<Gem>() {
            @Override
            public int compare(Gem o1, Gem o2) {
                if(o1.weight == o2.weight) {
                    return o2.cost - o1.cost;
                } else {
                    return o1.weight - o2.weight;
                }
            }
        });

        for(int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        PriorityQueue<Integer> costHeap = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for(int i = 0; i < bags.length; i++) {
            while(j < n && gems[j].weight <= bags[i]){
                costHeap.offer(gems[j++].cost);
            }

            if(!costHeap.isEmpty()) {
                answer += costHeap.poll();
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}