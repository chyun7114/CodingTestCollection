import java.util.*;

class Solution {
    
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        
        // 모든 조건을 생각하자
        for(int i = 0; i < info.length; i++) {
            dfs(info[i].split(" "), "", 0);
        }
        
        // 코테 점수에 맞춰서 오름차순 정렬
        for(ArrayList<Integer> list : map.values()) {
            Collections.sort(list);
        }
        
        answer = new int[query.length];
        
        for(int i = 0; i < query.length; i++) {
            answer[i] = find(query[i]);
        }
        
        return answer;
    }
    
    private void dfs(String[] info, String str, int depth) {
        // 종료 조건
        if(depth == 4) {
            int score = Integer.parseInt(info[depth]);
            if(map.containsKey(str)) {
                map.get(str).add(score);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(score);
                map.put(str, list);
            }
            
            return;
        }
        
        dfs(info, str + "-", depth + 1);
        dfs(info, str + info[depth], depth + 1);
    }
    
    private int find(String query) {
        String[] arr = query.split(" and ");
        
        int score = Integer.parseInt(arr[3].split(" ")[1]);
        
        query = arr[0] + arr[1] + arr[2] + arr[3].split(" ")[0];
        
        if(!map.containsKey(query)) {
            return 0;
        }
        
        ArrayList<Integer> list = map.get(query);
        int start = 0;
        int end = list.size();
        
        while(start < end) { 
            int mid = (start + end) / 2;
            if(list.get(mid) >= score)
                end = mid;
            else
                start = mid + 1;
        }
        
        return list.size() - start;
    }
}