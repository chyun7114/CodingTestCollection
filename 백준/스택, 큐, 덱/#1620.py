# 데이터 입력
import sys
n, m = map(int, sys.stdin.readline().split())

pokeData = {}
pokeData2 = {}

for i in range(1, n + 1):
    str = sys.stdin.readline().strip()
    pokeData[str] = i
    pokeData2[i] = str

result = []
for i in range(m):
    find = sys.stdin.readline().strip()
    if find[0].isalpha():
        print(pokeData[find])
    else:
        print(pokeData2[int(find)])
        