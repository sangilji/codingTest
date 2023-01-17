a,b=map(int,input().split())
c=[]
for i in range(a) :
    chess=list((map(str,input())))
    c.append(chess)
color=['W','B']
n=0
count=0
tmp=64
for x in range(a-7) :
    for y in range(b-7) :
        for i in range(x,x+8) :
            for j in range(y,y+8) :
                if color[n]!=c[i][j] :
                    count+=1
                n=(n+1)%2
            n=(n+1)%2
        if tmp> min(count,64-count) :
            tmp=min(count,64-count)
        count=0
print(tmp)