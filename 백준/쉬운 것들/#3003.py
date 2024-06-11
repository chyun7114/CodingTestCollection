chess = list(map(int, input().split()))
ans = [1, 1, 2, 2, 2, 8]
result = []

for i in range(len(chess)):
    result.append(ans[i] - chess[i])
    
print(*result)