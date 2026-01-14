import java.util.*;

class Solution {
    String[] map;
    boolean[][] visited;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[] maps) {
        List<Integer> answerList = new ArrayList<>();
        
        map = maps;
        visited = new boolean[map.length][maps[0].length()];
        
        for(int i = 0; i < map.length; i++) {
            String line = map[i];
            for(int j = 0; j < map[i].length(); j++) {
                if(line.charAt(j) != 'X' && !visited[i][j]) {
                    int count = bfs(i, j);
                    answerList.add(count);
                }
            }
        }
        
        if(answerList.size() < 1) {
            return new int[]{-1};
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    private int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = map[x].charAt(y) - '0';
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for(int i = 0; i < dx.length; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length()) {
                    continue;
                }
                String line = map[nx];
                
                if(line.charAt(ny) != 'X' && !visited[nx][ny]) {
                    count += map[nx].charAt(ny) - '0';
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        return count;
        
    }
}