import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> pokemonMap = new HashMap<>();
        int getPoke = nums.length / 2;
        int countKey = 0;
        
        for(int num : nums){
            if(pokemonMap.containsKey(num)){
                pokemonMap.put(num, pokemonMap.get(num) + 1);
            }else{
                pokemonMap.put(num, 0);
                countKey++;
            }
        }
        
        return countKey < getPoke ? countKey : getPoke;
    }
}