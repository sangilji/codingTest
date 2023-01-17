a=int(input())
for i in range(a) :
    b=int(input())
    c=int(input())
    room= [ x for x in range(1,c+1)]
    for j in range(b) :
        for k in range(1,c) :
            room[k]=room[k-1]+room[k]
    print(room[-1])


