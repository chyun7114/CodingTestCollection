import java.util.*;

class Solution {
    
    Queue<int[]>[] routeMemo;
    int size;
    int answer = 0;
    
    public int solution(int[][] points, int[][] routes) {
        size = routes.length;
        routeMemo = new LinkedList[size];
        for(int i = 0; i < size; i++) {
            routeMemo[i] = new LinkedList<>();
        }
        
        getRouteMemo(points, routes);
        getCollision();
        
        return answer;
    }
    
    private void getCollision() {
        int count = 0;
        while(count != size) {
            int[][] map = new int[101][101];
            count = 0;
            
            for(int i = 0; i < size; i++) {
                if(routeMemo[i].isEmpty()) {
                    count++;
                    continue;
                }
                int[] temp = routeMemo[i].poll();
                map[temp[0]][temp[1]]++;
            }
            
            for(int i = 0; i < 101; i++) {
                for(int j = 0; j < 101; j++) {
                    if(map[i][j] > 1) answer++;
                }
            }
        }
        
    }
    
    private void getRouteMemo(int[][] points, int[][] routes) {
        for(int i = 0; i < size; i++) {
            int[] point = points[routes[i][0] - 1];
            
            int startX = point[0];
            int startY = point[1];
            
            routeMemo[i].add(new int[]{startX, startY});
            for(int j = 1; j < routes[i].length; j++) {
                int[] nextPoint = points[routes[i][j] - 1];
                
                int nx = nextPoint[0];
                int ny = nextPoint[1];
                
                int dx = nx - startX;
                int dy = ny - startY;
                
                while(dx != 0) {
                    if(dx > 0) {
                        dx--;
                        startX++;
                        routeMemo[i].add(new int[]{startX, startY});
                    } else {
                        dx++;
                        startX--;
                        routeMemo[i].add(new int[]{startX, startY});
                    }
                }
                
                while(dy != 0) {
                    if(dy > 0) {
                        dy--;
                        startY++;
                        routeMemo[i].add(new int[]{startX, startY});
                    } else {
                        dy++;
                        startY--;
                        routeMemo[i].add(new int[]{startX, startY});
                    }
                }
            }
        }
    }
    
}