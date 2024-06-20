import sys
sys.setrecursionlimit(100000)

n = int(input())

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

area = []
res = 0
max_high = 0

# 그래프 정보 인접행렬로 입력
for i in range(n):
    temp = list(map(int, input().split()))
    area.append(temp)
    for j in temp:
        max_high = max(max_high, j)
    
# DFS 정의 (반복적 방법)
def dfs(start, visited, high):
    stack = [start]
    while stack:
        x, y = stack.pop()
        if visited[x][y]:
            continue
        visited[x][y] = True
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 좌표의 유효성 검사 통과 및 주어진 좌표가 안전지대인지 검사
            if 0 <= nx < n and 0 <= ny < n and area[nx][ny] > high and not visited[nx][ny]:
                stack.append((nx, ny))

for k in range(max_high):
    visited = [[False for i in range(n)] for j in range(n)]
    count = 0
    
    # 모든 점에 대하여 DFS 수행
    for x in range(n):
        for y in range(n):
            # 이미 방문한 곳은 방문 x
            # 물에 잠기지 않은 곳을 구한다
            if area[x][y] > k and not visited[x][y]:
                # DFS 수행 
                dfs((x, y), visited, k)
                # DFS 수행이 끝나면 count 늘림
                count += 1
    
    # 구한 count가 원래 값보다 큰지 검사
    res = max(count, res)

print(res)
