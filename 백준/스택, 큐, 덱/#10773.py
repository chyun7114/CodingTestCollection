# 먼저 값 입력받기
k = int(input())

data = []

# 0 입력시 리스트에서 pop,그외 나머지는 append
for i in range(0, k):
    input_data = int(input())
    if input_data == 0:
        data.pop()
    else:
        data.append(input_data)

# 최종 답안 제출
result = 0

for i in data:
    result += i
    
print(result)