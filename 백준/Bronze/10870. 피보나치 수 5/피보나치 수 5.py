n=[0,1]
a=int(input())
if(a==0) :
    print(0)
elif (a==1) :
    print(1)
else :
    for i in range(a-1) :
        n.append(n[i]+n[i+1])
    print(n[-1])
