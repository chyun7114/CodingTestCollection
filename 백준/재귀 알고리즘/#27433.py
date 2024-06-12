# 데이터 입력
n = int(input())

def factorial(num):
    if num == 0:
        return 1
    if num == 1:
        return num * 1
    return num * factorial(num - 1)

print(factorial(n))