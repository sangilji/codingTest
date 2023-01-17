a= int(input())
b=list(map(int,input().split()))
count=0
for i in b :
    error=0
    if i>1 :
        for j in range(2,i) :
            if(i%j==0) :
                error+=1
        if error ==0 :
            count+=1
print(count)
        
