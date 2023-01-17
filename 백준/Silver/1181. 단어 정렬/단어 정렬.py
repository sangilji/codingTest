import sys
a= int(input())
b=[]
for i in range(a) :
    b.append(input())
b=set(b)
b=list(b)
b.sort(key=lambda x :(len(x),x))
for i in b :
    print(i)