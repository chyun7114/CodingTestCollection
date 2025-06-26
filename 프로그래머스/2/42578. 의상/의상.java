import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(String[] temp : clothes){
            String type = temp[1];
            
            hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);
        }
        
        for(Integer value : hashMap.values()){
            answer *= value + 1;
        }
        
        return answer - 1;
    }
}