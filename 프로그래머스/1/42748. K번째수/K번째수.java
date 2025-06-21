import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int a = 0; a < commands.length; a++){
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            int[] temp = new int[j - i + 1];
            int idx = 0;
            
            for(int l = i - 1; l < j; l++){
                temp[idx] = array[l];
                idx++;
            }
            
            Arrays.sort(temp);
            answer[a] = temp[k - 1];
        }
        
        return answer;
    }
}