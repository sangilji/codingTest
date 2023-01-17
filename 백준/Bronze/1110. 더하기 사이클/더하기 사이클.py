a = int(input())
b= a
count=0

while 1 :
    x=a//10
    y=a%10
    if a<10 :
        a=a+a*10
    else :
        a=y*10+(x+y)%10
    count+=1
    if b==a :
        break
print(count)