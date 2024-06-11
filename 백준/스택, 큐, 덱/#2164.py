from collections import deque

# 입력 데이터
n = int(input())

cards = deque([i for i in range(1, n+1)])   # 덱 사용 안하면 시간초과 남

while len(cards) != 1:      # 카드 배열의 길이가 1이 될 때까지 => 카드가 한장 남을때까지
    cards.popleft()         # 맨 위의 카드를 버린다
    i = cards.popleft()     # 그 후 남은 카드 중 맨 위 카드를 가진 뒤
    cards.append(i)         # 이 카드를 맨 뒤로 옮긴다
    
print(*cards) 
    