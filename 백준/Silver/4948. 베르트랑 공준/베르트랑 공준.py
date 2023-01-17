sosu=[]
for i in range(2,246912) :
        error=0
        if i>1 :
            for j in range(2,int(i**0.5)+1) :
                if i%j==0 :
                    error+=1
                    break
            if error==0 :
                sosu.append(i)
while 1 :
    a= int(input())
    count=0
    if(a==0) :
        break
    for i in sosu :
        if a < i <= a*2 :
            count+=1
    print(count)
    