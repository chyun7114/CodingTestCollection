n = int(input())

datas = []

for i in range(n):
    datas.append(input())

result = []
score = 0
combo = 0

for data in datas:
    for i in range(len(data)):
        if data[i] == 'O':
            combo += 1
            score += combo
        elif data[i] == 'X':
            combo = 0
    result.append(score)
    score = 0
    combo = 0

for i in range(len(result)):
    print(result[i])
    

'''
5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX
'''