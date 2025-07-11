import java.util.*;

class Solution {
    public int solution(int[] q1, int[] q2) {
        int idx = 0;
        
        long total = 0;
        long q1Sum = 0;
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        
        for(int i = 0; i < q1.length; i++){
            total += q1[i] + q2[i];
            q1Sum += q1[i];
            queue1.add(q1[i]);
            queue2.add(q2[i]);
        }
        
        if(total % 2 != 0) return -1;
        
        long target = total / 2;
        
        while(true) {
            if(idx > (q1.length + q2.length) * 2) return -1;
            
            if(q1Sum == target){
                break;
            }else if (q1Sum > target) {
                q1Sum -= queue1.peek();
                queue2.offer(queue1.poll());
            }else {
                q1Sum += queue2.peek();
                queue1.offer(queue2.poll());
            }
            
            idx++;
        }
        
        return idx;
    }
}