n, m = map(int, input().split())

result = [0] * n

for i in range(m):
    start, last, ballNum = map(int, input().split())
    for j in range(start, last + 1):
        result[j - 1] = ballNum

for i in range(n):
    print(result[i], end=' ')    

"""
5 4
1 2 3
3 4 4
1 4 1
2 2 2
"""