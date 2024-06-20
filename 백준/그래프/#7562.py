from collections import deque
# 데이터 입력
k = int(input())




# 나이트가 움직일 수 있는 8방향 정의
dir = [
    (2, 1), (2, -1), (-2, 1), (-2, -1),
    (1, 2), (1, -2), (-1, 2), (-1, -2)
    ]

# bfs 함수 정의
def bfs(start):
    stack = deque()
    stack.append(start)
    
    while stack:
        curX, curY = stack.popleft()
        
        if curX == endX and curY == endY:
            print(visited[curX][curY] - 1)
            return
        
        for i in range(len(dir)):
            dirX, dirY = dir[i]
            
            nx = curX + dirX
            ny = curY + dirY
            
            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == 0:
                visited[nx][ny] = visited[curX][curY] + 1
                stack.append((nx, ny))
            else:
                continue 

for j in range(k):
    n = int(input())

    visited = [[0 for _ in range(n)] for _ in range(n)]

    startX, startY = map(int, input().split())
    endX, endY = map(int, input().split())

    visited[startX][startY] = 1

    bfs((startX, startY))