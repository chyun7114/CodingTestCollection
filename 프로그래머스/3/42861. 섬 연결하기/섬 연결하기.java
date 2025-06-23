import java.util.*;

// Kruskal Algorithm
class Solution {
    public int[] parent;
    
    public int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> (o1[2] - o2[2]));
        
        for(int[] cost : costs){
            if(find(cost[0]) != find(cost[1])){
                union(cost[0], cost[1]);
                answer += cost[2];
            }
        }
        return answer;
    }
}