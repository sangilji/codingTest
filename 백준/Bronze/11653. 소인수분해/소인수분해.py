a= int(input())
b=2
c=[]
while a!=1 :
    if a%b==0 :
       c.append(b)
       a=a//b
    else :
        b+=1
for i in c :
    print(i)