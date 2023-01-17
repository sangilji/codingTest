sosu=[]
result =[0 for i in range(10001)]
m=0
x,y=0,0
for i in range(2,10000) :
        error=0
        if i>1 :
            for j in range(2,int(i**0.5)+1) :
                if i%j==0 :
                    error+=1
                    break
            if error==0 :
                sosu.append(i)
n=int(input())
for i in sosu :
    result[i]=1
for i in range(n) :
    a= int(input())
    b,c=a//2,a//2
    while 1 :
        if result[b] ==1 :
            if result[c] ==1:
                if b+c==a :
                    print(c,b)
                    break
                else :
                    b+=1
            else :
                c-=1
        else :
            b+=1
        if b+c>a :
            b=a//2
            c-=1
