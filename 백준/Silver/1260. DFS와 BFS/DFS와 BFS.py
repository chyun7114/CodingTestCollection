from collections import deque
import sys
input = sys.stdin.readline
 
node,line,start = map(int,input().split())
arr = [[] for i in range(node+1)]
for i in range(line):
    a,b = map(int,input().split())
    arr[a].append(b)
    arr[b].append(a)
    
for i in arr :
    i.sort()
 
# DFS
visit = [False]*(node+1)
stack = [start]
answer = []
while stack :
    x = stack.pop()
    if not visit[x]:
        visit[x] = True
        answer.append(x)
        for nx in reversed(arr[x]):
            if not visit[nx]:
                stack.append(nx)
print(*answer)
 
# BFS
visit = [False]*(node+1)
answer = []
q = deque()
q.append(start)
 
while q:
    x = q.popleft()
    if not visit[x] :
        visit[x] = True
        answer.append(x)
        for nx in arr[x]:
            if not visit[nx]:
                q.append(nx)
print(*answer)
