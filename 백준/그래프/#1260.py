from collections import deque
import sys
read = sys.stdin.readline
# DFS and BFS In Python

# 데이터 입력 받기

n, m, v = map(int, read().split())
graph = [[False] * (n + 1) for _ in range(n + 1)] 

for _ in range(m):
    a, b = map(int, read().split())
    graph[a][b] = 1
    graph[b][a] = 1

visited1 = [False] * (n + 1)
visited2 = [False] * (n + 1)

def dfs(x):
    visited1[x] = True
    print(x, end = " ")
    for i in range(1, n + 1):
        if not visited1[i] and graph[x][i] == 1:
            dfs(i)

def bfs(x):
    stack = deque([x])
    visited2[x] = True
    while stack:
        v = stack.popleft()
        print(v, end=" ")
        for i in range(1, n + 1):
            if not visited2[i] and graph[v][i] == 1:
                stack.append(i)
                visited2[i] = True
        

dfs(v)
print()
bfs(v)