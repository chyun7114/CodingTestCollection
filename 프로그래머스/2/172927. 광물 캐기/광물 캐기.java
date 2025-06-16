import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int sum = Arrays.stream(picks).sum();
        
        int[][] p = new int[sum][3];
        
        for(int i = 0; i < minerals.length; i += 5){
            int n = i / 5;
            
            if(n == sum){
                break;
            }
            
            int[] costs = new int[3];
            
            for(int j = i; j < i + 5; j++){
                if(j == minerals.length){
                    break;
                }
                String temp = minerals[j];
                
                if(temp.equals("diamond")){
                    getCost(costs, 1, 5, 25);
                }else if(temp.equals("iron")){
                    getCost(costs, 1, 1, 5);
                }else{
                    getCost(costs, 1, 1, 1);
                }
            }
            
            for(int k = 0; k < 3; k++){
                p[n][k] = costs[k];
            }
        }
        
        Arrays.sort(p, (a1, a2) -> (a2[2]-a1[2]));
        
         for(int i = 0; i < sum; i++){
            if(picks[0] > 0){
                answer += p[i][0];
                picks[0]--;
            }
            else if(picks[1] > 0){
                answer += p[i][1];
                picks[1]--;
            }
            else if(picks[2] > 0){
                answer += p[i][2];
                picks[2]--;
            }
        }
        
        return answer;
    }
    
    private static void getCost(int[] costs, int d, int i, int s){
        costs[0] += d;
        costs[1] += i;
        costs[2] += s;
    }
}