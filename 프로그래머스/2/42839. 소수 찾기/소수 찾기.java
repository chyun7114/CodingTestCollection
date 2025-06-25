import java.util.*;

class Solution {
    Set<Integer> hashSet = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        
        dfs(numbers, "", 0);
        
        for(Integer num : hashSet){
            if(isPrime(num))
                answer++;
        }
        
        return answer;
    }
    
    public void dfs(String numbers, String now, int level){
        // 모든 숫자 다 찾은 경우
        if(level > numbers.length()){
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                hashSet.add(Integer.parseInt(now + numbers.charAt(i)));
                dfs(numbers, now + numbers.charAt(i), level + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }
    
    
    public boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        
        for(int i = 2; i <= (int) Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        
        return true;
    }
}