import random

# 이진 탐색 알고리즘
def binarySearch(start, end, target):
    if start > end:
        return -1
    
    mid = (start + end) // 2
    
    if data[mid] == target:	
        return mid 

    elif data[mid] > target:
        end = mid - 1
    else:                   
        start = mid + 1
        
    return binarySearch(start, end, target)


def solution(target, data):
    data.sort()
    start = 0
    end = len(data) - 1
    return binarySearch(start, end, target)

successCount = 0
count = 20
for i in range(count):
    data = [random.randrange(1, 40) for i in range(10)]

    target = random.randrange(1, 40)

    res = -1
    res = solution(target, data)
   
    if res != -1:
        print(data)
        print(f'{target}이 {res + 1}번째에 존재함')
        successCount += 1
    else:
        print(data)
        print(f'{target}이 존재하지 않음')
        
success = successCount / count * 100
print(f'전체 시행 결과 {success}%의 확률로 탐색 성공함')