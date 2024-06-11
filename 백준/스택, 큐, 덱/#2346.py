from collections import deque

# 데이터 입력
n = int(input())
# 데이터 (index, paper)쌍의 튜플로 저장
q = deque(enumerate(map(int, input().split())))

result = []

while q:
    index, paper = q.popleft()
    result.append(index + 1)
    if paper > 0:
        q.rotate(-(paper -  1))
    else:
        q.rotate(-paper)
        
print(*result)