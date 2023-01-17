a=int(input())
for i in range(a) :
    x,y=map(int,input().split())
    move_plus=0
    move=1
    count=0
    while move_plus<y-x :
        count+=1
        move_plus+=move
        if count%2==0 :
            move+=1
    
    print(count)   
    
        