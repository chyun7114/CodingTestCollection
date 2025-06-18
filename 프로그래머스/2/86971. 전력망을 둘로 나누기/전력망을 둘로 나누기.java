import java.util.*;

class Solution {
    private int answer;
    public List<List<Integer>> graph;
    public boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        answer = 987654321;
        
        for(int i = 0; i < wires.length; i++){
            // 1번 2번 ... 쭉 끊어버리기
            bfs(i, n, wires);
        }
        
        return answer;
    }
    
    private void bfs(int idx, int n, int[][] wires){
        
        // 한번 탐색마다 그래프 새로 그리기
        graph = new ArrayList<>();
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < wires.length; i++){
            // 끊는 부분 설정하기
            if(idx == i)
                continue;
            
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph.get(a - 1).add(b - 1);
            graph.get(b - 1).add(a - 1);
        }
        
        // BFS 시작
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(0);
        visited[0] = true;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            List<Integer> list = graph.get(cur);
            
            for(int temp : list){
                if(!visited[temp]){
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }
        
        int e1 = 0;
        int e2 = 0;
        
        for(boolean temp : visited){
            if(temp) e1++;
            else e2++;
        }
        
        answer = Math.min(answer, Math.abs(e1 - e2));
    }
}