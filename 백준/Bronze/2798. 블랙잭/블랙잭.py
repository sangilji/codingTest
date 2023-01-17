a,b=map(int,input().split())
sum=[]
c=list(map(int,input().split()))
for i in range(a):
    for j in range(i+1,a) :
        for k in range(j+1,a):
            sum.append(c[i]+c[j]+c[k])
sum.sort()
d=sum[0]
for i in sum :
    if(i>b) :
        break
    d=i
print(d)
    