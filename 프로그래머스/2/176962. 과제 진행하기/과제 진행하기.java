import java.util.*;

class Solution {
    
    class Plan {
        String name;
        int start;
        int playtime;
        
        public Plan(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
        
        public Plan(String name, int playtime) {
            this.name = name;
            this.playtime = playtime;
        }
    }
    
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        PriorityQueue<Plan> pq = new PriorityQueue<>(
            (o1, o2) -> (o1.start - o2.start)    
        );
        Stack<Plan> stack = new Stack<>();
        
        for(int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            String[] str = plans[i][1].split(":");
            int h = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int time = (h * 60) + m;
            int playtime = Integer.parseInt(plans[i][2]);
            
            pq.offer(new Plan(name, time, playtime));
        }
        
        while(!pq.isEmpty()) {
            Plan plan = pq.poll();
            
            String curName = plan.name;
            int curStart = plan.start;
            int curPlaytime = plan.playtime;
            
            int curTime = curStart;
            
            // 일단 과제가 남은 경우
            if(!pq.isEmpty()) {
                Plan nextPlan = pq.peek();
                
                // 지금 과제를 끝내고 새로운 과제를 시작하기까지 시간이 남은 경우
                if(curTime + curPlaytime < nextPlan.start) {
                    answer.add(curName);
                    curTime += curPlaytime;
                    
                    // 잠시 멈춘 과제가 있는 경우 남은 시간동안 해결
                    while(!stack.isEmpty()) {
                        Plan remainPlan = stack.pop();
                        
                        // 다음 과제 시작 전까지 끝낼 수 있는 경우
                        if(curTime + remainPlan.playtime <= nextPlan.start) {
                            answer.add(remainPlan.name);
                            curTime += remainPlan.playtime;
                            continue;
                        } else {
                            int t = remainPlan.playtime - (nextPlan.start - curTime);
                            stack.push(new Plan(remainPlan.name, t));
                            break;
                        }
                    }
                } else if(curStart + curPlaytime == nextPlan.start) {
                    answer.add(curName);
                    continue;
                } else {
                    int t = (nextPlan.start - curTime);
                    stack.push(new Plan(curName, curPlaytime - t));
                }
            }
            // 과제가 없는 경우
            else {
                // 멈춘 과제도 없는 경우 
                if(stack.isEmpty()) {
                    curTime += curPlaytime;
                    answer.add(curName);
                }else {
                    answer.add(curName);
                    
                    while(!stack.isEmpty()) {
                        Plan remainPlan = stack.pop();
                        answer.add(remainPlan.name);
                    }
                }
            }
        }
        
        return answer;
    }
}