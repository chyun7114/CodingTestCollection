import sys
# 데이터 입력
n = int(input())
lastEnd : int = 0
res : int = 0

data = []

for i in range(n):
    x, y  = map(int,sys.stdin.readline().rstrip().split())
    data.append([x, y])
    
data.sort(key=lambda : (x[1], x[0]))

for start, end in data:
    if lastEnd <= start:
        res += 1
        lastEnd = end

print(res)
        





'''
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
'''