import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {    
        
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    private static void dfs(String start, String target, String[] words, int cnt){
        
        // 종료 조건
        if(start.equals(target)){
            answer = cnt;
            return;
        }
        
        // 단어를 돌리면서 1글자만 틀린 경우 dfs 탐색 진행
        for(int i = 0; i < words.length; i++){
            if(visited[i]){
                continue;
            }
            
            int count = 0;
            for(int j = 0; j < words[i].length(); j++){
                if(start.charAt(j) == words[i].charAt(j)){
                    count++;
                }
            }
            
            if(count == words[i].length() - 1){
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                
                // 만약 올바른 경로가 아니었다면 백트래킹
                visited[i] = false;
            }
        }
    }
}