import sys
a=[0 for i in range(10001)]

n = int(input())
for i in range(n) :
    b=int(sys.stdin.readline())
    a[b]+=1
for i in range(1,10001) :
    for j in range(a[i]) :
        print(i)
