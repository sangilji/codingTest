a=int(input())
b=[]
for i in range(a) :
    c=list(map(int,input().split()))
    b.append(c)
c=[1 for i in range(a)]
for i in range(a) :
    for j in range(a) :
        if b[i][0]<b[j][0] and b[i][1]<b[j][1] :
            c[i]+=1
for i in c :
    print(i,end=" ")