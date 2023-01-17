a=int(input())
c=99
if a<100 :
    print(a)
else :
    b=[i for i in range(100,a+1)]
    for i in b :
        d=list(map(int,(str(i))))
        if(d[0]-d[1]==d[1]-d[2]) :
            c+=1
    print(c)