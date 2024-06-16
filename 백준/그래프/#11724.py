from collections import deque
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

# 11724 연결 요소의 개수

# 데이터 입력
n, m = map(int, input().split())

# 모든 정점이 방문 될 때까지
# dfs가 끝나는 경우에도 dfs를 계속 할 수 있게 설정한다
# 즉, dfs의 횟수 = 연결 요소의 개수

# dfs 설정
def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True

    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                
res = 0
graph = [[] for _ in range(n+1)]

for i in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

count = 0
visited = [False] * (n+1)

for i in range (1, n + 1):
    if not visited[i]:
        bfs(graph, i, visited)
        res += 1
        
print(res)