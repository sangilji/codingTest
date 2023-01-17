a= int(input())
b=a//5
sugars=[]
sum=[]
for i in range(b,-1,-1) :
    n=a-i*5
    c=n//3
    n-=c*3
    sugar=[n,i,c]
    sugars.append(sugar)
for i in range(b+1) :
    if sugars[i][0] ==0 :
        sum.append(sugars[i][1]+sugars[i][2])   

if len(sum) !=0 :
    sum.sort()
    print(sum[0])
else :
    print(-1)


