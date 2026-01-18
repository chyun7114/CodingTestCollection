import java.util.*;

class Solution {
    
    boolean[][] visited;
    int n, m;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[] oil;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        
        oil = new int[m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && visited[i][j] == false) {
                    bfs(land, visited, i, j);
                }
            }
        }
        
        answer = Arrays.stream(oil).max().getAsInt();
        return answer;
    }
    
    private void bfs(int[][] land, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        int count = 1;
        Set<Integer> set = new HashSet<>();

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            set.add(cur[1]);
            
            int curX = cur[0];
            int curY = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                
                if(!visited[nx][ny] && land[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count += 1;
                }
            }          
        }
        
        for(int num : set) {
            oil[num] += count;
        }
    }
}