# 데이터 입력
n, m = map(int, input().split())
balls = [i for i in range(1, n + 1)]

def swap(l, k):
    if l == k:
        return
    
    temp = balls[l]
    balls[l] = balls[k]
    balls[k] = temp
    
for i in range(m):
    a, b = map(int, input().split())
    swap(a - 1, b - 1)
    
print(*balls)

'''
2 1 4 3 5
3 1 4 2 5
'''