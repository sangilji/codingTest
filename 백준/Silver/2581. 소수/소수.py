a= int(input())
b= int(input())
sum_list=[]
for i in range(a,b+1) :
    error=0
    if i >1 :
        for j in range(2,i) :
            if i%j==0 :
                error+=1
                break
        if error ==0 :
            sum_list.append(i)
if len(sum_list)==0 :
    print(-1)
else:
    print(sum(sum_list))
    print(sum_list[0])
