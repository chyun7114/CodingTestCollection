import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] array = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            array[i] = String.valueOf(numbers[i]);
        }
        
        // 앞글자 큰 애들 앞으로
        Arrays.sort(array, (o1, o2) -> (o2 + o1).compareTo((o1 + o2)));
        
        StringBuilder sb = new StringBuilder();
        
        if(array[0].equals("0")){
            return "0";
        }
        
        for(String num : array){
            sb.append(num);
        }
        
        return sb.toString();
    }
}