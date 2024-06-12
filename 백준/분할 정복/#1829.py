# 데이터 입력
i, j, k = map(int, input().split())

# 재귀 함수 정의
def solution(a, b, c):
    if b == 1:
        return a % c    
    if b % 2 == 0:
        return ((solution(a, b // 2, c)) ** 2) % c
    else:
        return (((solution(a, b // 2, c)) ** 2) * a) % c
    
print(solution(i, j, k)) 