class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0);
        
        return answer;
    }
    
    private int dfs(int[] numbers, int target, int depth){
        int answer = 0;
        
        if(depth == numbers.length){
            int sum = 0;
            for(int number : numbers)
                sum += number;
            
            if(sum == target)
                return 1;
            else
                return 0;
        }else{
            answer += dfs(numbers, target, depth+1);
            numbers[depth] *= -1;
            answer += dfs(numbers, target, depth+1);
            return answer;
        }
    }
}