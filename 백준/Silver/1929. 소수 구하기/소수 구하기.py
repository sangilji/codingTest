
a,b= map(int,input().split())
for i in range(a,b+1) :
    error=0
    if i>1 :
        for j in range(2,int(i**0.5)+1) :
           if i%j==0 :
               error+=1
               break
        if error==0 :
            print(i) 