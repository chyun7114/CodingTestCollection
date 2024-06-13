# 데이터
n = input()

stack = []
result = 0

for i in range(len(n)):
    # 열린 괄호인 경우
    if n[i] == '(':
        stack.append(n[i])
    # 닫힌 괄호인 경우
    else:
        stack.pop()
        if n[i - 1] == '(':
            result += len(stack)
        else:
            result += 1
            

print(result)