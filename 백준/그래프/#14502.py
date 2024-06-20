from collections import deque
import copy

n, m = map(int, input().split())

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

data = [list(map(int, input().split())) for _ in range(n)]
answer = 0

# 벽을 세울 수 있는 후보 위치를 미리 저장
empty_spaces = [(i, j) for i in range(n) for j in range(m) if data[i][j] == 0]

def bfs():
    tmpGraph = copy.deepcopy(data)
    stack = deque()

    for i in range(n):
        for j in range(m):
            if tmpGraph[i][j] == 2:
                stack.append((i, j))

    while stack:
        x, y = stack.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and tmpGraph[nx][ny] == 0:
                tmpGraph[nx][ny] = 2
                stack.append((nx, ny))

    global answer
    cnt = sum(row.count(0) for row in tmpGraph)
    answer = max(answer, cnt)

def setGraph(cnt, start):
    if cnt == 3:
        bfs()
        return

    for i in range(start, len(empty_spaces)):
        x, y = empty_spaces[i]
        data[x][y] = 1
        setGraph(cnt + 1, i + 1)
        data[x][y] = 0

setGraph(0, 0)
print(answer)
