import sys
a= int(input())
b=1
c=6
x=1
if a==1 :
    print(1)
else :
    while 1 :
        x+=c*b
        if(a<=x) :
            break
        else :
            b+=1
    print(b+1)