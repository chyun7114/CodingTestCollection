n = int(input())

card = list(map(int, input().split()))

m = int(input())

getCard = list(map(int, input().split()))

result = [0] * m

cardDict = {}

for i in range(len(card)):
    cardDict[card[i]] = 0

for i in range(len(getCard)):
    if getCard[i] not in cardDict:
        result[i] = 0
    else:
        result[i] = 1

for i in range(len(result)):
    print(result[i], end=' ')
    
'''
5
6 3 2 10 -10
8
10 9 -5 2 3 4 5 -10
'''