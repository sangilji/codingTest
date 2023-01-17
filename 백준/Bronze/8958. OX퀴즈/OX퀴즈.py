a=int(input())
b=[]

for i in range(a) :
    b.append(input().split())
    c=0
    d=0
    for j in str(b[i]) :
        if j=="O" :
            d+=1
            c+=d

        elif j=="X" :
            d=0

    print(c)
    
