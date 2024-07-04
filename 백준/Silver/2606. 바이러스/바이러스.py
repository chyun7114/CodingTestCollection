from collections import deque

n = int(input())
m = int(input())

visited = [False] * (n + 1)
graph = [[] for _ in range(n + 1)]

for i in range(m):
    v, w = map(int, input().split())
    graph[v].append(w)
    graph[w].append(v)

count = -1

def bfs(v):
    q = deque([v])
    visited[v] = True

    while q:
        x = q.popleft()
        visited[x] = True

        for nx in graph[x]:
            if not visited[nx]:
                q.append(nx)

bfs(1)
for i in range(1, n + 1):
    if visited[i]:
        count += 1

print(count)