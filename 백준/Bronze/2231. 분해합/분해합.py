a=int(input())
c=[]
for i in range(a,0,-1) :
    b=sum(list(map(int,str(i))))
    if b+i==a:
        c.append(i)
if(len(c)==0) :
    print(0)
else :
    c.sort()
    print(c[0])