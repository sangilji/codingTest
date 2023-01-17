import sys
n = int(input())
info =[]
for i in range(n) :
    age,name=input().split()
    info.append([int(age),name])
info.sort(key=lambda x :x[0])
for i in info :
    for j in i :
        print(j,end=" ")
    print()
