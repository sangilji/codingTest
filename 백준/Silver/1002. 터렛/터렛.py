import math
a=int(input())
for i in range(a) :
    x1,y1,r1,x2,y2,r2=map(int,input().split())
    distance = math.sqrt((x2-x1)**2 +(y2-y1)**2)
    if distance == 0 and r1==r2 :
        print(-1)
    elif r1 + r2 == distance or abs(r1-r2) ==distance :
        print(1)
    elif abs(r1 - r2) < distance < (r1+r2) :
        print(2)
    else :
        print(0)

    
     