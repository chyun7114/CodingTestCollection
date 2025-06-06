import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        char[] charArray = number.toCharArray();
        
        int index = 0;
        int len = charArray.length - k;
        
        for(int i = 0; i < len; i++){
            char max = '0';
            for(int j = index; j <= i + k; j++){
                if(max < charArray[j]){
                    max = charArray[j];
                    index = j + 1;
                }
            }
            
            sb.append(max);
        }
        
        return sb.toString();
    }
}