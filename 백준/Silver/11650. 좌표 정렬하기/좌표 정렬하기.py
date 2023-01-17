import sys
a= int(input())
b=[]
for i in range(a) :
    c= list(map(int,sys.stdin.readline().split()))
    b.append(c)
b.sort(key=lambda x: (x[0],x[1]))
for i in b :
    for j in i :
        print(j,end=" ")
    print()