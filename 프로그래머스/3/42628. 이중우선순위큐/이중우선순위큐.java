import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1),
                       minHeap = new PriorityQueue<>();
        
        for(String operation : operations){
            String[] temp = operation.split(" ");
            switch(temp[0]){
                case "I":
                    minHeap.offer(Integer.parseInt(temp[1]));
                    maxHeap.offer(Integer.parseInt(temp[1]));
                    break;
                case "D":
                    if(temp[1].equals("1")){
                        if(!maxHeap.isEmpty()){
                            int max = maxHeap.poll();
                            minHeap.remove(max);
                        }
                    }else if(temp[1].equals("-1")){
                        if(!minHeap.isEmpty()){
                            int min = minHeap.poll();
                            maxHeap.remove(min);
                        }
                    }
                    break;
            }
        }
        
        int min = minHeap.isEmpty() ? 0 : minHeap.poll();
        int max = maxHeap.isEmpty() ? 0 : maxHeap.poll();
        
        return new int[]{max, min};
        
    }
}