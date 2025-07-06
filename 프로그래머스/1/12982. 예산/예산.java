import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        for(int i = 0; i < d.length; i++){
            int temp = budget - d[i];
            
            if(temp < 0){
                break;    
            }
            
            budget = temp;
            answer++;
        }
        
        return answer;
    }
}