import java.util.*;

class Solution {
    
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0,0,1});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            int x = current[0];
            int y = current[1];
            int cur = current[2];
            
            if(x == n - 1 && y == m - 1){
                return cur;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny,cur + 1});
                }
            }
        }
        
        return -1;
    }
}