a=[]
delete=[]
for i in range(1,10001) :
    a.append(i)

def selfNumber(n) :
    tmp=n
    n=list(map(int,(str(n))))
    b=tmp+sum(n)
    if b<=10000 :
        selfNumber(b)
        return delete.append(b)
        

for i in range(1,10000) :
    selfNumber(i)
for i in set(delete) :
    a.remove(i)
for i in a :
    print(i)






