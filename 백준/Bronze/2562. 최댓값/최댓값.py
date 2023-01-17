a=[]
for i in range(9) :
    n=int(input())
    a.append(n)
b=a[0]
c=1
for i in range(1,9) :
    if b<a[i]  :
        b=a[i]
        c=i+1
print(b)
print(c)