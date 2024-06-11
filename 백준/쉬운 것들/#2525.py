# 초기 시간 입력 받기 => 시간, 분
inputH, inputM = map(int, input().split())

# 조리 시간 입력 받기 => 분
cookTime = int(input())

# 조리 시간 시간 단위로 변환하기
cookMin = cookTime % 60
cookHour = int(cookTime / 60)

# 변환한 조리 시간 입력 시간에 더해주고
inputM += cookMin
inputH += cookHour

# 분은 60분을 넘기면 안되고, 시간은 24시간을 넘기면 안되기 때문에
if inputM >= 60:
    # 먼저 분 단위 올림 체크
    inputH += 1
    inputM -= 60
    
# 이후 시간 단위 내림 체크
if inputH >= 24:
    inputH -= 24

# 결과 출력
print(inputH, inputM)

