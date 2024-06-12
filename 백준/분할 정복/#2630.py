# 데이터 입력
num = int(input())
map = [list(map(int, input().split())) for _ in range(num)]

result = []

def quadTree(x, y, n):
    color = map[x][y]
    for i in range(x, x + n):
        for j in range(y, y + n): 
            if color != map[i][j]:
                quadTree(x, y, n//2)
                quadTree(x + n//2, y, n//2)
                quadTree(x, y + n//2, n//2)
                quadTree(x + n//2, y + n//2, n//2)
                return
    
    if color == 0:
        result.append(0)
    else:
        result.append(1)

quadTree(0, 0, num)
print(result.count(0))
print(result.count(1))