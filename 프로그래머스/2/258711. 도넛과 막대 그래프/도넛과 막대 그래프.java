import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {};
        
        Map<Integer, int[]> graph = new HashMap<>();
        
        int extraNode = -1;
        int donutGraph = 0;
        int stickGraph = 0;
        int eightGraph = 0;
        
        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            
            if(!graph.containsKey(from)){
                graph.put(from, new int[] {0, 0});
            }
            
            if(!graph.containsKey(to)) {
                graph.put(to, new int[] {0, 0});
            }
            
            // 나가는 간선(out)
            graph.get(from)[0]++;
            // 들어가는 간선(in)
            graph.get(to)[1]++;
        }
        
        for(int key : graph.keySet()) {
            int[] arr = graph.get(key);
            
            // 나가는 정점이 2개 이상 들어오는거 없는 경우 -> 생성된 정점
            if(arr[0] >= 2 && arr[1] == 0) {
                extraNode = key;
            }
            
            // 나가는 정점 0, 들어가는 정점 있는 경우 -> 막대 그래프
            if(arr[0] == 0 && arr[1] >= 0) {
                stickGraph++;
            }
            
            // 들어가는 정점, 나가는 정점 각 2개 이상인 경우 -> 8자 그래프
            if(arr[0] >= 2 && arr[1] >= 2) {
                eightGraph++;
            }
        }
        
        donutGraph = graph.get(extraNode)[0] - stickGraph - eightGraph;
        
        
        return new int[] {extraNode, donutGraph, stickGraph, eightGraph};
    }
}