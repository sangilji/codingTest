a=int(input())

for i in range(a) :
    b=(list(map(int,input().split())))
    c=0
    d=0
    for j in range(1, len(b)) :
        c+=b[j]
    c=c/b[0]
    for j in range(1,len(b)) :
        if b[j]>c :
            d+=1
    print(format(d/b[0]*100,".3f"),"%",sep="")