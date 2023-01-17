a=int(input())
b=list(map(int,input().split()))
b.sort()
c=0
for i in range(a) :
    b[i]=b[i]/b[a-1]*100
    c+=b[i]
print(c/a)
