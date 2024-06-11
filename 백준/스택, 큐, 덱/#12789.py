# 도키도키 간식 드리미

# 데이터 입력 받기
n = int(input())
wait = list(map(int, input().split()))

tmp = []
now = 1

# 일단 모든 인원을 리스트에 삽입
for i in wait:
    tmp.append(i)   # 리스트에 삽입
    while tmp and tmp[-1] == now:   # 리스트의 마지막 인원이 현재 나가야하는 인원이면
        tmp.pop()   # 리스트에서 1명 팝한 뒤
        now += 1    # 지금 나가야하는 사람으로 설정

if tmp: # 이 과정을 거친 후 스택에 인원 남아 있는 경우 간식 먹기 실패!
    print("Sad")
else:
    print("Nice")


'''
5
5 4 1 3 2
'''