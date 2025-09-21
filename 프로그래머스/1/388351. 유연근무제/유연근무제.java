class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < timelogs.length; i++) {
            int targetTime = getTargetTime(schedules[i]);
            boolean flag = true;
            for(int j = 0; j < timelogs[i].length; j++){
                if(!isWeekend(startday - 1, j) && targetTime < timelogs[i][j]){
                    flag = false;
                }
            }
            
            if(flag) answer++;
        }
        
        return answer;
    }
    
    private int[] getTime(int time) {
        int hour = time / 100;
        int minute = time % 100;
        
        return new int[] {hour, minute};
    }
    
    private int getTargetTime(int time) {
        int[] temp = getTime(time);
        
        int hour = temp[0];
        int minute = temp[1];
        
        minute += 10;
        if(minute > 59) {
            hour += 1;
            minute -= 60;
        }
        
        return (hour * 100 + minute);
    }
    
    private boolean isWeekend(int startDay, int idx) {
        if((startDay + idx) % 7 == 5 || (startDay + idx) % 7 == 6)
            return true;
        else
            return false;
    }
}