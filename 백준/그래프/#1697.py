from collections import deque

n, m = map(int, input().split())
max_num = 100000
visited = [0] * (max_num + 1)

def bfs():
    stack = deque()
    stack.append(n)
    while stack:
        v = stack.popleft()
        if v == m:
            print(visited[v])
            break
        for j in (v - 1, v + 1, v * 2):
            if 0 <= j <= max_num and not visited[j]:
                stack.append(j)
                visited[j] += visited[v] + 1

bfs()