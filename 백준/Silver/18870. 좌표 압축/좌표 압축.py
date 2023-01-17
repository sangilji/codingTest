import sys
n = int(input())
a =list(map(int,sys.stdin.readline().split()))
b=sorted(list(set(a)))
c = {b[i] : i for i in range(len(b))}
for i in a :
    print(c[i],end=" ")
