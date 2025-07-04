import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] answer;
    
    public int[] solution(String[][] places) {
        answer = new int[places.length];
        for(int i = 0; i < places.length; i++){
            String[] p = places[i];
            
            boolean isOk = true;
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    if(p[j].charAt(k) == 'P'){
                        if(!bfs(j,k,p))
                            isOk = false;
                    }
                }
            }
            
            answer[i] = isOk ? 1 : 0;
        }
        
        return answer;
    }
    
    public boolean bfs(int x, int y, String[] place){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (nx == x && ny == y)){
                    continue;
                }
                
                int distance = Math.abs(nx - x) + Math.abs(ny - y);
                
                if(distance <= 2 && place[nx].charAt(ny) == 'P')
                    return false;
                else if (place[nx].charAt(ny) == 'O' && distance < 2)
                    queue.offer(new int[] { nx, ny });
            }
        }
        
        return true;
    }
}