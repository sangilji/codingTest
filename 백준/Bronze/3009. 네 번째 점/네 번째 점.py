b=[]
for i in range(3) :
    b.append(list(map(int,input().split())))
if(b[0][0] == b[1][0]) :
    print(b[2][0],end=" ")
elif b[0][0]==b[2][0] :
    print(b[1][0],end=" ")
else :
    print(b[0][0],end=" ")
if(b[0][1] == b[1][1]) :
    print(b[2][1])
elif b[0][1]==b[2][1] :
    print(b[1][1])
else :
    print(b[0][1])