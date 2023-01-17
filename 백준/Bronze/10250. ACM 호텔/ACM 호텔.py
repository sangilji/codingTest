import math
n = int(input())
for i in range(n) :
    a,b,c=map(int,input().split())
    if c%a==0 :
        k=a
    else :
        k=c%a
    print(str(k),str(math.ceil(c/a)).zfill(2),sep="")

