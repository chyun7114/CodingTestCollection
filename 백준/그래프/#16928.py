from collections import deque
# 뱀과 사다리 게임
# 사다리의 수 n, 뱀의 수 m
n, m = map(int, input().split())

# 사다리와 뱀의 시작점
ladder = dict()
snake = dict()

board = [0] * 101
visited = [False] * 101

for i in range(n):
    x, y = map(int, input().split())
    ladder[x] = y

for i in range(m):
    x, y = map(int, input().split())
    snake[x] = y

# bfs 알고리즘 사용
queue = deque([1])

# 방문할 정점이 없어질 때까지
while queue:
    v = queue.popleft()
    # 100 이상 이동하는 경우는 없게 한다
    if v == 100:
        print(board[v])
        break
    # 주사위를 굴려 1에서 6까지 나옴
    for i in range(1, 7):
        nextV = v + i
        # 만약 다음 방문할 정점이 100이하이고 방문하지 않았을 경우
        if nextV <= 100 and not visited[nextV]:
            # 다음 정점이 사다리의 시작점
            if nextV in ladder.keys():
                nextV = ladder[nextV]
            # 다음 정점이 뱀의 시작점
            if nextV in snake.keys():
                nextV = snake[nextV]
            # 만약 둘 다 해당하지 않고 정점을 방문하지 않았을 경우
            if not visited[nextV]:
                queue.append(nextV)
                board[nextV] = 1 + board[v]
                visited[nextV] = True
            