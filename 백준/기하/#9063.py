# 데이터 입력 받기
n = int(input())

# 각 점든의 x, y좌표
x = []
y = []

for i in range(n):
    x1, y1 = map(int, input().split())
    x.append(x1)
    y.append(y1)
    
# x, y갑에 따라 오름차순 정렬
x.sort()
y.sort()

# 가장 큰 값에서 가장 작은 값을 뺴면
# 그 값이 직사각형의 가로 및 세로의 길이
width = x[len(x) - 1] - x[0]
height = y[len(y) - 1] - y[0]

# 직사각형의 넓이 = 가로 x 세로
print(width * height)