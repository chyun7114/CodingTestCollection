import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer;
        int max = (int)Math.sqrt(yellow);
        
        for(int i = 1; i <= max; i++){
            if(yellow % i != 0)
                continue;
            
            int w = yellow / i;
            int h = i;
            
            int result = (h + w) * 2 + 4;
            
            if(result == brown){
                return new int[] {w + 2, h + 2};
            }
        }
        
        return new int[] {0,0};
    }
}